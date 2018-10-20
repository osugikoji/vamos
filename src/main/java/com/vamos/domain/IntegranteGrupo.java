package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamos.domain.enums.EstadoPagamento;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class IntegranteGrupo implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private IntegranteGrupoPK id = new IntegranteGrupoPK();

    private Integer estadoPagamento;

    public IntegranteGrupo(){

    }

    public IntegranteGrupo(Estudante estudante, Grupo grupo, EstadoPagamento estadoPagamento) {
        this.id.setEstudante(estudante);
        this.id.setGrupo(grupo);
        this.estadoPagamento = (estadoPagamento == null) ? null : estadoPagamento.getCod();
    }

    public Estudante getEstudante(){
        return this.id.getEstudante();
    }

    public void setEstudante(Estudante estudante){
        this.id.setEstudante(estudante);
    }

    @JsonIgnore
    public Grupo getGrupo(){
        return this.id.getGrupo();
    }

    public void setGrupo(Grupo grupo){
        this.id.setGrupo(grupo);
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(this.estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegranteGrupo that = (IntegranteGrupo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
