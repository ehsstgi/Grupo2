package br.mackenzie;

import br.com.bean.Compracliente;
import br.com.interfaces.RCompraClienteRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidarCompraCliente", urlPatterns = {"/ValidarCompraCliente"})
public class ValidarCompraCliente extends HttpServlet {
    
    @EJB
    RCompraClienteRemote compracli;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Compracliente compracliente = new Compracliente();
        
        String as = ((String) request.getParameter("Assento"));
        String val = ((String) request.getParameter("Valor"));
        
        try {
            
            compracliente.setOrigem("Origem");
            compracliente.setDestino("Destino");
            //compracliente.setHorachegadaint(BigInteger.ZERO);
            //compracliente.setHoraida(BigInteger.ZERO);
            compracliente.setAssento(new BigInteger(as));
            //plataforma
            compracliente.setValor(new BigInteger(val));
         
            request.getSession().setAttribute("Origem", compracliente.getOrigem());
            request.getSession().setAttribute("Destino", compracliente.getDestino());
            //request.getSession().setAttribute("Hora", hora);
            request.getSession().setAttribute("Assento", compracliente.getAssento());
            //request.getSession().setAttribute("Plataforma", plataforma);
            request.getSession().setAttribute("Valor", compracliente.getValor());

       
             try {
                 
                response.sendRedirect(response.encodeRedirectURL("CompraEfetuadaCliente.jsp"));
                this.compracli.comprapassagem(compracliente);
           
            } catch(Exception ex) {
   
                 ex.printStackTrace();
                response.sendRedirect(response.encodeRedirectURL("CompraErroCliente.jsp"));
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
