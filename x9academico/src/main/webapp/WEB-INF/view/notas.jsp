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
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">-->
        <!-- CSS-->
        <link href="css/sb-admin.css" rel="stylesheet">
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
    <body class="fixed-nav sticky-footer" style="background-color: #e3f2fd;">

        <!-- NavBar-->
        <%@include file="navbar_prof.jsp"%>
        <!-- NavBar-->

        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Conteudo-->

                <div class="row">
                    <div id="caixa_conteudo">
                        <h3>Notas</h3>
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
                                        <th>Observações</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                <form action="EditarNotas" method="post">
                                    <td><input type="text" class="form-control" id="nota" name="lideranca" value="${notas.lideranca}" ></td>
                                    <td><input type="text" class="form-control" id="nota" name="trabalhoEmEquipe" value="${notas.trabalhoEmEquipe}" ></td>
                                    <td><input type="text" class="form-control" id="nota" name="participacaoEmSala" value="${notas.participacaoEmSala}" ></td>
                                    <td><input type="text" class="form-control" id="nota" name="motivacao" value="${notas.motivacao}" ></td>
                                    <td><input type="text" class="form-control" id="nota" name="criatividade" value="${notas.criatividade}" ></td>
                                    <td><input type="text" class="form-control" id="nota" name="observacoes" value="${notas.observacoes}"></td>
                                    
                                    <td>
                                        <a href="#" role="button" title="Editar" id="editar_notas" onclick="Edita_nts()"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
                                        <input type="hidden" class="btn btn-default" id="btn_salvar_notas" value="Salvar">
                                        <input type="hidden" name="A" value="${A}">
                                    </td>
                                </form>

                                </tr>
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

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!--<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    </body>
</html>



