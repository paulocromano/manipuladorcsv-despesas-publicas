package com.trabalho.despesaspublicas.despesaPublica.resource;

import com.trabalho.despesaspublicas.despesaPublica.model.DespesaPublica;
import com.trabalho.despesaspublicas.despesaPublica.service.DespesaPublicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/despesa-publica")
public class DespesaPublicaResource {

    @Autowired
    private DespesaPublicaService despesaPublicaService;


    @GetMapping(path = "/despesas-minas-gerais")
    public ResponseEntity<List<DespesaPublica>> buscarDespesasPublicasDeMinasGerais() {
        return despesaPublicaService.buscarDespesasPublicasDeMinasGerais();
    }
}
