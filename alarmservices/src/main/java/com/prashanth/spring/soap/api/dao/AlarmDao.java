package com.prashanth.spring.soap.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashanth.spring.soap.api.model.Alarm;

public interface AlarmDao extends JpaRepository<Alarm, String> {

}
