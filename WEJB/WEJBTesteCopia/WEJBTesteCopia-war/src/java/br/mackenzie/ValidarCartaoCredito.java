package br.mackenzie;

import br.com.bean.Cartaocredito;
import br.com.bean.Pessoa;
import br.com.interfaces.RCartaocreditoRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ValidarCartaoCredito", urlPatterns = {"/ValidarCartaoCredito"})
public class ValidarCartaoCredito extends HttpServlet {

@EJB
RCartaocreditoRemote CartaoCredito;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Pessoa p = null;

        String cpf = ((String) request.getParameter("CPF_Cliente"));  
        
        
        System.out.println("cpf " + cpf);
        
        p = this.CartaoCredito.buscarPessoa(cpf);
        
        System.out.println("p " + p);
        
        Cartaocredito cartaocredito = new Cartaocredito();

        //long cpf = Long.parseLong((String)request.getParameter("CPF_Cliente"));
        String cb = ((String) request.getParameter("Codigo_Banco"));
        String cagen = ((String) request.getParameter("Agencia"));
        String cc = ((String) request.getParameter("ContaCorrente"));
        String numcart = ((String) request.getParameter("NumeroCartao"));

        try {
 
            
            cartaocredito.setCodbanco(new BigInteger(cb));
            cartaocredito.setAgencia(new BigInteger(cagen));
            cartaocredito.setCodCc(new BigDecimal(cc));
            cartaocredito.setNumcartao(new BigInteger(numcart));
         // cartaocredito.setCodseguranca(new BigInteger("CodigoSeguranca"));
            cartaocredito.setTipopessoa(BigInteger.ZERO);
            cartaocredito.setPessoaCpf(p);
             
            request.getSession().setAttribute("CPF_Cliente", p.getCpf());
            request.getSession().setAttribute("Codigo_Banco", cartaocredito.getCodbanco());
            request.getSession().setAttribute("Agencia", cartaocredito.getAgencia());
            request.getSession().setAttribute("ContaCorrente", cartaocredito.getCodCc());
            request.getSession().setAttribute("NumeroCartao", cartaocredito.getNumcartao());
            request.getSession().setAttribute("CodigoSeguranca", cartaocredito.getCodseguranca());
          //request.getSession().setAttribute("DataValidade", datavalidade);
            
          
 try {
                 
                response.sendRedirect(response.encodeRedirectURL("CadastroEfetuadoCartao.jsp"));
                this.CartaoCredito.incluir(cartaocredito);
           
            } catch(Exception ex) {
   
                 ex.printStackTrace();
                response.sendRedirect(response.encodeRedirectURL("CadastroErroCartao.jsp"));
            }

        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
