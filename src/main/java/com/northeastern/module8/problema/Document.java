package com.northeastern.module8.problema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class Document {
    private Author author;
    private String title;
    private List<Document> bibliography;


    protected List<String> buildBibliography(){
        return BibliographyBuilder.build(this);
    }


}
