package model;

public class ActividadesClub {
    private int idActividad;
    private String deporte;
    private String dia;
    private int maximo;
    private double valorCuota;
    private int inscriptos;

    public ActividadesClub(int idActividad, String deporte, String dia, int maximo, double valorCuota, int inscriptos) {
        this.idActividad = idActividad;
        this.deporte = deporte;
        this.dia = dia;
        this.maximo = maximo;
        this.valorCuota = valorCuota;
        this.inscriptos = inscriptos;
    }

    public ActividadesClub(String deporte, String dia, int maximo, double valorCuota, int inscriptos) {
        this.deporte = deporte;
        this.dia = dia;
        this.maximo = maximo;
        this.valorCuota = valorCuota;
        this.inscriptos = inscriptos;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String nombre) {
        this.deporte = deporte;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String autor) {
        this.dia = autor;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public int getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(int inscriptos) {
        this.inscriptos = inscriptos;
    }

    @Override
    public String toString() {
        return "Disciplina" + "deporte=" + deporte + ", dia=" + dia + ", maximo=" + maximo + ", valorCuota=" + valorCuota + ", inscriptos=" + inscriptos + '}';
    }

      
}
