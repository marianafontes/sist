<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form name="formAddDentista"  id="formAddDentista" action="<c:url value="/dentista/adiciona"/>" method="post">
    <input type="hidden" name="dentista.cod" id="dentistaCod" class="id" value="${dentista.cod}">
 <input type="hidden" name="dentista.especialidades.cod" id="dentistaEspCod" class="id" value="${dentista.especialidades.cod}">

    <div class="row">
        <div class="form-group col-md-3">
          <input type="text" name="dentista.nome" id="dentistaNome" class="id" value="${dentista.nome}">  
        </div>
        <div class="form-group col-md-3">
            <label for="especialidades">Especialidade</label>
            <select class="form-control" id="especialidades" multiple name="dentista.especialidades[].cod">
                <option value="1">Especialidade 1</option>
                <option value="2" >Especialidade 2</option>
            </select>
        </div>
    </div>
    <hr />
    <div id="actions" class="row pull-right">
        <div class="col-md-12">
            <a class="btn btn-default" href="<c:url value="/dentista/lista"/>">Cancelar</a>
            <button type="submit" class="btn btn-primary">Salvar</button>            
        </div>
    </div>
</form>
