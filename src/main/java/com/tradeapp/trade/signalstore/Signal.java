package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;

public interface Signal {
    void processSignal(Algo algo);
}
