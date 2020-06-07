package com.prashanth.spring.soap.api.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.prashanth.spring.soap.api.dao.AlarmDao;
import com.prashanth.spring.soap.api.model.Alarm;
import cpm.prashanth.spring.soap.api.alarmdetails.AlarmDetails;

@Service
public class AlarmRepository {
	@Autowired
	private AlarmDao ad;
	public AlarmDetails getAlarmById(String id) {
		Alarm a1=null;
		Optional<Alarm> a=ad.findById(id);
		a1=a.get();
		AlarmDetails ad=new AlarmDetails();
		ad.setAlarmId(a1.getId());
		ad.setAlarmEquipment(a1.getEquipment());
		ad.setAlarmDateAndTime(DateTimeToXmlDateTime.convertLocalDateToXmlDate(a1.getDateAndTime()));
		ad.setAlarmDescription(a1.getDescription());
		return ad;
	}

}
