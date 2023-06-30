package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;

/**
 * Implementation for algo processing when signalID = 2.
 */
public class SignalTwo implements Signal {
    @Override
    public void processSignal(Algo algo) {
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
    }
}
