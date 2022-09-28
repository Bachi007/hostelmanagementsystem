//service layer
package com.hostelMS.serviceImpl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.hostelMS.dao.userDao;
import com.hostelMS.daoImpl.userDaoImpl;
import com.hostelMS.exception.GlobalException;
import com.hostelMS.model.user;
import com.hostelMS.service.userdashboard;

public class userdashboardImpl implements userdashboard {
	//declaring static objects to use in entire class
	static Logger log=Logger.getLogger(userdashboardImpl.class);
	static Scanner bs=new Scanner(System.in);
	static userdashboardImpl udl=new userdashboardImpl();
	static userDao dao=new userDaoImpl();
	static int userId;
	@Override
	//dashboard method
	public void dashboard(int uId) throws GlobalException {
		log.info("\t\t\t---------------------Welcome to userdashboard----------------------");
		int op=0;
		userId=uId;
		while(op<6) {
			//user can select operation
			log.info("\nPress 1 for viewRoom\nPress 2 for view dueAmount \nPress 3 for view profile\nPress 4 for Update Phone number \nPress 5 for Change password");
			
			op=bs.nextInt();
			
			switch(op) {
		
		case 1->udl.viewRoom();
		
		case 2->udl.viewDueAmount();
		
		case 3->udl.viewProfile();
		
		case 4->udl.changePhonenumber();
		
		case 5->udl.changePassword();
		}
		}
	}

	//view room details of the user
	@Override
	public void viewRoom() {
		//calling dao layer
	user u1=dao.viewRoom(userId);
	log.info("Hello "+u1.getUserName()+" your room number is"+u1.getUserRoom().getRoomId()+" room name is "+u1.getUserRoom().getRoomName()+" and it is "+u1.getUserRoom().getRoomType()+" room");
	}

	//view dueamount of the user
	@Override
	public void viewDueAmount() {
		//calling dao layer
		int amount=dao.viewDueAmount(userId);
		log.info("your fee due upto this month is :"+amount);
	}

	//viewProfile with toString 
	@Override
	public void viewProfile() {
		
		user u1=dao.viewProfile(userId);
		log.info(u1);
		
	}

	//to change phone number
	@Override
	public void changePhonenumber() {
		log.info("Enter New Phone number");
		String phone=bs.next();
		int st=dao.changePhone(userId, phone);
		if(st==1) {
			log.info("Phone number updated");
		}
	}

	//to update password, user have to enter current password
	@Override
	public void changePassword() throws GlobalException {
		
		log.info("Enter Current Password");
		String oldpwd=bs.next();
		log.info("Enter New Password");
		String newpwd=bs.next();
		int st=dao.changePassword(userId, oldpwd, newpwd);
		if(st==1) {
			log.info("password changed");
		}
	}

}
