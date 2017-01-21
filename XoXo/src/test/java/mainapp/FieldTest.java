package mainapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

	Field field = new Field();

	@Test
	public void getAnyFieldTest() {
		field.setField1('P');
		field.setField2('W');
		field.setField6('N');
		field.setField8('Z');
		assertTrue(field.getAnyField(1) == 'P');
		assertTrue(field.getAnyField(2) == 'W');
		assertTrue(field.getAnyField(6) == 'N');
		assertTrue(field.getAnyField(8) == 'Z');
		assertTrue(field.getAnyField(8) == field.getField8());


	}
}
