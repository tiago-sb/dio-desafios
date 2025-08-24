package collections.comparableComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {
  public static void main(String[] args) {
    ArrayList<Livro> livros = new ArrayList<Livro>();
    livros.add(new Livro("Aurio", "Azul", "Desconhecido"));
    livros.add(new Livro("Dom Casmurro", "Verde", "Machado de Assis"));
    livros.add(new Livro("O Pequeno Príncipe", "Amarelo", "Antoine de Saint-Exupéry"));
    livros.add(new Livro("1984", "Cinza", "George Orwell"));
    livros.add(new Livro("A Revolução dos Bichos", "Marrom", "George Orwell"));
    livros.add(new Livro("Harry Potter e a Pedra Filosofal", "Vermelho", "J. K. Rowling"));
    livros.add(new Livro("Senhor dos Anéis", "Preto", "J. R. R. Tolkien"));
    livros.add(new Livro("O Hobbit", "Verde", "J. R. R. Tolkien"));

    for(Livro l : livros){
      System.out.println(l.toString());
    }

    // usando o comparator
    Collections.sort(livros, new Comparator<Livro>() {
        @Override
        public int compare(Livro l1, Livro l2) {
          return l1.getNome().compareToIgnoreCase(l2.getNome());
        }
    });
    
    // usando o comparable
    Collections.sort(livros);

    System.out.println();

    for(Livro l : livros){
      System.out.println(l.toString());
    }
  }
}
