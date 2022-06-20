package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Regalo;
import com.generation.services.RegaloService;

@Controller
@RequestMapping("")
public class RegaloController {

	// INJECCION DE DEPENDENCIAS
	@Autowired
	RegaloService regaloService;
	
	// RUTA INDEX: Mostrar lista de regalos
	@RequestMapping("")
	public String mostrarRegalos(Model model) {
		// Traer lista de regalos a variable listaRegalos
		List<Regalo> listaRegalos = regaloService.listaRegalos();
		
		// Mandar lista a index.jsp
		model.addAttribute("listaRegalos", listaRegalos);
		
		return "index.jsp";
	}
	
	// RUTA REGISTRAR REGALO: Form para ingresar datos de nuevo regalo
	
	@RequestMapping("/registrar")
	public String nuevoRegalo(@Valid @ModelAttribute("regalo") Regalo regalo) { // Enviar objeto vacio a fomr
		return "registrar.jsp";
	}
	
	// VALIDA NUEVO REGALO: validar datos e ingresar nuevo regalo
	@PostMapping("/registrar/validar")
	public String agregarRegalo(@Valid @ModelAttribute("regalo") Regalo regalo, // Recuperar objeto con datos
			BindingResult result, 
			Model model) {
		
		// Comprobar si hay error en el ingreso de datos
		if(result.hasErrors()) {
			model.addAttribute("msgError", "Error en el ingreso de datos");
			return "/registrar.jsp";
		}
		
		// Guardar nuevo regalo en base de datos
		regaloService.nuevoRegalo(regalo);
		
		// Redireccionar a index
		return "redirect:/";
	}
	
	// RUTA EDITAR: enviar form con objeto a editar
	@RequestMapping("/editar/{id}")
	public String editarRegalo(@PathVariable("id") Long id, Model model) {
		// Buscar objeto con id
		Regalo regalo = regaloService.buscarRegalo(id);
		
		// Mandar objeto
		model.addAttribute("regalo", regalo);
		return "editar.jsp";
	}
	
	// RUTA VALIDAR EDICION Y REALIZARLA: Devolver objeto con nueva informacion
	@PostMapping("/editar/validar/{id}")
	public String validarEdicionRegalo(@PathVariable("id") Long id,
			@Valid @ModelAttribute("regalo") Regalo regalo,
			BindingResult result,
			Model model) {

		
		
		// Comprobar si hay error en el ingreso de datos
		if(result.hasErrors()) {
			model.addAttribute("msgError", "Error en el ingreso de datos");
			return "editar.jsp";
		}
		
		// Editarregalo en base de datos
		regaloService.editarRegalo(regalo, id);
		
		// Redireccionar a index
		return "redirect:/";
	}
	
	// ELIMINAR REGALO: Param id
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarRegalo(@PathVariable("id") Long id) {
		
		regaloService.eliminar(id);
		
		return "redirect:/";
	}
}
