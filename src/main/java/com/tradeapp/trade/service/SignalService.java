package com.tradeapp.trade.service;

import com.tradeapp.backend.Algo;
import com.tradeapp.trade.signalstore.Signal;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

/**
 * Service class responsible for executing signals based on signal IDs.
 */
@Service
public class SignalService {

    private final SignalMapping signalMapping;
    private final Algo algo;
    private final ExecutorService executorService;

    public SignalService(SignalMapping signalMapping,
                         Algo algo,
                         ExecutorService executorService) {
        this.signalMapping = signalMapping;
        this.algo = algo;
        this.executorService = executorService;
    }


    /**
     * Executes a signal task asynchronously based on the provided signal ID.
     *
     * @param signalId The ID of the signal task to be executed.
     */
    public void executeSignal(Long signalId) {
        final Signal signalTask = signalMapping.getSignalImplementationBySignalId(signalId);
        executorService.submit(() -> {
            signalTask.processSignal(algo);
            algo.doAlgo();
        });
    }
}
