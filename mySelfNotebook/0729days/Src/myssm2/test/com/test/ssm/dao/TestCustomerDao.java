package com.test.ssm.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.ssm.domain.po.Customer;

public class TestCustomerDao {
	private SqlSession session = null;
	private CustomerDao customerDao = null;
	@Before
	public void setup() throws IOException {
		// �����еĲ��Է���֮ǰִ��һ�Σ���ɳ�ʼ������
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(
				TestCustomerDao.class.getClassLoader(), resource
				);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		session = sessionFactory.openSession();
		customerDao = session.getMapper(CustomerDao.class);
	}

	@Test
	public void testFindById() {
		Customer customer = customerDao.findById(1);
		assertTrue(customer.getPassport().getId() == 2);
	}
	
	@Test
	public void testFindAll() {
		List<Customer> customers = customerDao.findAll();
		assertTrue(1 == customers.size());;
	}
	
	@After
	public void tear() {
		// �����еĲ��Է���ִ�н�����ִ�У������Դ���ͷ�
		session.close();
	}

}
