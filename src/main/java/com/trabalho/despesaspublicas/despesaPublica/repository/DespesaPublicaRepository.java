package com.trabalho.despesaspublicas.despesaPublica.repository;

import com.trabalho.despesaspublicas.despesaPublica.model.DespesaPublica;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DespesaPublicaRepository {

    private static final List<DespesaPublica> DESPESAS_PUBLICAS;

    static {
        DESPESAS_PUBLICAS = new ArrayList<>();
    }

    public List<DespesaPublica> getDespesasPublicas() { return DESPESAS_PUBLICAS; }

    public void addAll(List<DespesaPublica> despesaPublicas) { DESPESAS_PUBLICAS.addAll(despesaPublicas); }
}
