import java.util.ArrayList;
import java.util.List;

public class Abonados {

    private List<Vehiculo> vehiculosRegistrados;



    public Abonados() {
        vehiculosRegistrados = new ArrayList<Vehiculo>();
    }

    public List<Vehiculo> getVehiculosRegistrados() {
        return vehiculosRegistrados;
    }

    public void setVehiculosRegistrados(List<Vehiculo> vehiculosRegistrados) {
        this.vehiculosRegistrados = vehiculosRegistrados;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculosRegistrados.add(vehiculo);
    }

    public Vehiculo obtenerVehiculoPorId(int id){

        Vehiculo vehiculo = null;
        for (Vehiculo v : this.vehiculosRegistrados) {
            if(v.getIdVehiculo()==id){
                vehiculo = v;
            }
        }
        return vehiculo;
    }


    public void listarVehiculosRegistrados(){
        for (Vehiculo vehiculos : this.vehiculosRegistrados) {
            System.out.println(vehiculos);
        };
    }

    @Override
    public String toString() {
        return  "Abonados{" +
                ", vehiculosRegistrados=" + vehiculosRegistrados +
                '}';
    }
}
