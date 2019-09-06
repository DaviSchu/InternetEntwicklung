package de.stl.saar.internetentw1;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {

    @Test
    public void add1() {
        MyMath mm = new MyMath();

        int result = 10;
        int check = mm.add(5,5);

        assertEquals(check, result);
    }

    @Test
    public void add2() {
        MyMath mm = new MyMath();

        int result = 100;
        int check = mm.add(73,27);

        assertEquals(check, result);
    }
}