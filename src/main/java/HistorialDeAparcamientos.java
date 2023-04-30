import java.util.ArrayList;
import java.util.List;

public class HistorialDeAparcamientos {

    private List<VehiculoEntradaSalida> listaVehiculosIngresados;
    private List<VehiculoEntradaSalida> listaVehiculosSalidos;
    private List<VehiculoEntradaSalida> historialAparcamientos;

    public HistorialDeAparcamientos() {
        listaVehiculosIngresados = new ArrayList<VehiculoEntradaSalida>();
        listaVehiculosSalidos = new ArrayList<VehiculoEntradaSalida>();
        historialAparcamientos = new ArrayList<VehiculoEntradaSalida>();
    }

    public void agregarVehiculoListaVehIngresados(VehiculoEntradaSalida ticket){
        this.listaVehiculosIngresados.add(ticket);
    }

    public void agregarVehiculoListaVehsalidos(VehiculoEntradaSalida ticket){
        this.listaVehiculosSalidos.add(ticket);
    }

    public void agregarVehiculoAlHistorial(VehiculoEntradaSalida ticket){
        this.historialAparcamientos.add(ticket);
    }


    public VehiculoEntradaSalida obtenerVehiculoIngresadoPorId(int id){

        VehiculoEntradaSalida vehiculo = null;

        for (VehiculoEntradaSalida v : this.listaVehiculosIngresados) {
            if(v.getVehiculo().getIdVehiculo()==id){
                vehiculo = v;
            }
        }
        return vehiculo;
    }

    public String obtenerHoraIngresoVehiculoPorId(int id){
        String horaIngreso = "";
        for (VehiculoEntradaSalida vehiculo : this.listaVehiculosIngresados) {
            if(vehiculo.getVehiculo().getIdVehiculo()==id){
                horaIngreso = vehiculo.getHoraIngreso();
            }
        }
        return horaIngreso;

    }

    // Elimina vehiculos del ArrayLis<VehiculosEntradaSalida>
    public void eliminarVehiculosDeListaIgresados(int id){
        VehiculoEntradaSalida v = null;
        for (VehiculoEntradaSalida vehiculo : this.listaVehiculosIngresados) {
            if(vehiculo.getVehiculo().getIdVehiculo()==id){
                 v = vehiculo;
            }
        }
        listaVehiculosIngresados.remove(v);
    }

    public String obtenerTipoVehiculoPorId(int id){

        String tipo = "";

        for (VehiculoEntradaSalida vehiculo : this.listaVehiculosIngresados) {
            if(vehiculo.getVehiculo().getIdVehiculo()==id){
                tipo = vehiculo.getVehiculo().getTipoVehiculo();
            }
        }
        return tipo;

    }

    public boolean obtenerResidentePorId(int id){

        boolean tipo = false;

        for (VehiculoEntradaSalida vehiculo : this.listaVehiculosIngresados) {
            if(vehiculo.getVehiculo().getIdVehiculo()==id){
                tipo = vehiculo.getVehiculo().isResidente();
            }
        }
        return tipo;

    }

    public void listarVehiculosIngresados(){
        for (VehiculoEntradaSalida vehiculos : this.listaVehiculosIngresados) {
            System.out.println(vehiculos.toStringVehiculoIngresado());
        };
    }

    public void listarVehiculosSalidos(){
        for (VehiculoEntradaSalida vehiculos : this.listaVehiculosSalidos) {
            System.out.println(vehiculos);
        };
    }

    public List<VehiculoEntradaSalida> getListaVehiculosIngresados() {
        return listaVehiculosIngresados;
    }

    public void setListaVehiculosIngresados(List<VehiculoEntradaSalida> listaVehiculosIngresados) {
        this.listaVehiculosIngresados = listaVehiculosIngresados;
    }

    public List<VehiculoEntradaSalida> getListaVehiculosSalidos() {
        return listaVehiculosSalidos;
    }

    public void setListaVehiculosSalidos(List<VehiculoEntradaSalida> listaVehiculosSalidos) {
        this.listaVehiculosSalidos = listaVehiculosSalidos;
    }

    public List<VehiculoEntradaSalida> getHistorialAparcamientos() {
        return historialAparcamientos;
    }

    public void setHistorialAparcamientos(List<VehiculoEntradaSalida> historialAparcamientos) {
        this.historialAparcamientos = historialAparcamientos;
    }

    @Override
    public String toString() {
        return "HistorialDeAparcamientos{" +
                "listaVehiculosIngresados=" + listaVehiculosIngresados +
                ", listaVehiculosSalidos=" + listaVehiculosSalidos +
                ", historialAparcamientos=" + historialAparcamientos +
                '}';
    }
}
