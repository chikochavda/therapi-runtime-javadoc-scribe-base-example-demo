package com.chikoinc.apps.controller;

import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chikoinc.apps.doc.DocumentGeneratorService;
import com.chikoinc.apps.utility.docgenerator.DocumenttionHolderAPI;


@RestController
@RequestMapping(path = "/", 
consumes = MediaType.APPLICATION_JSON_VALUE, 
produces = MediaType.APPLICATION_JSON_VALUE, 
method = {RequestMethod.GET, RequestMethod.POST})
public class DocumentationController {

    @Resource(name="documentGeneratorService")
    private DocumentGeneratorService documentGeneratorService;    
    
    @GetMapping("/test-class-documentation")
    public ResponseEntity<DocumenttionHolderAPI> getPostPublishActionDocumentation() throws IOException, ClassNotFoundException {
    	return new ResponseEntity<DocumenttionHolderAPI>(documentGeneratorService.getTestClassDocumentation(), HttpStatus.OK);
    }
}