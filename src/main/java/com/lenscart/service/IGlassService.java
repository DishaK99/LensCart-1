package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Glass;
import com.lenscart.exception.InvalidProductDataException;

@Service
public interface IGlassService {
	
	public List<Glass> getAllGlass();

	public Glass getGlassById(Integer glassId) throws IdNotFoundException;

	public Glass addGlass(Glass glasslass) throws InvalidProductDataException ;

	public void deleteGlass(Integer glassId);
	
	public Glass updateGlass(Glass glass);

}
