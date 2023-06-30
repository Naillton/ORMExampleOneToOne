import entity.PessoaDesenvolvedora;
import entity.PessoaDesenvolvedoraService;
import entity.Salario;

public class Application {
  public static  void main(String[] args) {
    PessoaDesenvolvedora p = new PessoaDesenvolvedora();
    p.setNome("PD1");

    Salario s = new Salario();
    s.setValor(2000.0);
    s.setCargo("Desenvolvedor");
    s.setPessoaDesenvolvedora(p);

    p.setSalario(s);

    PessoaDesenvolvedoraService sp = new PessoaDesenvolvedoraService();
    sp.save(p);
  }
}
