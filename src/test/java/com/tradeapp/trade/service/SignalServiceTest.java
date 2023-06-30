package com.tradeapp.trade.service;


import com.tradeapp.backend.Algo;
import com.tradeapp.trade.signalstore.Signal;
import com.tradeapp.trade.signalstore.SignalDefault;
import com.tradeapp.trade.signalstore.SignalOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.verify;

public class SignalServiceTest {

    @Mock
    private Algo algo;
    @Mock
    private SignalOne signalOne;
    @Mock
    private SignalDefault signalDefault;

    private SignalService signalService;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        signalService = new SignalService(algo, Executors.newCachedThreadPool());
        Field signalFieldMap = signalService.getClass().getDeclaredField("signalMap");
        signalFieldMap.setAccessible(true);
        Map<Long, Signal> signalMap = new HashMap<>();
        signalMap.put(null, signalDefault);
        signalMap.put(1L, signalOne);
        signalFieldMap.set(signalService, signalMap);

    }

    @Test
    public void executeSignal_withValidSignal_callsSignal() throws Exception {
        signalService.executeSignal(1L);
        TimeUnit.MILLISECONDS.sleep(500);

        verify(signalOne).processSignal(algo);
        verify(algo).doAlgo();
    }

    @Test
    public void executeSignal_withUndefinedSignal_callsDefaultSignal() throws Exception {
        signalService.executeSignal(999L);
        TimeUnit.MILLISECONDS.sleep(500);

        verify(signalDefault).processSignal(algo);
        verify(algo).doAlgo();
    }
}
