package br.com.mastertech.consumer;

import br.com.mastertech.dto.InformationMapper;
import br.com.mastertech.producer.Cadastro;
import br.com.mastertech.producer.Log;
import br.com.mastertech.service.ConsumerService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

@Component
public class CadastroConsumer {

    private PrintWriter printWriter;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private InformationMapper informationMapper;

    public CadastroConsumer() throws FileNotFoundException, URISyntaxException {
        this.printWriter =  new PrintWriter(new File("consumer-csv/src/main/java/br/com/mastertech/log.csv"));

    }

    @KafkaListener(topics = "spec4-paloma-cristina-3", groupId = "Log")
    public void receber(@Payload Log log) throws FileNotFoundException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        consumerService.gravar(printWriter, informationMapper.toInformation(log));
        printWriter.flush();
    }

}
