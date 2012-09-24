<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CadastroEfetuadoCliente</title>
    </head>
    <body>
        <style type="text/css">


            body {
                background:#ddd;
                margin:20px;

            }

            ul.nav li {
                margin:10;
                padding:100;
                list-style:none;
                display:table;

            }
            ul.nav li a {
                float:left;
                width:10.0em;
                font:1.40em  Verdana, Arial, Helvetica, sans-serif;
                background:#808080;
                color:#F0F8FF;
                text-align:center;
                padding:2  0.2em 0.2em  2;
                border-width:0.1em;
                border-color:#fff #909090 #909090 #fff;
                border-style:solid;
                text-decoration:none;
            }
            ul.nav a:hover{
                background:#999;
                color:#fff;
                border-color:#000 #fafafa #fafafa #000;    }
            </style>
            <style type="text/css">
            td {
                font-family:verdana,arial;
                font-size:10pt;
                color: #FF6600


            }
            .estilotabela{
                background-color:#696969;
                border-style:solid;
                border-color:666666;
                border-width:1px;

            }
            .estilocelula{
                background-color:#696969;
                color:333333;
                font-weight:bold;
                font-size:10pt;
            }

        </style>
    

<%out.println("CPF_Cliente");%>
      
        <ul class="nav">
            <table border="25" align="center">

                <tr>
                    <td>Cadastro concluído com sucesso! Usuário: <%=session.getAttribute("CPF_Cliente")%> Senha: CPF <%=session.getAttribute("CPF_Cliente")%> </td></tr> 
            </table> <BR>   <table border="3" align="center">
                <tr><td><li> 
                    <a href="index.jsp">Entrar</a></li></td></tr>
            </table>

        </ul>
  <%   request.getSession().removeAttribute("Nome_Cliente");
            request.getSession().removeAttribute("CPF_Cliente");
            request.getSession().removeAttribute("RG_Cliente");
            request.getSession().removeAttribute("Telefone_Cliente");
           // request.getSession().removeAttribute("Nascimento_Cliente");
            request.getSession().removeAttribute("Sexo_Cliente");
            request.getSession().removeAttribute("EstadoCivil_Cliente");
            request.getSession().removeAttribute("Email_Cliente");
            request.getSession().removeAttribute("Endereco_Cliente");
            request.getSession().removeAttribute("Numero_Cliente");
            request.getSession().removeAttribute("Complemento_Cliente");
            request.getSession().removeAttribute("Pais_Cliente");
            request.getSession().removeAttribute("Estado_Cliente");
            request.getSession().removeAttribute("Cidade_Cliente");
            request.getSession().removeAttribute("Bairro_Cliente");
            request.getSession().removeAttribute("CEP_Cliente");
          %>
    </body>
</html>
