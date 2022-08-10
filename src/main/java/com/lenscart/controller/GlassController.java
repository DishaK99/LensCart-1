package com.lenscart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lenscart.entity.Glass;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.service.IGlassService;



@RestController
@RequestMapping("/lenscart")
public class GlassController {
	
	
		@Autowired
		private IGlassService glassService;

		@GetMapping("glass")
		public ResponseEntity<List<Glass>> getAllGlass() {
			return new ResponseEntity<List<Glass>>(glassService.getAllGlass(), HttpStatus.OK);
		}

		@GetMapping("glass/{glassId}")
		public ResponseEntity<Glass> getGlassById(@PathVariable("glassId") Integer glassId){
			return new ResponseEntity<Glass>(glassService.getGlassById(glassId), HttpStatus.OK);
		}

		@PostMapping("glass")
		public ResponseEntity<Glass> addGlass(@RequestBody Glass glass) throws InvalidProductDataException {
			glassService.addGlass(glass);
			return new ResponseEntity<Glass>(glass, HttpStatus.OK);
		}
		
		@DeleteMapping("/glass/{glassId}")
		public ResponseEntity<List<Glass>> deleteGlass(@PathVariable("glassId")Integer glassId){
			glassService.deleteGlass(glassId);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
		@PutMapping("glass")
		public ResponseEntity<Glass>updateGlass(@RequestBody Glass glass)
		{
			return new ResponseEntity<Glass>(glassService.updateGlass(glass), HttpStatus.OK);
		}
		

}
