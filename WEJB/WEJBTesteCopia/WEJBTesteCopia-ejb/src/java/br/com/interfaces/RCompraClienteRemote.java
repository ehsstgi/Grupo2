/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.bean.Compracliente;
import javax.ejb.Remote;

/**
 *
 * @author Administrador
 */
@Remote
public interface RCompraClienteRemote {
    
    public void comprapassagem(Compracliente compracliente);
    public void cancelarpassagem(Compracliente compracliente);
   
}
