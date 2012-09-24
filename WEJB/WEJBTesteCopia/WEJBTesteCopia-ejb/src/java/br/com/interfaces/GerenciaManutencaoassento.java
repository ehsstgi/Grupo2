/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Manutencaoassento;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaManutencaoassento")
public class GerenciaManutencaoassento implements LManutencaoassentoLocal{

    @Override
    public void incluir(Manutencaoassento manutencaoassento) {
         PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(manutencaoassento);
    }
    
}
