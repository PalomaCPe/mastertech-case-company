package br.com.mastertech.dto;

import br.com.mastertech.producer.Cadastro;
import br.com.mastertech.producer.Log;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InformationMapper {

    public Information toInformation (Log log ){
        Information information = new Information();

        information.setDatetime(new Date(System.currentTimeMillis()));
        information.setMessage(log.getMessage());
        information.setName(log.getName());
        information.setCnpj(log.getCnpj());

        return information;
    }
}
