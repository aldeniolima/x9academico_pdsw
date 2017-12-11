<%-- 
    Document   : listar_turmas_prof
    Created on : 27/11/2017, 16:17:44
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
        <!-- Bootstrap core CSS-->
        <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">
        <!-- JS -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
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
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

        <!-- NavBar-->
        <%@include file="navbar_prof.jsp"%>
        <!-- NavBar-->

        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Conteudo--

                <div class="row">
                    <div id="caixa_conteudo"> -->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="Menu?acao=Home">Home</a>
                    </li>
                    <li class="breadcrumb-item active">Turmas</li>
                    <a href="Menu?acao=Home"> <img alt="voltar" src="img/previous2.png" style="height: 30px; width: 30px; float: right;"></a>
                </ol>
                <div id="mensagem" style="height: 60px;">
                    <c:if test="${mensagens.existeErros}">
                        <div id="erro" class="alert alert-danger text-center">
                            <ul  id="ul_erro">
                                <c:forEach var="erro" items="${mensagens.erros}">
                                    <li> ${erro} </li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
                <div id="lista_turmas" class="table-responsive">

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Série</th>
                                <th>Sala</th>
                                <th>Turno</th>
                                <th>Quantidade máxima de alunos</th>
                                <th>Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="turma" items="${usuarioLogado.turmas}">
                                <tr>
                                    <td>${turma.idTurma}</td>
                                    <td>${turma.serie}</td>
                                    <td>${turma.numeroSala}</td>
                                    <td>${turma.turno}</td>
                                    <td>${turma.qtdAluno}</td>
                                    <td><a href="Menu?acao=listar_alunos&T=${turma.idTurma}">Listar Alunos</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!--<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    </body>
</html>
