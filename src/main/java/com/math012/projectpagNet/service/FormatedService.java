package com.math012.projectpagNet.service;

import com.math012.projectpagNet.model.CnabModel;
import com.math012.projectpagNet.repository.CnabRepository;
import com.math012.projectpagNet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class FormatedService {

    @Autowired
    private CnabRepository repository;

    @Autowired
    private TransactionRepository transactionRepository;

    DateTimeFormatter formattedHour = DateTimeFormatter.ofPattern("HHmmss");
    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyyMMdd");

    public String formatingDocument(String locationDocument){
        Scanner sc = null;
        String dono_da_loja, nome_da_loja, hora, data, cartao, cpf;
        double valor;
        int tipo;
        String path = locationDocument;
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null){
                tipo = Integer.parseInt(line.substring(0, 1));
                data = line.substring(1, 9);
                valor = Double.parseDouble(line.substring(10, 19));
                cpf = line.substring(19, 30);
                cartao = line.substring(30, 42);
                hora = line.substring(42, 48);
                dono_da_loja = line.substring(48, 62);
                nome_da_loja = line.substring(62, 80);

                LocalDate yearTime = LocalDate.parse(data, formattedDate);
                LocalTime hourTime = LocalTime.parse(hora, formattedHour);

                var currentTransaction = transactionRepository.findById(tipo);

                CnabModel entity = new CnabModel(yearTime, valor, cpf, cartao, hourTime, dono_da_loja, nome_da_loja, currentTransaction.get());
                line = br.readLine();
                repository.save(entity);

            }
            return "file save on the database";
        }catch (IOException e){
            return "error: " + e.getMessage();
        }finally {
            try{
                if (br != null){
                    br.close();
                }if (fr != null){
                    fr.close();
                }
            }catch (IOException e){
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}
