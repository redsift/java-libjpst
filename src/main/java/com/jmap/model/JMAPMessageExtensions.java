package com.jmap.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
public class JMAPMessageExtensions {
	@Getter private List<String> folder;
}
