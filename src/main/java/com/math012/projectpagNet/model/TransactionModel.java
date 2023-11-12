package com.math012.projectpagNet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "transacoes")
public class TransactionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TransacaoId;

    @Column(name = "Descricao")
    private String description;

    @Column(name = "Natureza")
    private String typeOfIO;

    @Column(name = "Sinal")
    private char Symbol;

    @JsonIgnore
    @OneToMany(mappedBy = "transaction")
    private List<CnabModel> cnabs = new ArrayList<>();

    public TransactionModel(){}

    public TransactionModel(int transacaoId, String description, String typeOfIO, char symbol, List<CnabModel> cnabs) {
        TransacaoId = transacaoId;
        this.description = description;
        this.typeOfIO = typeOfIO;
        Symbol = symbol;
        this.cnabs = cnabs;
    }

    public int getTransacaoId() {
        return TransacaoId;
    }

    public void setTransacaoId(int transacaoId) {
        TransacaoId = transacaoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfIO() {
        return typeOfIO;
    }

    public void setTypeOfIO(String typeOfIO) {
        this.typeOfIO = typeOfIO;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public List<CnabModel> getCnabs() {
        return cnabs;
    }

    public void setCnabs(List<CnabModel> cnabs) {
        this.cnabs = cnabs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionModel that = (TransactionModel) o;
        return TransacaoId == that.TransacaoId && Symbol == that.Symbol && Objects.equals(description, that.description) && Objects.equals(typeOfIO, that.typeOfIO) && Objects.equals(cnabs, that.cnabs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TransacaoId, description, typeOfIO, Symbol, cnabs);
    }
}
