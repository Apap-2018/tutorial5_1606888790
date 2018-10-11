package com.apap.tutorial5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.service.PilotService;

/*
 * PilotController
 */

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilot(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel pilotNya = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilotNya);
		
		return "view-pilot";
	}
	
//	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method=RequestMethod.GET)
//	private String deletePilot(@PathVariable(value="licenseNumber") String licenseNumber, Model model) {
//		PilotModel pilotNya = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
//		pilotService.deletePilot(pilotNya);
//		return "delete";
//	}
//	
//	@RequestMapping(value = "/pilot/update/{licenseNumber}", method=RequestMethod.GET)
//	private String updatePilot(@PathVariable(value="licenseNumber") String licenseNumber, Model model) {
//		PilotModel pilotNya = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
//		model.addAttribute("pilot", pilotNya);
//		return "updatePilot";
//	}
	
	@RequestMapping(value = "/pilot/update/{Id}", method=RequestMethod.GET)
	private String updatePilotById(@PathVariable(value="Id") long Id, Model model) {
		PilotModel pilotNya = pilotService.getPilotById(Id);
		model.addAttribute("pilot", pilotNya);
		return "updatePilot";
	}
	
	@RequestMapping(value = "/pilot/delete/{Id}", method=RequestMethod.GET)
	private String deletePilot(@PathVariable(value="Id") long Id, Model model) {
		PilotModel pilotNya = pilotService.getPilotById(Id);
		pilotService.deletePilot(pilotNya);
		return "delete";
	}
	
	@RequestMapping(value = "/pilot/update",method = RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "update";
	}
}
