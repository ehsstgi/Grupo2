<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ComprarPassagem</title>
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
    .dia {font-family: helvetica, arial; font-size: 8pt; color: #FFFFFF}
    .data {font-family: helvetica, arial; font-size: 8pt; text-decoration:none; color:#191970}
    .mes {font-family: helvetica, arial; font-size: 8pt}
    .Cabecalho_Calendario {font-family: helvetica, arial; font-size: 10pt; color: #000000; text-decoration:none; font-weight:bold}
        </style>

    </head>
    <body>

        

   
        <table  width=1500 height=10 cellpadding=1 cellspacing=1 class="estilotabela"align="center">
            <tr><td><H1 align="center">Comprar Passagem</H1> </td></tr>
        </table>
        <ul class="nav">
            <table align="center">
                <tr><td>   <li>  <a href="Principal.jsp">Home</a>
                    <a href="AtualizarCadastroCliente.jsp">Atualizar Cadastro</a>
                    <a href="CartaoCredito.jsp">Cartão de Crédito</a>
                    <a href="ComprarPassagem.jsp">Comprar Passagem</a>
                    <a href="ConsultarHistorico.jsp">Consultar Histórico</a>
                    <a href="index.jsp">Sair</a>
                </li></td></tr>
            </table>

            <BR>
                <%

        String origem = (String) session.getAttribute("Origem");
        String destino = (String) session.getAttribute("Destino");
        String hora = (String) session.getAttribute("Hora");
        String assento = (String) session.getAttribute("Assento");
        String plataforma = (String) session.getAttribute("Plataforma");
                String valor = (String) session.getAttribute("Valor");


        if (origem == null) {
            origem = "";
        }
        if (destino == null) {
            destino = "";
        }
        if (assento == null) {
            assento = "";
        }
        if (plataforma == null) {
            plataforma = "";
        }        if (valor == null) {
            valor = "";
        }
       
    %>
            
            <ul class="nav">
                <table border="25" align="center">
                    <form action="ValidarCompraCliente" method="post" align="center">


                        <tr><td> Origem       :           <select name="Origem">
                                    <option value=" "> </option><option value="SP">São Paulo</option>
                                </select></td></tr>

                        <tr><td> Destino       :           <select name="Destino">
                                    <option value=" "> </option><option value="RP">Ribeirão Preto</option>
                                </select></td></tr>
                        

                        
                      
                                                <tr><td> Hora       :           <select name="Hora">
                                    <option value=" "> </option>
                                    <option value="A">08:00</option>
                                    <option value="B">10:00</option>
                                    <option value="C">12:00</option>
                                    <option value="D">14:00</option>
                                </select></td></tr>
                                                
                  
                                                
                                                                        <tr><td> Assento       :           <select name="Assento">
                                    <option value=" "> </option>
                                    <option value="1">1</option>
                                     <option value="2">2</option>
                                      <option value="3">3</option>
                                       <option value="4">4</option>
                                        <option value="5">5</option>
                                         <option value="6">6</option>
                                          <option value="7">7</option>
                                           <option value="8">8</option>
                                            <option value="9">9</option>
                                             <option value="10">10</option>
                                                                                 
                                </select></td></tr>
                        <tr><td> Plataforma       :           <select name="Plataforma">
                                    </option><option value="Plataforma">5</option>
                                </select></td></tr>
                        
                                                <tr><td> Valor       :           <select name="Valor">
                                  <option value="100">100.00</option>
                                </select></td></tr>

                        <tr><td> <input type="submit" name="Comprar" value="Comprar" />

                    </FORM>
                    <form action="ComprarPassagem.jsp" method="post"align="center" >
                        <%
                            session.invalidate();
                        %>

                        <input type="submit" value="Limpar"  /></td></tr>
                    </FORM>
                </table>
            </ul>
                        <BR>
            <ul class="nav">
                <table border="3" align="center">

                    <tr>
                    <tr><td><li> 
                        <a href="Principal.jsp">Voltar</a></li></td></tr>
                </table>
                </table>
            </ul>

    </body>
</html>

