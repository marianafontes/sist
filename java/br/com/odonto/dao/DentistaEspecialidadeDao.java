/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.odonto.dao;

import br.com.odonto.modelo.DentistaEspecialidade;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mariana
 */
public class DentistaEspecialidadeDao extends Dao<DentistaEspecialidade, Long> {

    public DentistaEspecialidadeDao(Session session, Class<DentistaEspecialidade> aClass) {
        super(session, DentistaEspecialidade.class);
    }

    @Override
    public List<DentistaEspecialidade> listaTudo() {
        Criteria select = this.session.createCriteria(DentistaEspecialidade.class);
        select.addOrder(Order.asc("nomeEspecialidade"));
        return select.list();
    }
    
    
   
}
