package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessTest {

    private Chess chess;

    @BeforeEach
    void setUp() {
        chess = new Chess();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void normalize() {
        assertEquals("A1" , chess.normalize("a1"));
        assertEquals("A1" , chess.normalize("A1"));
        assertEquals("A1" , chess.normalize("1a"));
        assertEquals("A1" , chess.normalize("1A"));

        assertEquals("B1" , chess.normalize("b1"));
        assertEquals("B1" , chess.normalize("B1"));
        assertEquals("B1" , chess.normalize("1b"));
        assertEquals("B1" , chess.normalize("1B"));

        assertNull(chess.normalize("1I"));
        assertNull(chess.normalize("1J"));
        assertNull(chess.normalize("1K"));
        assertNull(chess.normalize("1L"));
        assertNull(chess.normalize("1M"));
        assertNull(chess.normalize("1N"));
        assertNull(chess.normalize("1O"));
        assertNull(chess.normalize("1P"));
        assertNull(chess.normalize("1R"));
        assertNull(chess.normalize("1S"));
        assertNull(chess.normalize("1T"));

        assertNull(chess.normalize("9I"));
        assertNull(chess.normalize("9J"));
        assertNull(chess.normalize("9K"));
        assertNull(chess.normalize("9L"));
        assertNull(chess.normalize("9M"));
        assertNull(chess.normalize("9N"));
        assertNull(chess.normalize("9O"));
        assertNull(chess.normalize("9P"));
        assertNull(chess.normalize("9R"));
        assertNull(chess.normalize("9S"));
        assertNull(chess.normalize("9T"));

        assertNull(chess.normalize("9i"));
        assertNull(chess.normalize("9j"));
        assertNull(chess.normalize("9k"));
        assertNull(chess.normalize("9l"));
        assertNull(chess.normalize("9m"));
        assertNull(chess.normalize("9n"));
        assertNull(chess.normalize("0o"));
        assertNull(chess.normalize("2p"));
        assertNull(chess.normalize("7r"));
        assertNull(chess.normalize("6s"));
        assertNull(chess.normalize("4t"));
        assertNull(chess.normalize("0a"));
        assertNull(chess.normalize("0B"));
        assertNull(chess.normalize("B0S"));

        assertNull(chess.normalize("AB0S"));
        assertNull(chess.normalize(""));
        assertNull(chess.normalize(null));

        assertNull(chess.normalize("A"));
        assertNull(chess.normalize("H"));
        assertNull(chess.normalize("1"));
        assertNull(chess.normalize("2"));
        assertNull(chess.normalize("9"));
        assertNull(chess.normalize("0"));



    }

    @Test
    void checkTower() {

        assertTrue(chess.checkTower("A1" ,"B1"));
        assertTrue(chess.checkTower("A1" ,"C1"));
        assertTrue(chess.checkTower("A1" ,"D1"));
        assertTrue(chess.checkTower("A1" ,"E1"));
        assertTrue(chess.checkTower("A1" ,"F1"));
        assertTrue(chess.checkTower("A1" ,"G1"));
        assertTrue(chess.checkTower("A1" ,"H1"));

        assertFalse(chess.checkTower("A1" ,"A1"));

        assertTrue(chess.checkTower("D6" ,"E6"));
        assertTrue(chess.checkTower("D6" ,"F6"));
        assertTrue(chess.checkTower("D6" ,"G6"));
        assertTrue(chess.checkTower("D6" ,"H6"));

        assertTrue(chess.checkTower("D6" ,"A6"));
        assertTrue(chess.checkTower("D6" ,"B6"));
        assertTrue(chess.checkTower("D6" ,"C6"));

        assertTrue(chess.checkTower("D6" ,"D1"));
        assertTrue(chess.checkTower("D6" ,"D2"));
        assertTrue(chess.checkTower("D6" ,"D3"));
        assertTrue(chess.checkTower("D6" ,"D4"));
        assertTrue(chess.checkTower("D6" ,"D5"));
        assertTrue(chess.checkTower("D6" ,"D7"));
        assertTrue(chess.checkTower("D6" ,"D8"));


        assertFalse(chess.checkTower("D6" ,"D6"));
        assertFalse(chess.checkTower("D6" ,"D9"));
        assertFalse(chess.checkTower("D6" ,"D10"));
        assertFalse(chess.checkTower("D6" ,"D0"));
        assertFalse(chess.checkTower("D6" ,"D0"));



    }

    @Test
    void checkShooter() {
        assertTrue(chess.checkShooter("A1" ,"B2"));
        assertTrue(chess.checkShooter("A1" ,"C3"));
        assertTrue(chess.checkShooter("A1" ,"D4"));
        assertTrue(chess.checkShooter("A1" ,"E5"));

        assertTrue(chess.checkShooter("D4" ,"C3"));
        assertTrue(chess.checkShooter("D4" ,"B2"));
        assertTrue(chess.checkShooter("D4" ,"A1"));
        assertTrue(chess.checkShooter("D4" ,"E5"));
        assertTrue(chess.checkShooter("D4" ,"F6"));
        assertTrue(chess.checkShooter("D4" ,"G7"));
        assertTrue(chess.checkShooter("D4" ,"H8"));


        assertTrue(chess.checkShooter("D4" ,"E3"));
        assertTrue(chess.checkShooter("D4" ,"F2"));
        assertTrue(chess.checkShooter("D4" ,"G1"));

        assertTrue(chess.checkShooter("D4" ,"C5"));
        assertTrue(chess.checkShooter("D4" ,"B6"));
        assertTrue(chess.checkShooter("D4" ,"A7"));

    }

    @Test
    void checkHorse() {

        assertTrue(chess.checkHorse("D6" ,"F5"));
        assertTrue(chess.checkHorse("D6" ,"F7"));
        assertTrue(chess.checkHorse("D6" ,"B5"));
        assertTrue(chess.checkHorse("D6" ,"B7"));
        assertTrue(chess.checkHorse("D6" ,"E4"));
        assertTrue(chess.checkHorse("D6" ,"E8"));
        assertTrue(chess.checkHorse("D6" ,"C8"));

    }

    @Test
    void listHorse() {
    }

    @Test
    void zoznamPolicokPoDvojnasobnomSkokuKonom() {
        List <String>list1 = chess.zoznamPolicokPoDvojnasobnomSkokuKonom("D6");
        List<String> list2 = Arrays.asList("H4", "H6", "H8");



        boolean zhoda = false;
        for (int i = 0; i <list1.size() ; i++) {
            zhoda = false;

            for (int j = 0; j < list2.size(); j++) {

                if (list1.get(i).equals(list2.get(j))) {
                    zhoda = true;

                }
            }
        }


        assertTrue(zhoda);
    }


}