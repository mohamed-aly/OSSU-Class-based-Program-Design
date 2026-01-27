package com.northeastern.module8.problema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BibliographyBuilder {

    private BibliographyBuilder() {
        //utility
    }

    public static List<String> build(Document root){
        List<Book> accumulator = new ArrayList<>();
        Set<Document> visited = new HashSet<>();

        collect(root, accumulator, visited);

        return accumulator.stream()
                .map(BibliographyBuilder::format)
                .sorted()
                .toList();
    }

    private static void collect(Document doc, List<Book> accumulator, Set<Document> visited){
        if (!visited.add(doc)){
            return;
        }

        if(doc instanceof Book book){
            accumulator.add(book);
        }

        for (Document bib: doc.getBibliography()){
            collect(bib, accumulator, visited);
        }
    }

    private static String format(Book book){
        return book.getAuthor().getLastName() + ", " +
               book.getAuthor().getFirstName() + ". \"" +
               book.getTitle() + "\".";
    }
}
