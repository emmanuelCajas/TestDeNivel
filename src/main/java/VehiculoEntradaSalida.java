import java.util.Date;

public class VehiculoEntradaSalida {


    private Vehiculo vehiculo;
    private String horaIngreso;
    private String HoraSalida;
    private double importe;

    public VehiculoEntradaSalida(Vehiculo vehiculo, String horaIngreso) {
        this.vehiculo = vehiculo;
        this.horaIngreso = horaIngreso;
    }

    public VehiculoEntradaSalida(Vehiculo vehiculo, String horaIngreso, String horaSalida, double importe) {
        this.vehiculo = vehiculo;
        this.horaIngreso = horaIngreso;
        HoraSalida = horaSalida;
        this.importe = importe;

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
        return HoraSalida;
    }

    public void setHoraSalida(String horaSalida) {
        HoraSalida = horaSalida;
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
        return  " idVehiculo=" + vehiculo.getIdVehiculo() +
                " Matricula=" + vehiculo.getNumeroMatricula() +
                " Propietario=" + vehiculo.getPropietario() +
                " tipoVehiculo=" + vehiculo.getTipoVehiculo() +
                " horaIngreso=" + horaIngreso +
                " HoraSalida=" + HoraSalida +
                " importe=" + importe;
    }
}
