/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Endereco;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaEndereco")
public class GerenciaEndereco implements REnderecoRemote {

    @Override
    public void incluir(Endereco endereco) {
        //throw new UnsupportedOperationException("Not supported yet.");
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(endereco);
    }
    
}
