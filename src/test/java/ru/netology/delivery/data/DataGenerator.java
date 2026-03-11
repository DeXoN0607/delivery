package ru.netology.delivery.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    private DataGenerator() {}

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int days) {
        return LocalDate.now()
                .plusDays(days)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        return faker.options().option(
                "Москва",
                "Санкт-Петербург",
                "Казань",
                "Новосибирск",
                "Екатеринбург"
        );
    }

    public static String generateName() {
        return faker.name().fullName();
    }

    public static String generatePhone() {
        return "+7" + faker.number().digits(10);
    }

    public static UserInfo generateUser() {
        return new UserInfo(
                generateCity(),
                generateName(),
                generatePhone()
        );
    }
}