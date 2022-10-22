package com.trabalho.despesaspublicas.despesaPublica.model;

import lombok.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DespesaPublica {

    private String idFuncao;
    private Integer anoExercicio;
    private Integer codigoFuncao;
    private String nome;


    public static DespesaPublica from(CSVRecord csvRecord) {
        Objects.requireNonNull(csvRecord);

        final String idFuncao = UUID.randomUUID().toString();
        final Integer anoExercicio = Integer.valueOf(csvRecord.get("ano_exercicio"));
        final Integer codigoFuncao = Integer.valueOf(csvRecord.get("cd_funcao"));
        final String nome = csvRecord.get("nome");

        return new DespesaPublica(idFuncao, anoExercicio, codigoFuncao, nome);
    }
}
