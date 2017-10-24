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
                        <h3>Alunos</h3>
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
                                <form method="post" action="${pageContext.request.contextPath}/AlterarAlunoServlet">
                                    <label for="turma">Turma:</label>
                                    <select class="form-control" name="id_turma">
                                        
                                        <c:forEach var="Turma" items="${listaTurmas}">
                                            <option value="${Turma.idturma}">Série: ${Turma.serie}</option>
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
                                                <a href="Menu?acao=editar_aluno&aln=${aluno.idaluno}" role="button"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
                                                <a href="#" role="button" onclick="confirmacao('${aluno.idaluno}')"><span class="glyphicon glyphicon-remove"></span> Excluir</a>
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

