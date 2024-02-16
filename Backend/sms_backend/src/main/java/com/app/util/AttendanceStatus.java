package com.app.util;

public enum AttendanceStatus {
	ABSENT("Absent"),
	PRESENT("Present");
	
	private String text;
	private AttendanceStatus(String text)
	{
		this.text=text;
	}
	
	public String toString()
	{
		return this.text;
	}
}
