import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static  Abonados listaAbonados = new Abonados();
    public static HistorialDeAparcamientos listaAparcamientos = new HistorialDeAparcamientos();

    public static  ArrayList<Vehiculo> vehiculosIgresados= new ArrayList<>();

    public static void menu() {

        boolean continueExecution=true;
        int option;
        while(continueExecution) {
            menuHeader();
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: {
                    darDeAltaVehiculo();
                    break;
                }
                case 2: {
                    registrarEntradaVehiculo();
                    break;
                }
                case 3: {
                    registrarSalidaVehiculo();
                    break;
                }
                case 4: {
                    System.out.println("-----Aun no implementado-----");
                    break;
                }
                case 5: {
                    mostrarUltimoMovimiento();
                    break;
                }
                case 6: {
                    mostrarMovimientoPorfecha();
                    break;
                }

                case 7: {
                    mostrarMovimientoPorMes();
                    break;
                }

                case 8: {
                    mostrarMovimientoPorPropietario();
                    break;
                }

                case 0: {
                    continueExecution=false;
                    sc.close();
                }
            }
        }
    }
    public static void menuHeader() {
        System.out.println("Escoge una opcion: ");
        System.out.println("1: Dar de alta un vehiculo");
        System.out.println("2: Registrar la entrada de un vehículo");
        System.out.println("3: Registrar la salida de un vehículo");
        System.out.println("4: Calcular importe de la tarifa.");
        System.out.println("5: Consultar la última entrada de un vehículo.");
        System.out.println("6: Mostrar las entradas/salidas según fecha");
        System.out.println("7: Mostrar entradas/salidas de un vehículo hechas en un determinado mes.");
        System.out.println("8: Mostrar entradas/salidas de un propietario");
        System.out.println("9: Generar informe");

    }

    public static void darDeAltaVehiculo() {

        System.out.println("Ingrese nro matricula");
        String matricula=sc.nextLine();
        System.out.println("Ingrese nombre del propietario");
        String propietario=sc.nextLine();
        System.out.println("Es residente: Y/N");
        String esResidente=sc.nextLine();
        boolean residente=false;

        if(esResidente.equalsIgnoreCase("Y")){
            residente=true;
        }

        System.out.println("tipo de vehiculo: L/M/N");
        String tipoVehiculo=sc.nextLine();

        Vehiculo vehiculo = new Vehiculo(matricula,propietario,residente,tipoVehiculo);
        listaAbonados.agregarVehiculo(vehiculo);

    }

    public static void registrarEntradaVehiculo() {
        System.out.println("Vehiculos Registrados");
        listarVehiculosAbonados();

        System.out.println("Ingrese id vehiculo a ingresar");
        int idVehiculo=Integer.parseInt(sc.nextLine());

        Vehiculo vehiculoObtenido = listaAbonados.obtenerVehiculoPorId(idVehiculo);

        if(listaAbonados.getVehiculosRegistrados().contains(vehiculoObtenido) &&
                !listaAparcamientos.getListaVehiculosIngresados().contains(listaAparcamientos.obtenerVehiculoIngresadoPorId(idVehiculo))){

            LocalDate fecha = LocalDate.now();
            LocalTime horaIngreso = LocalTime.now();

            VehiculoEntradaSalida vehiculo = new VehiculoEntradaSalida(vehiculoObtenido,fecha.toString(),horaIngreso.toString());

            listaAparcamientos.agregarVehiculoListaVehIngresados(vehiculo);

            listaAparcamientos.listarVehiculosIngresados();
        }else {
            System.out.println("Vehiculo no ha sido registrado");
        }
    }

    public static void registrarSalidaVehiculo() {

        System.out.println("Vehiculos Ingresados");
        listaAparcamientos.listarVehiculosIngresados();



        System.out.println("Ingrese id vehiculo a salir");
        int idVehiculo=Integer.parseInt(sc.nextLine());

        VehiculoEntradaSalida vehiculoEntradaSalida = listaAparcamientos.obtenerVehiculoIngresadoPorId(idVehiculo);

        if(listaAparcamientos.getListaVehiculosIngresados().contains(vehiculoEntradaSalida)){

            //obteniendo hora ingreso
            String horaIngresoStr = listaAparcamientos.obtenerHoraIngresoVehiculoPorId(idVehiculo);
            LocalTime horaIngreso = LocalTime.parse(horaIngresoStr);

            //Obteniendo hora salida
            //String horaSalidaStr = "02:23:20";
            //LocalTime horaSalida = LocalTime.parse(horaSalidaStr);
            LocalTime horaSalida = LocalTime.now();

            //Obteniendo total horas para calcular importeTarifa
            Duration duracion = Duration.between(horaIngreso, horaSalida);
            long diferenciaEnMinutos = duracion.toMinutes();
            long diferenciaEnHoras = duracion.toHours();
            long horas = 0l;

            if(diferenciaEnMinutos<15){
                horas = diferenciaEnHoras;
            }else{
                horas = diferenciaEnHoras+1l;
            }

            //obteniendo fecha

            LocalDate fecha = LocalDate.now();

            //Obteniendo tipo de vehiculo
            String tipoVehiculo= listaAparcamientos.obtenerTipoVehiculoPorId(idVehiculo);

            //Obteniendo si es residente
            boolean esResidente= listaAparcamientos.obtenerResidentePorId(idVehiculo);
            double importeTarifa = calcularImporteTarifa(tipoVehiculo,horas,esResidente);

            //obteniendo Vehiculo
            Vehiculo vehiculoObtenido = listaAbonados.obtenerVehiculoPorId(idVehiculo);
            VehiculoEntradaSalida vehiculo = new VehiculoEntradaSalida(vehiculoObtenido,fecha.toString(),horaIngreso.toString()
                    ,horaSalida.toString(),importeTarifa);

            listaAparcamientos.agregarVehiculoListaVehsalidos(vehiculo);
            listaAparcamientos.eliminarVehiculosDeListaIgresados(idVehiculo);
            listaAparcamientos.agregarVehiculoAlHistorial(vehiculo);

            System.out.println("Vehiculos Ingresados:");
            listaAparcamientos.listarVehiculosIngresados();
            System.out.println("");
            System.out.println("Vehiculos salidos:");
            listaAparcamientos.listarVehiculosSalidos();
            System.out.println("");

        }else{
            System.out.println("Vehiculo no ha sido ingresado ...");
        }

    }

    public static void mostrarMovimientoPorfecha(){

        System.out.println("Ingrese la fecha a consultar yyyy-mm-dd");
        String fecha=sc.nextLine();

        //obteniendo las fechas que coinciden agregando a una lista
        ArrayList<VehiculoEntradaSalida> vehiculosObtenidos = listaAparcamientos.obtenerVehiculoPorfecha(fecha);
        //Imprimiendo la lista obtenida
        vehiculosObtenidos.stream().forEach(System.out::println);

    }

    public static void mostrarMovimientoPorMes(){
        System.out.println("Ingrese numero de mes a consultar");
        int mes=Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la matricula a consultar");
        String numeroMatricula=sc.nextLine();

        //obteniendo fecha por numero de matricula y agregando a una lista
        ArrayList<VehiculoEntradaSalida> vehiculosObtenidos = listaAparcamientos.obtenerVehiculoPorMatricula(numeroMatricula);
        //Imprimiendo la lista obtenida
        vehiculosObtenidos.stream().forEach(System.out::println);

    }

    public static void mostrarMovimientoPorPropietario(){

        System.out.println("Ingrese nombre de propietario a consultar");
        String propietario=sc.nextLine();

        //obteniendo fecha por numero de matricula y agregando a una lista
        ArrayList<VehiculoEntradaSalida> vehiculosObtenidos = listaAparcamientos.obtenerVehiculoPorPropietario(propietario);
        //Imprimiendo la lista obtenida
        vehiculosObtenidos.stream().forEach(System.out::println);

    }

    public static void mostrarUltimoMovimiento(){

        System.out.println("Ingrese matricula a consultar");
        String matricula=sc.nextLine();

        //obteniendo ultimo registro de la lista por matricula
        ArrayList<VehiculoEntradaSalida> vehiculosObtenidos = listaAparcamientos.obtenerVehiculoPorMatricula(matricula);
        //Guardando en una variable
        VehiculoEntradaSalida vehiculoObtenido = vehiculosObtenidos.get(vehiculosObtenidos.size()-1);
        System.out.println("Ultimo registro de vehiculo: " + vehiculoObtenido.getVehiculo().getNumeroMatricula());
        System.out.println(vehiculoObtenido);


    }

    public static void listarVehiculosAbonados(){
        listaAbonados.listarVehiculosRegistrados();
    }

    public static double calcularImporteTarifa(String tipovehiculo, long horas, boolean esResidente){

        double tarifaBruta=3.5;
        double importe=0;

        switch (tipovehiculo){
            case "L":
                importe = horas * (tarifaBruta*0.01+tarifaBruta);
                break;
            case "M":
                importe = horas * (tarifaBruta*0.015+tarifaBruta);
                break;
            case "N":
                importe = horas * (tarifaBruta*0.020+tarifaBruta);
                break;
        }

        return importe;
    }

}
