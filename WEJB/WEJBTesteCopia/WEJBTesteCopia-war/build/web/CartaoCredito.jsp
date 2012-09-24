<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CartaoCredito</title>
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

    </head>
    <body>
       
        <script type="text/javascript">
            function Formatadata(Campo, teclapres)
            {
                var tecla = teclapres.keyCode;
                var vr = new String(Campo.value);
                vr = vr.replace("/", "");
                vr = vr.replace("/", "");
                vr = vr.replace("/", "");
                tam = vr.length + 1;
                if (tecla != 8 && tecla != 8)
                {
                    if (tam > 0 && tam < 2)
                        Campo.value = vr.substr(0, 2) ;
                    if (tam > 2 && tam < 4)
                        Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2);
                    if (tam > 4 && tam < 7)
                        Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2) + '/' + vr.substr(4, 7);
                }
            }
            function formatar_mascara(src, mascara) {
                var campo = src.value.length;
                var saida = mascara.substring(0,1);
                var texto = mascara.substring(campo);
                if(texto.substring(0,1) != saida) {
                    src.value += texto.substring(0,1);
                }
            } 
                           
        </script>
        <table  width=1500 height=10 cellpadding=1 cellspacing=1 class="estilotabela"align="center">
            <tr><td><H1 align="center">Cartão de Crédito</H1> </td></tr>
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

            <script type="text/javascript">
                function Formatadata(Campo, teclapres)
                {
                    var tecla = teclapres.keyCode;
                    var vr = new String(Campo.value);
                    vr = vr.replace("/", "");
                    vr = vr.replace("/", "");
                    vr = vr.replace("/", "");
                    tam = vr.length + 1;
                    if (tecla != 8 && tecla != 8)
                    {
                        if (tam > 0 && tam < 2)
                            Campo.value = vr.substr(0, 2) ;
                        if (tam > 2 && tam < 4)
                            Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2);
                        if (tam > 4 && tam < 7)
                            Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2) + '/' + vr.substr(4, 7);
                    }
                }
        
        
                function formatar_mascara(src, mascara) {
                    var campo = src.value.length;
                    var saida = mascara.substring(0,1);
                    var texto = mascara.substring(campo);
                    if(texto.substring(0,1) != saida) {
                        src.value += texto.substring(0,1);
                    }
                } 
        


                function valCPF(e,campo){
 
                    var tecla=(window.event)?event.keyCode:e.which;
                    if((tecla > 47 && tecla < 58 )){
                        return true;
                    }
                    else{
                        if (tecla != 8 ) return false;
                        else return true;
                    }
                }
        
                function validaCPF(cpf)   
                {  
                    erro = new String;  
                    if (cpf.value.length == 11)  
                    {     
                        cpf.value = cpf.value.replace('.', '');  
                        cpf.value = cpf.value.replace('.', '');  
                        cpf.value = cpf.value.replace('-', '');  
  
                        var nonNumbers = /\D/;  
      
                        if (nonNumbers.test(cpf.value))   
                        {  
                            erro = "Favor inserir apenas números!";   
                        }  
                        else  
                        {  
                            if (cpf.value == "00000000000" ||   
                                cpf.value == "11111111111" ||   
                                cpf.value == "22222222222" ||   
                                cpf.value == "33333333333" ||   
                                cpf.value == "44444444444" ||   
                                cpf.value == "55555555555" ||   
                                cpf.value == "66666666666" ||   
                                cpf.value == "77777777777" ||   
                                cpf.value == "88888888888" ||   
                                cpf.value == "99999999999") {  
                              
                                erro = "Número de CPF inválido!"  
                            }  
      
                            var a = [];  
                            var b = new Number;  
                            var c = 11;  
  
                            for (i=0; i<11; i++){  
                                a[i] = cpf.value.charAt(i);  
                                if (i < 9) b += (a[i] * --c);  
                            }  
      
                            if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }  
                            b = 0;  
                            c = 11;  
      
                            for (y=0; y<10; y++) b += (a[y] * c--);   
      
                            if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }  
      
                            if ((cpf.value.charAt(9) != a[9]) || (cpf.value.charAt(10) != a[10])) {  
                                erro = "Número de CPF inválido.";  
                            }  
                        }  
                    }  
                    else  
                    {  
                        if(cpf.value.length == 0)  
                            return false  
                        else  
                            erro = "Número de CPF inválido.";  
                    }  
                    if (erro.length > 0) {  
                        alert(erro);  
                        cpf.focus();  
                        return false;  
                    }     
                    return true;      
                }  


                function blockNumbers(e)
                {
                    var key;
                    var keychar;
                    var reg;

                    if(window.event) {
                        // for IE, e.keyCode or window.event.keyCode can be used
                        key = e.keyCode; 
                    }
                    else if(e.which) {
                        // netscape
                        key = e.which; 
                    }
                    else {
                        // no event, so pass through
                        return true;
                    }

                    keychar = String.fromCharCode(key);
                    reg = /[^\d-]/;
                    return !reg.test(keychar);
                }

            </script>


            <%

                String cpf = (String) session.getAttribute("CPF_Cliente");
                String codigobanco = (String) session.getAttribute("CodigoBanco");
                String agencia = (String) session.getAttribute("Agencia");
                String contacorrente = (String) session.getAttribute("ContaCorrente");
                String numerocartao = (String) session.getAttribute("NumeroCartao");
                String codigoseguranca = (String) session.getAttribute("CodigoSeguranca");
                String datavalidade = (String) session.getAttribute("DataValidade");

                if (cpf == null) {
                    cpf = "";
                }
                if (codigobanco == null) {
                    codigobanco = "";
                }
                if (agencia == null) {
                    agencia = "";
                }
                if (contacorrente == null) {
                    contacorrente = "";
                }
                if (numerocartao == null) {
                    numerocartao = "";

                }
                if (codigoseguranca == null) {
                    codigoseguranca = "";
                }
                if (datavalidade == null) {
                    datavalidade = "";
                }


            %>           
            <ul class="nav">
                <table border="25" align="center">
                    <form action="ValidarCartaoCredito" method="post" aling="center">
                        <tr><td> CPF          :     <input type="text" name="CPF_Cliente" maxlength="11"onBlur="javascript:validaCPF(this);"value=<%=cpf%>>  *Somente Números  </td></tr> 
                        <tr><td> Código Banco    :     <input type="text" name="Codigo_Banco" maxlength="3" size="3" onkeypress="return blockNumbers(event);"  value=<%=codigobanco%>> </td></tr>
                        <tr><td> Agência         :     <input type="text" name="Agencia"maxlength="4" size="4" onkeypress="return blockNumbers(event);"  value=<%=agencia%>> </td></tr>
                        <tr><td> Conta Corrente  :     <input type="text" name="ContaCorrente" size="10"maxlength="10" onkeypress="return blockNumbers(event);" value=<%=contacorrente%>> </td></tr>
                        <tr><td> Número Cartão   :     <input type="text" name="NumeroCartao" maxlength="19" size="19"onkeypress="return blockNumbers(event);"  value=<%=numerocartao%>> </td></tr>
                        <tr><td> Código Segurança:     <input type="text" name="CodigoSeguranca" maxlength="3" size="3" onkeypress="return blockNumbers(event);"  value=<%=codigoseguranca%>> </td></tr>
                        <tr><td> Data Validade   :     <input type="text" name="DataValidade"  maxlength="10" onkeyup="Formatadata(this,event)" value=<%=datavalidade%>> </td></tr>
                         



                        <tr><td><li> <input type="submit" name="Ok" value="Cadastrar" /></li>
                    </Form>

                    <form action="CartaoCredito.jsp" method="post"align="center" >
                        <%
                            session.invalidate();
                        %>

                        <input type="submit" value="Limpar"  /></td></tr>
                    </FORM>       </table>
                </body>
                </html>

