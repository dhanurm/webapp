package com.clc.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.clc.dao.EmployeeDaoImpl;
import com.clc.entity.EmployeeBean;
import com.clc.entity.EmployeeEntity;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDaoImpl daoImpl;
	// public JavaMailSender mailsender;

	// public void setMailsender(JavaMailSender mailsender) {
	// this.mailsender = mailsender;
	// }

	static {
		System.out.println("Serviceimpl..Static block..");
	}

	public EmployeeServiceImpl() {
		System.out.println("Service Impl Contructor");
	}

	public void setDaoImpl(EmployeeDaoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public EmployeeEntity convertBeanToEntity(EmployeeBean bean) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setId(bean.getId());
		entity.setName(bean.getName());
		entity.setPassword(bean.getPassword());
		entity.setRole(bean.getRole());
		return entity;
	}

	public EmployeeBean convertEntityToBean(EmployeeEntity entity) {
		EmployeeBean bean = new EmployeeBean();
		bean.setId(entity.getId());
		bean.setName(entity.getName());

		bean.setPassword(entity.getPassword());
		bean.setRole(entity.getRole());
		return bean;
	}

	public List<EmployeeBean> convertEntitiesToBeans(List<EmployeeEntity> entities) {
		List<EmployeeBean> beans = new ArrayList<EmployeeBean>();
		for (EmployeeEntity entity : entities) {
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}

	public List<EmployeeEntity> convertBeansToEntity(List<EmployeeBean> beans) {
		List<EmployeeEntity> entities = new ArrayList<EmployeeEntity>();
		for (EmployeeBean bean : beans) {
			entities.add(convertBeanToEntity(bean));
		}
		return entities;
	}

	public boolean addEmp(EmployeeBean bean) {
		// sendMail();
		return daoImpl.insertEmp(convertBeanToEntity(bean));
	}

	// private void sendMail() {
	// System.out.println(mailsender.toString());
	// MimeMessage mimeMessage = mailsender.createMimeMessage();
	// try {
	// MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	//
	// helper.setFrom("dhanshrimane23@gmail.com");
	// helper.setTo("dhanshrimane94@gmail.com");
	// helper.setSubject("Test MAil");
	// String content = "Hello Dhanshri";
	// helper.setText(content, true);
	// mailsender.send(mimeMessage);
	// } catch (MessagingException mse) {
	// mse.printStackTrace();
	// }
	// }

	public EmployeeBean getEmp(int empId) {
		return convertEntityToBean(daoImpl.fetchEmp(empId));
	}

	public boolean deleteEmp(int empId) {
		return daoImpl.removeEmp(empId);
	}

	public List<EmployeeBean> getAllEmps() {
		return convertEntitiesToBeans(daoImpl.fetchAllEmps());
	}

	public EmployeeBean updateEmp(EmployeeBean bean) {
		return convertEntityToBean(daoImpl.modifyEmp(convertBeanToEntity(bean)));
	}

//	@Override
//	public EmployeeBean getByUserName(String username) {
//		
//		return convertEntityToBean(daoImpl.fetchByuserName(username));
//	}

}
