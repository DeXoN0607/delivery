package ru.netology.delivery;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true) // Включаем скриншоты при падении
                .savePageSource(true) // Сохраняем HTML страницы
                .includeSelenideSteps(true)); // Включаем шаги Selenide в отчет
    }

    @BeforeEach
    void openPage() {
        open("http://localhost:9999");
    }
}