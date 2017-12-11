<%-- 
    Document   : alterar_aluno
    Created on : 23/10/2017, 10:08:02
    Author     : carlo
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
        <%@include file="navbar.jsp"%>
        <!-- NavBar-->

        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Conteudo

                <div class="row">
                    <div id="caixa_conteudo"> -->
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="Menu?acao=Home">Home</a>
                            </li>
                            <li class="breadcrumb-item active">Alunos</li>
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
                        <div id="lista_alunos" class="table-responsive">
                            <div class="form-group">
                                <form method="post" action="${pageContext.request.contextPath}/AlterarAlunoServlet">
                                    <label for="turma">Turma:</label>
                                    <select class="form-control" name="id_turma">

                                        <c:forEach var="Turma" items="${listaTurmas}">
                                            <option value="${Turma.idTurma}">Série: ${Turma.serie}</option>
                                        </c:forEach>
                                    </select>
                                    <input href="" type="submit" class="btn btn-default" name="btn_lista_aluno" value="Buscar"/>
                                </form>
                            </div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Matricula</th>
                                        <th>Nome</th>
                                        <th>Data de Nascimento</th>
                                        <th>Deficiência</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="aluno" items="${listaAluno}">
                                        <tr>
                                            <td>${aluno.matricula}</td>
                                            <td>${aluno.nome}</td>
                                            <td>${aluno.dataNascimento}</td>
                                            <td>${aluno.deficiencia}</td>
                                            <td>
                                                <a href="Menu?acao=editar_aluno&aln=${aluno.idAluno}" role="button"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
                                                <a href="#" role="button" onclick="confirmacao('${aluno.idAluno}')"><span class="glyphicon glyphicon-remove"></span> Excluir</a>
                                            </td>
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

        <script language="Javascript">
            function confirmacao(id) {
                var resposta = confirm("Deseja realmente remover o aluno?");
                //  $('#modal_excluir').modal('show'); 
                //document.getElementById("modal_excluir");

                if (resposta === true) {
                    window.location.href = "ExcluirAlunoServlet?aln=" + id;
                }
            }
        </script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!--<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    </body>
</html>


