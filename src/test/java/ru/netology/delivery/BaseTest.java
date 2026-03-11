package ru.netology.delivery;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeEach
    void openPage() {
        open("http://localhost:9999");
    }
}