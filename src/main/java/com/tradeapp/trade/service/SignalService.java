package com.tradeapp.trade.service;

import com.tradeapp.backend.Algo;
import com.tradeapp.trade.signalstore.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Service class responsible for executing signals based on signal IDs.
 */
@Service
public class SignalService {

    private final Algo algo;
    private final ExecutorService executorService;
    private final Map<Long, Signal> signalMap;

    public SignalService(Algo algo, ExecutorService executorService) {
        this.algo = algo;
        this.executorService = executorService;

        /**
         * Newly added signals are mapped here, default signal is mapped to null value
         */

        //TODO - Extract Signal Mapping as a Service
        signalMap = new HashMap<>();
        signalMap.put(null, new SignalDefault());
        signalMap.put(1L, new SignalOne());
        signalMap.put(2L, new SignalTwo());
        signalMap.put(3L, new SignalThree());
    }

    /**
     * Executes a signal task asynchronously based on the provided signal ID.
     *
     * @param signalId The ID of the signal task to be executed.
     */
    public void executeSignal(Long signalId) {
        final Signal signalTask = signalMap.getOrDefault(signalId, signalMap.get(null));
        executorService.submit(() -> {
            signalTask.processSignal(algo);
            algo.doAlgo();
        });
    }
}
