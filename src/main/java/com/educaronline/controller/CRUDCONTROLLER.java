package com.educaronline.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDCONTROLLER {

	private Persona persona = new Persona();
	private JdbcTemplate jdbcTemplate;

	// .....................................................................................................
	public CRUDCONTROLLER() {
		ConectarMySQL conectar = new ConectarMySQL();
		this.jdbcTemplate = new JdbcTemplate(conectar.conectar());
	}

	// .....................................................................................................
	@RequestMapping
	public String index() {

		return "index";
	}
	
	@RequestMapping("/index")
	public String indexx() {

		return "index";
	}

	// .....................................................................................................
	@RequestMapping("/FormularioDeRegistro")
	public String formularioDeRegistro(Model modelo) {

		
		modelo.addAttribute("persona", new Persona());
		return "FormularioDeRegistro";

	}
	
	//.....................................................................................................
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(HttpServletRequest request, Model modelo) {

		
		persona.setNombre(request.getParameter("nombre"));
		persona.setApellidos(request.getParameter("apellidos"));
		persona.setEdad(Integer.parseInt(request.getParameter("edad")));
		persona.setEmail(request.getParameter("email"));
		persona.setDireccion(request.getParameter("direccion"));
		persona.setGenero(request.getParameter("genero"));
		String[] intereses = request.getParameterValues("intereses");
		persona.setIntereses(intereses);
		persona.setPais(request.getParameter("pais"));
		modelo.addAttribute("persona", persona);

		return "procesarFormulario";
	}
	
	//.....................................................................................................
	@RequestMapping("/registrarme")
	public ModelAndView registrarUsuario() {

		ModelAndView mav = new ModelAndView();

		String[] intereses = persona.getIntereses();
		
		persona.setLibros(false);
		persona.setDeportes(false);
		persona.setPelicula(false);
		persona.setVideojuegos(false);
		persona.setOtros(false);

		for (String string : intereses) {

			if (string.equals("Libros")) {
				persona.setLibros(true);
			}
			if (string.equals("Deportes")) {
				persona.setDeportes(true);
			}
			if (string.equals("Películas")) {
				persona.setPelicula(true);
			}
			if (string.equals("Video Juegos")) {
				persona.setVideojuegos(true);
			}
			if (string.equals("Otros")) {
				persona.setOtros(true);
			}
		}

		this.jdbcTemplate.update(
				"INSERT INTO FUTUROSCLIENTES (NOMBRES,APELLIDOS,EDAD,EMAIL,DIRECCION,GENERO,LIBROS,"
						+ "DEPORTES,PELICULA,VIDEOJUEGOS,OTROS,PAIS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
				persona.getNombre(), persona.getApellidos(), persona.getEdad(), persona.getEmail(),
				persona.getDireccion(), persona.getGenero(), persona.isLibros(), persona.isDeportes(),
				persona.isPelicula(), persona.isVideojuegos(), persona.isOtros(), persona.getPais());
		mav.setViewName("estadoRegistro");

		return mav;
	}
	
	//.....................................................................................................
	@RequestMapping("/mostrarConsulta")
	public ModelAndView mostrarConsulta() {

		ModelAndView mav = new ModelAndView();
		String sql = "SELECT ID, NOMBRES, APELLIDOS, EDAD,EMAIL,DIRECCION,GENERO,LIBROS"
				+ ",DEPORTES,PELICULA,VIDEOJUEGOS,OTROS,PAIS " + "FROM FUTUROSCLIENTES";
		List<?> datos = this.jdbcTemplate.queryForList(sql);
		mav.addObject("datos", datos);
		mav.setViewName("muestraConsulta");

		return mav;

	}
	//.....................................................................................................

	@RequestMapping("/editar")
	public ModelAndView editar(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		persona.setId(Integer.parseInt(request.getParameter("ID")));

		Persona datos = this.selectPersona(persona.getId());
		mav.setViewName("editar");
		mav.addObject("persona",
				new Persona(datos.getId(), datos.getNombre(), datos.getApellidos(), datos.getEdad(), datos.getEmail(),
						datos.getGenero(), datos.getDireccion(), datos.getPais(),datos.isLibros(), datos.isDeportes(),
						datos.isPelicula(), datos.isVideojuegos(), datos.isOtros()));
		return mav;

	}
	//.....................................................................................................

	public Persona selectPersona(int id) {

		final Persona pers = new Persona();

		String sql = "SELECT * FROM FUTUROSCLIENTES WHERE ID= " + id + " ";

		return (Persona) jdbcTemplate.query(sql,

				new ResultSetExtractor<Persona>() {

					@Override
					public Persona extractData(ResultSet rs) throws SQLException, DataAccessException {

						if (rs.next()) {
							pers.setId(id);
							pers.setNombre(rs.getString("NOMBRES"));
							pers.setApellidos(rs.getString("APELLIDOS"));
							pers.setEdad(Integer.parseInt(rs.getString("EDAD")));
							pers.setEmail(rs.getString("EMAIL"));
							pers.setDireccion(rs.getString("DIRECCION"));
							pers.setGenero(rs.getString("GENERO"));
							pers.setLibros(rs.getBoolean("LIBROS"));
							pers.setLibros(rs.getBoolean("DEPORTES"));
							pers.setLibros(rs.getBoolean("PELICULA"));
							pers.setLibros(rs.getBoolean("VIDEOJUEGOS"));
							pers.setLibros(rs.getBoolean("OTROS"));
							pers.setPais(rs.getString("PAIS"));

						}

						return pers;
					}

				}

		);

	}

	//.....................................................................................................
	@RequestMapping("/procesarEdicion")
	public ModelAndView editar(@ModelAttribute("persona") Persona p, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String[] intereses = request.getParameterValues("intereses");
		persona.setIntereses(intereses);

		persona.setLibros(false);
		persona.setDeportes(false);
		persona.setPelicula(false);
		persona.setVideojuegos(false);
		persona.setOtros(false);

		for (String string : intereses) {

			if (string.equals("Libros")) {
				persona.setLibros(true);
			}
			if (string.equals("Deportes")) {
				persona.setDeportes(true);
			}
			if (string.equals("Películas")) {
				persona.setPelicula(true);
			}
			if (string.equals("Video Juegos")) {
				persona.setVideojuegos(true);
			}
			if (string.equals("Otros")) {
				persona.setOtros(true);
			}
		}

		String sql = "UPDATE FUTUROSCLIENTES SET NOMBRES=?, APELLIDOS=?, EDAD=?,EMAIL=?,DIRECCION=?,GENERO=?,LIBROS=?,"
				+ " DEPORTES=?,PELICULA=?,VIDEOJUEGOS=?,OTROS=?,PAIS=? WHERE ID=?";
		this.jdbcTemplate.update(sql, p.getNombre(), p.getApellidos(), p.getEdad(), p.getEmail(), p.getDireccion(),
				p.getGenero(), persona.isLibros(), persona.isDeportes(), persona.isPelicula(), persona.isVideojuegos(),
				persona.isOtros(), p.getPais(), persona.getId());
		System.out.println(p.isLibros());
		System.out.println(persona.isLibros());

		mav.setViewName("redirect:/mostrarConsulta");

		return mav;
	}
	
	//.....................................................................................................
	@RequestMapping("/delete")
	public ModelAndView eliminar(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		persona.setId(Integer.parseInt(request.getParameter("ID")));
		String sql = "DELETE FROM FUTUROSCLIENTES WHERE ID=?";
		this.jdbcTemplate.update(sql, persona.getId());
		mav.setViewName("redirect:/mostrarConsulta");

		return mav;
	}

	//.....................................................................................................
	@ModelAttribute("generoLista")
	public List<String> listadoGenero() {

		List<String> genero = new ArrayList<String>();
		genero.add("Masculino");
		genero.add("Femenino");

		return genero;
	}

	//.....................................................................................................
	@ModelAttribute("interesesLista")
	public List<String> listadoInteres() {

		List<String> intereses = new ArrayList<String>();
		intereses.add("Libros");
		intereses.add("Deportes");
		intereses.add("Películas");
		intereses.add("Video Juegos");
		intereses.add("Otros");

		return intereses;
	}

	//.....................................................................................................
	@ModelAttribute("paisLista")
	public List<String> listadoPaises() {

		List<String> pais = new ArrayList<String>();
		pais.add("Chile");
		pais.add("México");
		pais.add("Colombia");
		pais.add("Bolivia");
		pais.add("España");
		pais.add("Argentina");
		pais.add("Venezuela");

		return pais;
	}

}
