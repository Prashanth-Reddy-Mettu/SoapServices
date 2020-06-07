package com.prashanth.spring.soap.api.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,customFaultCode="{http://prashanth.com/spring/soap/api/alarmdetails}001_ALARM_NOT_FOUND")
//@SoapFault(faultCode = FaultCode.CLIENT)
public class MyException extends Exception {

	public MyException(String message) {
		super(message);
	}

}
