package br.com.odonto.dao;
/* 
 * Esta classe e normalmente extendida pelos Daos especificos
 * 
 * NAO DEVE SER ALTERADA, somente extendida
 */

import br.com.caelum.vraptor.ioc.Component;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@Component
public class Dao<T, KeyType extends Serializable> {

    protected Session session;
    private final Class classe;

    public Dao(Session session, Class classe) {
        this.session = session;
        this.classe = classe;
    }

    public Session getSession() {
        return session;
    }

    public void salva(T u) throws Exception {
        Transaction tx = session.beginTransaction();
        try {
            session.save(u);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new Exception("Ocorreu um erro a tentar inserir: " + e.getMessage());
        }
    }

    public void salvaVersao(T u) throws Exception {
        Transaction tx = session.beginTransaction();
        //  try {
        session.save(u);
        tx.commit();
//        } catch (HibernateException e) {
//            tx.rollback();
//            throw new Exception("Ocorreu um erro a tentar inserir: " + e.getMessage());
//        }
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<T> listaTudo() {
        List<T> t = this.session.createCriteria(this.classe).list();
        return t;

    }

    @SuppressWarnings("unchecked")
    public List<T> listaPorColuna(Object o, String campo) {
        List<T> t = this.session.createCriteria(this.classe)
                .add(Restrictions.eq(campo, o)).list();
        return t;
    }

    @SuppressWarnings("unchecked")
    public <T> T buscaPorColuna(Object o, String campo) {
        T t = (T) this.session.createCriteria(this.classe)
                .add(Restrictions.eq(campo, o)).uniqueResult();
        return t;
    }

    public <T> T carrega(KeyType id) {
        T t = (T) this.session.load(this.classe, id);
        return t;
    }

    public void atualiza(T u) {
        Transaction tx = session.beginTransaction();
//         try {
        session.update(u);
        tx.commit();
//        } catch (HibernateException e) {
//            tx.rollback();            
//            throw new Exception();
//        }        
        session.close();
    }

    public void remove(T u) {
        Transaction tx = session.beginTransaction();
        this.session.delete(u);
        tx.commit();
    }

    public void recarrega(T u) {
        session.refresh(u);
    }

    public <T> T get(KeyType id) {
        T t = (T) this.session.get(this.classe, id);
        return t;
    }

}
