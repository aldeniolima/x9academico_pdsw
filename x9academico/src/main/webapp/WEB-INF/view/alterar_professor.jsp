<%-- 
    Document   : editar_professor
    Created on : 11/10/2017, 14:51:42
    Author     : joselima
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
                    <div id="caixa_conteudo" style="width: 1100px">
                        <h3>Professores</h3>
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
                        <div id="lista_professores" class="table-responsive">

                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Login</th>
                                        <th>Data de Nascimento</th>
                                        <th>CPF</th>
                                        <th>Telefone</th>
                                        <th>Email</th>
                                        <th>Turmas</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="professor" items="${listaProf}">
                                        <tr>
                                            <td>${professor.nome}</td>
                                            <td>${professor.login}</td>
                                            <td>${professor.dataNascimento}</td>
                                            <td>${professor.cpf}</td>
                                            <td>${professor.telefone}</td>
                                            <td>${professor.email}</td>
                                            <td>
                                                <c:forEach var="turma" items="${professor.turmas}">
                                                    ${turma.serie} 
                                                </c:forEach>
                                            </td>
                                            <td>
                                                <a href="Menu?acao=editar_prof&codigo=${professor.idUsuario}" role="button" ><span class="glyphicon glyphicon-pencil"></span> Editar</a>
                                                <a href="#" onclick="confirmacao('${professor.idUsuario}')" role="button" name="excluir"><span class="glyphicon glyphicon-remove"></span> Excluir</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>
                        </div>   
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
                var resposta = confirm("Deseja realmente remover o usuário?");
                //  $('#modal_excluir').modal('show'); 
                //document.getElementById("modal_excluir");

                if (resposta == true) {
                    window.location.href = "ExcluirProfServlet?user=" + id;
                }
            }
        </script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!--<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    </body>
</html>
