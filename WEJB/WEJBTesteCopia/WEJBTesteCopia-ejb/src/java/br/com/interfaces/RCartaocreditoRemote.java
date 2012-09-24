/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.bean.Cartaocredito;
import br.com.bean.Pessoa;
import javax.ejb.Remote;

@Remote
public interface RCartaocreditoRemote {
    
    public void incluir(Cartaocredito cartaocredito);
    public void alterar(Cartaocredito cartaocredito);
    public void excluir(Cartaocredito cartaocredito);
    public Pessoa buscarPessoa(String cpf);
    
}
