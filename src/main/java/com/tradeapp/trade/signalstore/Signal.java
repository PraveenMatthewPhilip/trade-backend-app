package com.tradeapp.trade.signalstore;

import com.tradeapp.backend.Algo;

public interface Signal {
    public void processSignal(Algo algo);
}
