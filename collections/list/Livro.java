package collections.list;

public class Livro {
  private String titulo;
  private String autor;
  private int anoPublicacao;

  public Livro(String titulo, String autor, int anoPublicacao){
    this.titulo = titulo;
    this.autor = autor;
    this.anoPublicacao = anoPublicacao;
  }

  public String getTitulo(){
    return this.titulo;
  }
  
  public String getAutor(){
    return this.autor;
  }
  
  public int getAnoPublicacao(){
    return this.anoPublicacao;
  }
}
