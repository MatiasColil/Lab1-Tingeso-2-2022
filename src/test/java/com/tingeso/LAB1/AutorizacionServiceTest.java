package com.tingeso.LAB1;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.repositories.AutorizacionRepository;
import com.tingeso.LAB1.services.AutorizacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;

public class AutorizacionServiceTest {


    @Mock
    private AutorizacionRepository autorizacionRepository;

    @InjectMocks
    private AutorizacionService autorizacionService;

    AutorizacionEntity autorizacionEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        autorizacionEntity = new AutorizacionEntity();
    }

    @Test
    void testFindAll(){
        when(autorizacionRepository.findAll()).thenReturn(new ArrayList<AutorizacionEntity>(Collections.singleton(autorizacionEntity)));
        assertNotNull(autorizacionService.obtenerAutorizaciones());
    }

}
