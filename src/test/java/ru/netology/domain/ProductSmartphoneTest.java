package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductSmartphoneTest {
    Smartphone smartphone = new Smartphone(4,"iPhoneX",1000, "Apple");

    @Test
    void shouldMatchesByName() {
        assertTrue (smartphone.matches("iPhoneX"));
    }

    @Test
    void shouldMatchesByManufacturer() {
        assertTrue(smartphone.matches("Apple"));
    }

    @Test
    void shouldMatchesWrongName() {
        assertFalse(smartphone.matches("Galaxy"));
    }

    @Test
    void shouldMatchesWrongManufacturer() {
        assertFalse(smartphone.matches("Samsung"));
    }


}