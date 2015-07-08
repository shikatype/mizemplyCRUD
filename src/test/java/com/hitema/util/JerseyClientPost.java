package com.hitema.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hitema.model.Paiement;
import com.hitema.model.Role;

public class JerseyClientPost {

	public static void main(String[] args) {
		
		String url = "http://localhost:8080/mizemplyCRUD/rest/demandeDao/findByRole";
		Paiement paiement = new Paiement();
		paiement.setMontant(500);
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		
		paiement.setDate(formater.format(date));
		Role demande = new Role(); 
		PostUtils.appelPost(url, demande);
		System.out.println();
	}
}
