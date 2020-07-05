package com.chikoinc.apps.utility.docgenerator;

import java.io.Serializable;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class MethodDocumentationsAPI implements Serializable {
	String name;
	List<String> paramTypes = Collections.emptyList();
	String comment;
	String returnType;
	List<String> tags = Collections.emptyList();
	Map<String, String> miscellaneousJavadoc = Collections.emptyMap();
	Map<String, String> params = Collections.emptyMap();
	Map<String, String> throwsDoc = Collections.emptyMap();
}

@Getter
@Setter
public class DocumenttionHolderAPI implements Serializable {
	String className;
	String classDocumenation;
	List<String> tags = Collections.emptyList();
	Map<String, String> miscellaneousJavadoc = Collections.emptyMap();
	List<MethodDocumentationsAPI> methods = Collections.emptyList();	
}
