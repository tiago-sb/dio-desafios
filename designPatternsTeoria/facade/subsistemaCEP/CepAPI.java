package facade.subsistemaCEP;

public class CepAPI {
  private static CepAPI instancia = new CepAPI();

  private CepAPI(){
    super();
  }

  public static CepAPI getInstancia(){
    return instancia;
  }

  public static String recuperarCidade(String cep){
    return "Araraquara";
  }

  public static String recuperarEstado(String cep){
    return "São Paulo";
  }
}
