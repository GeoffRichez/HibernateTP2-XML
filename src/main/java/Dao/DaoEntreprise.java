package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Util.HibernateUtil;
import entities.Entreprise;

public class DaoEntreprise {

	public Entreprise addEntreprise(Entreprise ent) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(ent);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				session.close();
			}
			session.close();
		}
		return ent;
	}

	public Entreprise getEntreprise(int id) {
		Entreprise ent = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction

			ent = (Entreprise) session.load(Entreprise.class, id);
			tx.commit();
		} catch (Exception e) {
			// System.out.println("Un problème dans la base");
			if (tx != null) {
				tx.rollback();// on effectue un roll back en cas d’exception
				// afin de garder la cohérence des données
				session.close();
			}
			session.close();// fermeture de la session hibernate
		}

		return ent;

	}

	// deleteClient permet de supprimer un client avec id
	public Entreprise deleteClient(int id) {
		Entreprise ent = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction

			ent = (Entreprise) session.load(Entreprise.class, id);
			session.delete(ent); // suppression de l’objet « c »
			tx.commit();
		} catch (Exception e) {
			// System.out.println("Un problème dans la base");
			if (tx != null) {
				tx.rollback();// on effectue un roll back en cas d’exception
				// afin de garder la cohérence des données
				session.close();
			}
			session.close();// fermeture de la session hibernate
		}

		return ent;

	}

	// updateEntreprise
	public Entreprise updateEntreprise(int id, String newLibelle) {
		Entreprise entrepriseAmettreAJour = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
			entrepriseAmettreAJour = (Entreprise) session.load(Entreprise.class, id);
			entrepriseAmettreAJour.setLibelle(newLibelle);
			session.save(entrepriseAmettreAJour);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				session.close();
			}

		}
		session.close();
		return entrepriseAmettreAJour;
	}

	public List<Entreprise> getAllEntreprise() {
		List<Entreprise> ls = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction

//			//Méthode 1
//			 ls = (List<Entreprise>)session.createCriteria(Entreprise.class).list();
//			// Fin méthode 1
//			
			// Méthode 2: HQL
			String hql = "from Entreprise";
			Query query = session.createQuery(hql);
			ls = query.list();
			// Fin méthode 2

			// System.out.println(ls);
			tx.commit();
		} catch (Exception e) {
			// System.out.println("Un problème dans la base");
			if (tx != null) {
				tx.rollback();// on effectue un roll back en cas d’exception
				// afin de garder la cohérence des données
				session.close();
			}

		}
		session.close();// fermeture de la session hibernate
		return ls;
	}

}
