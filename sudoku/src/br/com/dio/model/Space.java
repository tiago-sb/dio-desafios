package model;

public class Space {
  private Integer atual;
  private final int esperado;
  private final boolean fixo;

  public Space(final int esperado, final boolean fixo){
    this.esperado = esperado;
    this.fixo = fixo;

    if(fixo) atual = esperado;
  }

  public Integer getAtual() {
    return this.atual;
  }

  public void setAtual(final Integer atual){
    if(fixo) return;
    this.atual = atual;
  }

  public void clearSpace(){
    setAtual(null);
  }
  
  public int getEsperado() {
    return this.esperado;
  }

  public boolean isFixo() {
    return this.fixo;
  }

  
}
