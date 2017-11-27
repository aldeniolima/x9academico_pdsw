<%-- 
    Document   : navbar_prof
    Created on : 27/11/2017, 16:01:54
    Author     : joselima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-ligth fixed-top" id="inicioNav" style="background-color: #e3f2fd;">
    <a class="navbar-brand" href="Menu?acao=Home">X9-Acadêmico</a>
    <div class="collapse navbar-collapse" id="navbarResponsivo">
        <ul class="navbar-nav navbar-sidenav" id="fechaMenu">
            <img src="img/logo.png" width="150px" style="margin:0px auto">
            <li class="nav-item" data-toggle="tooltip" data-placement="right">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#menuTurmas" data-parent="#fechaMenu">
                    <span class="nav-link-text">Turmas</span>
                    <!--<span class="glyphicon glyphicon-triangle-right"></span> -->
                </a>
                <ul class="sidenav-second-level collapse" id="menuTurmas">
                    <li>
                        <a href="Menu?acao=listar_turmas">Listar Turmas</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
                <a class="nav-link" href="#">
                    <span class="nav-link-text">Dados Pessoais</span>
                </a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" style="cursor: auto;">Bem-vindo, ${usuarioLogado.nomecompleto}!</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Sair</a>
            </li>
        </ul>
    </div>
</nav>

