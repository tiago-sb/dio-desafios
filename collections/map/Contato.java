public class Contato {
  private String nome;
  private int contato;

  public Contato(String nome, int contato){
    this.nome = nome;
    this.contato = contato;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getContato() {
    return contato;
  }

  public void setContato(int contato) {
    this.contato = contato;
  }

  public String toString(){
    return "[" + this.nome + ", " + this.contato + "]";
  }
}
