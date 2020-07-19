package guru.springframework.sfgpetclininc.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.controllers.IndexController;

public class IndexControllerTest {
    private IndexController controller;

    @BeforeEach
    void setup() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index());
    }
}