import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
  private Map<String, Integer> agenda;

  public AgendaContatos(){
    agenda = new HashMap<>();
  }

  public void adicionarContato(String nome, int telefone){
    agenda.put(nome, telefone);
  }

  public void removerContato(String nome){
    if(!agenda.isEmpty()) agenda.remove(nome);
  }

  public void exibirContatos(){
    System.out.println(agenda);
  }

  public Integer pesquisarPorNome(String nome){
    Integer numeroPorNome = null;
    if(!agenda.isEmpty()) numeroPorNome = agenda.get(nome);

    return numeroPorNome;
  }
}