package com.jmap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
public class JMAPEmailer {
	@Getter private String name;
	@Getter private String email;
}
