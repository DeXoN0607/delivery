package ru.netology.delivery.page;

import ru.netology.delivery.data.UserInfo;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryPage {

    public DeliveryPage setCity(String city) {
        $("[data-test-id=city] input").setValue(city);
        return this;
    }

    public DeliveryPage setDate(String date) {
        $("[data-test-id=date] input").doubleClick().sendKeys(date);
        return this;
    }

    public DeliveryPage setName(String name) {
        $("[data-test-id=name] input").setValue(name);
        return this;
    }

    public DeliveryPage setPhone(String phone) {
        $("[data-test-id=phone] input").setValue(phone);
        return this;
    }

    public DeliveryPage acceptAgreement() {
        $("[data-test-id=agreement]").click();
        return this;
    }

    public DeliveryPage submit() {
        $$("button").findBy(text("Запланировать")).click();
        return this;
    }

    public DeliveryPage verifySuccess(String date) {
        $("[data-test-id=success-notification] .notification__content")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Встреча успешно запланирована на " + date));
        return this;
    }

    public DeliveryPage verifyReplan() {
        $("[data-test-id=replan-notification]")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Перепланировать"));
        return this;
    }

    public DeliveryPage confirmReplan() {
        $("[data-test-id=replan-notification] button")
                .click();
        return this;
    }
}