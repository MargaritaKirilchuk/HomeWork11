package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerSmartphoneTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Smartphone firstPhone = new Smartphone(1,"Galaxy",1000, "Samsung");
    private Smartphone secondPhone = new Smartphone(2,"iPhone11",1000, "Apple");
    private Smartphone thirdPhone = new Smartphone(3,"RedmiNote",1000, "Xiaomi");
    private Smartphone fourthPhone = new Smartphone(4,"iPhoneX",1000, "Apple");
    private Smartphone fifthPhone = new Smartphone(5,"GalaxyNote",1000, "Samsung");

    @BeforeEach
    public void prepareManager(){
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(fourthPhone);
        manager.add(fifthPhone);

    }


    @Test
    void searchByName() {

        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Smartphone[]{firstPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Smartphone[]{secondPhone, fourthPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneNoExist() {

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Smartphone[]{};

        assertArrayEquals(expected, actual);
    }


}