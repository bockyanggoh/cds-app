package com.berkeley.cds.UnitTests;

import com.berkeley.cds.controller.RootController;
import com.berkeley.cds.service.CounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import static org.mockito.Mockito.when;

public class ControllerTest {

    @InjectMocks
    private RootController controller;

    @Mock
    private CounterService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void controllerRenderSuccess() {
        Model m = new ConcurrentModel();
        when(service.incrementCounter()).thenReturn("1");
        System.out.println(controller.index(m));
    }
}
