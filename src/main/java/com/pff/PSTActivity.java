/**
 * Copyright 2010 Richard Johnson & Orin Eman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ---
 *
 * This file is part of java-libpst.
 *
 * java-libpst is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * java-libpst is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with java-libpst.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.pff;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * PSTActivity represents Journal entries
 * 
 * @author Richard Johnson
 */
public class PSTActivity extends PSTMessage {

	/**
	 * @param theFile
	 *            the PSTFile
	 * @param descriptorIndexNode
	 *            the node index
	 * @throws PSTException
	 *             file error
	 * @throws IOException
	 *             read error
	 */
	public PSTActivity(PSTFile theFile, DescriptorIndexNode descriptorIndexNode)
			throws PSTException, IOException {
		super(theFile, descriptorIndexNode);
	}

	/**
	 * @param theFile
	 *            the PSTFile
	 * @param folderIndexNode
	 *            the folder index
	 * @param table
	 *            the table
	 * @param localDescriptorItems
	 *            the descriptor items Map
	 */
	public PSTActivity(PSTFile theFile, DescriptorIndexNode folderIndexNode,
			PSTTableBC table,
			HashMap<Integer, PSTDescriptorItem> localDescriptorItems) {
		super(theFile, folderIndexNode, table, localDescriptorItems);
	}

	/**
	 * Type
	 * 
	 * @return String
	 */
	public String getLogType() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008700,
				PSTFile.PSETID_Log));
	}

	/**
	 * Start
	 * 
	 * @return Date
	 */
	public Date getLogStart() {
		return getDateItem(pstFile.getNameToIdMapItem(0x00008706,
				PSTFile.PSETID_Log));
	}

	/**
	 * Duration
	 * 
	 * @return int
	 */
	public int getLogDuration() {
		return getIntItem(pstFile.getNameToIdMapItem(0x00008707,
				PSTFile.PSETID_Log));
	}

	/**
	 * End
	 * 
	 * @return Date
	 */
	public Date getLogEnd() {
		return getDateItem(pstFile.getNameToIdMapItem(0x00008708,
				PSTFile.PSETID_Log));
	}

	/**
	 * LogFlags
	 * 
	 * @return int
	 */
	public int getLogFlags() {
		return getIntItem(pstFile.getNameToIdMapItem(0x0000870c,
				PSTFile.PSETID_Log));
	}

	/**
	 * DocPrinted
	 * 
	 * @return boolean
	 */
	public boolean isDocumentPrinted() {
		return (getBooleanItem(pstFile.getNameToIdMapItem(0x0000870e,
				PSTFile.PSETID_Log)));
	}

	/**
	 * DocSaved
	 * 
	 * @return boolean
	 */
	public boolean isDocumentSaved() {
		return (getBooleanItem(pstFile.getNameToIdMapItem(0x0000870f,
				PSTFile.PSETID_Log)));
	}

	/**
	 * DocRouted
	 * 
	 * @return boolean
	 */
	public boolean isDocumentRouted() {
		return (getBooleanItem(pstFile.getNameToIdMapItem(0x00008710,
				PSTFile.PSETID_Log)));
	}

	/**
	 * DocPosted
	 * 
	 * @return boolean
	 */
	public boolean isDocumentPosted() {
		return (getBooleanItem(pstFile.getNameToIdMapItem(0x00008711,
				PSTFile.PSETID_Log)));
	}

	/**
	 * Type Description
	 * 
	 * @return String
	 */
	public String getLogTypeDesc() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008712,
				PSTFile.PSETID_Log));
	}

	public String toString() {
		return "Type ASCII or Unicode string: " + getLogType() + "\n"
				+ "Start Filetime: " + getLogStart() + "\n"
				+ "Duration Integer 32-bit signed: " + getLogDuration() + "\n"
				+ "End Filetime: " + getLogEnd() + "\n"
				+ "LogFlags Integer 32-bit signed: " + getLogFlags() + "\n"
				+ "DocPrinted Boolean: " + isDocumentPrinted() + "\n"
				+ "DocSaved Boolean: " + isDocumentSaved() + "\n"
				+ "DocRouted Boolean: " + isDocumentRouted() + "\n"
				+ "DocPosted Boolean: " + isDocumentPosted() + "\n"
				+ "TypeDescription ASCII or Unicode string: "
				+ getLogTypeDesc();

	}

}
