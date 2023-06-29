package com.tradeapp.trade.signal;

import com.tradeapp.backend.Algo;
import org.springframework.stereotype.Service;


@Service
public class SignalOne implements Signal{
    @Override
    public void processSignal(Algo algo) {
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
    }
}
