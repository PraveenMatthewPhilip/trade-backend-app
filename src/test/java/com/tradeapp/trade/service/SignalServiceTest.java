package com.tradeapp.trade.service;


import com.tradeapp.backend.Algo;
import com.tradeapp.trade.signalstore.Signal;
import com.tradeapp.trade.signalstore.SignalDefault;
import com.tradeapp.trade.signalstore.SignalOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;

public class SignalServiceTest {

    @Mock
    private Algo algo;
    @Mock
    private SignalOne signalOne;
    @Mock
    private SignalDefault signalDefault;
    @InjectMocks
    private SignalService signalService;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        Field signalFieldMap = SignalService.class.getDeclaredField("signalMap");
        signalFieldMap.setAccessible(true);
        Map<Long, Signal> signalMap = new HashMap<>();
        signalMap.put(null, signalDefault);
        signalMap.put(1L, signalOne);
        signalFieldMap.set(signalService, signalMap);

    }

    @Test
    public void executeSignal_withValidSignal_callsSignal() {
        signalService.executeSignal(1L);
        verify(signalOne).processSignal(algo);
        verify(algo).doAlgo();
    }

    @Test
    public void executeSignal_withUndefined_callsDefaultSignal() {
        signalService.executeSignal(999L);
        verify(signalDefault).processSignal(algo);
        verify(algo).doAlgo();
    }
}
