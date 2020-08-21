package br.com.mastertech.service;

import br.com.mastertech.clients.Receita;
import br.com.mastertech.producer.Cadastro;
import br.com.mastertech.producer.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private KafkaTemplate<String, Log> producer;

    public void save(Cadastro cadastro, Receita receita) {
        Log log =  new Log();

        log.setCnpj(cadastro.getCnpj());
        log.setName(cadastro.getNome());

        if (receita.getMessage() != null){
            log.setMessage("Cliente com pendencia.");
        }

        if (Double.parseDouble(receita.getCapital_social()) > 1000000) {
                log.setMessage("Capital permitido.");
        }else{
            log.setMessage("Capital não permitido");
        }

        producer.send("spec4-paloma-cristina-3", log);
        System.out.println("Cnpj: " + log.getCnpj() + " enviado.");
    }
}

