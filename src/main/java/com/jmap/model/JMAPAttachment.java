package com.jmap.model;

import lombok.Builder;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @author randalpinto
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class JMAPAttachment {
	@Getter
	private String id;
	@Getter
	private String url;
	@Getter
	private String type;
	@Getter
	private String name;
	@Getter
	private long size;
	@Getter
	private boolean isInline;
	@Getter
	private Integer width;
	@Getter
	private Integer height;
}
