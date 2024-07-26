package org.all;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.data.FailureClass;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AllFailures implements IAnnotationTransformer {
	
	@Override
	public void transform(ITestAnnotation annotation, 
			Class testClass, Constructor testConstructor, 
			Method testMethod) {
		
		annotation.setRetryAnalyzer(FailureClass.class);
		
	}

}
