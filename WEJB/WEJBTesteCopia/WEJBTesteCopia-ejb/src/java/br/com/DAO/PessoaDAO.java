/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.bean.*;
import br.com.conexao.ConexaoHibert;
import com.sun.xml.ws.api.tx.at.Transactional;
import java.math.BigDecimal;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrador
 */
public class PessoaDAO {
    
    private Session session;
    
 //PESSOA
	public void Salvar(Pessoa pessoa){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(pessoa);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}
        }
        

        //@Transactional(readOnly=true)
        public Pessoa buscarPessoa(String cpf) {
            Pessoa pessoa = null;
            Transaction tx = null; //permite transacao com o BD            
            session = ConexaoHibert.getInstance();            
            System.out.println("cpf DAO " + cpf);
            
            try{
                //if(session!=null) {
                    tx = session.beginTransaction();
                    pessoa = (Pessoa) session
                    .createQuery("FROM Pessoa where cpf=:cpf ")
                    .setParameter("cpf", new BigDecimal(cpf.trim()))
                    .uniqueResult();
                    tx.commit();//faz a transacao                       
                //}
                System.out.println("retorno pessoa DAO " + pessoa);
            }catch(Exception e){
                e.printStackTrace();
                //cancela a transcao em caso de falha
                tx.rollback();                
            }finally{
                session.close();
            }
            return pessoa;
        }
        
    public void alterar(Pessoa pessoa){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.update(pessoa);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
    
      public void excluir(Pessoa pessoa){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.delete(pessoa);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
      //CARTAO DE CREDITO
      
      public void Salvar(Cartaocredito cartaocredito){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(cartaocredito);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
      //COMPRA CLIENTE
      public void Salvar(Compracliente compracliente){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(compracliente);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
      //ONIBUS
      public void Salvar(Onibus onibus){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(onibus);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
       //COMPRA ANONIMA
      public void Salvar(Compraanonima compraanonima){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(compraanonima);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
      //ENDERECO
      public void Salvar(Endereco endereco){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(endereco);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      // FUNCIONARIO
      public void Salvar(Funcionario funcionario){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(funcionario);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
       //MANUTENCAOASSENTO
      public void Salvar(Manutencaoassento manutencaoassento){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(manutencaoassento);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
      //MANUTENCAOHORARIO
      public void Salvar(Manutencaohorario manutencaohorario){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(manutencaohorario);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
       //MANUTENCAOLINHA
      public void Salvar(Manutencaolinha manutencaolinha){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(manutencaolinha);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
      //MANUTENCAOVONIBUS
      public void Salvar(Manutencaoonibus manutencaoonibus){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(manutencaoonibus);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
      //MANUTENCAOROTA
      public void Salvar(Manutecaorota manutencaorota){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(manutencaorota);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
        //MANUTENCAOVIAGEM
      public void Salvar(Manutencaoviagem manutencaoviagem){
            System.out.println("teste");
		//obtem uma sessao
		session = ConexaoHibert.getInstance();
		Transaction tx = null; //permite transacao com o BD 
 
		try{
			tx = session.beginTransaction();
			session.save(manutencaoviagem);
			tx.commit();//faz a transacao
		}catch (Exception e) {
			e.printStackTrace();
			//cancela a transcao em caso de falha
			tx.rollback();
		}finally{
			session.close();
		}}
      
}