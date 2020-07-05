package com.chikoinc.apps.utility.docgenerator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.github.therapi.runtimejavadoc.ClassJavadoc;
import com.github.therapi.runtimejavadoc.CommentFormatter;
import com.github.therapi.runtimejavadoc.MethodJavadoc;
import com.github.therapi.runtimejavadoc.OtherJavadoc;
import com.github.therapi.runtimejavadoc.RuntimeJavadoc;
import com.github.therapi.runtimejavadoc.SeeAlsoJavadoc;
import com.github.therapi.runtimejavadoc.ThrowsJavadoc;
import com.github.therapi.runtimejavadoc.*;
import com.github.therapi.runtimejavadoc.ParamJavadoc;

public class DocExtractorApiUtil {
    // formatters are reusable and thread-safe
    private static final CommentFormatter formatter = new CommentFormatter();

    public static DocumenttionHolderAPI getDocumentation(String fullyQualifiedClassName) throws IOException {
    	DocumenttionHolderAPI documentationHolder = new DocumenttionHolderAPI();
        ClassJavadoc classDoc = RuntimeJavadoc.getJavadoc(fullyQualifiedClassName);
        documentationHolder.setClassName(classDoc.getName());
        documentationHolder.setClassDocumenation(format(classDoc.getComment()));

                                
    	List<String> classTags = Collections.emptyList();
        // @see tags
        for (SeeAlsoJavadoc see : classDoc.getSeeAlso()) {
        	classTags.add("See also: " + see.getLink());
        }
        
        documentationHolder.setTags(classTags);
        
    	Map<String, String> classMiscellaneousJavadoc = Collections.emptyMap();

        // miscellaneous and custom javadoc tags (@author, etc.)
        for (OtherJavadoc other : classDoc.getOther()) {
        	classMiscellaneousJavadoc.put(other.getName() , format(other.getComment()));
        }
        documentationHolder.setMiscellaneousJavadoc(classMiscellaneousJavadoc);
        
    	List<MethodDocumentationsAPI> methods = Collections.emptyList();	

        for (MethodJavadoc methodDoc : classDoc.getMethods()) {
        	MethodDocumentationsAPI methodDocumentations = new MethodDocumentationsAPI();
        	methodDocumentations.setName(methodDoc.getName());
        	methodDocumentations.setParamTypes(methodDoc.getParamTypes());
        	methodDocumentations.setComment(format(methodDoc.getComment()));
        	methodDocumentations.setReturnType(format(methodDoc.getReturns()));
        	List<String> tags = Collections.emptyList();
            for (SeeAlsoJavadoc see : methodDoc.getSeeAlso()) {
            	tags.add("  See also: " + see.getLink());
            }            
            methodDocumentations.setTags(tags);
            
        	Map<String, String> miscellaneousJavadoc = Collections.emptyMap();
            for (OtherJavadoc other : methodDoc.getOther()) {
            	miscellaneousJavadoc.put(other.getName(), format(other.getComment()));
            }
            methodDocumentations.setMiscellaneousJavadoc(miscellaneousJavadoc);
            
        	Map<String, String> paramJavaDoc = Collections.emptyMap();
            for (ParamJavadoc paramDoc : methodDoc.getParams()) {
            	paramJavaDoc.put(paramDoc.getName(),  format(paramDoc.getComment()));
            }           
            methodDocumentations.setParams(paramJavaDoc);
            
            
            Map<String, String> throwsDocMap = Collections.emptyMap();
            
            for (ThrowsJavadoc throwsDoc : methodDoc.getThrows()) {
            	paramJavaDoc.put(throwsDoc.getName(),  format(throwsDoc.getComment()));
            }
            methodDocumentations.setThrowsDoc(throwsDocMap);
            
            methods.add(methodDocumentations);
        }
        documentationHolder.setMethods(methods);
        return documentationHolder;
    }

    private static String format(Comment c) {
        return formatter.format(c);
    }
}