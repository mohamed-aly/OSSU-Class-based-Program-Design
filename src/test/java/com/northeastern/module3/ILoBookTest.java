package com.northeastern.module3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ILoBookTest {

    Book hp1 = new Book("hp1", "JKR", 20);
    Book hp2 = new Book("hp2", "JKR", 30);
    Book hp3 = new Book("hp3", "JKR", 40);

    ILoBook emptyList = new MtLoBook();

    ILoBook hpList = new ConsLoBook(hp1, new ConsLoBook(hp2, new ConsLoBook(hp3, emptyList)));

    @Test
    void testBooksCount() {
        assertEquals(3, hpList.count());
        assertEquals(0, emptyList.count());

    }

    @Test
    void testBooksPrice(){
       assertEquals(90, hpList.totalPrice());

       assertEquals(0, emptyList.totalPrice());
    }

    @Test
    void testCheaperThan(){
        ILoBook cheaperThan40List = hpList.cheaperThan(40);

        assertEquals(2, cheaperThan40List.count());
        assertEquals(50, cheaperThan40List.totalPrice());

        ILoBook cheaperThan10 = hpList.cheaperThan(10);

        assertEquals(0, cheaperThan10.count());

    }

    @Test
    void testInsert() {
        ILoBook newList = emptyList.insert(hp1);
        assertEquals(1, newList.count());
        assertEquals(20, newList.totalPrice());

        newList = newList.insert(hp2);
        assertEquals(2, newList.count());
        assertEquals(50, newList.totalPrice());
    }

    @Test
    void testSort() {
        ILoBook sortedList = hpList.sort();
        assertEquals(3, sortedList.count());
    }
}