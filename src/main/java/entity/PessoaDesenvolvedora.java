package entity;

import jakarta.persistence.*;

/**
 * definindo entidade do banco de dados e nome da tabela
 */
@Entity
@Table(name = "tb_pessoa_desenvolvedora")
public class PessoaDesenvolvedora {
  // usando o id para referemciar o id da tabela e o generated value para gerar o id automaticamente sem repetir valores
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  // definindo o JoinColumn para dizer que a tabela salario vai ser referenciada em pessoa desenvolvedora como salario_id
  // definindo relacionamento onetoone com o fetchType lazy, para recuperarmos a entidade so quando precisarmos dela
  // e usando o cascadeType como persist para persistir os dados no banco de dados.
  // OBS: usamos a persistencia aqui pois precisamos persistir salario em pessoa desenvolvedora caso nao especificarmos
  // os dados nao sao persistidos e teremos um erro
  @JoinColumn(name = "salario_id")
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private Salario salario;

  public Long getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Salario getSalario() {
    return salario;
  }

  public void setSalario(Salario salario) {
    this.salario = salario;
  }
}
