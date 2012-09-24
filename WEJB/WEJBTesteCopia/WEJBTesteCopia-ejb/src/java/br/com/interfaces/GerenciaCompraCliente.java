/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.DAO.PessoaDAO;
import br.com.bean.Compracliente;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless (mappedName="GerenciaCompraCliente")
public class GerenciaCompraCliente implements RCompraClienteRemote {

    @Override
    public void comprapassagem(Compracliente compracliente) {
        //throw new UnsupportedOperationException("Not supported yet.");
        PessoaDAO pdao = new PessoaDAO(); 
			pdao.Salvar(compracliente);
    }

    @Override
    public void cancelarpassagem(Compracliente compracliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
