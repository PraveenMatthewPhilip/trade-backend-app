package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;

/**
 * Implementation for algo processing when signalID is not provided
 */

public class SignalDefault implements Signal {
    @Override
    public void processSignal(Algo algo) {
        algo.cancelTrades();
    }
}