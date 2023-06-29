package com.tradeapp.trade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signal")
public class SignalController {

    @PostMapping("/{signal}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processSignal(@PathVariable Integer signal) {
    }
}
