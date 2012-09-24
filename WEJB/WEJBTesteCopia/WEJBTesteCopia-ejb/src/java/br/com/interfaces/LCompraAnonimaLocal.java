/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import javax.ejb.Local;
import br.com.bean.Compraanonima;
/**
 *
 * @author Administrador
 */
@Local
public interface LCompraAnonimaLocal {
    
    public void incluir(Compraanonima compraanonima);
    
}
