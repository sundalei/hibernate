package com.shengsiyuan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shengsiyuan.dao.PersonDAO;
import com.shengsiyuan.model.Person;
import com.shengsiyuan.util.HibernateUtil;

public class PersonDAOImpl implements PersonDAO {

	@Override
	public void savePerson(Person person) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(person);
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listAllPersons() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Person> list = null;
		
		try {
			// Person是类的名字，不是表的名字
			Query query = session.createQuery("from com.shengsiyuan.model.Person");
			list = (List<Person>)query.list();
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
		
		return list;
	}

	@Override
	public void removePerson(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Person person = (Person) session.get(Person.class, id);
			session.delete(person);
			tx.commit();
			
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
	}

	@Override
	public Person getSinglePerson(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Person person = null;
		
		try {
			person = (Person) session.get(Person.class, id);
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
		
		return person;
	}

}
