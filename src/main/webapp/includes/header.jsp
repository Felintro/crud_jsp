<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String nomeUsuario = (String) session.getAttribute("username");
%>

<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
          crossorigin="anonymous">

    <title>Cadastro de Despesas</title>
</head>

<body class="bg-dark text-light">

    <div class="container">
        <div class="jumbotron bg-danger">
            <h1>Cadastro de despesas!</h1>
            <p>Exemplo de CRUD com JSP</p>
            <% if(nomeUsuario != null) { %>
            <p class="text-right">Usuário logado: <%= nomeUsuario %></p>
            <% } %>
        </div>

