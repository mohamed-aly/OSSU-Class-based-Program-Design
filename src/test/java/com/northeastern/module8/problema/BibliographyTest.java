package com.northeastern.module8.problema;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BibliographyTest {

    @Test
    void singleBookNoBibliography() {
        Author author = new Author("John", "Doe");
        Book book = new Book(author, "Clean Code", List.of(), "Prentice Hall");

        List<String> result = book.buildBibliography();

        assertEquals(
                List.of("Doe, John. \"Clean Code\"."),
                result
        );
    }

    // ---------- 2. Wiki article ignored ----------

    @Test
    void wikiArticleProducesEmptyBibliography() {
        WikiArticle wiki = new WikiArticle(
                new Author("Wiki", "Editor"),
                "Software Engineering",
                List.of(),
                "https://wikipedia.org"
        );

        List<String> result = wiki.buildBibliography();

        assertTrue(result.isEmpty());
    }

    // ---------- 3. Book referenced by wiki ----------

    @Test
    void bookReferencedByWikiIsIncluded() {
        Book book = new Book(
                new Author("Robert", "Martin"),
                "Clean Architecture",
                List.of(),
                "Pearson"
        );

        WikiArticle wiki = new WikiArticle(
                new Author("Wiki", "Editor"),
                "Architecture",
                List.of(book),
                "https://wikipedia.org"
        );

        List<String> result = wiki.buildBibliography();

        assertEquals(
                List.of("Martin, Robert. \"Clean Architecture\"."),
                result
        );
    }

    // ---------- 4. Transitive bibliography ----------

    @Test
    void transitiveBibliographyIsCollected() {
        Book bookC = new Book(
                new Author("Donald", "Knuth"),
                "The Art of Computer Programming",
                List.of(),
                "Addison-Wesley"
        );

        Book bookB = new Book(
                new Author("Thomas", "Cormen"),
                "Algorithms",
                List.of(bookC),
                "MIT Press"
        );

        Book bookA = new Book(
                new Author("Alice", "Smith"),
                "Intro to CS",
                List.of(bookB),
                "OUP"
        );

        List<String> result = bookA.buildBibliography();

        assertEquals(
                List.of(
                        "Cormen, Thomas. \"Algorithms\".",
                        "Knuth, Donald. \"The Art of Computer Programming\".",
                        "Smith, Alice. \"Intro to CS\"."
                ),
                result
        );
    }

    // ---------- 5. Duplicate books ----------

    @Test
    void duplicateBooksAppearOnlyOnce() {
        Author author = new Author("Brian", "Kernighan");

        Book book1 = new Book(
                author,
                "The C Programming Language",
                List.of(),
                "PH"
                );
        Book book2 = new Book(author, "The C Programming Language", List.of(), "PH");

        Book root = new Book(
                new Author("Someone", "Else"),
                "Root Book",
                List.of(book1, book2),
                "Pub"
        );

        List<String> result = root.buildBibliography();

        assertEquals(
                List.of(
                        "Else, Someone. \"Root Book\".",
                        "Kernighan, Brian. \"The C Programming Language\"."
                ),
                result
        );
    }

    // ---------- 6. Alphabetical sorting ----------

    @Test
    void bibliographyIsSortedByAuthorLastName() {
        Book book1 = new Book(
                new Author("Alan", "Turing"),
                "Computing Machinery",
                List.of(),
                "OUP"
        );

        Book book2 = new Book(
                new Author("Edsger", "Dijkstra"),
                "Structured Programming",
                List.of(),
                "Academic Press"
        );

        Book root = new Book(
                new Author("Grace", "Hopper"),
                "Compilers",
                List.of(book1, book2),
                "IEEE"
        );

        List<String> result = root.buildBibliography();

        assertEquals(
                List.of(
                        "Dijkstra, Edsger. \"Structured Programming\".",
                        "Hopper, Grace. \"Compilers\".",
                        "Turing, Alan. \"Computing Machinery\"."
                ),
                result
        );
    }

    // ---------- 7. Cyclic references ----------

    @Test
    void cyclicBibliographyDoesNotLoop() {
        Book bookA = new Book(
                new Author("A", "Author"),
                "Book A",
                new ArrayList<>(),
                "Pub"
        );

        Book bookB = new Book(
                new Author("B", "Author"),
                "Book B",
                List.of(bookA),
                "Pub"
        );

        // create cycle
        bookA.getBibliography().add(bookB);

        List<String> result = bookA.buildBibliography();

        assertEquals(
                List.of(
                        "Author, A. \"Book A\".",
                        "Author, B. \"Book B\"."
                ),
                result
        );
    }
}
