package com.persistance;
import com.metier.*;
import com.util.HibernateSession;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class AccesData {
	private static  Session s = HibernateSession.getSession();
	private static Transaction t =null;
	// accesseurs sur listes d'objets
	public static List<TypeCharge> getListeTypeCharge() 	{
		return  s.createQuery("from TypeCharge").list();
					}
	public static List<Station> getListeStation() 	{
		return  s.createQuery("from Station").list();
	}
	public static List<Borne> getListeBorne() 	{
		return  s.createQuery("from Borne").list();
	}
	
	public static List<Borne> getListeBorneStation(int idStation) 	{
		return s.createQuery("from Borne Where idStation="+idStation).list();
		//return getBorneDAO().retrieve(idStation);
	}
	
	public static TypeCharge getTypeCharge(int idType) 	{
		TypeCharge tp = (TypeCharge) s.get(TypeCharge.class, idType);
		return tp;
	}
	public static Station getStation(int idStation) 	{
		Station st = (Station) s.get(Station.class, idStation);
		return st;
	}
	public static Borne getBorne(int idBorne) 	{
		Borne b = (Borne) s.get(Borne.class, idBorne);
		return b;
	}
	public static boolean addStation(Station st) 	{
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. save(st);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getStationDAO().create(s);
	}
	public static boolean deleteStation(Station st) 	{
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. delete (st);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getStationDAO().delete(s);
	}
	public static boolean updateStation(Station st) 	{
		boolean ok=false;
		try {
			 t = s.beginTransaction() ;
			s. saveOrUpdate (st);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getStationDAO().update(s);
	}
	public static boolean addBorne(Borne b) 	{
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. save(b);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getBorneDAO().create(b);
	}
	public static boolean deleteBorne(Borne b) 	{
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. delete (b);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getBorneDAO().delete(b);
	}
	public static boolean updateBorne(Borne b) 	{
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. saveOrUpdate(b);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getBorneDAO().update(b);
	}
	public static boolean updateTypeCharge(TypeCharge tp){
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. saveOrUpdate(tp);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getTypeChargeDAO().update(t);
	}
	public static boolean deleteTypeCharge(TypeCharge tp) 	{
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. delete(tp);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getTypeChargeDAO().delete(t);
	}
	public static boolean addTypeCharge(TypeCharge tp) 	{
		boolean ok=false;
		try {
			t = s.beginTransaction() ;
			s. save(tp);
			t.commit() ;
			ok = true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return ok;
		//return getTypeChargeDAO().create(t);
	}
	/*private static BorneDAO  getBorneDAO() 	{
		bDAO=new BorneDAO();
		return bDAO;
	}
	private static TypeChargeDAO  getTypeChargeDAO() 	{
		tcDAO=new TypeChargeDAO();
		return tcDAO;
	}
	private static StationDAO  getStationDAO() 	{
		sDAO=new StationDAO();
		return sDAO;
	}
	public static void closeBd() 	{
		AccesBd.close();
	}*/

}
