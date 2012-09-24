package br.mackenzie;                 

import br.com.bean.Endereco;
import br.com.bean.Pessoa;
import br.com.interfaces.RPessoaRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "ValidarCadastroCliente", urlPatterns = {"/ValidarCadastroCliente"})
public class ValidarCadastroCliente extends HttpServlet {

@EJB
RPessoaRemote funciona;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Pessoa pessoa = null;
   
   
 long cpf = Long.parseLong((String)request.getParameter("CPF_Cliente")); 
 String rg = ((String) request.getParameter("RG_Cliente"));
 String telefone = ((String) request.getParameter("Telefone_Cliente"));

      try {
            
            
            Pessoa pessoa = new Pessoa();
            
            pessoa.setNome(request.getParameter("Nome_Cliente"));
            pessoa.setCpf(new BigDecimal(cpf));
            pessoa.setTipopessoa(BigInteger.ZERO);
            pessoa.setRg(new BigInteger(rg));
            pessoa.setTelefone(new BigInteger(telefone));      
          //  pessoa.setNascimento(new Date(request.getParameter("Nascimento_Cliente")));           
            pessoa.setSexo( request.getParameter("Sexo_Cliente"));
            pessoa.setEstadocivil(request.getParameter("EstadoCivil_Cliente"));
            pessoa.setEmail(request.getParameter("Email_Cliente"));
            
            // PEGA DE OUTRA TABELA "ENDERECO"
/*            String endereco = request.getParameter("Endereco_Cliente");
            String numero = request.getParameter("Numero_Cliente");
            String complemento = request.getParameter("Complemento_Cliente");
            String pais = request.getParameter("Pais_Cliente");
            String estado = request.getParameter("Estado_Cliente");
            String cidade = request.getParameter("Cidade_Cliente");
            String bairro = request.getParameter("Bairro_Cliente");
            String cep = request.getParameter("CEP_Cliente");
            //*/
            
            // TODO: VERIFIICAR... SET SESSION...!
            request.getSession().setAttribute("Nome_Cliente", pessoa.getNome());
            request.getSession().setAttribute("CPF_Cliente", pessoa.getCpf());
            request.getSession().setAttribute("RG_Cliente", pessoa.getRg());
            request.getSession().setAttribute("Telefone_Cliente", pessoa.getTelefone());
           // request.getSession().setAttribute("Nascimento_Cliente", pessoa.getNascimento());
            request.getSession().setAttribute("Sexo_Cliente", pessoa.getSexo());
            request.getSession().setAttribute("EstadoCivil_Cliente", pessoa.getEstadocivil());
            request.getSession().setAttribute("Email_Cliente", pessoa.getEmail());
           /* request.getSession().setAttribute("Endereco_Cliente", endereco);
            request.getSession().setAttribute("Numero_Cliente", numero);
            request.getSession().setAttribute("Complemento_Cliente", complemento);
            //session.setAttribute("Pais_Cliente", pais);
            request.getSession().setAttribute("Estado_Cliente", estado);
            request.getSession().setAttribute("Cidade_Cliente", cidade);
            request.getSession().setAttribute("Bairro_Cliente", bairro);
            request.getSession().setAttribute("CEP_Cliente", cep);*/
            
            try {
               //String destination  ="CadastroErroCliente.jsp";   
                            
              //String destination  ="CadastroEfetuadoCliente.jsp";       
                response.sendRedirect(response.encodeRedirectURL("CadastroEfetuadoCliente.jsp"));
                this.funciona.incluir(pessoa);
                //this.funciona.incluir(pessoa);
            } catch(Exception ex) {
   
                 ex.printStackTrace();
                response.sendRedirect(response.encodeRedirectURL("CadastroErroCliente.jsp"));
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
