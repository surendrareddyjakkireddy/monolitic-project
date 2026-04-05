package com.sms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.AddressRepository;
import com.sms.exception.SmsServiceException;
import com.sms.model.Address;
import com.sms.service.AddressService;


@Service
public class AddressServiceImpl implements AddressService {

	Logger logger=LoggerFactory.getLogger(AddressServiceImpl.class);
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public Address createAddress(Address address) throws SmsServiceException {
		try {
			address=addressRepository.save(address);
		} catch (Exception e) {
			logger.error("address is not created");
			throw new SmsServiceException("", "", e.getCause());
		}
		return address;
	}

	@Transactional
	public Address updateAddress(Address address) {
		try {
			address=addressRepository.save(address);
			return address;
		} catch (Exception e) {
			logger.error("address is not updated");
			return null;
		}
	}

	@Transactional
	public List<Address> findAllAddress() {
		try {
			List<Address> address=addressRepository.findAll();
			return address;
		} catch (Exception e) {
			logger.error("addresses not found");
			return null;
		}
	}

	@Transactional
	public Address deleteByAddressId(Long addressId) {
		Address address=null;
		try {
			address=this.findByAddressId(addressId);
			if(address !=null) {
				addressRepository.deleteByAddressId(addressId);
			}
		} catch (Exception e) {
			logger.error("address is not deleted");
		}
		return address;
	}

	@Transactional
	public Address findByAddressId(Long addressId) {
		Address address=null;
		try {
			Optional<Address> addressOpt=addressRepository.findById(addressId);
			if(addressOpt.isPresent()) {
				address=addressOpt.get();
			}
		} catch (Exception e) {
			logger.error("address is not found");
		}
		return address;
	}

}
