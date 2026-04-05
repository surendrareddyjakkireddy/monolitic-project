package com.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address,Long>{

	public Address deleteByAddressId(Long addressId);

}
