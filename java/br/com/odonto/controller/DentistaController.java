/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.odonto.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.odonto.modelo.Dentista;
import br.com.odonto.dao.DaoFactory;
import br.com.odonto.modelo.DentistaEspecialidade;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;


@Resource
public class DentistaController {

    private final DaoFactory daoFactory;
    private final Result result;
    private final Validator validator;

    public DentistaController(DaoFactory daoFactory, Result result, Validator validator) {
        this.daoFactory = daoFactory;
        this.result = result;
        this.validator = validator;
    }

    
    public void adiciona(Dentista dentista, DentistaEspecialidade dentistaEspecialidade) {
        try {
            dentistaEspecialidade.setDentista(dentista);
            this.daoFactory.getDentistaDao().salva(dentista);
            
        } catch (Exception ex) {
            Logger.getLogger(DentistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        result.forwardTo(this).lista();
    }


   
    public void edita(Long cod) {
        
        List<Dentista> dentistas = daoFactory.getDentistaDao().listaTudo();
        result.include("dentistas", dentistas);
        result.include("dentista", daoFactory.getDentistaDao().carrega(cod));
    }

    
    public void altera(Dentista dentista) {
        this.daoFactory.getDentistaDao().atualiza(dentista);
        result.redirectTo(this).lista();
    }

    public void lista() {
       
        result.include("dentistas", daoFactory.getDentistaDao().listaTudo());
              
    }

   


    public void novo() {
        
    }

   
}
