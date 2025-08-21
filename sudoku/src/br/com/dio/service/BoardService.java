package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Board;
import model.GameStatusEnum;
import model.Space;

public class BoardService {
  private final static int BOARD_LIMIT = 9;
  private final Board board;

  public BoardService(final Map<String, String> gameConfig){
    this.board = new Board(initBoard(gameConfig));
  }

  public List<List<Space>> getSpaces(){
    return this.board.getEspacos();
  }

  public void reset(){
    this.board.reset();
  }

  public boolean hasErros(){
    return this.board.hasErros();
  }

  public GameStatusEnum getStatus(){
    return this.board.getStatus();
  }

  public boolean gameFinish(){
    return this.board.gameIsFinish();
  }

  public List<List<Space>> initBoard(final Map<String, String> gameConfig) {
    List<List<Space>> espacos = new ArrayList<>();
    for(int i = 0; i < BOARD_LIMIT; i++){
      espacos.add(new ArrayList<>());
      for(int j = 0; j < BOARD_LIMIT; j++){
        var configuracoesPosicao = gameConfig.get("%s,%s".formatted(i, j));
        if (configuracoesPosicao == null) {
          throw new IllegalArgumentException("Configuração ausente para a posição: " + i + "," + j);
        }

        var esperado = Integer.parseInt(configuracoesPosicao.split(",")[0]);
        var fixo = Boolean.parseBoolean(configuracoesPosicao.split(",")[1]);
        
        var currentSpace = new Space(esperado, fixo);
        espacos.get(i).add(currentSpace);
      }
    }

    return espacos;
  }
}
