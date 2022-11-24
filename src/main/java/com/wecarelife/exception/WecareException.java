package com.wecarelife.exception;

public class WecareException extends Exception{

	private static final long serialVersionUID = 1L;
	public WecareException(String errors) {
		super(errors);
	}
}
