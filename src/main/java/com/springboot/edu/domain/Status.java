package com.springboot.edu.domain;

public enum Status {

	SOLVENT(1, "SOLVENT"),
	FRAUDSTER(2, "FRAUDSTER"),
	VIP(3, "VIP");

	Status(int code, String name) {
		this.code = code;
		this.name = name;
	}

	private int code;
	private String name;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

