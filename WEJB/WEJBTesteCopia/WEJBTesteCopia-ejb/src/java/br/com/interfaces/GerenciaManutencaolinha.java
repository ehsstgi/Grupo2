/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Manutencaolinha;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaManutencaolinha")
public class GerenciaManutencaolinha implements LManutencaolinhaLocal{

    @Override
    public void incluir(Manutencaolinha manutencaolinha) {
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(manutencaolinha);
    }
    
}
