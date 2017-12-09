<%-- 
    Document   : template
    Created on : 11/10/2017, 14:29:11
    Author     : joselima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="inicioNav">
    <a class="navbar-brand" href="Menu?acao=Home">X9-Acadêmico</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsivo" aria-controls="navbarResponsivo" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsivo">
        <ul class="navbar-nav navbar-sidenav" id="fechaMenu">
            <img src="img/logo.png" width="150px" style="margin:0px auto">
            <li class="nav-item" data-toggle="tooltip" data-placement="right">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#menuTurmas" data-parent="#fechaMenu">
                    <i class="fa fa-fw fa-dashboard"></i>
                    <span class="nav-link-text">Turmas</span>
                    <!--<span class="glyphicon glyphicon-triangle-right"></span> -->
                </a>
                <ul class="sidenav-second-level collapse" id="menuTurmas">
                    <li>
                        <a href="Menu?acao=cadastrar_turma">Cadastrar Turma</a>
                    </li>
                    <li>
                        <a href="Menu?acao=alterar_turmas">Alterar Turmas</a>
                    </li>
                    <li>
                        <a href="Menu?acao=listar_turmas">Listar Turmas</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#menuProfessor" data-parent="#fechaMenu">
                    <span class="nav-link-text">Professores</span>
                </a>
                <ul class="sidenav-second-level collapse" id="menuProfessor">
                    <li>
                        <a href="Menu?acao=cadastrar_prof">Cadastrar Professor</a>
                    </li>
                    <li>
                        <a href="Menu?acao=alterar_prof">Editar Cadastro</a>
                    </li>
                    <li>
                        <a href="Menu?acao=listar_prof">Listar Professores</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#menuAluno" data-parent="#fechaMenu">
                    <span class="nav-link-text">Alunos</span>
                </a>
                <ul class="sidenav-second-level collapse" id="menuAluno">
                    <li>
                        <a href="Menu?acao=cadastrar_aluno">Cadastrar Aluno</a>
                    </li>
                    <li>
                        <a href="Menu?acao=alterar_aluno">Editar Cadastro</a>
                    </li>
                    <li>
                        <a href="Menu?acao=listar_aluno">Listar Alunos</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
                <a class="nav-link" href="Menu?acao=dados_pessoais">
                    <span class="nav-link-text">Dados Pessoais</span>
                </a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" style="cursor: auto;">Bem-vindo, ${usuarioLogado.nome}!</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Sair</a>
            </li>
        </ul>
    </div>
</nav>
