<%-- 
    Document   : editar_turma
    Created on : 16/10/2017, 12:37:42
    Author     : Aldo_PC
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
                <!-- Conteudo--

                <div class="row">
                    <div id="caixa_conteudo"> -->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="Menu?acao=Home">Home</a>
                    </li>
                    <li class="breadcrumb-item active">Editar Turma</li>
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
                <form method="get" action="${pageContext.request.contextPath}/EditarTurmaServlet">
                    <div class="form-group">
                        <label for="codigo">Código:</label>
                        <input type="text" class="form-control" name="codigo" id="codigo_turma" value="${turmaEditar.idTurma}" disabled>
                    </div>         
                    <div class="form-group">
                        <label for="serie">Série:</label>
                        <input type="text" class="form-control" name="serie" id="serie_turma" value="${turmaEditar.serie}" placeholder="Digite a série" disabled>
                    </div>
                    <div class="form-group">
                        <label for="sala">Sala:</label>
                        <input type="text" maxlength="2" class="form-control" name="sala" id="sala_turma" value="${turmaEditar.numeroSala}" placeholder="Digite a sala" required>
                    </div>                     
                    <div class="form-group">
                        <label for=quantidade_alunos">Quantidade Máxima de Alunos:</label>
                        <input type="text" maxlength="2" class="form-control" name="quantidade_alunos" id="quantidade_alunos_turma" value="${turmaEditar.qtdAluno}" placeholder="Digite a quantidade máxima de alunos" required>
                    </div>
                    <div class="form-group">
                        <label for=quantidade_alunos">Turno:</label>
                        <select class="form-control" name="turno">
                            <option value="${turmaEditar.turno}">${turmaEditar.turno}</option>
                            <option value="Manhã">Manhã</option>
                            <option value="Tarde">Tarde</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="select_prof">Professores:</label>
                        <select class="form-control" name="id_prof">
                            <option value="${turmaEditar.professor.idUsuario}">${turmaEditar.professor.nome}</option>
                            <c:forEach var="prof" items="${listaprof}">
                                <option value="${prof.idUsuario}">${prof.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-default" name="btn_cadastro_turma" value="Atualizar"/>

                        <!-- btn btn-success btn-block -->
                    </div>
                </form>
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


