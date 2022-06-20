package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Regalo;
import com.generation.repositories.RegaloRepository;

@Service
public class RegaloService {

	// Injeccion de dependencias
	@Autowired
	RegaloRepository regaloRepository;

	public void nuevoRegalo(@Valid Regalo regalo) {
		regaloRepository.save(regalo);
	}

	public List<Regalo> listaRegalos() {
		return regaloRepository.findAll();
	}

	public Regalo buscarRegalo(Long id) {
		return regaloRepository.findById(id).get();
	}

	public void editarRegalo(@Valid Regalo regalo, Long id) {
		regalo.setId(id);
		regaloRepository.save(regalo);
		
	}

	public void eliminar(Long id) {
		regaloRepository.deleteById(id);
	}
	
}
