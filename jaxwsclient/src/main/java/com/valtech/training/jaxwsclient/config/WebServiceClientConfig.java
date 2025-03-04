
package com.valtech.training.jaxwsclient.config;
 
import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.jaws.HelloWorld;

 
@Configuration
public class WebServiceClientConfig {
	@Bean
	public HelloWorld createHelloWorldService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(HelloWorld.class);
		proxy.setServiceName(new QName("http://jaws.training.valtech.com/","HelloWorldImplService"));
		proxy.setAddress("http://localhost:8080/services/helloWorld");
		return proxy.create(HelloWorld.class);
	}
	
}
 
 
