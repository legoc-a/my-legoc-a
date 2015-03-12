package com.test;
import com.metier.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BorneTest {
	private Borne b , b0;
	private TypeCharge t1 , t2 , t3 ;
	private Station s, s0;

	@Before
	public void setUp() throws Exception {
		t1 = new TypeCharge(1 , "normale" , 3);
		t2 = new TypeCharge(2 , "semi-rapide" ,24);
		s = new Station(1,"station");
		s0 = new Station(2,"station");
		b = new Borne(2 , "25/09/2014" , s , "ES" ,  t1);
		b0 = new Borne("26/09/2014" , s0 , t1);
		t3 = new TypeCharge("très rapide" , 75);
	}

	@After
	public void tearDown() throws Exception {
		b = null;
		t1 = null;
		t2 = null;
	}

	@Test
	public void testBorne() {
		assertNotNull(b);
		assertNotNull(b0);
	}

	@Test
	public void testGetDateMiseEnService() {
		assertEquals("25/09/2014" , b.getDateMiseEnService());
		assertEquals("26/09/2014" , b0.getDateMiseEnService());
	}

	@Test
	public void testSetDateMiseEnService() {
		b.setDateMiseEnService("26/09/2014");
		assertEquals("26/09/2014" , b.getDateMiseEnService());
	}

	@Test
	public void testGetEtat() {
		assertEquals("ES", b.getEtat());
		assertEquals("ES", b0.getEtat());
	}

	@Test
	public void testSetEtat() {
		b.setEtat("HS");
		assertEquals("HS" , b.getEtat());
	}
	@Test
	public void testGetIdStation() {
		assertEquals(b.getLaStation().getIdStation(), 1);
		assertEquals(b0.getLaStation().getIdStation() , 2);
	}
	@Test
	public void testSetIdStation() {
		b0.setLaStation(s);
		assertEquals(1 , b.getLaStation().getIdStation());
	}
	@Test
	public void testGetTypeCharge() {
		assertEquals(t1 , b.getTypeCharge());
		assertEquals(t1 , b0.getTypeCharge());
	}

	@Test
	public void testSetTypeCharge() {
		b.setTypeCharge(t2);
		assertEquals(t2 , b.getTypeCharge());
		
	}

	@Test
	public void testGetIdBorne() {
		assertEquals(2, b.getIdBorne());
		assertEquals(0, b0.getIdBorne());
	}
}
