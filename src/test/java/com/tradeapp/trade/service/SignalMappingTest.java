package com.tradeapp.trade.service;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignalMappingTest {

    @Mock
    private SignalOne signalOne;
    private SignalMapping signalMapping;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        signalMapping = new SignalMapping();
        Field signalFieldMap = signalMapping.getClass().getDeclaredField("signalMap");
        signalFieldMap.setAccessible(true);
        Map<Long, Signal> signalMap = new HashMap<>();
        signalMap.put(1L, signalOne);
        signalFieldMap.set(signalMapping, signalMap);
    }

    @Test
    void getSignalImplementationBySignalId_withValidSignalId_returnsValidImplementation() {

        Signal signalResult = signalMapping.getSignalImplementationBySignalId(1L);

        assertThat(signalResult).isNotNull();
        assertThat(signalResult).isEqualTo(signalOne);
    }

    @Test
    void getSignalImplementationBySignalId_withValidSignalId_returnsDefaultImplementation() {

        Signal signalResult = signalMapping.getSignalImplementationBySignalId(999L);

        assertThat(signalResult).isNotNull();
        assertThat(signalResult).isInstanceOf(SignalDefault.class);
    }
}
