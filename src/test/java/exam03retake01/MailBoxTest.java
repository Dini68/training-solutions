package exam03retake01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailBoxTest {

    MailBox mailBox = new MailBox();

    @BeforeEach
    void init() {
        MailTest mail1 = new MailTest(new Contact("John Doe", "johndoe@example.com"),
                List.of(new Contact("Jane Doe", "janedoe@example.com"), new Contact("Jack Doe", "jackdoe@example.com")),
                "Doe Family",
                "Hi All!");

        MailTest mail2 = new MailTest(new Contact("John Doe", "johndoe@example.com"),
                List.of(new Contact("John Smith", "johnsmith@example.com")),
                "Johnes",
                "Hi!");

        MailTest mail3 = new MailTest(new Contact("John Doe", "johndoe@example.com"),
                List.of(new Contact("Jane Smith", "janesmith@example.com")),
                "John - Jane",
                "Hello!");

        MailTest mail4 = new MailTest(new Contact("Jane Doe", "janedoe@example.com"),
                List.of(new Contact("John Doe", "johndoe@example.com"), new Contact("Jack Doe", "jackdoe@example.com")),
                "RE: Doe Family",
                "Rerere!");

        mailBox.addMail(mail1);
        mailBox.addMail(mail2);
        mailBox.addMail(mail3);
        mailBox.addMail(mail4);
    }

    @Test
    void addMail() {
        List<MailTest> mails = mailBox.getMails();
        assertEquals(4, mails.size());
        assertEquals("Rerere!", mails.get(3).getMessage());
    }

    @Test
    void findFrom() {
        List<MailTest> mails =  mailBox.findByCriteria("from:johndoe@example.com");
        assertEquals(3, mails.size());
    }

    @Test
    void findTo() {
        List<MailTest> mails =  mailBox.findByCriteria("to:Jack Doe");
        assertEquals(2, mails.size());

    }

    @Test
    void findSubject() {
        List<MailTest> mails =  mailBox.findByCriteria("Hi");
        assertEquals(2, mails.size());

    }

    @Test
    void findMessage() {
        List<MailTest> mails =  mailBox.findByCriteria("Rerere");
        assertEquals(1, mails.size());

    }
}