package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Catalogo;
import com.prestamo.kafka.service.CatalogoEventService;
import com.prestamo.repository.CatalogoRepository;

@Service
public class CatalogoServiceImpl implements CatalogoService {
	
	@Autowired
	private CatalogoRepository catalogoRepostory;
	@Autowired
	private CatalogoEventService catalogoEventService;

	@Override
	public List<Catalogo> findAll() {
		return catalogoRepostory.findAll();
	}

	@Override
	public Catalogo insertaCatalogo(Catalogo catalogo) {
		catalogoEventService.publish(catalogo);
		return catalogoRepostory.save(catalogo);
	}
	

}
