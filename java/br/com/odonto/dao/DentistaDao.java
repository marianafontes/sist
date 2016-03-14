/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.odonto.dao;

import br.com.odonto.modelo.Dentista;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mariana
 */
public class DentistaDao extends Dao<Dentista, Long> {

    public DentistaDao(Session session, Class<Dentista> aClass) {
        super(session, Dentista.class);
    }

    @Override
    public List<Dentista> listaTudo() {
        Criteria select = this.session.createCriteria(Dentista.class);
        select.addOrder(Order.asc("nome"));
        return select.list();
    }

}
