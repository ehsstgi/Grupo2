/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Onibus;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaOnibus")
public class GerenciaOnibus implements LOnibusLocal {

    @Override
    public void incluir(Onibus onibus) {
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(onibus);
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
