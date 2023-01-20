package com.p3.demoentity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteCourses {

	public static void main(String[] args) {
		// delete only courses don't delete the instructor//
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			int id=1;
			Courses c =entityManager.find(Courses.class,id);
			System.out.println("delteing the course: "+c.getTitle());
			entityManager.remove(c);
			System.out.println("delted...");
			entityTransaction.commit();
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			entityManager.close();
		}
	}

}
