package com.jmap.utils;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

import org.apache.commons.io.FileUtils;

public class JMAPFileUtils {
	public static String saveAttachment(String mid, int aid, InputStream fis, String outputDirectory) {
		String rPath = null;
		try {
			String hash = sha256(mid);
			String fPath = outputDirectory + hash + "-att-" + aid;
			FileUtils.copyInputStreamToFile(fis, new File(fPath));
			rPath = fPath;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return rPath;
	}

	public static String sha256(String base) {
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
