package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;
import org.springframework.stereotype.Service;

/**
 * Implementation for algo processing when signalID = 3
 */
@Service
public class SignalThree implements Signal {
    @Override
    public void processSignal(Algo algo) {
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }
}
