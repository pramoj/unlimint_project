package com.unlimint.orders_parser.enums;

public enum FileType {

	CSV("CSV"),

	JSON("JSON");

	public String value;

	FileType(final String value) {

		this.value = value;
	}
}
