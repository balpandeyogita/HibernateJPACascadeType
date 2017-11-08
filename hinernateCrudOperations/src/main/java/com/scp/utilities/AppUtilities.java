package com.scp.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Yogesh
 *
 */
public class AppUtilities {
	
	private static SessionFactory sFactory= null; 
	
	/**
	 * 
	 * @return
	 */
	public static SessionFactory getAppSessionFactory(){
		if(null==sFactory)
			sFactory = new Configuration().configure().buildSessionFactory();

		return sFactory;
	}

}
