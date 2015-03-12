package com.vue;
import java.util.List;

import com.metier.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateSession;

public class TestHiber {

	public static void main(String[]args){
		//cr�er une session 
		Session s = HibernateSession.getSession();
		//recup�re tout les champs de type charge
		List<TypeCharge> l = s.createQuery("from TypeCharge").list();
		for(TypeCharge tp : l){
			System.out.println(tp.toString());
		}
		//r�cup�ration d'un type charge
		TypeCharge tp = (TypeCharge) s.get(TypeCharge.class, 2);
		System.out.println("                         test ==> "+tp.toString());
		
	}

}
