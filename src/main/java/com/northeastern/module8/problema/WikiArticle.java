package com.northeastern.module8.problema;

import lombok.Getter;

import java.util.List;

@Getter
public class WikiArticle extends Document{

    public WikiArticle(Author author, String title, List<Document> bibliography, String url) {
        super(author, title, bibliography);
        this.url = url;
    }

    private final String url;
}
