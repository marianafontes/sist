package br.com.odonto.infra;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Component
@RequestScoped
public class CriadorDeSession implements ComponentFactory<Session> {

    private final SessionFactory factory;
    private Session session;

    public CriadorDeSession(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Session getInstance() {
        return this.session;
    }

    @PostConstruct
    public void abre() {
        this.session = factory.openSession();
        System.out.println("Criando Session...........");
    }

    @PreDestroy
    public void fecha() {
        this.session.close();
        System.out.println("Fechando Session...........");
    }

}
