package com.educaronline.controller;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConectarMySQL {

	public DriverManagerDataSource conectar() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/personas" + "?useTimezone=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
	}

}
