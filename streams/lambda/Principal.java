import java.util.*;
import java.util.stream.Collectors;

public class Principal {
  public static void main(String[] args) {
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
    
    List<Integer> numeroPares = numeros.stream().filter(valor -> valor % 2 == 0).collect(Collectors.toList());
    int soma = numeros.stream().reduce(0, (a, b) -> a + b);

    System.out.println(numeroPares);
    System.out.println(soma);

  }
}