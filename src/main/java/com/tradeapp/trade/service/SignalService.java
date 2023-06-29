package com.tradeapp.trade.service;

import com.tradeapp.backend.Algo;
import com.tradeapp.trade.exception.SignalUndefined;
import com.tradeapp.trade.signal.Signal;
import com.tradeapp.trade.signal.SignalOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignalService {

    @Autowired
    private Algo algo;

    private Map<Integer, Signal> signalMap;

    public SignalService() {
        signalMap = new HashMap<>();
        signalMap.put(1, new SignalOne());
    }

    public void executeSignal(Integer signal) {

        Signal signalTask = signalMap.get(signal);

        if(signalTask != null) {
            signalTask.processSignal(algo);
        } else {
            throw new SignalUndefined("Signal " + signal + " is undefined");
        }
    }
}
