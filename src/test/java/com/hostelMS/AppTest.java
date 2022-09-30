package com.hostelMS;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hostelMS.dao.adminDao;
import com.hostelMS.dao.hostelMSDao;
import com.hostelMS.dao.userDao;
import com.hostelMS.daoImpl.adminDaoImpl;
import com.hostelMS.daoImpl.hostelMSDaoImpl;
import com.hostelMS.daoImpl.userDaoImpl;
import com.hostelMS.exception.GlobalException;
import com.hostelMS.model.room;
import com.hostelMS.model.user;

/**
 * Unit test for simple App.
 */
public class AppTest{ 

	@Test
	@Disabled
	@DisplayName(" test Registration")
	void testregistration() {
		hostelMSDao dao=new hostelMSDaoImpl();
		user u1=new user();
		u1.setUserName("adminbs");
		u1.setUserPassword("admin123");
		u1.setUserPhone("9059065724");
		u1.setUserRole("admin");
		u1.setUserAddress("vizag");
		user u2=new user();
		u2.setUserName("tony");
		u2.setUserPassword("tony123");
		u2.setUserPhone("9059065724");
		u2.setUserRole("student");
		u2.setUserAddress("Tirupati");
		assertAll(
				()->assertEquals(1,dao.registration(u2)),
				()->assertThrows(GlobalException.class,()->dao.registration(u1))
		);
	}
	
	@Test
	@DisplayName("Chanign password")
	@Disabled
	void testchangePassword() throws GlobalException {
		
		userDao udao=new userDaoImpl();
		
		assertAll(
		()->assertEquals(1,udao.changePassword(3,"anu007", "anu123")),
		()->assertEquals(1,udao.changePassword(3,"anu007", "anu123"))
		);
	}
	
	@Test
	void testadmin() throws GlobalException {
		adminDao adao=new adminDaoImpl();
		room r1=new room();
		r1.setRoomId(104);
		r1.setRoomName("Anjanadri");
		r1.setRoomType("AC");
		
		assertEquals(1,adao.createRoom(r1));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	}
