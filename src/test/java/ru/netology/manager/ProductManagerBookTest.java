package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerBookTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1,"Война и Мир",1000, "Л.Н.Толстой");
    private Book secondBook = new Book(2, "Капитанская дочка", 1000, "А.С.Пушкин");
    private Book thirdBook = new Book(3, "Рассказы", 1000,"А.П.Чехов");
    private Book fourthBook = new Book(4, "Мастер и Маргарита", 1000, "М.А.Булгаков");
    private Book fifthBook = new Book(5, "Сборник стихов", 1000, "С.А.Есенин");

    @BeforeEach
    public void prepareManager() {

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);

    }

    @Test
    void searchByName() {

        Product[] actual = manager.searchBy("Мастер и Маргарита");
        Product[] expected = new Book[]{fourthBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {

        Product[] actual = manager.searchBy("М.А.Булгаков");
        Product[] expected = new Book[]{fourthBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookNoExist() {

        Product[] actual = manager.searchBy("Тихий Дон");
        Product[] expected = new Book[]{};

        assertArrayEquals(expected, actual);
    }

}