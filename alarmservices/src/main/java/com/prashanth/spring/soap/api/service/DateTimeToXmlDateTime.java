package com.prashanth.spring.soap.api.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateTimeToXmlDateTime {
	public static XMLGregorianCalendar convertLocalDateToXmlDate(LocalDateTime datetime) {
		GregorianCalendar gCalendar = GregorianCalendar.from(datetime.atZone(ZoneId.systemDefault()));
       
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            System.out.println(ex+"\n Date And TIme Exception !@#");
        }
        return xmlCalendar;
	}
}