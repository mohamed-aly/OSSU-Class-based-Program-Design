package com.northeastern.module6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AncestorsTreeTest {

    IAncestorTree enid = new Person("Enid", 1904, false, new Unknown(), new Unknown());
    IAncestorTree edward = new Person("Edward", 1902, true, new Unknown(), new Unknown());
    IAncestorTree emma = new Person("Emma", 1906, false, new Unknown(), new Unknown());
    IAncestorTree eustace = new Person("Eustace", 1907, true, new Unknown(), new Unknown());

    IAncestorTree david = new Person("David", 1925, true, new Unknown(), this.edward);
    IAncestorTree daisy = new Person("Daisy", 1927, false, new Unknown(), new Unknown());
    IAncestorTree dana = new Person("Dana", 1933, false, new Unknown(), new Unknown());
    IAncestorTree darcy = new Person("Darcy", 1930, false, this.emma, this.eustace);
    IAncestorTree darren = new Person("Darren", 1935, true, this.enid, new Unknown());
    IAncestorTree dixon = new Person("Dixon", 1936, true, new Unknown(), new Unknown());

    IAncestorTree clyde = new Person("Clyde", 1955, true, this.daisy, this.david);
    IAncestorTree candace = new Person("Candace", 1960, false, this.dana, this.darren);
    IAncestorTree cameron = new Person("Cameron", 1959, true, new Unknown(), this.dixon);
    IAncestorTree claire = new Person("Claire", 1956, false, this.darcy, new Unknown());

    IAncestorTree bill = new Person("Bill", 1980, true, this.candace, this.clyde);
    IAncestorTree bree = new Person("Bree", 1981, false, this.claire, this.cameron);

    IAncestorTree andrew = new Person("Andrew", 2001, true, this.bree, this.bill);


    @Test
    void testCount(){
        assertEquals(16, andrew.countAnc());
    }

    @Test
    void testCountFemaleAnc(){
        assertEquals(8, andrew.countFemaleAnc());
    }

    @Test
    void testYoungestAncAtGen(){
        assertEquals(andrew, andrew.youngestPersonAtGen(0));
        assertEquals(bree, andrew.youngestPersonAtGen(1));
        assertEquals(candace, andrew.youngestPersonAtGen(2));
        assertEquals(dixon, andrew.youngestPersonAtGen(3));
        assertEquals(eustace, andrew.youngestPersonAtGen(4));
    }


}