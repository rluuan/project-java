// Nome do pacote
package br.rluan.aw.modelo;
 
// Importações
// JavaBeans costumam implementar Serializable
// Date utilizado para lidar com data de nascimento
import java.io.Serializable;
import java.util.Date;
 
// Definição da classe
public class Cliente implements Serializable {
 
  // Um atributo para cada campo da tabela Cliente
  private String name;
  private String email;
  private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
  // Dois métodos construtores
  // Primeiro método construtor, sem argumentos, típico de JavaBeans
  public Cliente() {
  }
 
  // Segundo método construtor, com todos os argumentos
  public Cliente(String nomeCliente, String email, String pass) {
    this.name = nomeCliente;
    this.pass = pass;
    this.email = email;
  }
  public Cliente(String nomeCliente, String email) {
    this.name = nomeCliente;
    this.pass = pass;
    this.email = email;
  }
 
  // Seguem-se todos os métodos de acesso (Getters e Setters)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}