package com.fundamentosplatzi.springboot.proyectrospring;

import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBean;
import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBeanImplement;
import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.proyectrospring.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.proyectrospring.component.ComponentDependency;
import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import com.fundamentosplatzi.springboot.proyectrospring.pojo.UserPojo;
import com.fundamentosplatzi.springboot.proyectrospring.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProyectrospringApplication implements CommandLineRunner {

	//Inyeccion
	private ComponentDependency componentDependency;

	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(ProyectrospringApplication.class);

	private UserRepository userRepository;

	public ProyectrospringApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean,
									  MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties,
									  UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectrospringApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		SaveUserInDataBase();
	}

	public void SaveUserInDataBase() {
		//Creamos Usuarios que queremos agregar a la DataBase
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		//Añadimos a una lista
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5);
		//Añadimos a persistencia
		list.stream().forEach(userRepository::save);
	}

	public void ejemplosAnteriores() {
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
