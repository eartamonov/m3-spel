package com.luxoft.springel.example08;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luxoft.springel.example08.Expression;


public class RegExAnnotationBasedTest {
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "example08/application-context.xml";
	private AbstractApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
	}
	
	@Test
	public void testRegEx() {
		Expression testRegEx = (Expression) context.getBean("expressionBean");
		assertEquals(testRegEx.getRegExResult(), "-Yes there is a match.");
		assertEquals(testRegEx.getNumberResult(), "-Yes this is digit.");
		System.out.println(testRegEx.toString());
	}
	
	@After
	public void tearDown() {
		context.close();
	}

}
