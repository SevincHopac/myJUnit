package day08;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class _02_JavaFaker {


    @Test
    public void javaFakerTest() {

        Faker faker = new Faker();
        String fName = faker.name().firstName();
        System.out.println(fName);

        String fLastName = faker.name().lastName();
        System.out.println(fLastName);

        String fUserName = faker.name().username();
        System.out.println(fUserName);

        System.out.println(faker.name().title());

        System.out.println(faker.address().city());

        System.out.println(faker.address().state());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.phoneNumber().cellPhone());

        System.out.println(faker.internet().emailAddress());

        System.out.println(faker.number().digits(15));


 /*
              TEST DATA : kullanici adi, sifre, tel no, e-mail, sehir, kredi kart no,...
              Test datalari kimden alinir?
              1- BA-Business Analyst (Acceptance Criteria'lari yazar)
              2- Test Lead
              3- Manual Tester
              4- Tech Lead & Team Lead & DEV Lead
              5- Developer
              6- Database
              7- API call'lar
              8- Documentations. Ornegin, API swagger dokumani.
              9- Java Faker da fake data almak icin kullaniyoruz.
              NERDEN GELMEZ : end-user  alinmaz, scrum master,..
 */
    }
}
