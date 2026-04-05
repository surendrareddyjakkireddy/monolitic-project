package com.sms.service;

import java.util.List;

import com.sms.exception.SmsServiceException;
import com.sms.model.Address;

public interface AddressService {

	public Address createAddress(Address address) throws SmsServiceException;
	
	public Address updateAddress(Address address);
	
	public List<Address> findAllAddress();
	
	public Address findByAddressId(Long addressId);
	
	public Address  deleteByAddressId(Long addressId);
}
