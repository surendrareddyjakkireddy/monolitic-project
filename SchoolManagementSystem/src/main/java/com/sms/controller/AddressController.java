package com.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Address;
import com.sms.service.AddressService;
import com.sms.util.ServiceResponse;
import com.sms.util.SmsContorllerUtil;

@RestController
@RequestMapping("api/address/v1")
public class AddressController {

	Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private SmsContorllerUtil smsContorllerUtil;
	
	@Autowired
	private AddressService addressService;

	@PostMapping("/createAddress")
	public ResponseEntity<?> createAddress(@RequestBody Address address) {
		ResponseEntity<?> response = null;
		ServiceResponse smsResponse = new ServiceResponse();
		try {
			address = addressService.createAddress(address);
			if(address != null) {
				smsResponse.addDataObject("address", address);
				smsResponse = smsContorllerUtil.successStatus(smsResponse, "address is saved");
				response = new ResponseEntity<ServiceResponse>(smsResponse, HttpStatus.OK);
			} else {
				smsResponse.addDataObject("address", address);
				smsResponse = smsContorllerUtil.successStatus(smsResponse, "address is not saved");
				response = new ResponseEntity<ServiceResponse>(smsResponse, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			logger.error("error created in address creation");
			smsResponse = smsContorllerUtil.failureStatus(smsResponse, "", e.getMessage());
			response = new ResponseEntity<ServiceResponse>(smsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@PutMapping("/updateAddress")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
		try {
			address = addressService.updateAddress(address);
			return new ResponseEntity<Address>(address, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in address updation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAllAddress")
	public ResponseEntity<List<Address>> findAllAddress() {
		try {
			List<Address> address = addressService.findAllAddress();
			return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in find all addresses");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findByAddressId")
	public ResponseEntity<Address> findByAddressId(@RequestParam Long addressId) {
		Address address=null;
		try {
			 address=addressService.findByAddressId(addressId);
		} catch (Exception e) {
			logger.error("error created in find by addressId");
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAddress")
	public ResponseEntity<Address> deleteByAddressId(@RequestParam Long addressId) {
		try {
			Address address = addressService.deleteByAddressId(addressId);
			return new ResponseEntity<Address>(address, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in address deletion");
			return new ResponseEntity<>(null, HttpStatus.TOO_MANY_REQUESTS);
		}
	}
}
