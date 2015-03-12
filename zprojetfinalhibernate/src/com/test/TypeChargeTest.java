package com.test;
import com.metier.TypeCharge;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeChargeTest {
	private TypeCharge t, t0;

	@Before
	public void setUp() throws Exception {
		t=new TypeCharge(1, "normale", 3);
		t0=new TypeCharge("semi-rapide",24);
		}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void testTypeCharge() {
		assertNotNull(t);
		assertNotNull(t0);
	}

	@Test
	public void testGetLibelleTypeCharge() {
		assertEquals("normale", t.getLibelleTypeCharge());
		assertEquals("semi-rapide", t0.getLibelleTypeCharge());
	}

	@Test
	public void testSetLibelleTypeCharge() {
		t.setLibelleTypeCharge("new normale");
		assertEquals("new normale", t.getLibelleTypeCharge());
	}

	@Test
	public void testGetPuissanceTypeCharge() {
	assertEquals(3, t.getPuissanceTypeCharge());
	assertEquals(24, t0.getPuissanceTypeCharge());
	}

	@Test
	public void testSetPuissanceTypeCharge() {
		t.setPuissanceTypeCharge(5);
		assertEquals(5, t.getPuissanceTypeCharge());
	}

	@Test
	public void testGetCodeTypeCharge() {
		assertEquals(1, t.getCodeTypeCharge());
		assertEquals(0, t0.getCodeTypeCharge());
	}

	@Test
	public void testToString() {
		assertEquals("TypeCharge [codeTypeCharge=1, libelleTypeCharge=normale, puissanceTypeCharge=3]", t.toString());
	}

}
