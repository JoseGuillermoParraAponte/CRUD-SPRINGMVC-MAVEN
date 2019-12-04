package com.educaronline.controller;



public class Persona {
	
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	private String email;
	private String genero;
	private String direccion;
	private String pais;
	private String[] intereses;
	private boolean libros;
	private boolean deportes;
	private boolean pelicula;
	private boolean videojuegos;
	private boolean otros;

	// .....................................................................................................
	public Persona() {

	}

	public Persona(int id,String nombre, String apellidos, int edad, String email, String genero, String direccion,
			String pais, boolean libros, boolean deportes, boolean pelicula, boolean videojuegos, boolean otros) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.genero = genero;
		this.direccion = direccion;
		this.pais = pais;
		this.libros=libros;
		this.deportes=deportes;
		this.pelicula=pelicula;
		this.videojuegos=videojuegos;
		this.otros=otros;
		
	}
	// .....................................................................................................

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String[] getIntereses() {
		return intereses;
	}

	public void setIntereses(String[] intereses) {
		this.intereses = intereses;
	}
	
	public boolean isLibros() {
		return libros;
	}

	public void setLibros(boolean libros) {
		this.libros = libros;
	}

	public boolean isDeportes() {
		return deportes;
	}

	public void setDeportes(boolean deportes) {
		this.deportes = deportes;
	}

	public boolean isPelicula() {
		return pelicula;
	}

	public void setPelicula(boolean pelicula) {
		this.pelicula = pelicula;
	}

	public boolean isVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(boolean videojuegos) {
		this.videojuegos = videojuegos;
	}

	public boolean isOtros() {
		return otros;
	}

	public void setOtros(boolean otros) {
		this.otros = otros;
	}

}
