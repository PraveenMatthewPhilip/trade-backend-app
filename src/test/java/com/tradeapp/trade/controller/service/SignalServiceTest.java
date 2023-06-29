package com.tradeapp.trade.controller.service;


import com.tradeapp.backend.Algo;
import com.tradeapp.trade.exception.SignalUndefined;
import com.tradeapp.trade.service.SignalService;
import com.tradeapp.trade.signal.Signal;
import com.tradeapp.trade.signal.SignalOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

public class SignalServiceTest {

    @Mock
    private Algo algo;
    @Mock
    private SignalOne signalOne;
    @InjectMocks
    private SignalService signalService;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        Field signalFieldMap = SignalService.class.getDeclaredField("signalMap");
        signalFieldMap.setAccessible(true);
        Map<Integer, Signal> signalMap = new HashMap<>();
        signalMap.put(1, signalOne);
        signalFieldMap.set(signalService, signalMap);

    }

    @Test
    public void executeSignal_withValidSignal_callsSignal() {
        signalService.executeSignal(1);
        verify(signalOne).processSignal(algo);
    }

    @Test
    public void executeSignal_withInvalidSignal_throwsException() {
        assertThrows(SignalUndefined.class, () -> signalService.executeSignal(3));
    }
}
