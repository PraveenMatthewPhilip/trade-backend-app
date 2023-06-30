package com.tradeapp.trade.controller;

import com.tradeapp.trade.service.SignalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signal")
public class SignalController {
    private final SignalService signalService;

    public SignalController(SignalService signalService) {
        this.signalService = signalService;
    }

    @PostMapping("/{signal}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processSignal(@PathVariable Long signal) {
        signalService.executeSignal(signal);
    }
}
