/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Funcionario;

/**
 *
 * @author Administrador
 */
public class GerenciaFuncionario implements LCadastrofuncionarioLocal {

    @Override
    public void incluir(Funcionario funcionario) {
       PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(funcionario);
    }
    
}
