package br.com.odonto.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.odonto.modelo.Dentista;
import br.com.odonto.modelo.DentistaEspecialidade;
import org.hibernate.Session;

@Component
public class DaoFactory {

    private final Session session;

    public DaoFactory(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return this.session;
    }

    public DentistaDao getDentistaDao() {
        return new DentistaDao(this.session, Dentista.class);
    }

    public DentistaEspecialidadeDao getDentistaEspecialidadeDao() {
        return new DentistaEspecialidadeDao(this.session, DentistaEspecialidade.class);
    }

}
