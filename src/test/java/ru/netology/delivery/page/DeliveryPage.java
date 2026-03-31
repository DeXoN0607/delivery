package ru.netology.delivery.page;

import io.qameta.allure.Step;
import ru.netology.delivery.data.UserInfo;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryPage {

    @Step("Установить город: {city}")
    public DeliveryPage setCity(String city) {
        $("[data-test-id=city] input").setValue(city);
        return this;
    }

    @Step("Установить дату: {date}")
    public DeliveryPage setDate(String date) {
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        return this;
    }

    @Step("Установить имя: {name}")
    public DeliveryPage setName(String name) {
        $("[data-test-id=name] input").setValue(name);
        return this;
    }

    @Step("Установить телефон: {phone}")
    public DeliveryPage setPhone(String phone) {
        $("[data-test-id=phone] input").setValue(phone);
        return this;
    }

    @Step("Принять соглашение")
    public DeliveryPage acceptAgreement() {
        $("[data-test-id=agreement]").click();
        return this;
    }

    @Step("Нажать кнопку 'Запланировать'")
    public DeliveryPage submit() {
        $$("button").findBy(text("Запланировать")).click();
        return this;
    }

    @Step("Проверить успешное планирование на дату: {date}")
    public DeliveryPage verifySuccess(String date) {
        $("[data-test-id=success-notification] .notification__content")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Встреча успешно запланирована на " + date));
        return this;
    }

    @Step("Проверить появление уведомления о перепланировании")
    public DeliveryPage verifyReplan() {
        $("[data-test-id=replan-notification]")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Перепланировать"));
        return this;
    }

    @Step("Подтвердить перепланирование")
    public DeliveryPage confirmReplan() {
        $("[data-test-id=replan-notification] button")
                .click();
        return this;
    }
}