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
		
		//sesion.persist(p1); esto inserta p1 en la base de datos
		
		// esto modifica la ciudad de p2
			Profesor p2 = sesion.get(Profesor.class, "08");
			System.out.println(p2);
			
			p2.setCiudad("Salinas");
			sesion.merge(p2);
			p2 = sesion.get(Profesor.class, "08");
			System.out.println(p2);
		//
			
		sesion.delete(p2);//esto borra la tabla de p2
		
		tx.commit();
		sesion.close();
		sessionFactory.close();
	}

}
