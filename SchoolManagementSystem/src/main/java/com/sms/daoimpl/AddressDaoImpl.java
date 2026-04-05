package com.sms.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sms.dao.AddressDao;
import com.sms.model.Address;
import com.sms.rowmapper.AddressRowMapper;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createAddress(Address address) {
		String createSql="INSERT INTO SMS.ADDRESS VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(createSql,address.getAddressId(),address.getHouseNo(),address.getLandMark(),address.getStreet(),address.getCity(),address.getDistrict(),address.getState(),address.getPinCode());
	}


	public void updateAddress(Address address) {
		String update="UPDATE SMS.ADDRESS SET HOUSENO=?,LANDMARK=?,STREET=?,CITY=?,DISTRICT=?,STATE=?,PINCODE=? WHERE ADDRESSID=?";
		jdbcTemplate.update(update,address.getHouseNo(),address.getLandMark(),address.getStreet(),address.getCity(),address.getDistrict(),address.getState(),address.getPinCode(),address.getAddressId());
	}


	public List<Address> findAllAddress() {
		String findAll="SELECT * FROM SMS.ADDRESS ";
		List<Address> addressList = jdbcTemplate.query(findAll, new AddressRowMapper());
		return addressList;
	}


	public Address deleteByAddressId(Long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

}
