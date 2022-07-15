<div class="modal fade" id="agregarDisciplinaModal" tabindex="-1" aria-labelledby="agregarDisciplinaModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Disciplina</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="deporte">Deporte</label>
                        <input type="text" class="form-control" name="deporte" required="">
                    </div>
                    <div class="form-group">
                        <label for="dia">Dia</label>
                        <input type="text" class="form-control" name="dia">
                    </div>
                    <div class="form-group">
                        <label for="maximo">Maximo</label>
                        <input type="number" class="form-control" name="maximo" required="">
                    </div>
                    <div class="form-group">
                        <label for="valorCuota">Valor de la Cuota</label>
                        <input type="number" class="form-control" name="valorCuota" required="">
                    </div>
                    <div class="form-group">
                        <label for="inscriptos">Cantidad de Inscriptos</label>
                        <input type="number" class="form-control" name="inscriptos" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
