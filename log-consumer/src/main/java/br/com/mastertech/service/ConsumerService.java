package br.com.mastertech.service;

import br.com.mastertech.dto.Information;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Service
public class ConsumerService {

    public void gravar(PrintWriter writer, Information information) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, FileNotFoundException {

        try {

            ColumnPositionMappingStrategy<Information> mapStrategy = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(Information.class);

            String[] columns = new String[]{"datetime","message", "cnpj", "name"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<Information> btcsv = new StatefulBeanToCsvBuilder<Information>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(';')
                    .build();

            btcsv.write(information);

            System.out.println( information.getDatetime() + " - Mensagem recebida e gravada no log." );

        } catch (CsvException ex) {
            throw ex;
        }
    }

}
