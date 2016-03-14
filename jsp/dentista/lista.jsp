<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@include file="../../../jspf/cabecalho.jspf"%>  
        <script type="text/javascript" src="<c:url value="/google/js/jquery.js"/>"></script> 
        <script type="text/javascript" src="<c:url value="/google/js/jquery-ui.min.js"/>"></script> 
        <script type="text/javascript" src="<c:url value="/bt/js/bootstrap.min.js"/>"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script type="text/javascript" src="<c:url value="/bt/js/holder.min.js"/>"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script type="text/javascript" src="<c:url value="/bt/js/ie10-viewport-bug-workaround.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.validate.js" />"  charset="ISO-8859-1"></script>
        <script type="text/javascript" src="<c:url value="/js/util.js"/>"></script>
    </head>
    <body>
        <!-- Inicio Menu Superior -->
        <%@include file="../../../jspf/menu_superior.jspf"%>
        <!-- Fim menu -->
        <div class="container-fluid">
            <div class="row">
                <!--  Principal -->
                <div class="main">
                    <h4 class="page-header">Lista de Dentistas</h4>     
                    <div id="main" class="container-fluid">
                        <div id="top" class="row">
                            <div class="col-md-3">
                                <h2>Itens</h2>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group h2">
                                    <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Itens">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="submit">
                                            <span class="glyphicon glyphicon-search"></span>
                                        </button>
                                    </span>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <!-- Button trigger modal -->
                                <a href="<c:url value="/dentista/novo"/>" class="btn btn-primary pull-right h2">Novo</a>
                            </div>
                        </div> <!-- /#top -->
                        <hr />
                        <div id="list" class="row">
                            <div class="table-responsive col-md-12">
                                <display:table id="dentista" name="${dentistas}"  class="table table-bordered table-condensed table-hover table-striped" requestURI="lista" pagesize="5">                                    
                                    <display:column property="nome" title="Nome" sortable="false"/>
                                   
                                    <display:column title="Ação" class="actions" sortable="false">
                                        <a class="btn btn-success btn-xs" href="view.html">Visualizar</a>
                                        <a class="btn btn-warning btn-xs" href="<c:url value="edita?cod=${dentista.cod}"/>" >Alterar</a>
                                    </display:column>
                                </display:table>
                            </div>
                        </div> <!-- /#list -->
                        <div id="bottom" class="row">
                        </div> <!-- /#bottom -->
                    </div>  <!-- /#main -->
                </div>
                <!-- Fim Principal -->
            </div>
        </div>
        <!-- Rodapé -->
        <footer class="footer">
            <div class="container">
                <%@include file="../../../jspf/rodape.jspf"%>
            </div>
        </footer><!-- Fim Rodapé -->
    </body>
</html>
