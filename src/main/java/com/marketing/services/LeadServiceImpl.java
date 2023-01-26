package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repositories.Leadrepository;
@Service
public class LeadServiceImpl implements LeadService {
	@Autowired
	private Leadrepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public List<Lead> getList() {
	List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}

	@Override
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
	}
	@Override
	public Lead findOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id); // getting the data in the form of optional
														//class obj. with ref. of id.
		Lead lead = findById.get();		// converting class to lead obj.
		return lead;  //giving lead obj. to calling statement.
	}
	
	
	
}
