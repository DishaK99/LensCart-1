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
		 if (glass.getPrice() <= 0) {
				throw new InvalidProductDataException("Product price should be greater than 0");
			}
		else if(glass.getType().equals("zero power") || glass.getType().equals("digital screen protection")
				|| glass.getType().equals("single vision") || glass.getType().equals("bifocal powered glass"))
		{
			return glassRepo.save(glass);
		}
		
		else
		{
			throw new InvalidProductDataException("Please Enter Zero power/digital screen protection/single vision/bifocal powered glass");
		}
	}

	@Override
	public List<Glass> getAllGlass() {
		return glassRepo.findAll();
	}

	@Override
	public Glass getGlassById(int glassId) throws IdNotFoundException {
		
		
		try
		{
			Glass glass = glassRepo.findById(glassId).get();
			return glass;
			
		}catch (Exception e) {
			throw new IdNotFoundException("Id is not Present ");
		}
		
		
	}

	public List<Glass> deleteGlass(int glassId) throws IdNotFoundException {
		try {
		glassRepo.deleteById(glassId);
		return glassRepo.findAll();
		}
		catch(Exception e)
		{
			throw new IdNotFoundException("Id is not Present ");
		}
		
	}
	
	public Glass updateGlass(Glass glass) throws InvalidProductDataException
	{
		if (glass.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		else if(glass.getType().equals("zero power") || glass.getType().equals("digital screen protection")
				|| glass.getType().equals("single vision") || glass.getType().equals("bifocal powered glass"))
		{
			return glassRepo.save(glass);
		}
		 
		else
		{
			throw new InvalidProductDataException("Please Enter Zero power/digital screen protection/single vision/bifocal powered glass");
		}
	}
}
