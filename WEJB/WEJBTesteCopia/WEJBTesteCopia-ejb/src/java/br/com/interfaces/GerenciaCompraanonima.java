/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Compraanonima;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaCompraanonima")
public class GerenciaCompraanonima implements LCompraAnonimaLocal{

    @Override
    public void incluir(Compraanonima compraanonima) {
         PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(compraanonima);
        
    }
    
}
