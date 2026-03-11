package ru.netology.delivery;

import org.junit.jupiter.api.Test;
import ru.netology.delivery.data.DataGenerator;
import ru.netology.delivery.data.UserInfo;
import ru.netology.delivery.page.DeliveryPage;

public class CardDeliveryTest extends BaseTest {

    DeliveryPage page = new DeliveryPage();

    @Test
    void shouldReplanMeeting() {

        UserInfo user = DataGenerator.generateUser();

        String firstDate = DataGenerator.generateDate(4);
        String secondDate = DataGenerator.generateDate(7);

        page.setCity(user.getCity())
                .setDate(firstDate)
                .setName(user.getName())
                .setPhone(user.getPhone())
                .acceptAgreement()
                .submit()
                .verifySuccess(firstDate);

        page.setDate(secondDate)
                .submit()
                .verifyReplan()
                .confirmReplan()
                .verifySuccess(secondDate);
    }
}