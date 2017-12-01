<%-- 
    Document   : cadastrar_professor
    Created on : 11/10/2017, 14:51:17
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
                        <h3>Cadastrar um Professor</h3>
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
                        <div class="box clearfix">
                            <form method="post" action="${pageContext.request.contextPath}/CadastroProfServlet">

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="nome">Nome:</label>
                                            <input type="text" class="form-control" name="nome" id="nome_professor" value="" placeholder="Digite o nome" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="data_nascimento">Data de nascimento:</label>
                                            <input type="text" class="form-control" name="data_nascimento" id="data_nascimento_professor" value="" placeholder="Digite a data de nascimento" required>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="telefone">Telefone:</label>
                                            <input type="tel" class="form-control" minlength="10" maxlength="11" name="telefone" id="telefone_professor" value="" placeholder="Digite o telefone" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="email" class="form-control" name="email" id="email_professor" value="" placeholder="Digite o email" required>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->
                                <div class="row">
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="cpf">CPF:</label>
                                            <input type="" class="form-control" name="cpf" minlength="14" maxlength="14" id="cpf_professor" value="" placeholder="Digite o CPF" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="login">Login:</label>
                                            <input type="text" class="form-control" name="login" id="login_professor" value="" placeholder="Digite o Login" required>
                                        </div>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="senha">Senha:</label>
                                            <input type="password" class="form-control" name="senha" minlength="8" maxlength="30" id="senha_professor" value="" placeholder="Digite a senha" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="confirma_senha">Confirmar Senha:</label>
                                            <input type="password" class="form-control" name="confirma_senha" minlength="8" maxlength="30" id="confirma_senha_professor" value="" placeholder="Confirme a senha" required>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->


                                <div class="row">

                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label for="endereco">Endereço:</label>
                                            <input type="text" class="form-control" name="endereco" id="endereco_professor" value="" placeholder="Digite o endereço" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="cidade">Cidade:</label>
                                            <input type="text" class="form-control" name="cidade" id="cidade_professor" value="" placeholder="Digite a cidade" required>
                                        </div>
                                    </div>


                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="UF">UF:</label>
                                            <input type="text" class="form-control" maxlength="2" name="UF" id="UF_professor" value="" placeholder="Digite a UF" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="numero">Número:</label>
                                            <input type="text" class="form-control" name="numero" id="numero_professor" value="" placeholder="Digite o numero" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="cep">CEP:</label>
                                            <input type="text" class="form-control" minlength="10" maxlength="10" name="cep" id="cep_professor" value="" placeholder="Digite o cep" required>
                                        </div>
                                    </div>


                                </div>

                                <div class="col-sm-12 text-center">
                                    <div class="form-group">
                                        <input href="CadastroProfServlet" type="submit" class="btn btn-template-main" name="btn_cadastro_turma" value="Cadastrar"/>
                                        <input href="#" type="reset" class="btn btn-template-main" name="btn_limpar_cadastro" value="Limpar"/>
                                        <!-- btn btn-success btn-block -->
                                    </div>
                                </div>
                            </form>

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
