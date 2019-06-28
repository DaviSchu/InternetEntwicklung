package de.stl.saar.internetentw1;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {

    @Test
    public void add() {
        MyMath mm = new MyMath();

        int result = 10;
        int check = mm.add(5,5);

        assertEquals(check, result);
    }
}