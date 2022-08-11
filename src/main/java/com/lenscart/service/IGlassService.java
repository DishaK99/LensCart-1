package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Glass;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;

@Service
public interface IGlassService {
	
	public List<Glass> getAllGlass();

	public Glass getGlassById(int glassId) throws IdNotFoundException;

	public Glass addGlass(Glass glasslass) throws InvalidProductDataException ;

	public List<Glass> deleteGlass(int glassId) throws IdNotFoundException;
	
	public Glass updateGlass(Glass glass) throws InvalidProductDataException;

}
