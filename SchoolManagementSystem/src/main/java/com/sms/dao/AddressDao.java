package com.sms.dao;

import java.util.List;

import com.sms.model.Address;

public interface AddressDao {

	public void createAddress(Address address);
	
	public void updateAddress(Address address);
	
	public  List<Address> findAllAddress();
	
	public Address deleteByAddressId(Long addressId);
}
