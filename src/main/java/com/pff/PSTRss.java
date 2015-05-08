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
import java.util.HashMap;

/**
 * Object that represents a RSS item
 * @author Richard Johnson
 */
public class PSTRss extends PSTMessage {

	/**
	 * @param theFile the PSTFile
	 * @param descriptorIndexNode the descriptor index node
	 * @throws PSTException file error
	 * @throws IOException read error
	 */
	public PSTRss(PSTFile theFile, DescriptorIndexNode descriptorIndexNode)
			throws PSTException, IOException {
		super(theFile, descriptorIndexNode);
	}

	/**
	 * @param theFile the PSTFile
	 * @param folderIndexNode the folder index
	 * @param table the table
	 * @param localDescriptorItems the local descriptors
	 */
	public PSTRss(PSTFile theFile, DescriptorIndexNode folderIndexNode,
			PSTTableBC table,
			HashMap<Integer, PSTDescriptorItem> localDescriptorItems) {
		super(theFile, folderIndexNode, table, localDescriptorItems);
	}
	
	/**
	 * Channel
	 * @return String
	 */
	public String getPostRssChannelLink() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008900, PSTFile.PSETID_PostRss));
	}
	/**
	 * Item link
	 * @return String
	 */
	public String getPostRssItemLink() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008901, PSTFile.PSETID_PostRss));
	}
	/**
	 * Item hash Integer 32-bit signed
	 * @return int
	 */
	public int getPostRssItemHash() {
		return getIntItem(pstFile.getNameToIdMapItem(0x00008902, PSTFile.PSETID_PostRss));
	}
	/**
	 * Item GUID
	 * @return String
	 */
	public String getPostRssItemGuid() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008903, PSTFile.PSETID_PostRss));
	}
	/**
	 * Channel GUID
	 * @return String
	 */
	public String getPostRssChannel() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008904, PSTFile.PSETID_PostRss));
	}
	/**
	 * Item XML
	 * @return String
	 */
	public String getPostRssItemXml() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008905, PSTFile.PSETID_PostRss));
	}
	/**
	 * Subscription
	 * @return String
	 */
	public String getPostRssSubscription() {
		return getStringItem(pstFile.getNameToIdMapItem(0x00008906, PSTFile.PSETID_PostRss));
	}

	public String toString() {
		return
		 "Channel ASCII or Unicode string values: "+ getPostRssChannelLink() + "\n" +
		 "Item link ASCII or Unicode string values: "+ getPostRssItemLink() + "\n" +
		 "Item hash Integer 32-bit signed: "+ getPostRssItemHash() + "\n" +
		 "Item GUID ASCII or Unicode string values: "+ getPostRssItemGuid() + "\n" +
		 "Channel GUID ASCII or Unicode string values: "+ getPostRssChannel() + "\n" +
		 "Item XML ASCII or Unicode string values: "+ getPostRssItemXml() + "\n" +
		 "Subscription ASCII or Unicode string values: "+ getPostRssSubscription();
	}
}
