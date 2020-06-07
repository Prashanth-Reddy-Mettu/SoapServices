package com.prashanth.spring.soap.api.wsconfig;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;



@EnableWs
@Configuration
public class AlarmWsConfig extends WsConfigurerAdapter{
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
		MessageDispatcherServlet messageDispatcherServlet=new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/ws/*");
	}
	@Bean
	public XsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("alarm-details.xsd"));
	}
	@Bean(name="alarmdetails")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition definition=new DefaultWsdl11Definition();
		definition.setPortTypeName("AlarmDetails");
		definition.setSchema(schema);
		definition.setTargetNamespace("http://prashanth.cpm/spring/soap/api/alarmdetails");
		definition.setTransportUri("/ws");
		return definition;
	}
	@Bean
	public SimplePasswordValidationCallbackHandler callbackHandler() {
		SimplePasswordValidationCallbackHandler callbackHandler=new SimplePasswordValidationCallbackHandler();
		callbackHandler.setUsersMap(Collections.singletonMap("Prashanth", "Reddy"));
		return callbackHandler;
	}
	@Bean
	public XwsSecurityInterceptor securityInterceptor() {
		XwsSecurityInterceptor interceptor=new XwsSecurityInterceptor();
		interceptor.setCallbackHandler(callbackHandler());
		interceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
		return interceptor;
	}
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptor) {
		interceptor.add(securityInterceptor());
	}
}
