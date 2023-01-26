package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@RequestMapping("/api/leads")
@RestController
public class LeadRestController {
	
	@Autowired
		private LeadService leadService;
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadService.saveLead(lead);
		
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadService.saveLead(lead);
	}
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> lead = leadService.getList();
		return lead;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		leadService.deleteOneLead(id);
	}
	
	@RequestMapping("/get/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		try {
			Lead lead = leadService.findOneLead(id);
		return lead;
		} catch (Exception e) {
			
		}
		return null;
	}
}
