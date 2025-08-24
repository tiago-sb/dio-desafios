package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenarPessoa {
  List<Pessoa> listaPessoas;

  public OrdenarPessoa(){
    listaPessoas = new ArrayList<>();
  }

  public void adicionarPessoa(String nome, int idade, double altura){
    listaPessoas.add(new Pessoa(nome, idade, altura));
  }

  public List<Pessoa> ordenarPorIdade(){
    List<Pessoa> pessoasPorIdade = new ArrayList<>(listaPessoas);
    Collections.sort(pessoasPorIdade);

    return pessoasPorIdade;
  }

  public void  ordenarPorAltura(){

  }
}
