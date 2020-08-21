package br.com.mastertech.dtos;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;

public class CompanyRequest {

    @NotBlank
    private String nomeEmpresa;

    @CNPJ
    private String cnpj;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
