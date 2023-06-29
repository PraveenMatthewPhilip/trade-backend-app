package com.tradeapp.trade.signal;

import com.tradeapp.backend.Algo;

public interface Signal {
    public void processSignal(Algo algo);
}
