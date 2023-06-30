package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;

/**
 * Implementation for algo processing when signalID = 1
 */
public class SignalOne implements Signal {
    @Override
    public void processSignal(Algo algo) {
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
    }
}
