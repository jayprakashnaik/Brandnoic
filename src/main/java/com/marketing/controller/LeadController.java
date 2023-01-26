package com.marketing.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;
import com.marketing.utilities.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	//@Autowired
	//private EmailService emailService;
	
	@RequestMapping(value="/viewCreateLeadPage")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	@RequestMapping(value="/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) { // no need to create Lead Class object
		leadService.saveLead(lead);
		//emailService.sendEmail(lead.getEmail(), "Welcome", "Inquiry sent successfully");
		model.addAttribute("msg","Lead Saved Successfully..!!");
			return "create_lead";
	}
	@RequestMapping("/listAll")
	public String getAllList(ModelMap model) {
		List<Lead> leads = leadService.getList();
		//List<Lead> leads = new LinkedList<>(); 2nd way to take Collection
		//leads.addAll(leadService.getList());
		model.addAttribute("leads",leads);
		return "lead_search_result";
	}

		
		
//	@RequestMapping("/saveLead")
//	public String saveOneLead
//	(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobile") Long mobile) {
//		Lead l = new Lead();			// Mandatory to create "Lead" class object
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		
//		leadService.saveLead(l);
//		return "create_lead";
	
//	@RequestMapping(value="/saveLead")
//	public String saveOneLead(LeadData lead, ModelMap model ) {
//		Lead l = new Lead();			//Mandatory to create "Lead " class Object
//		l.setFirstName(lead.getFirstName());
//		l.setLastName(lead.getLastName());
//		l.setEmail(lead.getEmail());
//		l.setMobile(lead.getMobile());
//		
//		leadService.saveLead(l);
//		model.addAttribute("msg","Lead is Saved..!!");
//		
//		return "create_lead";
//		
		@RequestMapping("/delete")
		public String deleteLeadById(@RequestParam("id") long id, ModelMap model) {
			leadService.deleteOneLead(id);
			List<Lead> leads =leadService.getList();
			model.addAttribute("leads", leads);
			return "lead_search_result";
			
		}
		
		@RequestMapping("/update")
		public String updateOneLead(@RequestParam("id") long id, ModelMap model) {
			Lead lead = leadService.findOneLead(id); // taking the lead obj
			model.addAttribute("lead",lead);
			return "update_lead";
		}
		
		@RequestMapping("/updateLead")
		public String updateLead(@ModelAttribute("lead")  Lead lead, ModelMap model ) {
			leadService.saveLead(lead);
			model.addAttribute("msg", "Lead with id:" + lead.getId()+ "is updated");
			List<Lead> leads =leadService.getList();
			model.addAttribute("leads", leads);
			return "lead_search_result";
		}
}
