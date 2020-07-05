package com.chikoinc.apps.doc;

import java.io.IOException;

import com.chikoinc.apps.utility.docgenerator.DocumenttionHolderAPI;

public interface DocumentGeneratorService {

	public DocumenttionHolderAPI getTestClassDocumentation() throws IOException, ClassNotFoundException;

}
