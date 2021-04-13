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

/*
 * Author : JEGANNATH P S
 * Version : 1.0
 * Date : 05-04-2021
 * Description : This is Office outlet Controller
*/

@RestController
@RequestMapping("/api/ocma/Office")
public class OfficeOutletController {

	@Autowired
	private IOfficeOutletService officeService;
	
	final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	
	
	/********************************************
	 * Method              : addNewOffice
	 * Description         : It is used to add a new Office Outlet Details into courier_office_outlet table
	 * @param officeOutlet : CourierOfficeOutlet Object
	 * @returns            : It returns CourierOfficeOutletDTO Object with details
	 * @PostMapping        : It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception          : InvalidAddressException, OfficeDetailsNullException
	 * Created By          : JEGANNATH P S
     * Created Date        : 05-04-2021 
	 * 
	 *******************************************/
	

	@PostMapping("/addOffice")
	public ResponseEntity<CourierOfficeOutletDTO> addNewOffice(@RequestBody CourierOfficeOutlet officeOutlet)
			throws InvalidAddressException, OfficeDetailsNullException {

		CourierOfficeOutletDTO officeDTO = null;

		ResponseEntity<CourierOfficeOutletDTO> officeResponse = null;

		officeDTO = officeService.addNewOffice(officeOutlet);

		officeResponse = new ResponseEntity<>(officeDTO, HttpStatus.ACCEPTED);

		return officeResponse;
	}
	
	/********************************************
	 * Method              : removeNewOffice
	 * Description         : It is used to Remove an Existing Office Outlet from the courier_office_outlet table
	 * @param officeId     : CourierOfficeOutlet Object
	 * @returns            : It returns CourierOfficeOutletDTO Object with details
	 * @DeleteMapping      : It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception          : InvalidAddressException, OfficeDetailsNullException
	 * Created By          : JEGANNATH P S
     * Created Date        : 05-04-2021 
	 * 
	 *******************************************/
	


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
	
	/********************************************
	 * Method          : getOfficeInfo
	 * Description     : It is used to Get Office outlet informations from courier_office_outlet table
	 * @param officeId : int officeId
	 * @returns        : It returns CourierOfficeOutletDTO  Object with details
	 * @GetMapping     : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody    : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception      : OutletNotFoundException
	 * Created By      : JEGANNATH P S
     * Created Date    : 05-04-2021
	 * 
	 *******************************************/

	@GetMapping("/getOffice/{officeId}")
	public ResponseEntity<CourierOfficeOutletDTO> getOfficeInfo(@PathVariable("officeId") int officeId) throws OutletNotFoundException {
		
		CourierOfficeOutletDTO officeoutlet = officeService.getOfficeInfo(officeId);
		
		ResponseEntity<CourierOfficeOutletDTO> officeresponse = new ResponseEntity<>(officeoutlet, HttpStatus.ACCEPTED);

		return officeresponse;

	}
	
	/********************************************
	 * Method          : getAllOfficesData
	 * Description     : It is used to Get all of the Office outlet informations from courier_office_outlet table
	 * @returns        : It returns all List<CourierOfficeOutletDTO> Object with details
	 * @GetMapping     : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody    : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception      : OutletNotFoundException
	 * Created By      : JEGANNATH P S
     * Created Date    : 05-04-2021
	 * 
	 *******************************************/


	@GetMapping("/getAllOfficeData")
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException {

	
		return officeService.getAllOfficesData();
	}
	
	

	/********************************************
	 * Method          : isOfficeOpenorClosed
	 * Description     : It is used to get information about the office availability by checking with the current system time
	 * @returns        : It returns String containing the office availability details
	 * @param officeId : int officeId
	 * @GetMapping     : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody    : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception      : OutletClosedException
	 * Created By      : JEGANNATH P S
     * Created Date    : 05-04-2021
	 * 
	 *******************************************/


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