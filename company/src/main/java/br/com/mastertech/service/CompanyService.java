package br.com.mastertech.service;

import br.com.mastertech.producer.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private KafkaTemplate<String, Company> producer;

    public void sendToKafka(Company company) {
        producer.send("spec4-paloma-cristina-2", company);
    }
}
