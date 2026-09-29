package com.aryan.hibernate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aryan.hibernate.entity.Employee;

public class LobsFetch {

	public static void main(String[] args) throws IOException {
		SessionFactory  factory = new Configuration()
										.addAnnotatedClass(Employee.class)
										.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		byte[] image = null;
		char[] resume = null;
		
		Employee emp = session.find(Employee.class, 1);
		
		System.out.println(emp);
		
		image = emp.getImage();
		resume = emp.getResume();
		Files.write(Paths.get("/Users/aryangupta/Downloads/FetchedImage.webp"), image);
		Files.writeString(Paths.get("/Users/aryangupta/Downloads/FetchedResume.txt"), new String(resume));
		
		session.close();
		factory.close();
	}

}

//OUTPUT

/*Hibernate: 
    select
        e1_0.empId,
        e1_0.empAddress,
        e1_0.empName,
        e1_0.image,
        e1_0.resume 
    from
        empTab e1_0 
    where
        e1_0.empId=?
Employee [eid=1, ename=sachin, eaddress=CSK]
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown initiated...
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown completed.
Sept 28, 2026 2:09:25 AM org.hibernate.cache.spi.AbstractRegionFactory stop
WARN: HHH90001002: Attempt to stop an already-stopped JCacheRegionFactory.
*/
