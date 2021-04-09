package com.capg.ocma.controller;

import java.util.List;

import java.util.Optional;

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

	@PostMapping("/addOffice")
	public ResponseEntity<CourierOfficeOutletDTO> addNewOffice(@RequestBody CourierOfficeOutlet officeOutlet)
			throws OutletNotFoundException {
		System.out.println(officeOutlet);
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeResponse = null;

		if (OfficeOutletServiceImp.ValidateOfficeDetails(officeOutlet)) {
			officeDTO = officeService.addNewOffice(officeOutlet);
			officeResponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
		} else
			throw new OutletNotFoundException("Office outlet not found");
		return officeResponse;
	}
	@DeleteMapping("/deleteOffice")
	public ResponseEntity<CourierOfficeOutletDTO> removeNewOffice(@RequestBody CourierOfficeOutlet officeOutlet)
			throws OutletNotFoundException {
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeResponse = null;
		Optional<CourierOfficeOutletDTO> optional = Optional.of(officeService.removeNewOffice(officeOutlet));
		if (optional.isPresent()) {
			officeDTO = optional.get();
			officeResponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
		} else
			throw new OutletNotFoundException("Office outlet doesn't exist");
		return officeResponse;

	}
	@GetMapping("/getOffice/{officeId}")
	public ResponseEntity<CourierOfficeOutletDTO> getOfficeInfo(@PathVariable("officeId") int officeId)
			throws OutletNotFoundException {
		CourierOfficeOutlet officeoutlet = new CourierOfficeOutlet();
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeresponse = null;
		if (OfficeOutletServiceImp.ValidateOfficeDetails(officeoutlet)) {
			officeoutlet = officeService.getOfficeInfo(officeId);
			officeresponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
		} else
			throw new OutletNotFoundException("No Offices with the id" + officeId + "are stored");
		return officeresponse;

	}
	@GetMapping("/getAllOffice")
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException {
		
		if (officeService.getAllOfficesData() == null) {
			throw new OutletNotFoundException("No Office Data found in the database");
		}
		return officeService.getAllOfficesData();
	}
	@GetMapping("/checkOfficeOpen")
	public ResponseEntity<String> isOfficeOpen(@RequestBody CourierOfficeOutlet officeOutlet)
			throws OutletClosedException {

		boolean check = officeService.isOfficeOpen(officeOutlet);
		if (check) {

			return new ResponseEntity<>("The office with office id: " + officeOutlet.getOfficeId() + " is open: ",
					HttpStatus.OK);

		} else {

			throw new OutletClosedException("The office is closed");

		}
	}
	@GetMapping("/checkOfficeClosed")
	public ResponseEntity<String> isOfficeClosed(@RequestBody CourierOfficeOutlet officeOutlet)
			throws OutletClosedException {

		boolean check = officeService.isOfficeClosed(officeOutlet);
		if (check) {

			throw new OutletClosedException("The Office is Closed");

		} else {

			return new ResponseEntity<String>("The Office is opened", HttpStatus.OK);

		}
	}

}
