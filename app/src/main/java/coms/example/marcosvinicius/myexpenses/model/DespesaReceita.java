package coms.example.marcosvinicius.myexpenses.model;

import android.text.Editable;

public class DespesaReceita {
    private Long id;
    private Double valor;
    private Long idCategoria;
    private String observacao;
    private String tipo;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.getIdCategoria() + " - " +  this.getValor() + " - " + this.getObservacao();
    }
}
