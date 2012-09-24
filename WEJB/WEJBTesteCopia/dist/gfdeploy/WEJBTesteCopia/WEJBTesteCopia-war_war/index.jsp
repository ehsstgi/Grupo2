<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
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

    </head>
<body>
    <table  width=1500 height=10 cellpadding=1 cellspacing=1 class="estilotabela"align="center">
        <tr><td><H1 align="center">Sistema Rodoviário</H1> </td></tr>
    </table>




    <ul class="nav">
        <table border="25" align="center">
            <form action="ValidarLogin" method="post"align="center">
                <tr>
                    <td> Usuário:    <input type="text" name="usuario" size="20"/></td></tr> 
                <tr><td> Senha  :     <input type="password" name="senha" size="20"/> </td></tr>
                <tr><td><li> <input type="submit" name="Entrar" value="Enviar"/></li></td></tr>
        </table>
    </table>
</ul>
<table align="center">

    <tr>

        <td> <li><a href="CadastrarCliente.jsp">Não tem cadastro? Clique aqui!</a></li> </td>
</tr>
</table>

</body>
</html>