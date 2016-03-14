<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@include file="../../../jspf/cabecalho.jspf"%>
        <script type="text/javascript" src="<c:url value="/google/js/jquery.js"/>"></script> 
        <script type="text/javascript" src="<c:url value="/google/js/jquery-ui.min.js"/>"></script> 
       
    </head>
    <body>
        <!-- Inicio Menu Superior -->
        <%@include file="../../../jspf/menu_superior.jspf"%>
        <!-- Fim menu -->
        <div class="container-fluid">
            <div class="row">
                <!--  Principal -->
                <div class="main">
                    <h3 class="page-header">Adicionar</h3>   
                    <%@include file="formAdd.jsp" %>
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
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="<c:url value="/bt/js/jquery.min.js"/>"><\/script>');</script>
        <script type="text/javascript" src="<c:url value="/bt/js/bootstrap.min.js"/>"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script type="text/javascript" src="<c:url value="/bt/js/holder.min.js"/>"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script type="text/javascript" src="<c:url value="/bt/js/ie10-viewport-bug-workaround.js"/>"></script>
    </body>
</html>
