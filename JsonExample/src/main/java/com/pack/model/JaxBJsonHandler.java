package com.pack.model;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

public class JaxBJsonHandler {

	public static void jsonMarshaller() throws JAXBException {
		Employee e=new Employee();
		e.setId(1);
		e.setName("Boney");
		e.setDesignation("Software Enginer");
		
		JAXBContext jx = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jx.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(e, System.out);

	}
	
	public static void jsonUnmarshaller() throws JAXBException {
		JAXBContext jx = JAXBContext.newInstance(Employee.class);
		Unmarshaller  unmarshaller = jx.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
		
		StreamSource json = new StreamSource(new StringReader("{\"employee\":{\"id\":1,\"name\":\"boney\",\"designation\":[\"software Engineer\"]}}"));
		Employee employee = unmarshaller.unmarshal(json, Employee.class) .getValue();	
				        System.out.println("Employee Id: " + employee.getId());
				        System.out.println("\nEmployee Name: " + employee.getName());
				        System.out.println("\nEmployee Designation: "+(employee.getDesignation()));
			
				    }

	}

