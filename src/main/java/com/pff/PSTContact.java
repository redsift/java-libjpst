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
 * Class for Contacts
 * 
 * @author Richard Johnson
 */
public class PSTContact extends PSTMessage {

	/**
	 * @param theFile the PSTFile
	 * @param descriptorIndexNode the descriptor index
	 * @throws PSTException file error
	 * @throws IOException read error
	 */
	public PSTContact(PSTFile theFile, DescriptorIndexNode descriptorIndexNode)
			throws PSTException, IOException {
		super(theFile, descriptorIndexNode);
	}

	/**
	 * @param theFile the PSTFile
	 * @param folderIndexNode the folder index
	 * @param table the table
	 * @param localDescriptorItems the descriptor Map
	 */
	public PSTContact(PSTFile theFile, DescriptorIndexNode folderIndexNode,
			PSTTableBC table,
			HashMap<Integer, PSTDescriptorItem> localDescriptorItems) {
		super(theFile, folderIndexNode, table, localDescriptorItems);
	}

	/**
	 * Contact's Account name
	 * 
	 * @return String
	 */
	public String getAccount() {
		return this.getStringItem(0x3a00);
	}

	/**
	 * Callback telephone number
	 * 
	 * @return String
	 */
	public String getCallbackTelephoneNumber() {
		return this.getStringItem(0x3a02);
	}

	/**
	 * Contact's generational abbreviation FTK: Name suffix
	 * 
	 * @return String
	 */
	public String getGeneration() {
		return this.getStringItem(0x3a05);
	}

	/**
	 * Contacts given name
	 * 
	 * @return String
	 */
	public String getGivenName() {
		return this.getStringItem(0x3a06);
	}

	/**
	 * Contacts Government ID Number
	 * 
	 * @return String
	 */
	public String getGovernmentIdNumber() {
		return this.getStringItem(0x3a07);
	}

	/**
	 * Business/Office Telephone Number
	 * 
	 * @return String
	 */
	public String getBusinessTelephoneNumber() {
		return this.getStringItem(0x3a08);
	}

	/**
	 * Home Telephone Number
	 * 
	 * @return String
	 */
	public String getHomeTelephoneNumber() {
		return this.getStringItem(0x3a09);
	}

	/**
	 * Contacts initials
	 * 
	 * @return String
	 */
	public String getInitials() {
		return this.getStringItem(0x3a0a);
	}

	/**
	 * Keyword
	 * 
	 * @return String
	 */
	public String getKeyword() {
		return this.getStringItem(0x3a0b);
	}

	/**
	 * Contact's language
	 * 
	 * @return String
	 */
	public String getLanguage() {
		return this.getStringItem(0x3a0c);
	}

	/**
	 * Contact's location
	 * 
	 * @return String
	 */
	public String getLocation() {
		return this.getStringItem(0x3a0d);
	}

	/**
	 * MHS Common Name
	 * 
	 * @return String
	 */
	public String getMhsCommonName() {
		return this.getStringItem(0x3a0f);
	}

	/**
	 * Organizational identification number
	 * 
	 * @return String
	 */
	public String getOrganizationalIdNumber() {
		return this.getStringItem(0x3a10);
	}

	/**
	 * Contact's surname FTK: Last name
	 * 
	 * @return String
	 */
	public String getSurname() {
		return this.getStringItem(0x3a11);
	}

	/**
	 * Original display name
	 * 
	 * @return String
	 */
	public String getOriginalDisplayName() {
		return this.getStringItem(0x3a13);
	}

	/**
	 * Default Postal Address
	 * 
	 * @return String
	 */
	public String getPostalAddress() {
		return this.getStringItem(0x3a15);
	}

	/**
	 * Contact's company name
	 * 
	 * @return String
	 */
	public String getCompanyName() {
		return this.getStringItem(0x3a16);
	}

	/**
	 * Contact's job title FTK: Profession
	 * 
	 * @return String
	 */
	public String getTitle() {
		return this.getStringItem(0x3a17);
	}

	/**
	 * Contact's department name Used in contact item
	 * 
	 * @return String
	 */
	public String getDepartmentName() {
		return this.getStringItem(0x3a18);
	}

	/**
	 * Contact's office location
	 * 
	 * @return String
	 */
	public String getOfficeLocation() {
		return this.getStringItem(0x3a19);
	}

	/**
	 * Primary Telephone
	 * 
	 * @return String
	 */
	public String getPrimaryTelephoneNumber() {
		return this.getStringItem(0x3a1a);
	}

	/**
	 * Contact's secondary office (business) phone number
	 * 
	 * @return String
	 */
	public String getBusiness2TelephoneNumber() {
		return this.getStringItem(0x3a1b);
	}

	/**
	 * Mobile Phone Number
	 * 
	 * @return String
	 */
	public String getMobileTelephoneNumber() {
		return this.getStringItem(0x3a1c);
	}

	/**
	 * Radio Phone Number
	 * 
	 * @return String
	 */
	public String getRadioTelephoneNumber() {
		return this.getStringItem(0x3a1d);
	}

	/**
	 * Car Phone Number
	 * 
	 * @return String
	 */
	public String getCarTelephoneNumber() {
		return this.getStringItem(0x3a1e);
	}

	/**
	 * Other Phone Number
	 * 
	 * @return String
	 */
	public String getOtherTelephoneNumber() {
		return this.getStringItem(0x3a1f);
	}

	/**
	 * Transmittable display name
	 * 
	 * @return String
	 */
	public String getTransmittableDisplayName() {
		return this.getStringItem(0x3a20);
	}

	/**
	 * Pager Phone Number
	 * 
	 * @return String
	 */
	public String getPagerTelephoneNumber() {
		return this.getStringItem(0x3a21);
	}

	/**
	 * Primary Fax Number
	 * 
	 * @return String
	 */
	public String getPrimaryFaxNumber() {
		return this.getStringItem(0x3a23);
	}

	/**
	 * Contact's office (business) fax number
	 * 
	 * @return String
	 */
	public String getBusinessFaxNumber() {
		return this.getStringItem(0x3a24);
	}

	/**
	 * Contact's home fax number
	 * 
	 * @return String
	 */
	public String getHomeFaxNumber() {
		return this.getStringItem(0x3a25);
	}

	/**
	 * Business Address Country
	 * 
	 * @return String
	 */
	public String getBusinessAddressCountry() {
		return this.getStringItem(0x3a26);
	}

	/**
	 * Business Address City
	 * 
	 * @return String
	 */
	public String getBusinessAddressCity() {
		return this.getStringItem(0x3a27);
	}

	/**
	 * Business Address State
	 * 
	 * @return String
	 */
	public String getBusinessAddressStateOrProvince() {
		return this.getStringItem(0x3a28);
	}

	/**
	 * Business Address Street
	 * 
	 * @return String
	 */
	public String getBusinessAddressStreet() {
		return this.getStringItem(0x3a29);
	}

	/**
	 * Business Postal Code
	 * 
	 * @return String
	 */
	public String getBusinessPostalCode() {
		return this.getStringItem(0x3a2a);
	}

	/**
	 * Business PO Box
	 * 
	 * @return String
	 */
	public String getBusinessPoBox() {
		return this.getStringItem(0x3a2b);
	}

	/**
	 * Telex Number
	 * 
	 * @return String
	 */
	public String getTelexNumber() {
		return this.getStringItem(0x3a2c);
	}

	/**
	 * ISDN Number
	 * 
	 * @return String
	 */
	public String getIsdnNumber() {
		return this.getStringItem(0x3a2d);
	}

	/**
	 * Assistant Phone Number
	 * 
	 * @return String
	 */
	public String getAssistantTelephoneNumber() {
		return this.getStringItem(0x3a2e);
	}

	/**
	 * Home Phone 2
	 * 
	 * @return String
	 */
	public String getHome2TelephoneNumber() {
		return this.getStringItem(0x3a2f);
	}

	/**
	 * Assistant's Name
	 * 
	 * @return String
	 */
	public String getAssistant() {
		return this.getStringItem(0x3a30);
	}

	/**
	 * Hobbies
	 * 
	 * @return String
	 */
	public String getHobbies() {
		return this.getStringItem(0x3a43);
	}

	/**
	 * Middle Name
	 * 
	 * @return String
	 */
	public String getMiddleName() {
		return this.getStringItem(0x3a44);
	}

	/**
	 * Display Name Prefix (Contact Title)
	 * 
	 * @return String
	 */
	public String getDisplayNamePrefix() {
		return this.getStringItem(0x3a45);
	}

	/**
	 * Profession
	 * 
	 * @return String
	 */
	public String getProfession() {
		return this.getStringItem(0x3a46);
	}

	/**
	 * Preferred By Name
	 * 
	 * @return String
	 */
	public String getPreferredByName() {
		return this.getStringItem(0x3a47);
	}

	/**
	 * Spouse's Name
	 * 
	 * @return String
	 */
	public String getSpouseName() {
		return this.getStringItem(0x3a48);
	}

	/**
	 * Computer Network Name
	 * 
	 * @return String
	 */
	public String getComputerNetworkName() {
		return this.getStringItem(0x3a49);
	}

	/**
	 * Customer ID
	 * 
	 * @return String
	 */
	public String getCustomerId() {
		return this.getStringItem(0x3a4a);
	}

	/**
	 * TTY/TDD Phone
	 * 
	 * @return String
	 */
	public String getTtytddPhoneNumber() {
		return this.getStringItem(0x3a4b);
	}

	/**
	 * Ftp Site
	 * 
	 * @return String
	 */
	public String getFtpSite() {
		return this.getStringItem(0x3a4c);
	}

	/**
	 * Manager's Name
	 * 
	 * @return String
	 */
	public String getManagerName() {
		return this.getStringItem(0x3a4e);
	}

	/**
	 * Nickname
	 * 
	 * @return String
	 */
	public String getNickname() {
		return this.getStringItem(0x3a4f);
	}

	/**
	 * Personal Home Page
	 * 
	 * @return String
	 */
	public String getPersonalHomePage() {
		return this.getStringItem(0x3a50);
	}

	/**
	 * Business Home Page
	 * 
	 * @return String
	 */
	public String getBusinessHomePage() {
		return this.getStringItem(0x3a51);
	}

	/**
	 * Note
	 * 
	 * @return String
	 */
	public String getNote() {
		return this.getStringItem(0x6619);
	}

	String getNamedStringItem(int key) {
		int id = pstFile.getNameToIdMapItem(key, PSTFile.PSETID_Address);
		if (id != -1) {
			return getStringItem(id);
		}
		return "";
	}

	public String getSMTPAddress() {
		return getNamedStringItem(0x00008084);
	}

	/**
	 * Company Main Phone
	 * 
	 * @return String
	 */
	public String getCompanyMainPhoneNumber() {
		return getStringItem(0x3a57);
	}

	/**
	 * Children's names
	 * 
	 * @return String
	 */
	public String getChildrensNames() {
		return this.getStringItem(0x3a58);
	}

	/**
	 * Home Address City
	 * 
	 * @return String
	 */
	public String getHomeAddressCity() {
		return this.getStringItem(0x3a59);
	}

	/**
	 * Home Address Country
	 * 
	 * @return String
	 */
	public String getHomeAddressCountry() {
		return this.getStringItem(0x3a5a);
	}

	/**
	 * Home Address Postal Code
	 * 
	 * @return String
	 */
	public String getHomeAddressPostalCode() {
		return this.getStringItem(0x3a5b);
	}

	/**
	 * Home Address State or Province
	 * 
	 * @return String
	 */
	public String getHomeAddressStateOrProvince() {
		return this.getStringItem(0x3a5c);
	}

	/**
	 * Home Address Street
	 * 
	 * @return String
	 */
	public String getHomeAddressStreet() {
		return this.getStringItem(0x3a5d);
	}

	/**
	 * Home Address Post Office Box
	 * 
	 * @return String
	 */
	public String getHomeAddressPostOfficeBox() {
		return this.getStringItem(0x3a5e);
	}

	/**
	 * Other Address City
	 * 
	 * @return String
	 */
	public String getOtherAddressCity() {
		return this.getStringItem(0x3a5f);
	}

	/**
	 * Other Address Country
	 * 
	 * @return String
	 */
	public String getOtherAddressCountry() {
		return this.getStringItem(0x3a60);
	}

	/**
	 * Other Address Postal Code
	 * 
	 * @return String
	 */
	public String getOtherAddressPostalCode() {
		return this.getStringItem(0x3a61);
	}

	/**
	 * Other Address State
	 * 
	 * @return String
	 */
	public String getOtherAddressStateOrProvince() {
		return this.getStringItem(0x3a62);
	}

	/**
	 * Other Address Street
	 * 
	 * @return String
	 */
	public String getOtherAddressStreet() {
		return this.getStringItem(0x3a63);
	}

	/**
	 * Other Address Post Office box
	 * 
	 * @return String
	 */
	public String getOtherAddressPostOfficeBox() {
		return this.getStringItem(0x3a64);
	}

	// /////////////////////////////////////////////////
	// Below are the values from the name to id map...
	// /////////////////////////////////////////////////

	/**
	 * File under FTK: File as
	 * 
	 * @return String
	 */
	public String getFileUnder() {
		return getNamedStringItem(0x00008005);
	}

	/**
	 * Home Address
	 * 
	 * @return String
	 */
	public String getHomeAddress() {
		return getNamedStringItem(0x0000801a);
	}

	/**
	 * Business Address
	 * 
	 * @return String
	 */
	public String getWorkAddress() {
		return getNamedStringItem(0x0000801b);
	}

	/**
	 * Other Address
	 * 
	 * @return String
	 */
	public String getOtherAddress() {
		return getNamedStringItem(0x0000801c);
	}

	/**
	 * Selected Mailing Address
	 * 
	 * @return String
	 */
	public int getPostalAddressId() {
		return getIntItem(pstFile.getNameToIdMapItem(0x00008022,
				PSTFile.PSETID_Address));
	}

	/**
	 * Webpage
	 * 
	 * @return String
	 */
	public String getHtml() {
		return getNamedStringItem(0x0000802b);
	}

	/**
	 * Business Address City
	 * 
	 * @return String
	 */
	public String getWorkAddressStreet() {
		return getNamedStringItem(0x00008045);
	}

	/**
	 * Business Address Street
	 * 
	 * @return String
	 */
	public String getWorkAddressCity() {
		return getNamedStringItem(0x00008046);
	}

	/**
	 * Business Address State
	 * 
	 * @return String
	 */
	public String getWorkAddressState() {
		return getNamedStringItem(0x00008047);
	}

	/**
	 * Business Address Postal Code
	 * 
	 * @return String
	 */
	public String getWorkAddressPostalCode() {
		return getNamedStringItem(0x00008048);
	}

	/**
	 * Business Address Country
	 * 
	 * @return String
	 */
	public String getWorkAddressCountry() {
		return getNamedStringItem(0x00008049);
	}

	/**
	 * Business Address Country
	 * 
	 * @return String
	 */
	public String getWorkAddressPostOfficeBox() {
		return getNamedStringItem(0x0000804A);
	}

	/**
	 * IM Address
	 * 
	 * @return String
	 */
	public String getInstantMessagingAddress() {
		return getNamedStringItem(0x00008062);
	}

	/**
	 * E-mail1 Display Name
	 * 
	 * @return String
	 */
	public String getEmail1DisplayName() {
		return getNamedStringItem(0x00008080);
	}

	/**
	 * E-mail1 Address Type
	 * 
	 * @return String
	 */
	public String getEmail1AddressType() {
		return getNamedStringItem(0x00008082);
	}

	/**
	 * E-mail1 Address
	 * 
	 * @return String
	 */
	public String getEmail1EmailAddress() {
		return getNamedStringItem(0x00008083);
	}

	/**
	 * E-mail1 Display Name
	 * 
	 * @return String
	 */
	public String getEmail1OriginalDisplayName() {
		return getNamedStringItem(0x00008084);
	}

	/**
	 * E-mail1 type
	 * 
	 * @return String
	 */
	public String getEmail1EmailType() {
		return getNamedStringItem(0x00008087);
	}

	/**
	 * E-mail2 display name
	 * 
	 * @return String
	 */
	public String getEmail2DisplayName() {
		return getNamedStringItem(0x00008090);
	}

	/**
	 * E-mail2 address type
	 * 
	 * @return String
	 */
	public String getEmail2AddressType() {
		return getNamedStringItem(0x00008092);
	}

	/**
	 * E-mail2 e-mail address
	 * 
	 * @return String
	 */
	public String getEmail2EmailAddress() {
		return getNamedStringItem(0x00008093);
	}

	/**
	 * E-mail2 original display name
	 * 
	 * @return String
	 */
	public String getEmail2OriginalDisplayName() {
		return getNamedStringItem(0x00008094);
	}

	/**
	 * E-mail3 display name
	 * 
	 * @return String
	 */
	public String getEmail3DisplayName() {
		return getNamedStringItem(0x000080a0);
	}

	/**
	 * E-mail3 address type
	 * 
	 * @return String
	 */
	public String getEmail3AddressType() {
		return getNamedStringItem(0x000080a2);
	}

	/**
	 * E-mail3 e-mail address
	 * 
	 * @return String
	 */
	public String getEmail3EmailAddress() {
		return getNamedStringItem(0x000080a3);
	}

	/**
	 * E-mail3 original display name
	 * 
	 * @return String
	 */
	public String getEmail3OriginalDisplayName() {
		return getNamedStringItem(0x000080a4);
	}

	/**
	 * Fax1 Address Type
	 * 
	 * @return String
	 */
	public String getFax1AddressType() {
		return getNamedStringItem(0x000080b2);
	}

	/**
	 * Fax1 Email Address
	 * 
	 * @return String
	 */
	public String getFax1EmailAddress() {
		return getNamedStringItem(0x000080b3);
	}

	/**
	 * Fax1 Original Display Name
	 * 
	 * @return String
	 */
	public String getFax1OriginalDisplayName() {
		return getNamedStringItem(0x000080b4);
	}

	/**
	 * Fax2 Address Type
	 * 
	 * @return String
	 */
	public String getFax2AddressType() {
		return getNamedStringItem(0x000080c2);
	}

	/**
	 * Fax2 Email Address
	 * 
	 * @return String
	 */
	public String getFax2EmailAddress() {
		return getNamedStringItem(0x000080c3);
	}

	/**
	 * Fax2 Original Display Name
	 * 
	 * @return String
	 */
	public String getFax2OriginalDisplayName() {
		return getNamedStringItem(0x000080c4);
	}

	/**
	 * Fax3 Address Type
	 * 
	 * @return String
	 */
	public String getFax3AddressType() {
		return getNamedStringItem(0x000080d2);
	}

	/**
	 * Fax3 Email Address
	 * 
	 * @return String
	 */
	public String getFax3EmailAddress() {
		return getNamedStringItem(0x000080d3);
	}

	/**
	 * Fax3 Original Display Name
	 * 
	 * @return String
	 */
	public String getFax3OriginalDisplayName() {
		return getNamedStringItem(0x000080d4);
	}

	/**
	 * Free/Busy Location (URL)
	 * 
	 * @return String
	 */
	public String getFreeBusyLocation() {
		return getNamedStringItem(0x000080d8);
	}

	/**
	 * Birthday
	 * 
	 * @return String
	 */
	public Date getBirthday() {
		return this.getDateItem(0x3a42);
	}

	/**
	 * (Wedding) Anniversary
	 * 
	 * @return String
	 */
	public Date getAnniversary() {
		return this.getDateItem(0x3a41);
	}

	public String toString() {

		return "Contact's Account name: " + getAccount() + "\n"
				+ "Display Name: " + getGivenName() + " " + getSurname() + " ("
				+ getSMTPAddress() + ")\n" + "Email1 Address Type: "
				+ getEmail1AddressType() + "\n" + "Email1 Address: "
				+ getEmail1EmailAddress() + "\n"
				+ "Callback telephone number: " + getCallbackTelephoneNumber()
				+ "\n" + "Contact's generational abbreviation (name suffix): "
				+ getGeneration() + "\n" + "Contacts given name: "
				+ getGivenName() + "\n" + "Contacts Government ID Number: "
				+ getGovernmentIdNumber() + "\n"
				+ "Business/Office Telephone Number: "
				+ getBusinessTelephoneNumber() + "\n"
				+ "Home Telephone Number: " + getHomeTelephoneNumber() + "\n"
				+ "Contacts initials: " + getInitials() + "\n" + "Keyword: "
				+ getKeyword() + "\n" + "Contact's language: " + getLanguage()
				+ "\n" + "Contact's location: " + getLocation() + "\n"
				+ "MHS Common Name: " + getMhsCommonName() + "\n"
				+ "Organizational identification number: "
				+ getOrganizationalIdNumber() + "\n"
				+ "Contact's surname  (Last name): " + getSurname() + "\n"
				+ "Original display name: " + getOriginalDisplayName() + "\n"
				+ "Default Postal Address: " + getPostalAddress() + "\n"
				+ "Contact's company name: " + getCompanyName() + "\n"
				+ "Contact's job title (Profession): " + getTitle() + "\n"
				+ "Contact's department name  Used in contact ite: "
				+ getDepartmentName() + "\n" + "Contact's office location: "
				+ getOfficeLocation() + "\n" + "Primary Telephone: "
				+ getPrimaryTelephoneNumber() + "\n"
				+ "Contact's secondary office (business) phone number: "
				+ getBusiness2TelephoneNumber() + "\n"
				+ "Mobile Phone Number: " + getMobileTelephoneNumber() + "\n"
				+ "Radio Phone Number: " + getRadioTelephoneNumber() + "\n"
				+ "Car Phone Number: " + getCarTelephoneNumber() + "\n"
				+ "Other Phone Number: " + getOtherTelephoneNumber() + "\n"
				+ "Transmittable display name: "
				+ getTransmittableDisplayName() + "\n" + "Pager Phone Number: "
				+ getPagerTelephoneNumber() + "\n" + "Primary Fax Number: "
				+ getPrimaryFaxNumber() + "\n"
				+ "Contact's office (business) fax numbe: "
				+ getBusinessFaxNumber() + "\n" + "Contact's home fax number: "
				+ getHomeFaxNumber() + "\n" + "Business Address Country: "
				+ getBusinessAddressCountry() + "\n"
				+ "Business Address City: " + getBusinessAddressCity() + "\n"
				+ "Business Address State: "
				+ getBusinessAddressStateOrProvince() + "\n"
				+ "Business Address Street: " + getBusinessAddressStreet()
				+ "\n" + "Business Postal Code: " + getBusinessPostalCode()
				+ "\n" + "Business PO Box: " + getBusinessPoBox() + "\n"
				+ "Telex Number: " + getTelexNumber() + "\n" + "ISDN Number: "
				+ getIsdnNumber() + "\n" + "Assistant Phone Number: "
				+ getAssistantTelephoneNumber() + "\n" + "Home Phone 2: "
				+ getHome2TelephoneNumber() + "\n" + "Assistant's Name: "
				+ getAssistant() + "\n" + "Hobbies: " + getHobbies() + "\n"
				+ "Middle Name: " + getMiddleName() + "\n"
				+ "Display Name Prefix (Contact Title): "
				+ getDisplayNamePrefix() + "\n" + "Profession: "
				+ getProfession() + "\n" + "Preferred By Name: "
				+ getPreferredByName() + "\n" + "Spouse's Name: "
				+ getSpouseName() + "\n" + "Computer Network Name: "
				+ getComputerNetworkName() + "\n" + "Customer ID: "
				+ getCustomerId() + "\n" + "TTY/TDD Phone: "
				+ getTtytddPhoneNumber() + "\n" + "Ftp Site: " + getFtpSite()
				+ "\n" + "Manager's Name: " + getManagerName() + "\n"
				+ "Nickname: " + getNickname() + "\n" + "Personal Home Page: "
				+ getPersonalHomePage() + "\n" + "Business Home Page: "
				+ getBusinessHomePage() + "\n" + "Company Main Phone: "
				+ getCompanyMainPhoneNumber() + "\n" + "Childrens names: "
				+ getChildrensNames() + "\n" + "Home Address City: "
				+ getHomeAddressCity() + "\n" + "Home Address Country: "
				+ getHomeAddressCountry() + "\n" + "Home Address Postal Code: "
				+ getHomeAddressPostalCode() + "\n"
				+ "Home Address State or Province: "
				+ getHomeAddressStateOrProvince() + "\n"
				+ "Home Address Street: " + getHomeAddressStreet() + "\n"
				+ "Home Address Post Office Box: "
				+ getHomeAddressPostOfficeBox() + "\n" + "Other Address City: "
				+ getOtherAddressCity() + "\n" + "Other Address Country: "
				+ getOtherAddressCountry() + "\n"
				+ "Other Address Postal Code: " + getOtherAddressPostalCode()
				+ "\n" + "Other Address State: "
				+ getOtherAddressStateOrProvince() + "\n"
				+ "Other Address Street: " + getOtherAddressStreet() + "\n"
				+ "Other Address Post Office box: "
				+ getOtherAddressPostOfficeBox() + "\n" + "\n" + this.getBody();
	}
}
