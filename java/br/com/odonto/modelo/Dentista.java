/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.odonto.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity


public class Dentista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dentista_cod")
    private Long cod;
    private String nome;
    @OneToMany(cascade=CascadeType.ALL)
    private List<DentistaEspecialidade> especialidades;

    //Construtor
    public Dentista() {
    }
    //Getters e Setters

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public List<DentistaEspecialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<DentistaEspecialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  
}
