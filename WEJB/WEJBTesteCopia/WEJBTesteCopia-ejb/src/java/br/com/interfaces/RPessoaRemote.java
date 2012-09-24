/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;
import br.com.bean.Pessoa;
import javax.ejb.*;

@Remote
public interface RPessoaRemote {
   
    public void incluir(Pessoa pessoa);
    public void alterar(Pessoa pessoa);
    public void excluir(Pessoa pessoa);
    
}
