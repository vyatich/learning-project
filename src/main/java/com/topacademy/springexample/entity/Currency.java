package com.topacademy.springexample.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Currency {

    private String currency;
    private LocalDate date;
    private Double value;

    public Currency(String currency, LocalDate date, Double value) {
        this.currency = currency;
        this.date = date;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency1 = (Currency) o;
        return Objects.equals(currency, currency1.currency) &&
                Objects.equals(date, currency1.date) &&
                Objects.equals(value, currency1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, date, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Currency{");
        sb.append("currency='").append(currency).append('\'');
        sb.append(", date=").append(date);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
