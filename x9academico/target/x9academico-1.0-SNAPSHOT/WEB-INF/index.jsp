<%-- 
    Document   : index
    Created on : 11/10/2017, 14:18:26
    Author     : joselima
--%>

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
    </head>
    <body class="bg-dark">

        <div class="container">

            <div class="card card-login mx-auto mt-5" id="card_login">
                <div class="card-header">X9-Acadêmico   <img src="img/logo.png" width="35px" style="margin:0px auto; text-align: center; float: right;"></div>
                <div class="card-body">
                    <form method="post" action="LoginServlet">
                        <div class="form-group">
                            <label for="login">Login:</label>                      
                            <input class="form-control has-feedback" name="login" type="text" placeholder="Login" onkeyup="verificaLogin(this)" data-toggle="popover" data-trigger="hover" data-content="Apenas letras, números, _ e ." required="required">           
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha:</label>
                            <input class="form-control" name="senha" type="password" placeholder="Senha" min="6" max="20" onkeyup="verificaSenha(this)" data-toggle="popover" data-trigger="hover" data-content="Mínimo de 6, máximo 20 caracteres" required="required">
                        </div>
                        <input type="submit" id="btn_login" class="btn btn-primary btn-block" value="Entrar">
                    </form>
                    <div class="text-center">                        
                        <a class="d-block small mt-3" href="#">Não consegue acessar?</a>
                    </div>
                    <div class="alert alert-danger text-center mt-3" id="alertIndex" style="display: none;">
                        <strong>Erro!</strong> Insira os dados corretamente.
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <script>
                                $(document).ready(function () {
                                    $('[data-toggle="popover"]').popover();
                                });
        </script>
    </body>
</html>
