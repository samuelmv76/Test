package proyectoInicioHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import proyectoInicioHibernate.entidades.Profesor;

import org.hibernate.Session;

public class App {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sessionFactory.openSession(); 
		
		Transaction tx = sesion.beginTransaction();
		
		Profesor p1 = new Profesor("08","Sergio","Aviles");
		
		sesion.persist(p1);
		
		tx.commit();
		sesion.close();
		sessionFactory.close();
	}

}
