/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Manutencaoonibus;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaManutencaoonibus")
public class GerenciaManutencaoonibus implements LManutencaoonibusLocal {

    @Override
    public void incluir(Manutencaoonibus manutencaoonibus) {
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(manutencaoonibus);
    }
    
 
    
}
