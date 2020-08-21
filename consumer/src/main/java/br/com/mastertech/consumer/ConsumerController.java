package br.com.mastertech.consumer;

import br.com.mastertech.clients.Receita;
import br.com.mastertech.clients.ReceitaClient;
import br.com.mastertech.producer.Cadastro;
import br.com.mastertech.producer.Log;
import br.com.mastertech.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private ReceitaClient receitaClient;

    @KafkaListener(topics = "spec4-paloma-cristina-2", groupId = "validar-cnpj")
    public void receberCadastro(@Payload Cadastro cadastro) {

        Receita receita = receitaClient.getById(cadastro.getCnpj());

        consumerService.save(cadastro, receita);
    }

}
