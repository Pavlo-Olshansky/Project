package com.cooking.app.controller;

public class  DuplicateEntityException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String entityName;
	private final String fieldName;
	private final String fieldValue;

	public DuplicateEntityException(String entityName, String fieldName, String fieldValue) {
		super();
		this.entityName = entityName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	@Override
	public String getMessage() {
		return entityName + " with " + fieldName + " equal to " + fieldValue + " already exists!";
	}

	@Override
	public String toString() {
		return "DuplicateEntityException [entityName=" + entityName + ", fieldName=" + fieldName + ", fieldValue="
				+ fieldValue + "]";
	}

}
