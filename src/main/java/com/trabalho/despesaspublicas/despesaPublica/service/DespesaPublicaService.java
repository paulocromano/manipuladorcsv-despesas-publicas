package com.trabalho.despesaspublicas.despesaPublica.service;

import com.trabalho.despesaspublicas.DespesasPublicasApplication;
import com.trabalho.despesaspublicas.despesaPublica.model.DespesaPublica;
import com.trabalho.despesaspublicas.despesaPublica.repository.DespesaPublicaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DespesaPublicaService {

    @Autowired
    private DespesaPublicaRepository despesaPublicaRepository;


    public ResponseEntity<List<DespesaPublica>> buscarDespesasPublicasDeMinasGerais() {
        if (despesaPublicaRepository.getDespesasPublicas().isEmpty()) {
            final InputStream inputStream = DespesasPublicasApplication.class.getResourceAsStream("/dados/despesas_publicas_minas_gerais.csv");

            if (Objects.nonNull(inputStream)) {
                final BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));

                final CSVFormat csvFormat = CSVFormat.Builder.create()
                        .setDelimiter(";")
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .setIgnoreEmptyLines(true)
                        .setTrim(true)
                        .build();

                try {
                    final CSVParser csvParser = new CSVParser(fileReader, csvFormat);
                    final List<DespesaPublica> despesasPublicas = csvParser.getRecords()
                            .stream()
                            .map(csv -> DespesaPublica.from(csv))
                            .collect(Collectors.toList());

                    despesaPublicaRepository.addAll(despesasPublicas);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return ResponseEntity.ok(despesaPublicaRepository.getDespesasPublicas());
    }
}
