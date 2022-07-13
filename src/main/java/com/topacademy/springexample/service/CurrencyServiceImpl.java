package com.topacademy.springexample.service;

import com.topacademy.springexample.dao.CurrencyDao;
import com.topacademy.springexample.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    @PostConstruct
    public void init() {
        System.out.println("CurrencyServiceImpl init");
    }

    @Override
    public List<Currency> getAll() {
        return currencyDao.getAll();
    }

    @Override
    public List<Currency> getById(Long id) {
        return null;
    }
}
