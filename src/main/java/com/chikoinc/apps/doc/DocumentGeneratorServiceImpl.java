package com.chikoinc.apps.doc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.chikoinc.apps.utility.docgenerator.DocExtractorApiUtil;
import com.chikoinc.apps.utility.docgenerator.DocumenttionHolderAPI;

enum ClassNames {
	TESTCLASS
}

@Service("documentGeneratorService")
public class DocumentGeneratorServiceImpl implements DocumentGeneratorService {
	
	static Map<ClassNames, String> fullyQualifiedClassName = new HashMap<ClassNames, String>();
	
	static {		
		fullyQualifiedClassName.put(ClassNames.TESTCLASS, "com.chikoinc.ConnectorBaseHelperUtils");
	}
	
	@Override
	public DocumenttionHolderAPI getTestClassDocumentation() throws IOException, ClassNotFoundException {
		return DocExtractorApiUtil.getDocumentation(fullyQualifiedClassName.get(ClassNames.TESTCLASS));
	}
}
