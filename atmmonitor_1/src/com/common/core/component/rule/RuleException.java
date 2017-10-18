package com.common.core.component.rule;


public class RuleException extends Exception{
	
	private static final long serialVersionUID = -3010345764122748053L;
	public RuleException(String message) {
		super(message);
	}
	public RuleException(Exception exception) {
		super(exception);
	}
	public RuleException(String message, Exception exception) {
		super(message, exception);
	}	
}
