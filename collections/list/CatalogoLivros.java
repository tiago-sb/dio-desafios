package collections.list;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
  List<Livro> listaLivros;

  public CatalogoLivros(){
    listaLivros = new ArrayList<>();
  }

  public void adicionarLivro(String titulo, String autor, int anoPublicacao){
    listaLivros.add(new Livro(titulo, autor, anoPublicacao));
  }

  public List<Livro> pesquisarPorAutor(String autor){
    List<Livro> listaLivrosAutor = new ArrayList<>();
    
    if(!listaLivros.isEmpty()){
      for(Livro livro : listaLivros){
        if(livro.getAutor() == autor) {
          listaLivrosAutor.add(livro);
        }
      }
    }

    return listaLivrosAutor;
  }

  public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
    List<Livro> listaNoIntervalo = new ArrayList<>();
    
    if(!listaLivros.isEmpty()){
      for(Livro livro : listaLivros){
        if((livro.getAnoPublicacao() >= anoInicial) && (livro.getAnoPublicacao() <= anoFinal)) {
          listaNoIntervalo.add(livro);
        }
      }
    }

    return listaNoIntervalo;
  }

  public Livro pesquisarPorTitulo(String titulo){
    for(Livro livro : listaLivros){
      if(livro.getTitulo() == titulo) return livro;
    }

    return null;
  }
}
