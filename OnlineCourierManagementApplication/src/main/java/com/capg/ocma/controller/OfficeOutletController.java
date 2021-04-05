package com.capg.ocma.controller;

import java.util.List;

import java.util.Optional;

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
	
	IOfficeOutletService officeService;

	OfficeOutletServiceImp service = new OfficeOutletServiceImp();

	@PostMapping("/addOffice")
	public ResponseEntity<CourierOfficeOutletDTO> addNewOffice(@RequestBody CourierOfficeOutlet officeoutlet)
			throws OutletNotFoundException {
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeresponse = null;

		if (OfficeOutletServiceImp.ValidateOfficeDetails(officeoutlet)) {
			officeDTO = officeService.addNewOffice(officeoutlet);
			officeresponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
		} else
			throw new OutletNotFoundException("Office outlet not found");
		return officeresponse;
	}
	@DeleteMapping("/deleteOffice")
	public ResponseEntity<CourierOfficeOutletDTO> removeNewOffice(@RequestBody CourierOfficeOutlet officeoutlet)
			throws OutletNotFoundException {
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeresponse = null;
		Optional<CourierOfficeOutletDTO> optional = Optional.of(officeService.removeNewOffice(officeoutlet));
		if (optional.isPresent()) {
			officeDTO = optional.get();
			officeresponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
		} else
			throw new OutletNotFoundException("Office outlet doesn't exist");
		return officeresponse;

	}
	@GetMapping("/getOffice/officeid={officeid}")
	public ResponseEntity<CourierOfficeOutletDTO> getOfficeInfo(@PathVariable("officeid") int officeid)
			throws OutletNotFoundException {
		CourierOfficeOutlet officeoutlet = new CourierOfficeOutlet();
		CourierOfficeOutletDTO officeDTO = null;
		ResponseEntity<CourierOfficeOutletDTO> officeresponse = null;
		if (OfficeOutletServiceImp.ValidateOfficeDetails(officeoutlet)) {
			officeoutlet = officeService.getOfficeInfo(officeid);
			officeresponse = new ResponseEntity<CourierOfficeOutletDTO>(officeDTO, HttpStatus.ACCEPTED);
		} else
			throw new OutletNotFoundException("No Offices with the id" + officeid + "are stored");
		return officeresponse;

	}
	@GetMapping("/getAllOffice")
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException {
		if (officeService.getAllOfficesData() == null) {
			throw new OutletNotFoundException("No Offices found in the database");
		}
		return officeService.getAllOfficesData();
	}
	@GetMapping("/checkOfficeOpen")
	public ResponseEntity<String> isOfficeOpen(@RequestBody CourierOfficeOutlet officeoutlet)
			throws OutletClosedException {

		boolean check = officeService.isOfficeOpen(officeoutlet);
		if (check) {

			return new ResponseEntity<>("The office with office id: " + officeoutlet.getOfficeId() + " is open: ",
					HttpStatus.OK);

		} else {

			throw new OutletClosedException("The office is closed");

		}
	}
	@GetMapping("/checkOfficeClosed")
	public ResponseEntity<String> isOfficeClosed(@RequestBody CourierOfficeOutlet officeoutlet)
			throws OutletClosedException {

		boolean check = officeService.isOfficeClosed(officeoutlet);
		if (check) {

			throw new OutletClosedException("The Office is Closed");

		} else {

			return new ResponseEntity<>("The Office is opened", HttpStatus.OK);

		}
	}

}
