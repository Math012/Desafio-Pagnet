package com.math012.projectpagNet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CNAB")
public class CnabModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cnabid")
    private int id;

    @Column(name = "Data")
    private LocalDate date;

    @Column(name = "Valor")
    private Double value;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "Cartao")
    private String creditCard;

    @Column(name = "Hora")
    private LocalTime hour;

    @Column(name = "Dono_da_Loja")
    private String storeOwner;

    @Column(name = "Nome_da_Loja")
    private String storeName;

    @ManyToOne
    @JoinColumn(name = "Tipo")
    private TransactionModel transaction;

    public CnabModel(){}

    public CnabModel(LocalDate date, Double value, String cpf, String creditCard, LocalTime hour, String storeOwner, String storeName, TransactionModel transaction) {
        this.date = date;
        this.value = value;
        this.cpf = cpf;
        this.creditCard = creditCard;
        this.hour = hour;
        this.storeOwner = storeOwner;
        this.storeName = storeName;
        this.transaction = transaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public TransactionModel getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionModel transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CnabModel cnabModel = (CnabModel) o;
        return id == cnabModel.id && Objects.equals(date, cnabModel.date) && Objects.equals(value, cnabModel.value) && Objects.equals(cpf, cnabModel.cpf) && Objects.equals(creditCard, cnabModel.creditCard) && Objects.equals(hour, cnabModel.hour) && Objects.equals(storeOwner, cnabModel.storeOwner) && Objects.equals(storeName, cnabModel.storeName) && Objects.equals(transaction, cnabModel.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, value, cpf, creditCard, hour, storeOwner, storeName, transaction);
    }
}
