<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ConsultarHistorico</title>
        <style type="text/css">
            body {
                background:#ddd;
                margin:10px;
            }
            ul.nav li {
                margin:10;
                padding:10;
                list-style:none;
                display:table;
            }
            ul.nav li a {
                float:left;
                width:15.0em;
                font:0.90em  Verdana, Arial, Helvetica, sans-serif;
                background:#f1f1f1;
                color:#333;
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
            ul.nav lp {
                margin:10;
                padding:10;
                list-style:none;
                display:table;
            }
            ul.nav lp a {
                float:left;
                width:4.0em;
                font:0.90em  Verdana, Arial, Helvetica, sans-serif;
                background:#f1f1f1;
                color:#333;
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

        </head>
        <body>

            <ul class="nav">
            <table align="center">
                <tr><td>   <li>  <a href="Principal.jsp">Home</a>
                    <a href="CadastrarCliente.jsp">Atualizar Cadastro</a>
                    <a href="AtualizarCadastroCliente.jsp">Cartão de Crédito</a>
                    <a href="ComprarPassagem.jsp">Comprar Passagem</a>
                    <a href="ConsultarHistorico.jsp">Consultar Histórico</a>
                    <a href="index.jsp">Sair</a>
                </li></td></tr>
            </table>
       
                <table  width=1500 height=10 cellpadding=1 cellspacing=1 class="estilotabela"align="center">
        <tr><td><H1 align="center">Histórico</H1> </td></tr>
    </table>
            
        

    </body>
</html>

