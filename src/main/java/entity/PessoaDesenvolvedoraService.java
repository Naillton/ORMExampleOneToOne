package entity;

import jakarta.persistence.*;

public class PessoaDesenvolvedoraService {
  // criando gerenciador de entiddes e passando o nome da nossa unidade de persistencia usado no arquivo persistence
  EntityManagerFactory emf =
          Persistence.createEntityManagerFactory("hibernate.ORMExample");

  public void save(PessoaDesenvolvedora p) {
    EntityManager em = emf.createEntityManager();
    // iniciando transacao
    em.getTransaction().begin();
    // persistindo informacoes no bd
    em.persist(p);
    // commitando as transacoes e finalizando
    em.getTransaction().commit();
    em.close();
  }
}
