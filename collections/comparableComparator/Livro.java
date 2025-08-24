package collections.comparableComparator;

import java.util.Comparator;

public class Livro implements Comparable<Livro> {
  private String nome;
  private String cor;
  private String autor;
  
  public Livro(String nome, String cor, String autor){
    this.nome = nome;
    this.cor = cor;
    this.autor = autor;
  }

  public int compareTo(Livro livro){
    return nome.compareTo(livro.getNome());
  }
  
  public String getNome(){
    return this.nome;
  }
  
  public void setNome(String nome){
    this.nome = nome;
  }

  public String getCor(){
    return this.cor;
  }

  public void setCor(String cor){
    this.cor = cor;
  }
  
  public String getAutor(){
    return this.autor;
  }

  public void setAutor(String autor){
    this.autor = autor;
  }

  public String toString(){
    return this.nome + " na cor " + this.cor + ", autor: " + this.autor;
  }
}

class CompararNome implements Comparator<Livro> {
  @Override
  public int compare(Livro livro01, Livro livro02){
    return livro01.getNome().compareTo(livro02.getNome());
  }
}