package com.hcl.bdd.exception;

public class NoUserFound extends RuntimeException {
	
	public NoUserFound(String msg, Throwable cause)
	{
		super(msg, cause);
	}

}
