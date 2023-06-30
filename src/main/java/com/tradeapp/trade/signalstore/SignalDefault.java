package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;
import org.springframework.stereotype.Service;


@Service
public class SignalDefault implements Signal {
    @Override
    public void processSignal(Algo algo) {
        algo.cancelTrades();
    }
}