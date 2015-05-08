package com.jmap.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jmap.model.JMAPAttachment;
import com.jmap.model.JMAPEmailer;
import com.jmap.model.JMAPMessage;
import com.jmap.model.JMAPMessageExtensions;
import com.jmap.utils.JMAPFileUtils;
import com.pff.PSTAttachment;
import com.pff.PSTMessage;
import com.pff.PSTRecipient;

public class JMAPMessageConverter {
			
	public static JMAPMessage getJMAPMessageWithoutAttachments(String mailboxName, PSTMessage pstMsg, List<String> folderPath) {
		return getJMAPMessageWithAttachments(mailboxName, pstMsg, folderPath, null);
	}
	
	public static JMAPMessage getJMAPMessageWithAttachments(String mailboxName, PSTMessage pstMsg, List<String> folderPath, String outputDirectory) {
		return JMAPMessage
				.builder()
				.id(pstMsg.getInternetMessageId())
				.mailboxIds(Arrays.asList(mailboxName))
				.inReplyToMessageId(pstMsg.getInReplyToId())
				.isUnread(!pstMsg.isRead())
				.isFlagged(pstMsg.isFlagged())
				.isAnswered(pstMsg.hasReplied())
				.hasAttachment(pstMsg.hasAttachments())
				.from(JMAPEmailer.builder().name(pstMsg.getSenderName())
						.email(pstMsg.getSenderEmailAddress()).build())
				.to(getJMAPEmailerList(pstMsg, PSTRecipient.MAPI_TO))
				.cc(getJMAPEmailerList(pstMsg, PSTRecipient.MAPI_CC))
				.bcc(getJMAPEmailerList(pstMsg, PSTRecipient.MAPI_BCC))
				.replyTo(
						JMAPEmailer.builder().name(pstMsg.getSenderName())
								.email(pstMsg.getSenderEmailAddress()).build())
				.subject(pstMsg.getSubject())
				.date(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
						.format(pstMsg.getMessageDeliveryTime()))
				.size(pstMsg.getMessageSize()).textBody(pstMsg.getBody())
				.htmlBody(pstMsg.getBodyHTML())
				.attachments(getJMAPAttachmentList(pstMsg, outputDirectory))
				.extensions(JMAPMessageExtensions
						.builder()
						.folder(folderPath)
						.build())
				.build();
	}

	
	private static List<JMAPEmailer> getJMAPEmailerList(PSTMessage msg, int type) {
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
	
	private static List<JMAPAttachment> getJMAPAttachmentList(PSTMessage msg, String outputDirectory) {
		ArrayList<JMAPAttachment> attachments = null;
		if(outputDirectory != null) {
			try {
				for (int i = 0; i < msg.getNumberOfAttachments(); i++) {
					PSTAttachment pa = msg.getAttachment(i);
					if (attachments == null) {
						attachments = new ArrayList<JMAPAttachment>();
					}
					attachments.add(JMAPAttachment
							.builder()
							.id(new Integer(pa.getAttachNum()).toString())
							.url(JMAPFileUtils.saveAttachment(msg.getInternetMessageId(),
									pa.getAttachNum(), pa.getFileInputStream(), outputDirectory))
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
		}
		return attachments;
	}
}
