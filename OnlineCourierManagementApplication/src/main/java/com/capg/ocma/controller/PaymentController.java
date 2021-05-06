package com.capg.ocma.controller; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.CourierDTO;
import com.capg.ocma.service.IPaymentService;

/*
 * Author      : PRADHIEEP K
 * Version     : 1.0
 * Date        : 04-04-2021
 * Description : This is Payment Controller
 */ 
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ocma/payment")
public class PaymentController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPaymentService paymentService;
	
	/**********
	 * Method         : processPaymentByCash 
	 * Description    : It is used to select the payment method by cash 
	 * @param         : int courierId
	 * @returns       : It returns CourierDTO Object with details
	 * @GetMapping    : It is used for mapping HTTP GET requests onto specific handler methods.
	 * @ResponseEntity: It represents the whole HTTP response: status code, headers, and body.
	 * @exception     : CourierNotFoundException
	 * Created By     - PRADHIEEP K
     * Created Date   - 04-04-2021 
	 * 
	 **********/
	
	@GetMapping("/byCash/{courierId}")
	public ResponseEntity<CourierDTO> processPaymentByCash(@PathVariable int courierId)  throws CourierNotFoundException {
		
		logger.info("byCash URL is opened");
		logger.info("processPaymentByCash() is initiated");
		CourierDTO courierDTO = paymentService.processPaymentByCash(courierId);
		logger.info("processPaymentByCash has executed and you have chosen cash on delivery");
		
		return new ResponseEntity<CourierDTO> (courierDTO,HttpStatus.OK);
		
	}
	
	/**********
	 * Method         : processPaymentByCard 
	 * Description    : It is used to select the payment method by card
	 * @param         : long accountNo
	 * @returns       : It returns ResponseEntity Payment process
	 * @GetMapping    : It is used for mapping HTTP GET requests onto specific handler methods.
	 * @ResponseEntity: It represents the whole HTTP response: status code, headers, and body.
	 * @exception     : AccountNotFoundException
	 * Created By     - PRADHIEEP K
     * Created Date   - 04-04-2021 
	 * 
	 **********/
	
	@GetMapping("/byCard/{accountNo}")
	public ResponseEntity<String> processPaymentByCard(@PathVariable long accountNo) throws AccountNotFoundException{
		
		logger.info("byCard URL is opened");
		logger.info("processPaymentByCard() is initiated");
		boolean flag = false;
		ResponseEntity<String> response = null;
		
		if(accountNo > 0) {
			flag = paymentService.processPaymentByCard(accountNo);
			if(flag == true)
				response = new ResponseEntity<String> ("You have selected card payment method and paid successfully ",HttpStatus.OK);
			else 
				throw new AccountNotFoundException("Cannot able to pay by card");
		}
		
		logger.info("processPaymentByCard() has executed");
		
		return response;
	}


}