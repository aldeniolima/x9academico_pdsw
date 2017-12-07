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
    </head>
    <body class="bg-dark">

        <div class="container">
            
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">X9-Acadêmico   <img src="img/logo.png" width="35px" style="margin:0px auto; text-align: center; float: right;"></div>
                <div class="card-body">
                    <form method="post" action="LoginServlet">
                        <div class="form-group">
                            <label for="login">Login:</label>
                            <input class="form-control" name="login" type="text" placeholder="Login" required="required">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha:</label>
                            <input class="form-control" name="senha" type="password" placeholder="Senha" required="required">
                        </div>
                        <input type="submit"class="btn btn-primary btn-block" value="Entrar">
                    </form>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
