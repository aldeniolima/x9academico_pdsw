<%-- 
    Document   : cadastrar_aluno
    Created on : 23/10/2017, 10:07:29
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
                    <div id="caixa_conteudo">
                        <h3>Cadastrar Aluno</h3>
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
                        <form method="post" action="${pageContext.request.contextPath}/CadastroAlunoServlet">
                            <div class="form-group">
                                <label for="matricula">Matrícula:</label>
                                <input type="text" class="form-control" name="matricula" id="matricula_aluno" value="" placeholder="Digite a matricula" required>
                            </div>
                            <div class="form-group">
                                <label for="nome">Nome:</label>
                                <input type="text" class="form-control" name="nome" id="nome_aluno" value="" placeholder="Digite o nome" required>
                            </div>
                            <div class="form-group">
                                <label for="turma">Turma:</label>
                                <select class="form-control" name="id_turma">
                                    <option></option>
                                    <c:forEach var="Turma" items="${listaTurmas}">
                                        <option value="${Turma.idTurma}">${Turma.serie}</option>
                                    </c:forEach>
                                </select>
                            </div> 
                            <div class="form-group">
                                <label for="data_nascimento">Data de nascimento:</label>
                                <input type="text" class="form-control" name="data_nascimento" id="data_nascimento_aluno" value="" placeholder="Digite a data de nascimento" required>
                            </div>
                            <div class="form-group">
                                <label for="deficiencia">Deficiência:</label>
                                <select class="form-control" name="deficiencia_aluno">
                                    <option></option>
                                    <option value="Sim" required>Sim</option>
                                    <option value="Nao">Não</option>
                                </select>
                            </div>
                            <h4>Responsável</h4>
                            <div class="form-group">

                                <label for="nome">Nome:</label>
                                <input type="text" class="form-control" name="nome_resp" id="nome_responsavel_aluno" value="" placeholder="Digite o nome" required>
                            </div>
                            <div class="form-group">
                                <label for="data_nascimento">Data de nascimento:</label>
                                <input type="text" class="form-control" name="data_nascimento_resp" id="data_nascimento_responsavel_aluno" value="" placeholder="Digite a data de nascimento" required>
                            </div>
                            <div class="form-group">
                                <label for="endereco">Endereço:</label>
                                <input type="text" class="form-control" name="endereco_resp" id="endereco_professor" value="" placeholder="Digite o endereço" required>
                            </div>
                            <div class="form-group">
                                <label for="cep">CEP:</label>
                                <input type="text" class="form-control" name="cep_resp" id="cep_professor" value="" placeholder="Digite o cep" required>
                            </div>
                            <div class="form-group">
                                <label for="cidade">Cidade:</label>
                                <input type="text" class="form-control" name="cidade_resp" id="cidade_professor" value="" placeholder="Digite a cidade" required>
                            </div>
                            <div class="form-group">
                                <label for="numero">Número:</label>
                                <input type="text" class="form-control" name="numero_resp" id="numero_professor" value="" placeholder="Digite o numero" required>
                            </div>
                            <div class="form-group">
                                <label for="UF">UF:</label>
                                <input type="text" class="form-control" name="UF_resp" id="UF_professor" value="" placeholder="Digite a UF" required>
                            </div>
                            <div class="form-group">
                                <label for="telefone">Telefone:</label>
                                <input type="tel" class="form-control" name="telefone_resp" id="telefone_responsavel_aluno" value="" placeholder="Digite o telefone" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" name="email_resp" id="email_responsavel_aluno" value="" placeholder="Digite o email" required>
                            </div>
                            <div class="form-group">
                                <label for="cpf">CPF:</label>
                                <input type="text" class="form-control" name="cpf_resp" id="cpf_responsavel_aluno" value="" placeholder="Digite o CPF" required>
                            </div>
                            <div class="form-group">
                                <label for="login_resp">Login:</label>
                                <input type="text" class="form-control" name="login_resp" id="login_resp" value="" placeholder="Digite o login" required>
                            </div>
                            <div class="form-group">
                                <label for="senha">Senha:</label>
                                <input type="password" class="form-control" name="senha_resp" id="senha_responsavel_aluno" value="" placeholder="Digite a sennha - Min. 08 Max. 12 caracteres" required>
                            </div>
                            <div class="form-group">
                                <label for="senha">Confirma Senha:</label>
                                <input type="password" class="form-control" name="confirma_senha_resp" id="confir_senha_responsavel" value="" placeholder="Digite a sennha - Min. 08 Max. 12 caracteres" required>
                            </div>
                            <div class="form-group">
                                <input href="CadastroAlunoServlet" type="submit" class="btn btn-default" name="btn_cadastro_aluno" value="Cadastrar"/>
                                <input href="#" type="reset" class="btn btn-default" name="btn_limpar_cadastro" value="Limpar"/>
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

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!--<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    </body>
</html>

