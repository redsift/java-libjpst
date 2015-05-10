package example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jmap.converter.JMAPMessageConverter;
import com.jmap.utils.JMAPFileUtils;
import com.pff.PSTException;
import com.pff.PSTFile;
import com.pff.PSTFolder;
import com.pff.PSTMessage;

/**
 * 
 * @author randalpinto
 *
 */
public class TestJMAP {

	private final String OUTPUT_DIRECTORY = "output/";
	private List<String> folderPath = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			TestJMAP importer = new TestJMAP();
			PSTFile pstFile = new PSTFile(args[0]);
			importer.processFolder(pstFile.getMessageStore().getDisplayName(),
					pstFile.getRootFolder());
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public void processFolder(String mboxName, PSTFolder folder)
			throws PSTException, java.io.IOException {
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
				processFolder(mboxName, childFolder);
			}
		}

		// and now the emails for this folder
		if (folder.getContentCount() > 0) {
			PSTMessage email = (PSTMessage) folder.getNextChild();
			while (email != null) {
				// System.out.println("Processing: " + email.toString());
				ObjectMapper mapper = new ObjectMapper();

				// TODO: remove indentation from production system
				mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
				mapper.configure(
						SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
				mapper.writeValue(
						new File(OUTPUT_DIRECTORY
								+ JMAPFileUtils.sha256(email
										.getInternetMessageId())),
						JMAPMessageConverter.getJMAPMessageWithAttachments(
								mboxName, email, folderPath, OUTPUT_DIRECTORY));

				email = (PSTMessage) folder.getNextChild();
			}
		}
		// Pop the current folder from the path as we are returning from
		// recursion
		if (folderPath.size() > 0) {
			folderPath.remove(folderPath.size() - 1);
		}
	}

}
