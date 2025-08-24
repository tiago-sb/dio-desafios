package collections.list;

public class Tarefa {
  private String descricao;

  public Tarefa(String descricao){
    this.descricao = descricao;
  }

  public String getDescricao(){
    return this.descricao;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }

  public String toString(){
    return "[ " + this.descricao + " ]";
  }
}
