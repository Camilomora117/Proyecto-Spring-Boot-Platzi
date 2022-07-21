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
import org.springframework.data.domain.Sort;

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
		getInformationAndUser();
	}

	public void getInformationAndUser() {
		/*
		LOGGER.info("Usuario con el Metodo findByUserEmail : " +
				userRepository.findMyUserByEmail("john@domain.com").orElseThrow( () -> new RuntimeException("No se encontro el user")));

		userRepository.findByAndSort("user", Sort.by("id").descending())
				.stream().forEach(user -> LOGGER.info("El usuario encontrado es : " + user.getName()));

		//Encontrar Users por nombre
		userRepository.findByName("Marco")
				.stream().forEach(user -> LOGGER.info("User con Query method (findByName) : " + user ));

		//Encontrar Usuario con nombre and email
		LOGGER.info(" User con Query method findByNameAndEmail : " + userRepository.findByNameAndEmail("John","john@domain.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el Usuario")));

		//Encontrar lista de usuarios con LIKE
		userRepository.findByNameLike("%user%").stream().forEach(user -> LOGGER.info("Usuario con LIKE : " + user));

		//Encontrar lista de usuarios con OR (name or email)
		userRepository.findByNameOrEmail("Marco", null).stream().forEach(user -> LOGGER.info("Usuario con OR : " + user));

		//Encontrar user en un rango de fechas
		userRepository.findByBirthDateBetween(LocalDate.of(2021, 1, 1), LocalDate.of(2021,4, 2))
				.stream().forEach(user -> LOGGER.info("Usuarios en el rango de Fechas : " + user));

		// Ordenar descendientemente por Id dado el nombre LIKE
		userRepository.findByNameLikeOrderByIdDesc("%user%").stream().forEach(user -> LOGGER.info("Ordenar descendiente : " + user ));

		// Ordenar ascendente por Id dado el nombre LIKE
		userRepository.findByNameLikeOrderByIdAsc("%user%").stream().forEach(user -> LOGGER.info("Ordenar ascendente : " + user ));

		// Ordenar descendientemente por Id dado el nombre sin LIKE
		userRepository.findByNameContainingOrderByIdDesc("user").stream().forEach(user -> LOGGER.info("Ordenar descendiente sin LIKE : " + user ));

		 */
	}

	public void SaveUserInDataBase() {
		//Creamos Usuarios que queremos agregar a la DataBase
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Marco", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("user6", "user6@domain.com", LocalDate.of(2021, 1, 1));
		User user7 = new User("user7", "user7@domain.com", LocalDate.of(2021, 1, 1));
		User user8 = new User("user8", "user8@domain.com", LocalDate.of(2021, 1, 1));
		//Añadimos a una lista
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5, user6, user7, user8);
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
