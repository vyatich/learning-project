package com.topacademy.springexample.dao;

import com.topacademy.springexample.entity.Currency;

import java.util.List;

public interface CurrencyDao {

    List<Currency> getAll();
}
