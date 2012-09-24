/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Manutecaorota;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaManutencaorota")
public class GerenciaManutencaorota implements LManutencaorotaLocal{

    @Override
    public void incluir(Manutecaorota manutencaorota) {
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(manutencaorota);
    }
    
}
