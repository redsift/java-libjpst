package com.jmap.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Builder
public class JMAPMessage {

	@Getter private String id;
	@Getter private String threadId;
	@Getter private List<String> mailboxIds;
	@Getter private String inReplyToMessageId;
	@Getter private boolean isUnread;
	@Getter private boolean isFlagged;
	@Getter private boolean isAnswered;
	@Getter private boolean isDraft;
	@Getter private boolean hasAttachment;
	@Getter private String rawUrl;
	@Getter private Map<String, String> headers;
	@Getter private JMAPEmailer from;
	@Getter private List<JMAPEmailer> to;
	@Getter private List<JMAPEmailer> cc;
	@Getter private List<JMAPEmailer> bcc;
	@Getter private JMAPEmailer replyTo;
	@Getter private String subject;
	@Getter private String date;
	@Getter private long size;
	@Getter private String preview;
	@Getter private String textBody;
	@Getter private String htmlBody;
	@Getter private List<JMAPAttachment> attachments;
	@Getter private Map<String, JMAPMessage> attachedMessages;
}
