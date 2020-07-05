package com.chikoinc.apps.utility.docgenerator;

import java.io.Serializable;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class MethodDocumentations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String[] params;
	String description;
	String returnType;
	String exception;
}

@Getter
@Setter
public class DocumentationHolder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String className;
	String classDocumenation;
	List<MethodDocumentations> methods = Collections.emptyList();	
}
