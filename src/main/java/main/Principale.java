package main;

import java.util.List;

import Dao.DaoClient;
import Dao.DaoEntreprise;
import entities.Client;
import entities.Entreprise;

public class Principale {

	public static void main(String[] args) {
////		// STEP 1 lire les donnenées depuis le clavier
////		Scanner lect = new Scanner(System.in);
////		System.out.println("Donner un Id");
////		int idc = lect.nextInt();
////
////		System.out.println("Donner le nom du client");
////		String nom = lect.next();
////
////		System.out.println("Donner le prenom du client");
////		String prenom = lect.next();
////
////		// STEP 2 création d'un objet Client
////		Client c = new Client(idc, nom, prenom);
////
////		// STEP3 Appeller
////		DaoClient daoClient = new DaoClient();
////		daoClient.addClient(c);
//
//		// STEP 1 lire les donnenées depuis le clavier
//		Scanner lect = new Scanner(System.in);
//		System.out.println("Donner le code de l'entreprise à mettre à jour ");
//		int idc = lect.nextInt();
//
////		System.out.println("Donner le nom de l'entreprise");
////		String nomEntreprise = lect.next();
////
////		// STEP 2 création d'un objet Client
////		Entreprise e = new Entreprise(idc, nomEntreprise);
//
//		// STEP3 Appeller
//		DaoEntreprise daoEntreprise = new DaoEntreprise();
//
//		// daoEntreprise.addEntreprise(e);
//
//		lect.close();
//
//		daoEntreprise.updateEntreprise(101, "Auchan");

		// Recherche d'un Client par son code
		DaoClient daoclient = new DaoClient();
		// Client res = daoclient.getClient(400);
		// Client res = daoclient.deleteClient(2000);
		// Client res = daoclient.updateClient(500,"François");
		List<Client> res = daoclient.getAllClient();
		for (Client c : res) {
			System.out.println(c);
		}
		// System.out.println(res.toString());
		// System.out.println(res);

		DaoEntreprise daoEntreprise = new DaoEntreprise();
		List<Entreprise> resEntreprise = daoEntreprise.getAllEntreprise();
		for (Entreprise e : resEntreprise) {
			System.out.println(e);
		}
		Long nbreClient = daoclient.getCountClient();
		System.out.println("le nombre de client dans la base est de :" + nbreClient);
	}

}
