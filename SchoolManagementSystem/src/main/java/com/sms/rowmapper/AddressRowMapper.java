package com.sms.rowmapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sms.model.Address;

public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address=new Address();
		address.setAddressId(rs.getLong(1));
		address.setHouseNo(rs.getString(2));
		address.setLandMark(rs.getString(3));
		address.setStreet(rs.getString(4));
		address.setCity(rs.getString(5));
		address.setDistrict(rs.getString(6));
		address.setState(rs.getString(7));
		address.setPinCode(rs.getLong(8));
		return address;
	}
	
}