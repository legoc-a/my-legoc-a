package com.vue;
import java.util.List;

import com.metier.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateSession;

public class TestHiber {

	public static void main(String[]args){
		//créer une session 
		Session s = HibernateSession.getSession();
		//recupére tout les champs de type charge
		List<TypeCharge> l = s.createQuery("from TypeCharge").list();
		for(TypeCharge tp : l){
			System.out.println(tp.toString());
		}
		//récupération d'un type charge
		TypeCharge tp = (TypeCharge) s.get(TypeCharge.class, 2);
		System.out.println("                         test ==> "+tp.toString());
		
	}

}
