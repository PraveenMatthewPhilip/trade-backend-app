package com.tradeapp.trade.controller;

import com.tradeapp.backend.Algo;
import com.tradeapp.trade.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signal")
public class SignalController {

    @Autowired
    private SignalService signalService;

    @PostMapping("/{signal}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processSignal(@PathVariable Integer signal) {
        signalService.executeSignal(signal);
    }
}
