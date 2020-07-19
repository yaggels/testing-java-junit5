package guru.springframework.sfgpetclininc.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

public class OwnerTest {

    Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner(1l, "Johnson", "Chow");
        owner.setCity("Fairfax");
        owner.setAddress("Dunn Loring");
    }

    @Test
    void dependentAssertions() {

        assertAll(
            () -> assertAll("Person Properties",
                () -> assertEquals("Johnson", owner.getFirstName()),
                () -> assertEquals("Chow", owner.getLastName())
            ),
            () -> assertAll("Owner Properties",
                () -> assertEquals("Fairfax", owner.getCity(), "City Not Equal"),
                () -> assertEquals("Dunn Loring", owner.getAddress())
            )
        );

    }

    @Test
    void dependentAssetionsJunit5Guide() {

        assertAll("Person Properties",
            () -> {
                String firstName = owner.getFirstName();
                if("".equals(firstName)) {
                    fail("First Name is blank");
                }

                assertAll(
                    () -> assertTrue(firstName.startsWith("J"), "First Name didn't start with J"),
                    () -> assertEquals("Johnson", firstName, "First name was not Johnson")
                );
            }
        );
    }

}