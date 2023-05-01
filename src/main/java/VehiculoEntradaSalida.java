import java.util.Date;

public class VehiculoEntradaSalida {


    private Vehiculo vehiculo;
    private String fecha;
    private String horaIngreso;
    private String horaSalida;
    private double importe;

    public VehiculoEntradaSalida(Vehiculo vehiculo,String fecha, String horaIngreso) {

        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
    }

    public VehiculoEntradaSalida(Vehiculo vehiculo, String fecha, String horaIngreso, String horaSalida, double importe) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.importe = importe;

    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        horaSalida = horaSalida;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String toStringVehiculoIngresado() {
        return  " idVehiculo=" + vehiculo.getIdVehiculo() +
                " Matricula=" + vehiculo.getNumeroMatricula() +
                " Propietario=" + vehiculo.getPropietario() +
                " tipoVehiculo=" + vehiculo.getTipoVehiculo() +
                " horaIngreso=" + horaIngreso;
    }

    @Override
    public String toString() {
        return  "vehiculo=" + vehiculo +
                ", fecha='" + fecha + '\'' +
                ", horaIngreso='" + horaIngreso + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", importe=" + importe;
    }
}
