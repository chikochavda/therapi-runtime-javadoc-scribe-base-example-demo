package com.chikoinc.documentationannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodDocumenationHolder {
	    String name();
	    String description();
	    String returnvalue();
	    String[] paramDetails();
	    String exceptionDetails() default "";
}
