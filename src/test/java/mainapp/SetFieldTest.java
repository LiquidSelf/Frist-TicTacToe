package mainapp;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SetFieldTest {

    @Test
    public void setEmptyField() {
        Field field = new Field();
        SetField.setEmptyField(field);

        Random random = new Random(System.currentTimeMillis());

        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');
        assertTrue(field.getAnyField(1 + random.nextInt(9)) == ' ');


    }

    @Test
    public void setNumeredField() throws Exception {

        Field field = new Field();
        SetField.setNumeredField(field);
        Random random = new Random(System.currentTimeMillis());

        int q = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q2 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q3 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q4 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q5 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q6 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q7 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q8 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));
        int q9 = 1 + random.nextInt(9);
        assertTrue(field.getAnyField(q) == String.valueOf(q).charAt(0));

        System.out.println(q + ", " + q2 + ", " + q3 + ", " + q3 + ", ... etc.");
    }

}