package com.tradeapp.trade.service;

import com.tradeapp.trade.signalstore.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for mapping signalIds to respective signal implementations.
 */

@Service
public class SignalMapping {

    private final Map<Long, Signal> signalMap = new HashMap<>();

    /**
     * Creates mapping between signalId's and signalImplementation
     * When a new signal is added this init method needs to be updated
     */
    @PostConstruct
    public void init() {
        signalMap.put(1L, new SignalOne());
        signalMap.put(2L, new SignalTwo());
        signalMap.put(3L, new SignalThree());
    }

    /**
     * Fetches the signal implementation based on signalID.
     * Returns the default signal implementation if no match is found.
     *
     * @param signalId The ID of the signal.
     * @return The Signal implementation associated with the signal ID.
     */
    public Signal getSignalImplementationBySignalId(Long signalId) {
        return signalMap.getOrDefault(signalId, new SignalDefault());
    }
}
