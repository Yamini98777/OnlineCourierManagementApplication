package com.capg.ocma.service;



import com.capg.ocma.exception.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.CustomerDTO;
import com.capg.ocma.repository.IComplaintDao;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.repository.ICustomerDao;
import com.capg.ocma.util.ComplaintUtil;
import com.capg.ocma.util.CustomerUtil;

/*
 * Author : GOMATHI M
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Customer Service Layer that provides services to Add New COmplaint,Checking tracking status, validating the entities
*/

@Service
public class CustomerServiceImp implements ICustomerService {

	static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);

	static String validationSuccessful = "Validation Successful";
	
	@Autowired
	private ICustomerDao customerRepo;

	@Autowired
	private IComplaintDao complaintRepo;

	@Autowired
	private ICourierDao courierRepo;

	/*
	 * Description 			: This method add the customer 
	 * Input Parameter	 	: Customer
	 * object Return Value  : CustomerDto object
	 *  Exception 			: CustomerNotFound
	 */
	@Override
	public CustomerDTO addCustomer(Customer customer) throws CustomerNotFoundException,AccountNotFoundException{
		
		if(validateCustomer(customer)) {
			if(validateBankAccount(customer.getAcct())) {
	
		 Customer cust= customerRepo.save(customer);
		 return CustomerUtil.convertToCustomerDTO(cust);
			}
			else
				throw new AccountNotFoundException("Invalid Data");
	}
		else
			throw new CustomerNotFoundException("Invalid Customer details");
	}

	/*
	 * Description			 : This method Checking the status of the Courier 
	 * Input Parameter		 : ConsignmentNo 
	 * Return Value			 : Courier status
	 *  Exception 			 : CourierNotFoundException
	 */
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException {
		Courier courier = courierRepo.findByConsignmentNo(consignmentno);
		String status = null;
		
		if (courier == null)
			throw new CourierNotFoundException("No complaint with this consignment number exists...enter valid consignment number");
		else
			status = courier.getStatus();

		return status;
	}

	/*
	 * Description 			: This method registers the complaint 
	 * Input Parameter		: Complaint
	 * object Return Value  : ComplaintDTO object 
	 * Exception 			: ComplaintNotFoundException
	 */
	public ComplaintDTO registerComplaint(Complaint complaint) throws ComplaintNotFoundException {

		logger.info("registerComplaint() service is initiated");
		Complaint complaintEntity;

		if (complaint == null)
		{
			complaintEntity = null;
		}
		else if (!validateComplaintId(complaint))
		{
			throw new ComplaintNotFoundException("Invalid complaintId");
		}
		else
		{
			
			complaintEntity = complaintRepo.save(complaint);
			logger.info("registerComplaint() service has executed");
		}

		return ComplaintUtil.convertToComplaintDTO(complaintEntity);
	}

	

	/*
	 * Description 			: This method validated the Mobile no 
	 * Input Parameter		: Mobile no
	 * object Return Value  : Boolean flag 
	 * Exception 			: CustomerNotFoundException
	 */
	
	public static boolean validateNumber(long mobileNo) throws CustomerNotFoundException {
		
		logger.info("validateNumber() is initiated");
		
		boolean flag = false;
		String str = Long.toString(mobileNo);
		int size = str.length();
		if (size == 0)
			throw new CustomerNotFoundException("Mobileno cannot be empty");
		else if (size <= 10 || size > 15)
			throw new CustomerNotFoundException("Mobileno not valid");
		else
			flag = true;
		logger.info(validationSuccessful);

		return flag;
	}

	/*
	 * Description 			: This method validated the Aadhar no 
	 * Input Parameter		: Aadhaar no  
	 * object Return Value  : Boolean flag 
	 * Exception 			: CustomerNotFoundException
	 */
	
	public static boolean validatesetAadharno(long aadharNo) throws CustomerNotFoundException {
		logger.info("validatesetAadharno() is initiated");
		boolean flag = false;
		String str = Long.toString(aadharNo);
		int size = str.length();
		if (size == 0)
			throw new CustomerNotFoundException("AAdhaarno cannot be empty");

		else if (size < 5)
			throw new CustomerNotFoundException("Enter valid aadhar number");

		else if (size > 5)
			flag = true;
		logger.info("validatesetAadharno() has executed");

		return flag;
	}
	/*
	 * Description 			: This method validated the FirstName and Last Name 
	 * Input Parameter		: Customer
	 * object Return Value  : Boolean flag 
	 * Exception 			: CustomerNotFoundException
	 */
	
	
	public static boolean validatesetName(Customer customer) throws CustomerNotFoundException {
		logger.info("validatesetName() is initiated");
		boolean flag = false;
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
		if (firstName==null || firstName.length()<2)
			throw new CustomerNotFoundException("FirstName invalid");

		else if (lastName==null)
			throw new CustomerNotFoundException("Enter valid lastName");

		else if (firstName.length()>2 && lastName.length()>=1)
			flag = true;
		logger.info("validatesetAadharno() has executed");

		return flag;
	}

	public static boolean validateCustomer(Customer customer) throws CustomerNotFoundException
	{
		boolean flag = false;
		if(customer == null)
			throw new CustomerNotFoundException("Invalid Customer");
		
		else if(!(validatesetName(customer)) 
				&& validatesetAadharno(customer.getAadharNo())
				&& validateNumber(customer.getMobileNo()))
			throw new CustomerNotFoundException("Invalid Data");
		
		else
			flag = true;
		
		return flag; 
	} 
	

	/*
	 * Description 			: This method validated the Complaint Id 
	 * Input Parameter		: Complaint 
	 * object Return Value  : Boolean flag 
	 * Exception 			: ComplaintNotFoundException
	 */
	
	public static boolean validateComplaintId(Complaint complaint) throws ComplaintNotFoundException {

		logger.info("validateComplaintId() is initiated");
		boolean flag = false;
		if (complaint == null) {
			logger.error("Tenant details cannot be blank");
			throw new ComplaintNotFoundException("Complaint details cannot be blank");
		} else if (!(validateConsignmentNo(complaint.getConsignmentNo()))) {
			logger.error("Invalid Address");
			throw new ComplaintNotFoundException("Invalid consignment");
		} else {
			logger.info(validationSuccessful);
			flag = true;
		}
		logger.info("validateComplaintId() has executed");
		return flag;
	}


	/*
	 * Description 			: This method validated the consignmentNo
	 * Input Parameter		: ConsignmentNo 
	 * object Return Value  : Boolean flag 
	 * Exception 			: ComplaintNotFoundException
	 */
	
	public static boolean validateConsignmentNo(int consignmentNo) throws ComplaintNotFoundException {
		
		logger.info("validateConsignmentNo() is initiated");
		
		boolean flag = false;
		String str = Long.toString(consignmentNo);
		int size = str.length();
		if (size == 0)
			throw new ComplaintNotFoundException("Consignment no cant be empty");
		else if (!str.matches("^[0-9a-zA-Z]+$"))
			throw new ComplaintNotFoundException("Consignment no invalid");
		else
			flag = true;
		logger.info("validateConsignmentNo() has executed");
		
		return flag;
		
	}
	
// BANK ACCOUNT VALIDATIONS
	
	/*
	 * Description 			: This is validation of Bank Account
	 * Input Parameter		: bankAccount 
	 * object Return Value  : Boolean flag 
	 * Exception 			: AccountNotFoundException
	 */
	
		public static boolean validateBankAccount(BankAccount bankAccount) throws AccountNotFoundException
		{
			boolean flag = false;
			if(bankAccount == null)
				throw new AccountNotFoundException("Bank account details cannot be blank");
			
			else if(!(validateAccountNo(bankAccount.getAccountNo()) 
					&& validateAccountHolderName(bankAccount.getAccountHolderName())
					&& validateAccountType(bankAccount.getAccountType())))
				throw new AccountNotFoundException("Invalid Data");
			
			else
				flag = true;
			
			return flag; 
		} 
		
		/*
		 * Description 			: This is validation of Bank Account Number
		 * Input Parameter		: accountNo 
		 * object Return Value  : Boolean flag 
		 * Exception 			: AccountNotFoundException
		 */
	
		
		public static boolean validateAccountNo(long accountNo) throws AccountNotFoundException
		{
			boolean flag = false;
			String str = Long.toString(accountNo);
			long size = str.length();
			if(accountNo <= 0 )  
				throw new AccountNotFoundException("Account Number cannot be 0 or Negative");
			
			else if(size < 2 || size > 9 )
				throw new AccountNotFoundException("Account Number size cannot be below 2 or above 9");
			
			else 
					flag = true;
			
			return flag;
		}
		
		/*
		 * Description 			: This is validation of Bank Account Holder Name
		 * Input Parameter		: accountHolderName
		 * object Return Value  : Boolean flag 
		 * Exception 			: AccountNotFoundException
		 */
		
		public static boolean validateAccountHolderName(String accountHolderName) throws AccountNotFoundException{
			boolean flag = false;
			
			if(accountHolderName == null)
				throw new AccountNotFoundException("Account Holder Name cannot be empty ");
		
			else if (!accountHolderName.matches("^[a-zA-Z ]+$"))
				throw new AccountNotFoundException("Account Holder Name cannot contain Numbers or Special Characters");
			
			else 
				flag = true;
			
			return flag;
			
		}
		
		/*
		 * Description 			: This is validation of Bank Account Type
		 * Input Parameter		: accountType
		 * object Return Value  : Boolean flag 
		 * Exception 			: AccountNotFoundException
		 */
		
		public static boolean validateAccountType(String accountType) throws AccountNotFoundException{
			boolean flag = false;
			
			if(accountType == null)
				throw new AccountNotFoundException("Account Type cannot be empty");
			
			else if(!accountType.matches("^[a-zA-Z ]+$")) 
				throw new AccountNotFoundException("Account Type cannot contain Numbers or Special Characters");
			
			else if(accountType.equals("Current") || accountType.equals("Savings") || accountType.equals("Salary"))
				flag = true;
				
			return flag;
			
		}
	}