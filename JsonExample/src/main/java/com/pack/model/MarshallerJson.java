package com.pack.model;

import javax.xml.bind.JAXBException;

public class MarshallerJson {

	public static void main(String[] args) throws JAXBException {
		JaxBJsonHandler.jsonMarshaller();
		
		JaxBJsonHandler.jsonUnmarshaller();

	}

}
