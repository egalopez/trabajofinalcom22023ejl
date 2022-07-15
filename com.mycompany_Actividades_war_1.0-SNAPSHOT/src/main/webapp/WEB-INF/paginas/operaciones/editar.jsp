<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Disciplina</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idLibro=${disciplina.idActividad}" method="POST" class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavEdicion.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Disciplina</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="deporte">Deporte</label>
                                        <input type="text" class="form-control" name="deporte" required="" value="${disciplina.deporte}">
                                    </div>
                                    <div class="form-group">
                                        <label for="dia">Dia</label>
                                        <input type="text" class="form-control" name="dia" value="${disciplina.dia}">
                                    </div>
                                    <div class="form-group">
                                        <label for="maximo">Maximo</label>
                                        <input type="number" class="form-control" name="maximo" required="" value="${disciplina.maximo}">
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Valor de la Cuota</label>
                                        <input type="currency" class="form-control" name="valorCuota" required="" value="${disciplina.valorCuota}">
                                    </div>
                                    <div class="form-group">
                                        <label for="copias">Cantidad de Inscriptos</label>
                                        <input type="number" class="form-control" name="inscriptos" required="" value="${disciplina.inscriptos}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
