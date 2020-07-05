package com.chikoinc.apps.utility.docgenerator;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.chikoinc.documentationannotations.ClassDocumenationHolder;
import com.chikoinc.documentationannotations.MethodDocumenationHolder;

public class DocExtractorUtil {
    /**
     * 
     * @param classForDocumentation
     * @return
     */
    private static ClassDocumenationHolder getClassAnnotation(Class<?> classForDocumentation) {
    	Annotation annotation = classForDocumentation.getAnnotation(ClassDocumenationHolder.class);
    	ClassDocumenationHolder classDocumenationHolder = (ClassDocumenationHolder) annotation;
    	return classDocumenationHolder;
    }
    public static DocumentationHolder getDocumentation(String fullyQualifiedClassName) throws IOException, ClassNotFoundException {
    	
    	Class<?> classForDocumentation = Class.forName(fullyQualifiedClassName);
    	
    	DocumentationHolder documentationHolder = new DocumentationHolder();
        if (!classForDocumentation.isAnnotationPresent(ClassDocumenationHolder.class)) {
        	return documentationHolder;
        }
        ClassDocumenationHolder annotation = getClassAnnotation(classForDocumentation);
       
        documentationHolder.setClassName(annotation.name());
        documentationHolder.setClassDocumenation(annotation.description());

        
    	List<MethodDocumentations> methods = new ArrayList<MethodDocumentations>();	

        for (Method methodDoc : classForDocumentation.getMethods()) {
        	if (methodDoc.isAnnotationPresent(MethodDocumenationHolder.class)) {
				MethodDocumentations methodDocumentations = new MethodDocumentations();
				MethodDocumenationHolder methodAnnotation = methodDoc.getAnnotation(MethodDocumenationHolder.class);
				methodDocumentations.setName(methodDoc.getName());
				methodDocumentations.setParams(methodAnnotation.paramDetails());
				methodDocumentations.setDescription(methodAnnotation.description());
				methodDocumentations.setReturnType(methodAnnotation.returnvalue());
				methodDocumentations.setException(methodAnnotation.exceptionDetails());
				methods.add(methodDocumentations);
        	}
        }
        documentationHolder.setMethods(methods);
        return documentationHolder;
    }
}