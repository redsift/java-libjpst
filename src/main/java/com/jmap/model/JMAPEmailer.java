package com.jmap.model;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @author randalpinto
 *
 */
@Builder
public class JMAPEmailer {
	@Getter
	private String name;
	@Getter
	private String email;
}
