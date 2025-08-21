package model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Board {
  private final List<List<Space>> espacos;

  public Board(final List<List<Space>> espacos){
    this.espacos = espacos;
  }

  public List<List<Space>> getEspacos(){
    return this.espacos;
  }

  public GameStatusEnum getStatus(){
    if(espacos.stream().flatMap(Collection::stream)
      .noneMatch(s -> !s.isFixo() && Objects.nonNull(s.getAtual()))){
      
      return GameStatusEnum.NAO_INICIADO;
    }

    return espacos.stream().flatMap(Collection::stream)
      .anyMatch(s -> Objects.isNull(s.getAtual())) ? 
      GameStatusEnum.INCOMPLETO : GameStatusEnum.COMPLETO;
  }

  public boolean hasErros(){
    if(getStatus() == GameStatusEnum.NAO_INICIADO) return false;

    return espacos.stream().flatMap(Collection::stream)
      .anyMatch(s -> Objects.nonNull(s.getAtual()) && 
      s.getAtual().equals(s.getEsperado()));
  }

  public boolean changeValue(final int coluna, final int linha, final int valor){
    var espaco = espacos.get(coluna).get(linha);
    if(espaco.isFixo()) return false;

    espaco.setAtual(valor);
    return true;
  }

  public boolean clearValue(final int coluna, final int linha){
    var espaco = espacos.get(coluna).get(linha);
    if(espaco.isFixo()) return false;

    espaco.clearSpace();
    return true;
  }

  public void reset(){
    espacos.forEach(c -> c.forEach(Space::clearSpace));
  }

  public boolean gameIsFinish(){
    return !hasErros() && getStatus().equals(GameStatusEnum.COMPLETO);
  }
}
