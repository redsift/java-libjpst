package example;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jmap.model.JMAPAttachment;
import com.jmap.model.JMAPEmailer;
import com.jmap.model.JMAPMessage;
import com.pff.PSTAttachment;
import com.pff.PSTException;
import com.pff.PSTFile;
import com.pff.PSTFolder;
import com.pff.PSTMessage;
import com.pff.PSTRecipient;

public class TestJMAP {

	private final String OUTPUT_DIRECTORY = "output/";
	private List<String> folderPath = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			TestJMAP importer = new TestJMAP();
			PSTFile pstFile = new PSTFile(args[0]);
			importer.processFolder(pstFile.getRootFolder());
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public void processFolder(PSTFolder folder) throws PSTException,
			java.io.IOException {
		// the root folder doesn't have a display name
		String fname = folder.getDisplayName();
		if (fname != null && !fname.isEmpty()) {
			folderPath.add(fname);
			// System.out.println(folderPath);
		}

		// go through the folders...
		if (folder.hasSubfolders()) {
			Vector<PSTFolder> childFolders = folder.getSubFolders();
			for (PSTFolder childFolder : childFolders) {
				processFolder(childFolder);
			}
		}

		// and now the emails for this folder
		if (folder.getContentCount() > 0) {
			PSTMessage email = (PSTMessage) folder.getNextChild();
			while (email != null) {
				System.out.println("Processing: " + email.getSubject());
				ObjectMapper mapper = new ObjectMapper();

				// TODO: remove indentation from production system
				mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
				mapper.configure(
						SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
				// mapper.writeValue(new File(OUTPUT_DIRECTORY +
				// sha256(email.getInternetMessageId())),
				// getJMAPMessage(email));
				mapper.writeValue(System.out, getJMAPMessage(email));

				email = (PSTMessage) folder.getNextChild();
			}
		}
		// Pop the current folder from the path as we are returning from
		// recursion
		if (folderPath.size() > 0) {
			folderPath.remove(folderPath.size() - 1);
		}
	}

	private JMAPMessage getJMAPMessage(PSTMessage pm) {
		return JMAPMessage
				.builder()
				.id(pm.getInternetMessageId())
				.mailboxIds(folderPath)
				.inReplyToMessageId(pm.getInReplyToId())
				.isUnread(!pm.isRead())
				.isFlagged(pm.isFlagged())
				.isAnswered(pm.hasReplied())
				.hasAttachment(pm.hasAttachments())
				.from(JMAPEmailer.builder().name(pm.getSenderName())
						.email(pm.getSenderEmailAddress()).build())
				.to(getJMAPEmailerList(pm, PSTRecipient.MAPI_TO))
				.cc(getJMAPEmailerList(pm, PSTRecipient.MAPI_CC))
				.bcc(getJMAPEmailerList(pm, PSTRecipient.MAPI_BCC))
				.replyTo(
						JMAPEmailer.builder().name(pm.getSenderName())
								.email(pm.getSenderEmailAddress()).build())
				.subject(pm.getSubject())
				.date(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
						.format(pm.getMessageDeliveryTime()))
				.size(pm.getMessageSize()).textBody(pm.getBody())
				.htmlBody(pm.getBodyHTML())
				.attachments(getJMAPAttachmentList(pm)).build();
	}

	private List<JMAPEmailer> getJMAPEmailerList(PSTMessage msg, int type) {
		ArrayList<JMAPEmailer> emailers = null;
		try {
			for (int i = 0; i < msg.getNumberOfRecipients(); i++) {
				PSTRecipient pr = msg.getRecipient(i);
				if (pr.getRecipientType() == type) {
					if (emailers == null) {
						emailers = new ArrayList<JMAPEmailer>();
					}
					String name = pr.getDisplayName();
					String email = pr.getEmailAddress();
					emailers.add(JMAPEmailer.builder().name(name).email(email)
							.build());
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return emailers;
	}

	private List<JMAPAttachment> getJMAPAttachmentList(PSTMessage msg) {
		ArrayList<JMAPAttachment> attachments = null;
		try {
			for (int i = 0; i < msg.getNumberOfAttachments(); i++) {
				PSTAttachment pa = msg.getAttachment(i);
				if (attachments == null) {
					attachments = new ArrayList<JMAPAttachment>();
				}
				attachments.add(JMAPAttachment
						.builder()
						.id(new Integer(pa.getAttachNum()).toString())
						.url(saveAttachment(msg.getInternetMessageId(),
								pa.getAttachNum(), pa.getFileInputStream()))
						.type(pa.getMimeTag())
						.name(pa.getDisplayName())
						.size(pa.getAttachSize())
						.isInline(
								!pa.isAttachmentInvisibleInHtml()
										|| !pa.isAttachmentInvisibleInRTF())
						.build());
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return attachments;
	}

	private String saveAttachment(String mid, int aid, InputStream fis) {
		String rPath = null;
		try {
			String hash = sha256(mid);
			String fPath = OUTPUT_DIRECTORY + hash + "-att-" + aid;
			Files.copy(fis, Paths.get(fPath));
			rPath = fPath;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return rPath;
	}

	private String sha256(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
