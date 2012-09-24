<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AtualizarCadastroCliente</title>
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
        <tr><td><H1 align="center">Atualizar Cadastro</H1> </td></tr>
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

            String nome = (String) session.getAttribute("Nome_Cliente");
            String cpf = (String) session.getAttribute("CPF_Cliente");
            String rg = (String) session.getAttribute("RG_Cliente");
            String telefone = (String) session.getAttribute("Telefone_Cliente");
            String nascimento = (String) session.getAttribute("Nascimento_Cliente");
            String sexo = (String) session.getAttribute("Sexo_Cliente");
            String estadocivil = (String) session.getAttribute("EstadoCivil_Cliente");
            String email = (String) session.getAttribute("Email_Cliente");
            String endereco = (String) session.getAttribute("Endereco_Cliente");
            String numero = (String) session.getAttribute("Numero_Cliente");
            String complemento = (String) session.getAttribute("Complemento_Cliente");
            String pais = (String) session.getAttribute("Pais_Cliente");
            String estado = (String) session.getAttribute("Estado_Cliente");
            String cidade = (String) session.getAttribute("Cidade_Cliente");
            String bairro = (String) session.getAttribute("Bairro_Cliente");
            String cep = (String) session.getAttribute("CEP_Cliente");

            if (nome == null) {
                nome = "";
            }
            if (cpf == null) {
                cpf = "";
            }
            if (rg == null) {
                rg = "";
            }
            if (telefone == null) {
                telefone = "";
            }
            if (nascimento == null) {
                nascimento = "";
            }
            if (sexo == null) {
                sexo = "";
            }
            if (estadocivil == null) {
                estadocivil = "";
            }
            if (email == null) {
                email = "";
            }
            if (endereco == null) {
                endereco = "";
            }
            if (numero == null) {
                numero = "";
            }
            if (complemento == null) {
                complemento = "";
            }
            if (pais == null) {
                pais = "";
            }
            if (estado == null) {
                estado = "";
            }
            if (cidade == null) {
                cidade = "";
            }
            if (bairro == null) {
                bairro = "";
            }
            if (cep == null) {
                cep = "";
            }

        %>

        <ul class="nav">
            <table border="25" align="center">
                <form action="ValidarCadastroCliente.jsp" method="post" align="center">
                    <tr><td> Nome Completo:     <input type="text" name="Nome_Cliente" size="50" value=<%=nome%>></td></tr> 
                    <tr><td> CPF          :     <input type="text" name="CPF_Cliente" maxlength="11"onBlur="javascript:validaCPF(this);"value=<%=cpf%>>  *Somente Números  </td></tr> 
                    <tr><td> RG          :     <input type="text" name="RG_Cliente"  maxlength="12" size="12" onkeypress="formatar_mascara(this, '##.###.###-#')" value=<%=rg%>> </td></tr>
                    <tr><td> Telefone     :     <input type="text" name="Telefone_Cliente" maxlength="12" size="12" onkeypress="formatar_mascara(this, ('##-####-####')"value=<%=telefone%>> </td></tr>
                    <tr><td> Nascimento   :     <input type="text" name="Nascimento_Cliente"   maxlength="10" onkeyup="Formatadata(this,event)" value=<%=nascimento%>> </td></tr>
                    <tr><td> Sexo         :  Masculino   <input type="radio" name="Sexo_Cliente" value ="Masculino"value=<%=sexo%> >
                            Feminino <input type="radio" name="Sexo_Cliente" value ="Feminino"value=<%=sexo%>> </td></tr>
                    <tr><td> Estado Civil :     Solteiro(a)   <input type="radio" name="EstadoCivil_Cliente" value ="Solteiro"value=<%=estadocivil%> >
                            Casado(a) <input type="radio" name="EstadoCivil_Cliente" value ="Casado"value=<%=estadocivil%>> 
                            Separado(a) <input type="radio" name="EstadoCivil_Cliente" value ="Separado"value=<%=estadocivil%>> 
                            Divorciado(a) <input type="radio" name="EstadoCivil_Cliente" value ="Divorciado"value=<%=estadocivil%>> 
                            Viuvo(a) <input type="radio" name="EstadoCivil_Cliente" value ="Viuvo"value=<%=estadocivil%>>           </td></tr>
                    <tr><td> Email        :     <input type="text" name="Email_Cliente"  size="40" maxlength="40"  value=<%=email%>> </td></tr>
                    <tr><td> Endereço     :     <input type="text" name="Endereco_Cliente"ID="7"  size="5"  value=<%=endereco%>> </td></tr>
                    <tr><td> Número       :     <input type="text" name="Numero_Cliente"  maxlength="5"size="5"onkeypress="return blockNumbers(event);" value=<%=numero%>> </td></tr>
                    <tr><td> Complemento  :     <input type="text" name="Complemento_Cliente" ID="9" size="10"value=<%=complemento%>> </td></tr>
                    <tr><td> País         :     Brasil   <input type="radio" name="Pais_Cliente" value ="Brasil"value=<%=pais%>>  
                            Outro <input type="radio" name="Pais_Cliente" value ="Outro"value=<%=pais%>> </td></tr>

                    <tr><td> Estado       :           <select name="Estado_Cliente"value=<%=estado%>>
                                <option value=" "> </option>
                                <option value="Acre">Acre</option>
                                <option value="Alagoas">Alagoas</option>
                                <option value="Amapá">Amapá</option>
                                <option value="Amazonas">Amazonas</option>
                                <option value="Bahia">Bahia</option>
                                <option value="Ceara">Ceará</option>
                                <option value="DistritoFederal">Distrito Federal</option>
                                <option value="EspiritoSanto">Espírito Santo</option>
                                <option value="Maranhao">Maranhão</option>
                                <option value="MatoGrosso">Mato Grosso</option>
                                <option value="MatoGrossodoSul">Mato Grosso do Sul</option>
                                <option value="Minas Gerais">Minas Gerais</option>
                                <option value="Outro">Outro</option>
                                <option value="Para">Para</option>
                                <option value="Paraiba">Paraíba</option>
                                <option value="Parana">Paraná</option>
                                <option value="Pernambuco">Pernambuco</option>
                                <option value="Piaui">Piaui</option>
                                <option value="RiodeJaneiro">Rio de Janeiro</option>
                                <option value="RioGrandedoNorte">Rio Grande do Norte</option>
                                <option value="RioGrandedoSul">Rio Grande do Sul</option>
                                <option value="Rondonia">Rondônia</option>
                                <option value="Roraima">Roraima</option>
                                <option value="SantaCatarina">Santa Catarina</option>
                                <option value="SaoPaulo">São Paulo</option>
                                <option value="Sergipe">Sergipe</option>
                                <option value="Tocantins">Tocantins</option>
                            </select></td></tr>
                    <tr><td> Cidade       :     <input type="text" name="Cidade_Cliente" ID="11" size="15"value=<%=cidade%>> </td></tr>
                    <tr><td> Bairro       :     <input type="text" name="Bairro_Cliente" ID="10" size="15"value=<%=bairro%>> </td></tr>


                    <tr><td> CEP          :     <input type="text" name="CEP_Cliente" ID="14" maxlength="8" size="8" onkeypress="return blockNumbers(event);"value=<%=cep%>> </td></tr>

                    <tr><td> <input type="submit" name="Atualizar" value="Atualizar" /></td></tr>

                </FORM>

            </table>
        </ul>

    </table>
</ul>

</body>
</html>

