<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="libros">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Disciplinas</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Deporte</th>
                                <th>Dia</th>
                                <th>Maximo</th>
                                <th>Valor de Cuota</th>
                                <th>Inscriptos</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="disciplina" items="${disciplinas}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${disciplina.deporte}</td>
                                    <td>${disciplina.dia}</td>
                                    <td>${disciplina.maximo}</td>
                                    <td><fmt:formatNumber value="${disciplina.valorCuota}" type="currency"/></td>
                                    <td>${disciplina.inscriptos}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idlibro=${disciplina.idActividad}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de Inscriptos</h3>
                        <h4 class="display-4">${cantidad}</h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3> Total </h3>
                        <h4 class="display-4"><fmt:formatNumber value="${precioTotal}" type="currency"/></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarLibro.jsp"/>