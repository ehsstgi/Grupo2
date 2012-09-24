/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Manutencaohorario;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaManutencaohorario")
public class GerenciaManutencaohorario implements LManutencaohorarioLocal {

    @Override
    public void incluir(Manutencaohorario manutencaohorario) {
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(manutencaohorario);
    }
    
}
