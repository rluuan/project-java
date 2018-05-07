/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rluan.aw.tests;
import br.rluan.aw.modelo.Cliente;
import br.rluan.aw.modelo.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Trunks
 */
public class TestsConexao {
    public static void main(String[] args) {
        ClienteDAO.conectar();
        ClienteDAO cd = new ClienteDAO();
        Cliente cl = new Cliente("Rodrigo Luan", "rodrigoluanx@gmail.com");
        cd.inserirCliente(cl);
        ClienteDAO.desconectar();
        
    }
}
