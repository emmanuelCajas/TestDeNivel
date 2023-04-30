public class Vehiculo {

    private static int nextId = 1;

    private int idVehiculo;
    private String NumeroMatricula;
    private String propietario;
    private boolean residente;
    private String tipoVehiculo;

    public Vehiculo() {
    }

    public Vehiculo( String numeroMatricula, String propietario, boolean residente, String tipoVehiculo) {
        this.idVehiculo = nextId;
        this.NumeroMatricula = numeroMatricula;
        this.propietario=propietario;
        this.residente = residente;
        this.tipoVehiculo = tipoVehiculo;
        nextId++;

    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public String getNumeroMatricula() {
        return NumeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        NumeroMatricula = numeroMatricula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public boolean isResidente() {
        return residente;
    }

    public void setResidente(boolean residente) {
        this.residente = residente;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String toString() {
        return "idVehiculo=" + idVehiculo +
                " NumeroMatricula='" + NumeroMatricula + '\'' +
                " propietario='" + propietario + '\'' +
                " residente=" + residente +
                " tipoVehiculo='" + tipoVehiculo;
    }
}
