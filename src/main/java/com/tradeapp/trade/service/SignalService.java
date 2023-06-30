package com.tradeapp.trade.service;

import com.tradeapp.backend.Algo;
import com.tradeapp.trade.signalstore.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@Service
public class SignalService {

    private final Algo algo;
    private final ExecutorService executorService;
    private final Map<Long, Signal> signalMap;

    public SignalService(Algo algo, ExecutorService executorService) {
        this.algo = algo;
        this.executorService = executorService;

        signalMap = new HashMap<>();
        signalMap.put(null, new SignalDefault());
        signalMap.put(1L, new SignalOne());
        signalMap.put(2L, new SignalTwo());
        signalMap.put(3L, new SignalThree());
    }

    public void executeSignal(Long signal) {
        final Signal signalTask = signalMap.getOrDefault(signal, signalMap.get(null));
        executorService.submit(() -> {
            signalTask.processSignal(algo);
            algo.doAlgo();
        });
    }
}
