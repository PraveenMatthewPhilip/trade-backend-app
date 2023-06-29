package com.tradeapp.trade.service;

import com.tradeapp.backend.Algo;
import com.tradeapp.trade.exception.SignalUndefined;
import com.tradeapp.trade.signalstore.Signal;
import com.tradeapp.trade.signalstore.SignalOne;
import com.tradeapp.trade.signalstore.SignalThree;
import com.tradeapp.trade.signalstore.SignalTwo;
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
        signalMap.put(2, new SignalTwo());
        signalMap.put(3, new SignalThree());
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
