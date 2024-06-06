package teste.model;

import java.util.Date;

public class Produto {
    private String descricao;
    private String codigoProduto;
    private double valor;
    private double valorPromocional;
    private Date dataInicioPromocao;
    private Date dataFimPromocao;
    private Date dataCadastro;
    private boolean status;


    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoProduto() {
        return this.codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorPromocional() {
        return this.valorPromocional;
    }

    public void setValorPromocional(double valorPromocional) {
        this.valorPromocional = valorPromocional;
    }

    public Date getDataInicioPromocao() {
        return this.dataInicioPromocao;
    }

    public void setDataInicioPromocao(Date dataInicioPromocao) {
        this.dataInicioPromocao = dataInicioPromocao;
    }

    public Date getDataFimPromocao() {
        return this.dataFimPromocao;
    }

    public void setDataFimPromocao(Date dataFimPromocao) {
        this.dataFimPromocao = dataFimPromocao;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
