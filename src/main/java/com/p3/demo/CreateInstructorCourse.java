package com.p3.demo;

import com.p3.demoentity.Courses;
import com.p3.demoentity.Instructor;
import com.p3.demoentity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
// creating courses field in the course table //
public class CreateInstructorCourse {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			//  first getting the instructor from database//
			int id=1;
			Instructor instructor = entityManager.find(Instructor.class,id);
			// creating course object //
			Courses c1 = new Courses("power-electronics");
			Courses c2 = new Courses("digitalElectronics");
			Courses c3 = new Courses("Social");
			// add courses created to the instructor//
			instructor.add(c1);
			instructor.add(c2);
			instructor.add(c3);
			// save the courses //
			entityManager.persist(c1);
			entityManager.persist(c2);
			entityManager.persist(c3);
			// commit transaction //
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
