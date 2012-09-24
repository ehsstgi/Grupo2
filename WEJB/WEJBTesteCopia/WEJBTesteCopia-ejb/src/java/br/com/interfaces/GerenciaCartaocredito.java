/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Cartaocredito;
import br.com.bean.Pessoa;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaCartaocredito")
public class GerenciaCartaocredito implements RCartaocreditoRemote {

    @Override
    public void incluir(Cartaocredito cartaocredito) {
          PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(cartaocredito);
    }

    @Override
    public void alterar(Cartaocredito cartaocredito) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Cartaocredito cartaocredito) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Pessoa buscarPessoa(String cpf){
        PessoaDAO pdao = new PessoaDAO(); 
        return pdao.buscarPessoa(cpf);
    }    
    
}
