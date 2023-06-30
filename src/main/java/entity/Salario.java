package entity;

import jakarta.persistence.*;

/**
 * definindo entidade do banco de dados e nome da tabela
 */
@Entity
@Table(name = "tb_salario")
public class Salario {
  // usando o id para referemciar o id da tabela e o generated value para gerar o id automaticamente sem repetir valores
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double valor;

  private String cargo;

  // definindo relacionamento ontetoone na entidade salario mapeando o salario e definindo o cascadeType como all
  // o fetchType como lazy para recuperarmos a entidade quando realmente precisarmos dela e o orphanremoval como true
  // para excluir a entidade filha caso nao seja referenciada pela tabela pai
  @OneToOne(mappedBy = "salario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private PessoaDesenvolvedora pessoaDesenvolvedora;

  public Double getValor() {
    return this.valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public PessoaDesenvolvedora getPessoaDesenvolvedora() {
    return this.pessoaDesenvolvedora;
  }

  public void setPessoaDesenvolvedora(PessoaDesenvolvedora pessoaDesenvolvedora) {
    this.pessoaDesenvolvedora = pessoaDesenvolvedora;
  }
}
