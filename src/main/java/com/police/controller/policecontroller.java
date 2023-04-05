package com.police.controller;
import java.util.List;

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

import com.police.Entity.police;
import com.police.service.policeservice;
@RestController
@RequestMapping(value="/api/police")
public class policecontroller {
	private policeservice policeservice;

	public policecontroller(com.police.service.policeservice policeservice) {
		super();
		this.policeservice = policeservice;
	}
	//create police data
	@PostMapping
	
	public ResponseEntity<police>savepolice(@RequestBody police police){
		return new ResponseEntity<police>(policeservice.savapolice(police),HttpStatus.CREATED);
		
	}
	//get police list
	@GetMapping
	public List<police>getALLpolice(){
		return policeservice.getALLpolice();
		
	}
	//get police by id
	@GetMapping("{id}")
	public ResponseEntity<police>getpoliceByid(@PathVariable("id") Long id){
		return new ResponseEntity<police>(policeservice.getpoliceByid(id),HttpStatus.OK);
		
	}
	//updateting th epolice data
	@PutMapping("{id}")
	public ResponseEntity<police>updatepolice(@PathVariable("id") Long id,@RequestBody police police){
		return new ResponseEntity<police>(policeservice.updatepolice(police, id),HttpStatus.OK);
	}
	
	//deleting 
	@DeleteMapping("{id}")
	public ResponseEntity<String>deletepolice(@PathVariable("id") Long id){
		policeservice.deletepolice(id);
		return new ResponseEntity<String>("police delete successfully",HttpStatus.OK);
		
	}
}
