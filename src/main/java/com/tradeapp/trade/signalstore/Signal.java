package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;

/**
 * Interface representing a signal for processing in a trading application.
 */
public interface Signal {
    /**
     * Processes the signal using the provided Algo instance.
     *
     * @param algo The Algo instance used for signal processing.
     */
    void processSignal(Algo algo);
}
