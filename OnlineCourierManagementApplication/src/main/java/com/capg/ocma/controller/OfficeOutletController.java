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

import com.capg.ocma.exception.InvalidAddressException;
import com.capg.ocma.exception.OfficeDetailsNullException;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.service.IOfficeOutletService;


@RestController
@RequestMapping("/api/ocma/Office")
public class OfficeOutletController {

	@Autowired
	IOfficeOutletService officeService;
	final Logger logger = LoggerFactory.getLogger(ManagerController.class);

	@PostMapping("/addOffice")
	public ResponseEntity<CourierOfficeOutletDTO> addNewOffice(@RequestBody CourierOfficeOutlet officeOutlet)
			throws InvalidAddressException, OfficeDetailsNullException {

		CourierOfficeOutletDTO officeDTO = null;

		ResponseEntity<CourierOfficeOutletDTO> officeResponse = null;

		officeDTO = officeService.addNewOffice(officeOutlet);

		officeResponse = new ResponseEntity<>(officeDTO, HttpStatus.ACCEPTED);

		return officeResponse;
	}

	@DeleteMapping("/deleteOffice/{officeId}")
	public ResponseEntity<CourierOfficeOutletDTO> removeNewOffice(@PathVariable("officeId") int officeId)
			throws OutletNotFoundException {
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeResponse = null;

		officeDTO = officeService.removeNewOffice(officeId);

		officeResponse = new ResponseEntity<>(officeDTO, HttpStatus.ACCEPTED);
		logger.info("Office outlet deleted");
		return officeResponse;

	}

	@GetMapping("/getOffice/{officeId}")
	public ResponseEntity<CourierOfficeOutletDTO> getOfficeInfo(@PathVariable("officeId") int officeId) throws OutletNotFoundException {
		
		CourierOfficeOutletDTO officeoutlet = officeService.getOfficeInfo(officeId);
		
		ResponseEntity<CourierOfficeOutletDTO> officeresponse = new ResponseEntity<>(officeoutlet, HttpStatus.ACCEPTED);

		return officeresponse;

	}

	@GetMapping("/getAllOffice")
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException {

	
		return officeService.getAllOfficesData();
	}

	@GetMapping("/CheckOfficeAvailability/{officeId}")
	public ResponseEntity<String> isOfficeOpenorClosed(@PathVariable("officeId") int officeId) throws OutletClosedException {

		boolean check = officeService.isOfficeOpenorClosed(officeId);
		if (check) {

			throw new OutletClosedException("The Office is Closed");

		} else {

			return new ResponseEntity<>("The Office is opened", HttpStatus.OK);

		}
	}

}