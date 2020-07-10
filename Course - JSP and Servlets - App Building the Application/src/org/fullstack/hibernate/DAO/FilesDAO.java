package org.fullstack.hibernate.DAO;

import java.io.File;
import java.util.List;

import org.fullstack.hibernate.entity.Files;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FilesDAO {
	
	SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Files.class)
									.buildSessionFactory();
	
	
	
	public void addFilesDetails(Files file) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(file);
		session.getTransaction().commit();
		System.out.println((file.getFileName()) + "Good Added");
	}
	public List<Files> listFiles(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<Files> files = session.createQuery("from files").getResultList();
		//session.get(Files.class, 1);
		//session.getTransaction().commit();
		return files;
		
		
	}

}
