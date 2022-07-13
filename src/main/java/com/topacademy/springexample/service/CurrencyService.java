package com.topacademy.springexample.service;

import com.topacademy.springexample.entity.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> getAll();

    List<Currency> getById(Long id);
}
