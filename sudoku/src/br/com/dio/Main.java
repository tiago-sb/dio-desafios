import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Space;
import util.BoardTemplate;
import model.Board;

public class Main {

  private final static Scanner scan = new Scanner(System.in);
  private static Board board;
  private final static int BOARD_LIMIT = 9;

  public static int runUntilGetValidNumber(final int min, final int max){
    var current = scan.nextInt();
    while (current < min || current > max) {
      System.out.printf("Informe um número entre %s e %s: ", min, max);
      current = scan.nextInt();
    }

    return current;
  }

  private static void finishGame() {
    if(Objects.isNull(board)){
      System.out.println("Jogo não foi iniciado!");
      return;
    }

    if(!board.gameIsFinish()){
      System.out.println("Parabéns você concluiu o jogo!");
      showCurrentGame();
      board = null;
    } else if(board.hasErros()){
      System.out.println("Seu jogo contém erros!!");
    } else {
      System.out.println("Você ainda precisa preencher algum espaço!");
    }
  }

  private static void clearGame() {
    if(Objects.isNull(board)){
      System.out.println("Jogo não foi iniciado!");
      return;
    }

    System.out.print("Deseja mesmo limpar o jogo? ");
    var confirmacao = scan.nextLine();

    while (!confirmacao.equals("sim") || !confirmacao.equals("nao")) {
      System.out.println("Informe 'sim' ou 'nao'");
      confirmacao = scan.nextLine();
    }

    if(confirmacao.equals("sim")) board.reset();
  }

  private static void showGameStatus() {
    if(Objects.isNull(board)){
      System.out.println("Jogo não foi iniciado!");
      return;
    }

    System.out.printf("O jogo atualmente se encontra no status %s\n", board.getStatus().getLabel());
    if(board.hasErros()){ System.out.println("O jogo contém erros!"); } 
    else { System.out.println("O jogo não contém erros!"); }
  }

  private static void removeNumber() {
    if(Objects.isNull(board)){
      System.out.println("Jogo não foi iniciado!");
      return;
    }

    System.out.print("Informe a coluna em que o número será inserido: ");
    var coluna = runUntilGetValidNumber(0, 8);
    System.out.print("Informe a linha em que o número será inserido: ");
    var linha = runUntilGetValidNumber(0, 8);

    if(!board.clearValue(coluna, linha)){
      System.out.printf("A posição [%s, %s] tem um valor fixo!\n", coluna, linha);
    }
  }

  private static void showCurrentGame() {
    if(Objects.isNull(board)){
      System.out.println("Jogo não foi iniciado!");
      return;
    }

    var args = new Object[81];
    var argPos = 0;
    for(int i = 0; i < BOARD_LIMIT; i++){
      for(var col: board.getEspacos()){
        args[argPos++] = " " + (Objects.isNull(col.get(i).getAtual()) 
        ? " " : col.get(i).getAtual());
      }
    }

    System.out.println("Seu jogo se encontra da seguinte forma");
    System.out.printf(BoardTemplate.BOARD_TEMPLATE + "%n", args);
  }

  private static void inputNumber() {
    if(Objects.isNull(board)){
      System.out.println("Jogo não foi iniciado!");
      return;
    }

    System.out.print("Informe a coluna em que o número será inserido: ");
    var coluna = runUntilGetValidNumber(0, 8);
    System.out.print("Informe a linha em que o número será inserido: ");
    var linha = runUntilGetValidNumber(0, 8);
    
    System.out.printf("Informe o número que vai entrar na posição [%s, %s]\n", coluna, linha);
    var valor = runUntilGetValidNumber(1, 9);

    if(!board.changeValue(coluna, linha, valor)){
      System.out.printf("A posição [%s, %s] tem um valor fixo!\n", coluna, linha);
    }
  }

  private static void startGame(final Map<String, String> posicoes) {
    if(Objects.nonNull(board)){
      System.out.println("Jogo já iniciado!");
      return;
    }

    List<List<Space>> espacos = new ArrayList<>();
    for(int i = 0; i < BOARD_LIMIT; i++){
      espacos.add(new ArrayList<>());
      for(int j = 0; j < BOARD_LIMIT; j++){
        var configuracoesPosicao = posicoes.get("%s,%s".formatted(i, j));
        var esperado = Integer.parseInt(configuracoesPosicao.split(",")[0]);
        var fixo = Boolean.parseBoolean(configuracoesPosicao.split(",")[1]);
        
        var currentSpace = new Space(esperado, fixo);
        espacos.get(i).add(currentSpace);
      }
    }

    board = new Board(espacos);
    System.out.println("O jogo está pronto para começar!");
  }
  
  public static void main(String[] args) {
    final var posicoes = Stream.of(args)
        .collect(Collectors.toMap(
            k -> k.split(";")[0],
            v -> v.split(";")[1]));

    var opcoes = -1;
    while (true) {
      System.out.println("Selecione uma das opções a seguir");
      System.out.println("1 - Iniciar um novo Jogo");
      System.out.println("2 - Colocar um novo número");
      System.out.println("3 - Remover um número");
      System.out.println("4 - Visualizar jogo atual");
      System.out.println("5 - Verificar status do jogo");
      System.out.println("6 - limpar jogo");
      System.out.println("7 - Finalizar jogo");
      System.out.println("8 - Sair");

      opcoes = scan.nextInt();

      switch (opcoes) {
        case 1 -> startGame(posicoes);
        case 2 -> inputNumber();
        case 3 -> removeNumber();
        case 4 -> showCurrentGame();
        case 5 -> showGameStatus();
        case 6 -> clearGame();
        case 7 -> finishGame();
        case 8 -> System.exit(0);
        default -> System.out.println("Opção inválida, selecione uma das opções do menu!");
      }
    }
  }

  
  
}