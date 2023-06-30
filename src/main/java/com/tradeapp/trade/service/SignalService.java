package com.tradeapp.trade.service;

import com.tradeapp.backend.Algo;
import com.tradeapp.trade.signalstore.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignalService {

    private final Algo algo;

    private final Map<Long, Signal> signalMap;

    public SignalService(Algo algo) {
        this.algo = algo;

        signalMap = new HashMap<>();
        signalMap.put(null, new SignalDefault());
        signalMap.put(1L, new SignalOne());
        signalMap.put(2L, new SignalTwo());
        signalMap.put(3L, new SignalThree());
    }

    public void executeSignal(Long signal) {

        Signal signalTask = signalMap.get(signal);

        if (signalTask != null) {
            signalTask.processSignal(algo);
        } else {
            signalTask = signalMap.get(null);
            signalTask.processSignal(algo);
        }

        algo.doAlgo();
    }
}
