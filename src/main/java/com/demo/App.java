package com.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.bean.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Student student1 = new Student(10, "Sachin", "Sci", "Pune");

		Student student2 = new Student(11, "Amar", "Art", "Sangli");

		Student student3 = new Student(13, "Sangam", "com", "Kolhapur");
		
		Student student4 = new Student(14, "Sachin", "Sci", "Pune");

		Student student5 = new Student(15, "Amar", "Art", "Sangli");

		Student student6 = new Student(18, "Sangam", "com", "Kolhapur");


		SessionFactory sessionfactory = new org.hibernate.cfg.Configuration().configure("/hibnernate.cfg.xml").buildSessionFactory();

		Session session = sessionfactory.openSession();

		session.save(student3);
		session.save(student2);
		session.save(student1);
		session.save(student4);
		session.save(student5);
		session.save(student6);
		
		session.beginTransaction().commit();

		Criteria criteria = session.createCriteria(Student.class);

		/* Finding studentAddress by cityName */
		// criteria.add(Restrictions.eq("studentAddress", "Pune"));

		/* Findind name by like query */
		// criteria.add(Restrictions.like("studentName", "a%"));

		/* Finding student rollNumber greater than */
		// criteria.add(Restrictions.gt("studentRollNumber", 11));

		/* Using paginatin */
		criteria.setFirstResult(1);
		criteria.setMaxResults(4);
		

		List<Student> students = criteria.list();

		for (Student student : students) {
			System.out.println(student);
		}
		session.close();

	}
}
