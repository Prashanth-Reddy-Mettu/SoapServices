package com.prashanth.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.prashanth.spring.soap.api.exceptions.MyException;
import com.prashanth.spring.soap.api.service.AlarmRepository;

import cpm.prashanth.spring.soap.api.alarmdetails.AlarmDetails;
import cpm.prashanth.spring.soap.api.alarmdetails.GetAlarmByIdRequest;
import cpm.prashanth.spring.soap.api.alarmdetails.GetAlarmByIdResponse;

@Endpoint
public class AlarmEndpoint    {
	@Autowired
	private AlarmRepository ar;
	@PayloadRoot(namespace="http://prashanth.cpm/spring/soap/api/alarmdetails",localPart="getAlarmByIdRequest")
	@ResponsePayload
	public GetAlarmByIdResponse getUserRequest(@RequestPayload GetAlarmByIdRequest request) throws MyException{
		GetAlarmByIdResponse response = new GetAlarmByIdResponse();
		if (!request.getAlarmid().equals("")) {			
			AlarmDetails ur1 = null;
			ur1 = ar.getAlarmById(request.getAlarmid());
			response.setAlarmDetails(ur1);
		}
		else
			throw new MyException("Provide Alarm ID, Id should not be null");
		return response;
}
}
