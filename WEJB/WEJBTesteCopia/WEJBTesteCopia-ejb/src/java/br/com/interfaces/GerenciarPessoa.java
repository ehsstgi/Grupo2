/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.interfaces.RPessoaRemote;
import br.com.bean.Pessoa;
import javax.ejb.Stateless;
/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciarPessoa")
public class GerenciarPessoa implements RPessoaRemote{
 

    @Override
    public void incluir(Pessoa pessoa) {
     //throw new UnsupportedOperationException("Not supported yet.");
	     
     PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(pessoa);
                       
         }

    @Override
    public void alterar(Pessoa pessoa) {
         PessoaDAO pdao = new PessoaDAO(); 
			pdao.alterar(pessoa);
    }

    @Override
    public void excluir(Pessoa pessoa) {
          PessoaDAO pdao = new PessoaDAO(); 
			pdao.excluir(pessoa);
    }
    
}
