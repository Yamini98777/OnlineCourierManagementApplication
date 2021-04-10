package com.capg.ocma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.service.IOfficeOutletService;
import com.capg.ocma.service.OfficeOutletServiceImp;

@RestController
@RequestMapping("/api/ocma/Office")
public class OfficeOutletController {
	@Autowired
	IOfficeOutletService officeService;
	final Logger Logger = LoggerFactory.getLogger(ManagerController.class);

	@PostMapping("/addOffice")
	public ResponseEntity<CourierOfficeOutletDTO> addNewOffice(@RequestBody CourierOfficeOutlet officeOutlet)
			throws OutletNotFoundException {
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeResponse = null;

		if (OfficeOutletServiceImp.ValidateOfficeDetails(officeOutlet)) {
			officeDTO = officeService.addNewOffice(officeOutlet);
			officeResponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
		} else
			throw new OutletNotFoundException("Office outlet not found");
		return officeResponse;
	}
	@DeleteMapping("/deleteOffice/{officeId}")
	public ResponseEntity<CourierOfficeOutletDTO> removeNewOffice(@PathVariable("officeId") int officeId)
			throws OutletNotFoundException {
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeResponse = null;
		
		    officeDTO = officeService.removeNewOffice(officeId);
		    
			officeResponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
            Logger.info("Office outlet deleted");	
		return officeResponse;

	}

	@GetMapping("/getOffice/{officeId}")
	public ResponseEntity<CourierOfficeOutletDTO> getOfficeInfo(@PathVariable("officeId") int officeId)
			throws OutletNotFoundException {
		CourierOfficeOutletDTO officeoutlet = new CourierOfficeOutletDTO();
		ResponseEntity<CourierOfficeOutletDTO> officeresponse = null;
	   
			officeoutlet = officeService.getOfficeInfo(officeId);
			officeresponse = new ResponseEntity<CourierOfficeOutletDTO>(officeoutlet, HttpStatus.ACCEPTED);
	
		return officeresponse;

	}
	@GetMapping("/getAllOffice")
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException {
		
		if (officeService.getAllOfficesData() == null) {
			throw new OutletNotFoundException("No Office Data found in the database");
		}
		return officeService.getAllOfficesData();
	}
	@GetMapping("/checkOfficeOpen/{officeId}")
	public ResponseEntity<String> isOfficeOpen(@PathVariable("officeId") int officeId)
			throws OutletClosedException {

		boolean check = officeService.isOfficeOpen(officeId);
		if (check) {

			return new ResponseEntity<>("The office  is open: ",HttpStatus.OK);

		} else {

			throw new OutletClosedException("The office is closed");

		}
	}
	@GetMapping("/checkOfficeClosed/{officeId}")
	public ResponseEntity<String> isOfficeClosed(@PathVariable("officeId")int officeId) throws OutletClosedException {

		boolean check = officeService.isOfficeClosed(officeId);
		if (check) {

			throw new OutletClosedException("The Office is Closed");

		} else {

			return new ResponseEntity<String>("The Office is opened", HttpStatus.OK);

		}
	}

}