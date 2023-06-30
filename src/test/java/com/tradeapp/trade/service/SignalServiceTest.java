package com.tradeapp.trade.service;


import com.tradeapp.backend.Algo;
import com.tradeapp.trade.signalstore.SignalDefault;
import com.tradeapp.trade.signalstore.SignalOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SignalServiceTest {

    @Mock
    SignalMapping signalMapping;
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
        signalService = new SignalService(signalMapping, algo, Executors.newCachedThreadPool());
    }

    @Test
    public void executeSignal_withValidSignal_callsSignal() throws Exception {
        when(signalMapping.getSignalImplementationBySignalId(any())).thenReturn(signalOne);

        signalService.executeSignal(1L);
        TimeUnit.MILLISECONDS.sleep(500);

        verify(signalOne).processSignal(algo);
        verify(algo).doAlgo();
    }

    @Test
    public void executeSignal_withUndefinedSignal_callsDefaultSignal() throws Exception {
        when(signalMapping.getSignalImplementationBySignalId(any())).thenReturn(signalDefault);

        signalService.executeSignal(999L);
        TimeUnit.MILLISECONDS.sleep(500);

        verify(signalDefault).processSignal(algo);
        verify(algo).doAlgo();
    }
}
