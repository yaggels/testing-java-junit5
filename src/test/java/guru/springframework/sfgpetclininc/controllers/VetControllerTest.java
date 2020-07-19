package guru.springframework.sfgpetclininc.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.controllers.VetController;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

public class VetControllerTest {

    private VetController vetController;
    private VetService vetService;
    private SpecialtyService specialtyService;
    private Model model;

    @BeforeEach
    void setup() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);

        model = new ModelMapImpl();
    }

    @Test
    void listVets() {
        // arrange
        vetService.save(new Vet(1l, "Vet", "one", Collections.emptySet()));
        vetService.save(new Vet(2l, "Vet", "Two", Collections.emptySet()));

        // act
        String view = vetController.listVets(model);
        
        // assert
        assertEquals("vets/index", view);
        assertNotEquals(Collections.emptySet(), model.getAttribute("vets"));
    }
    
}