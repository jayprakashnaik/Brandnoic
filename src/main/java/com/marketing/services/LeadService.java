package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {
		public void saveLead(Lead lead);

		public List<Lead> getList();

		public void deleteOneLead(long id);

		public Lead findOneLead(long id);
		
}
