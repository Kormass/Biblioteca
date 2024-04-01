package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	//Archivos de Tablas y relleno de informacion de las tablas en Biblioteca/resourses/static/MySQL

	//AutoGeneracion de contraseña Principal para entrar en el H2 con Security,
	//Cambiar propertys Segun considere profe yo en mi caso trabaje con root y contraseña: 0000

	//Trate de autogenerar la base de datos pero no supe como implementarlo correctamente
	//Entonces se debe realizar la creacion de la base de datos biblioteca
}
