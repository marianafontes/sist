/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.odonto.controller;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.odonto.dao.DaoFactory;




public abstract class Controller {

    protected final DaoFactory daoFactory;
    protected final Result result;
    
    protected final Validator validator;

    public Controller(DaoFactory daoFactory, Result result, Validator validator) {
        this.daoFactory = daoFactory;
        this.result = result;
        
        this.validator = validator;
    }
}
