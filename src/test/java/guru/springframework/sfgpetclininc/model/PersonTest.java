package guru.springframework.sfgpetclininc.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Person;

public class PersonTest {

    @Test
    void groupAssertions() {
        Person person = new Person(1l, "Johnson", "Chow");

        assertAll("Testing Person Properties",
            () -> assertEquals("Johnson", person.getFirstName()),
            () -> assertEquals("Chow", person.getLastName(), "Field: Last Name Not Equal")
        );
    }
    
}