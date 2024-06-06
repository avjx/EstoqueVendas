package teste.model;

import java.util.Date;

public class Produto {
    private String descricao;
    private String codigoProduto;
    private double valor;
    private double valorPromocional;
    private Date dataInicialPromocao;
    private Date dataFinalPromocao;
    private Date dataCadastro;
    private boolean status;

    // Getters and Setters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorPromocional() {
        return valorPromocional;
    }

    public void setValorPromocional(double valorPromocional) {
        this.valorPromocional = valorPromocional;
    }

    public Date getDataInicialPromocao() {
        return dataInicialPromocao;
    }

    public void setDataInicialPromocao(Date dataInicialPromocao) {
        this.dataInicialPromocao = dataInicialPromocao;
    }

    public Date getDataFinalPromocao() {
        return dataFinalPromocao;
    }

    public void setDataFinalPromocao(Date dataFinalPromocao) {
        this.dataFinalPromocao = dataFinalPromocao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
