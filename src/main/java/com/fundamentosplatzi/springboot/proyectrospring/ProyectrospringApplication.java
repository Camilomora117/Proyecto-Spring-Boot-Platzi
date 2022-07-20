package com.fundamentosplatzi.springboot.proyectrospring;

import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBean;
import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBeanImplement;
import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.proyectrospring.component.ComponentDependency;
import com.fundamentosplatzi.springboot.proyectrospring.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectrospringApplication implements CommandLineRunner {

	//Inyeccion
	private ComponentDependency componentDependency;

	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(ProyectrospringApplication.class);

	public ProyectrospringApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean,
									  MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties,
									  UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectrospringApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword()+"-"+userPojo.getAge());
		//Uso de Logs
		LOGGER.error("Esto es un error del aplicativo");
		//Generamos un error
		try {
			int var = 10/5;
			LOGGER.debug("Este es mi valor = " + var);
		} catch (Exception e) {
			LOGGER.error("Error por dividir entre cero " + e.getMessage());
		}
	}

}
