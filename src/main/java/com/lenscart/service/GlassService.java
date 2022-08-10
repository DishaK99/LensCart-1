package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lenscart.entity.Glass;
import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.repository.GlassRepository;
import com.lenscart.repository.SunGlassRepository;

@Service
public class GlassService implements IGlassService {
	
	@Autowired
	private GlassRepository glassRepo;

	@Override
	public Glass addGlass(Glass glass) throws InvalidProductDataException {
		if(glass.getType().equals("zero power") || glass.getType().equals("digital screen protection")
				|| glass.getType().equals("single vision") || glass.getType().equals("bifocal powered glass"))
		{
			return glassRepo.save(glass);
		}
		else
		{
		throw new InvalidProductDataException("Please Enter Valid Type");
		}
	}

	@Override
	public List<Glass> getAllGlass() {
		return glassRepo.findAll();
	}

	@Override
	public Glass getGlassById(Integer glassId) throws IdNotFoundException {
		
		if()
		{
			throw new IdNotFoundException(" ");
		}
		
		return glassRepo.findById(glassId).get();
	}

	public void deleteGlass(Integer glassId) {
		glassRepo.deleteById(glassId);
		
	}
	
	public Glass updateGlass(Glass glass)
	{
		return glassRepo.save(glass);
	}
}
