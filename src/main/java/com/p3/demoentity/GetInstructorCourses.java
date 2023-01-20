package com.p3.demoentity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class GetInstructorCourses {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			int id=1;
			Instructor i =entityManager.find(Instructor.class,id);
			//getting courses of instructor//
			System.out.println("instructor:"+i.getFirstname());
			System.out.println(i.getInstructorDetail());
			System.out.println("courses: "+i.getCourses());
			entityTransaction.commit();
			System.out.println("done");
			
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
