package com.topacademy.springexample.controller;

import com.topacademy.springexample.entity.Currency;
import com.topacademy.springexample.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CurrencyController {

    @Resource
    private CurrencyService currencyService;

    @GetMapping("/currency")
    public List<Currency> getAll() {
        return currencyService.getAll();
    }

    @PostMapping("/currency/{id}")//currency/200
    public List<Currency> getById(@PathVariable Long id) {
        return currencyService.getById(id);
    }
}
