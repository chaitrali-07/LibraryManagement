package com.library;

public class LibBook {
	private int bkid;
	private int bkqun;
	private String bkgener;
	private String bkname;
	private String authname;
	
	public LibBook(int bkid,int bkqun, String bkgener, String bkname, String authname) 
	{
		super();
		this.bkid = bkid;
		this.bkqun = bkqun;
		this.bkgener = bkgener;
		this.bkname = bkname;
		this.authname = authname;
	}

	public int getBkqun() {
		return bkqun;
	}

	public void setBkqun(int bkqun) {
		this.bkqun = bkqun;
	}

	public int getBkid() {
		return bkid;
	}

	public void setBkid(int bkid) {
		this.bkid = bkid;
	}

	public String getBkgener() {
		return bkgener;
	}

	public void setBkgener(String bkgener) {
		this.bkgener = bkgener;
	}

	public String getBkname() {
		return bkname;
	}

	public void setBkname(String bkname) {
		this.bkname = bkname;
	}

	public String getAuthname() {
		return authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	
}
