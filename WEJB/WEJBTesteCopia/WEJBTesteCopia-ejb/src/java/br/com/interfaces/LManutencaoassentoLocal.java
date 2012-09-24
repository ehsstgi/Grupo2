/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.bean.Manutencaoassento;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface LManutencaoassentoLocal {
    public void incluir(Manutencaoassento manutencaoassento);
    
    
}
