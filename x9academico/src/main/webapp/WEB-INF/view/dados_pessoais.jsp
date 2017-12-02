<%-- 
    Document   : dados_pessoais
    Created on : 02/12/2017, 00:59:15
    Author     : aldenioL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>X9-Acadêmico</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">-->
        <!-- CSS-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <style>
            #caixa_conteudo{
                height: auto;
                width: 900px;
                padding: 40px 40px;
                margin: 0 auto 25px;
                overflow:auto;
            }

            #ul_erro{
                list-style-type: none;  
            }
        </style>

    </head>
    <body class="fixed-nav sticky-footer" style="background-color: #e3f2fd;">

        <!-- NavBar-->
        <%@include file="navbar.jsp"%>
        <!-- NavBar-->

        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Conteudo-->

                <div class="row">
                    <div id="caixa_conteudo">
                        <h3>Dados Pessoais</h3>
                        <a href="Menu?acao=Home"> <img alt="voltar" src="img/previous2.png" style="height: 30px; width: 30px; float: right;"></a>
                        <div id="mensagem" style="height: 50px;">
                            <c:if test="${mensagens.existeErros}">
                                <div id="erro" class="alert">
                                    <ul  id="ul_erro">
                                        <c:forEach var="erro" items="${mensagens.erros}">
                                            <li> ${erro} </li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                        <form method="post" action="${pageContext.request.contextPath}/EditarUsuario">                  
                            <div class="form-group">
                                <label for="nome">Nome:</label>
                                <input type="text" class="form-control" name="nome" id="nome" value="${usuarioLogado.nome}" placeholder="Digite o nome" required>
                            </div>
                            <div class="form-group">
                                <label for="data_nascimento">Data de nascimento:</label>
                                <input type="text" class="form-control" name="data_nascimento" id="data_nascimento" value="${usuarioLogado.dataNascimento}" placeholder="Digite a data de nascimento" required>
                            </div>
                            <div class="form-group">
                                <label for="telefone">Telefone:</label>
                                <input type="tel" class="form-control" minlength="11" maxlength="11" name="telefone" id="telefone" value="${usuarioLogado.telefone}" placeholder="Digite o telefone" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" name="email" id="email" value="${usuarioLogado.email}" placeholder="Digite o email" required>
                            </div>
                            <div class="form-group">
                                <label for="cpf">CPF:</label>
                                <input type="text" class="form-control" minlength="11" maxlength="11" name="cpf" id="cpf" value="${usuarioLogado.cpf}" disabled>
                            </div>
                            <div class="form-group">
                                <label for="login">Login:</label>
                                <input type="text" class="form-control" name="login" id="login" value="${usuarioLogado.login}" disabled>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-default" name="btn_editar" value="Salvar"/>
                                <!-- btn btn-success btn-block -->
                            </div>
                        </form>
                    </div>
                </div>

                <!-- div para dar altura-->
                <div style="height: 1000px;"></div>
            </div>
            <!-- final conteudo-->

            <!-- footer -->
            <%@include file="footer.jsp"%>
            <!-- final footer -->
        </div>
        <!-- final paginas -->

        <script language="Javascript">
            function confirmacao(id) {
                var resposta = confirm("Deseja realmente remover a turma?");
                //  $('#modal_excluir').modal('show'); 
                //document.getElementById("modal_excluir");

                if (resposta == true) {
                    window.location.href = "ExcluirTurmaServlet?turma=" + id;
                }
            }
        </script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!--<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    </body>
</html>


