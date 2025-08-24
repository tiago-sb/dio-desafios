package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

  private List<Tarefa> tarefas;

  public ListaTarefas(){
    this.tarefas = new ArrayList<Tarefa>();
  }

  public void adicionarTarefa(String descricao) {
    tarefas.add(new Tarefa(descricao));
  }
  
  public void removerTarefa(String descricao) {
    List<Tarefa> tarefasParaRemover = new ArrayList<>();

    for(Tarefa tarefa : tarefas){
      if(tarefa.getDescricao() == descricao){
        tarefasParaRemover.add(tarefa);
      }
    }

    tarefas.removeAll(tarefasParaRemover);
  }
  
  public int obterNumeroTotalTarefas() {
    return tarefas.size();
  }

  public void obterDescricoesTarefas() {
    for(Tarefa tarefa : tarefas){
      System.out.println(tarefa.getDescricao());
    }
  }
}
