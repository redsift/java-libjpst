package com.jmap.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @author randalpinto
 *
 */
@Builder
public class JMAPMessageExtensions {
	@Getter
	private List<String> folder;
}
