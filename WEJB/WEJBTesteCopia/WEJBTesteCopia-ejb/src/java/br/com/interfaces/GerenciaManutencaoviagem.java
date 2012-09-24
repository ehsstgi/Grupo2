/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Manutencaoviagem;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaManutencaoviagem")
public class GerenciaManutencaoviagem implements LManutencaoviagemLocal{

    @Override
    public void incluir(Manutencaoviagem manutencaoviagem) {
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(manutencaoviagem);
    }
    
}
