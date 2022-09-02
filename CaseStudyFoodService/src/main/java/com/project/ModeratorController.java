package com.project;

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

import com.project.Service.ModeratorService;
import com.project.model.Moderator;

@RestController
@RequestMapping(path = "/moderators")
public class ModeratorController {
	@Autowired
	ModeratorService service;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<Moderator>> getAllModerators(){
		return new ResponseEntity <List<Moderator>> ((List<Moderator>) service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getModerator/{id}")
	public ResponseEntity<?> getModeratorById(@PathVariable Integer id) throws Exception{
		try {
			return new ResponseEntity<Moderator>(service.getModeratorById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Moderator not found", HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteModerator/{id}")
	public ResponseEntity<?> deleteModeratorById(@PathVariable Integer id) throws Exception{
		try {
			return new ResponseEntity<Boolean>(service.deleteModeratorById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Moderator not found", HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/createModerator")
	public ResponseEntity<?> createDepartment(@RequestBody Moderator mod) throws Exception{
		try {
			return new ResponseEntity<Moderator>(service.createModerator(mod), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Moderator not found", HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/updateModerator/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody Moderator mod) throws Exception{
		try {
			return new ResponseEntity<Moderator>(service.updateModerator(id, mod), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Moderator not found", HttpStatus.CONFLICT);
		}
	}

