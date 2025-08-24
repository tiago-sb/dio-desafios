package collections.list;

public class Pessoa implements Comparable<Pessoa> {
  private String nome;
  private int idade;
  private double altura;

  public Pessoa(String nome, int idade, double altura){
    this.nome = nome;
    this.idade = idade;
    this.altura = altura;
  }
  
  public String getNome(){
    return nome;
  }
  
  public int getIdade(){
    return idade;
  }
  
  public double getAltura(){
    return altura;
  }

  public String toString(){
    return this.nome + " " + this.idade + " " + this.altura;
  }

  @Override
  public int compareTo(Pessoa pessoa) {
    return Integer.compare(this.idade, pessoa.getIdade());
  }
} 
