package com.p3.demo;

import org.hibernate.query.sqm.mutation.internal.temptable.PersistentTableInsertStrategy;

import com.p3.demoentity.Courses;
import com.p3.demoentity.Instructor;
import com.p3.demoentity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CreateInstructor {

	public static void main(String[] args) {
	
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Instructor i = new Instructor("abhishek","c","abhi@gmail.com");
			InstructorDetail i_d = new InstructorDetail("dolluchannel","film"); 
			i.setInstructorDetail(i_d);
			entityTransaction.begin();
			entityManager.persist(i);
			entityTransaction.commit();
			System.out.println("done....");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			entityManager.close();
		}
	}

}
