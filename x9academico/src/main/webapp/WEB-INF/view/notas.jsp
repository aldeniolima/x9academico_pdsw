<%-- 
    Document   : notas
    Created on : 27/11/2017, 16:18:40
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
                <!-- Conteudo-->

                <div class="row">
                    <div id="caixa_conteudo">
                        <h3>Notas</h3>
                        <a href="javascript:window.history.go(-1)"> <img alt="voltar" src="img/previous2.png" style="height: 30px; width: 30px; float: right;"></a>
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
                        <div id="lista_alunos" class="table-responsive">
                            <div class="form-group">         
                            </div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Lideranca</th>
                                        <th>Trabalho em Equipe</th>
                                        <th>Participação em Sala</th>
                                        <th>Motivação</th>
                                        <th>Criatividade</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                <form action="EditarNotas" method="post">
                                        <td><input type="text" class="form-control nota" name="lideranca" value="${notas.lideranca}" disabled=""></td>
                                        <td><input type="text" class="form-control nota" name="trabalhoEmEquipe" value="${notas.trabalhoEmEquipe}" disabled=""></td>
                                        <td><input type="text" class="form-control nota" name="participacaoEmSala" value="${notas.participacaoEmSala}" disabled=""></td>
                                        <td><input type="text" class="form-control nota" name="motivacao" value="${notas.motivacao}" disabled=""></td>
                                        <td><input type="text" class="form-control nota" name="criatividade" value="${notas.criatividade}" disabled=""></td>

                                        <td>
                                            <a href="#" role="button" title="Editar" id="editar_notas" onclick="Edita_nts()"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
                                            <input type="hidden" href="EditarNotas" class="btn btn-default" id="btn_salvar_notas" value="Salvar">
                                            <input type="hidden" name="A" value="${A}">
                                        </td>
                                    </tr>
                            </table>
                            <label for="obs" style="font-weight: bold">Observações</label>
                            <textarea class="form-control nota" name="observacoes" disabled="">${notas.observacoes}</textarea>
                            </form>
                        </div>

                    </div>
                </div>

                <!-- div para dar altura-->
                <div style="height: 1000px;"></div>
            </div>
            <!-- final conteudo-->


            <div class="modal fade" id="formLogin" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Login</h4>
                            <c:if test="${mensagens.existeErros}">
                                <div id="erro">
                                    <ul>
                                        <c:forEach var="erro" items="${mensagens.erros}">
                                            <li> ${erro} </li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                        <div class="modal-body" style="padding:40px 60px;">
                            <form method="post" action="index.jsp">
                                <div class="form-group">
                                    <label for="login">Login:</label>
                                    <input type="text" class="form-control" name="login" id="nome_login" value="${param.login}" placeholder="Insira seu login" required>
                                </div>
                                <div class="form-group">
                                    <label for="senha">Senha:</label>
                                    <input type="password" class="form-control" name="senha" id="senha_login" placeholder="Insira sua senha" required>
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn btn-default" name="bOK" value="Entrar"/>
                                    <!-- btn btn-success btn-block -->
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer" style="padding:40px 50px;">


                        </div>

                    </div>
                </div>
            </div>


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



