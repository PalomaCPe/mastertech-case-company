package br.com.mastertech.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "receita", url = "http://receitaws.com.br/v1/")
public interface ReceitaClient {

    @GetMapping("/cnpj/{cnpj}")
    Receita getById(@PathVariable String cnpj);
}

