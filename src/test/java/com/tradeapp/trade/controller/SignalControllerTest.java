package com.tradeapp.trade.controller;

import com.tradeapp.trade.service.SignalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class SignalControllerTest {

	@Mock
	SignalService signalService;

	@InjectMocks
	SignalController signalController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void executeSignal_withValidInput_callsSignalService() {
		signalController.processSignal(1);
		verify(signalService).executeSignal(1);
	}

}
