package com.tradeapp.trade.controller;

import com.tradeapp.trade.service.SignalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class responsible for handling the signal
 */

@RestController
@RequestMapping("/signal")
public class SignalController {
    private final SignalService signalService;

    public SignalController(SignalService signalService) {
        this.signalService = signalService;
    }

    /**
     * Receive singalId as Path Variable from the POST request and passes it to the Signal Service
     *
     * @param signalId The ID of the signal to be processed.
     */
    @PostMapping("/{signalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processSignal(@PathVariable Long signalId) {
        signalService.executeSignal(signalId);
    }
}
