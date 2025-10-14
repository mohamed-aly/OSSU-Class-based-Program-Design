package com.northeastern.module3;

import lombok.Getter;

@Getter
public class Book {
    private final String title;
    private final String author;
    private final int price;

    public Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

}

interface ILoBook{
    int count();

    int totalPrice();

    ILoBook cheaperThan(int price);

    ILoBook insert(Book book);

    ILoBook sort();

}

class MtLoBook implements ILoBook{

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int totalPrice() {
        return 0;
    }

    @Override
    public ILoBook cheaperThan(int price) {
        return this;
    }

    @Override
    public ILoBook insert(Book book) {
        return new ConsLoBook(book, this);
    }

    @Override
    public ILoBook sort() {
        return this;
    }
}

class ConsLoBook implements ILoBook{
    private final Book first;
    private final ILoBook rest;

    public ConsLoBook(Book first, ILoBook rest){
        this.first = first;
        this.rest = rest;
    }

    @Override
    public int count() {
        return 1 + rest.count();
    }

    @Override
    public int totalPrice() {
        return this.first.getPrice() + rest.totalPrice();
    }

    @Override
    public ILoBook cheaperThan(int price) {
        if(this.first.getPrice() < price){
            return new ConsLoBook(this.first, this.rest.cheaperThan(price));
        }

        return this.rest.cheaperThan(price);
    }

    @Override
    public ILoBook insert(Book book) {
        if (this.first.getPrice() < book.getPrice()){
            return new ConsLoBook(this.first, this.rest.insert(book));
        }
        return new ConsLoBook(book, this);
    }

    @Override
    public ILoBook sort() {
        return this.rest.sort().insert(this.first);
    }
}