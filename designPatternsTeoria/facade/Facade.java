package facade;

import facade.subsistemaCEP.CepAPI;
import facade.subsistemaCRM.CrmService;

public class Facade {
  public void migrarCliente(String nome, String cep){
    String cidade = CepAPI.recuperarCidade(cep);
    String estado = CepAPI.recuperarEstado(cep);
    
    CrmService.gravarCliente(nome, cep, cidade, estado);
  }
}
