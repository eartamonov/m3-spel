package com.luxoft.springel.example03;
import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luxoft.springel.example03.Country;
import com.luxoft.springel.example03.UsualPerson;

import java.util.List;
import java.util.ArrayList;

public class SpringELXmlBasedMethodInvocationTest {
	
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "example03/application-context.xml";
	private AbstractApplicationContext context;
	private UsualPerson expectedPerson;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		UsualPerson person = (UsualPerson) context.getBean("personBean");
//		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
		assertEquals(expectedPerson, person);
		
		System.out.println(person.getFullCountryInfo());
		assertEquals(person.getFullCountryInfo(), "1. Russia (RU)");
	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setId(1);
		person.setAge(35);
		person.setHeight(1.78F);
		person.setIsProgrammer(true);
		person.setName("Ivan Ivanov");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		List<String> contacts = new ArrayList<String>();
		contacts.add("asd@asd.ru");
		contacts.add("+7-234-456-67-89");

		person.setContacts(contacts);

		return person;
	}
	
	@After
	public void tearDown() {
		context.close();
	}
}
