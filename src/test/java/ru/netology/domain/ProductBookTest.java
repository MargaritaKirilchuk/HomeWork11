package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductBookTest {
    Book book = new Book(1,"Война и Мир",1000, "Л.Н.Толстой");

    @Test
    void shouldMatchesByName () {
        assertTrue (book.matches("Война и мир"));
    }

    @Test
    void shouldMatchesByAuthor () {
        assertTrue(book.matches("Л.Н.Толстой"));
    }

    @Test
    void shouldMatchesWrongName () {
        assertFalse(book.matches("Отцы и дети"));
    }

    @Test
    void shouldMatchesWrongAuthor () {
        assertFalse(book.matches("А.П.Чехов"));
    }

}