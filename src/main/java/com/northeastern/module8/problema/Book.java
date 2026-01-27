package com.northeastern.module8.problema;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Book extends Document{
    private final String publisher;

    public Book(Author author, String title, List<Document> bibliography, String publisher) {
        super(author, title, bibliography);
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return this.getAuthor().equals(book.getAuthor())
               && getTitle().equals(book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle());
    }

}
