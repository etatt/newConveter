package com.example.eriq.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void metertocentimeter() throws Exception {
        assertEquals(100, 1*100);
    }
    @Test
    public void metertoinch() throws Exception {
        assertEquals(39, 1*39);
    }
    @Test
    public void metertofoot() throws Exception {
        assertEquals(3, 1*3);
    }
    @Test
    public void centimetertometer() throws Exception {
        assertEquals(100, 100 / 1);
    }
    @Test
    public void centimetertoinch() throws Exception {
        assertEquals(2, 2/ 1);
    }
    @Test
    public void centimetertofoot() throws Exception {
        assertEquals(30, 30 / 1);
    }
    @Test
    public void inchtometer() throws Exception {
        assertEquals(39, 39 / 1);
    }
    @Test
    public void inchtocentimeter() throws Exception {
        assertEquals(2, 2 * 1);
    }
    @Test
    public void inchtofoot() throws Exception {
        assertEquals(12, 12 / 1);
    }
    @Test
    public void foottometer() throws Exception {
        assertEquals(3, 3 * 1);
    }
    @Test
    public void foottocentimeter() throws Exception {
        assertEquals(30, 30 * 1);
    }
    @Test
    public void foottoinch() throws Exception {
        assertEquals(12, 12 * 1);
    }
}