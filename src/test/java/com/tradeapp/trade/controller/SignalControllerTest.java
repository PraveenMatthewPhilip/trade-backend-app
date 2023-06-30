package com.tradeapp.trade.controller;

import com.tradeapp.trade.service.SignalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class SignalControllerTest {

    @Mock
    private SignalService signalService;

    private SignalController signalController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        signalController = new SignalController(signalService);
    }

    @Test
    void executeSignal_withValidInput_callsSignalService() {
        signalController.processSignal(1L);
        verify(signalService).executeSignal(1L);
    }

}
