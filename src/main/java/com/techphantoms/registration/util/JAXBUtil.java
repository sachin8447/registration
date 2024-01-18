package com.techphantoms.registration.util;


import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String convertObjectToXml(Object object, Class<?> xmlClass) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(object , stringWriter);
            String xmlString = stringWriter.toString();
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Marshalling the Object");
            return null;
        }
    }

    public static Object convertXmlToObject(String xmlString, Class<?> objectClass) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(xmlString);
            Object object = jaxbUnmarshaller.unmarshal(stringReader);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in converting XML String to Object for Class : " + objectClass.getName());
            return null;
        }
    }

}
