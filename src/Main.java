import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Miguel Abadía
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //creacion variables
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarea> tareas = new ArrayList<>();

        try {
            tareas.add(new Tarea("Tirar la basura", "Recoger la bolsa de basura, ir a la calle," +
                    " buscar un contenedor y arrojar la bolsa.", LocalDate.now().minusDays(1)));
            tareas.add(new Tarea("Pasear al perro", "Buscar la correa, amarrar al perro, salir" +
                    " a la calle, recoger sus heces dar una vuelta y volver a casa.",
                    LocalDate.now().minusDays(2)));
            tareas.add(new Tarea("Hacer la colada", "Amontonar toda la ropa sucia, separarla por" +
                    " colores, programar la lavadora para cada grupo, esperar a que termine y tender la ropa.",
                    LocalDate.now().minusDays(3)));
            tareas.add(new Tarea("Lavar el coche", "Ir al garaje, coger el coche, ir al lavadero" +
                    "pagar un euro, encender el aspersor y lavar el coche con los distintos modos.",
                    LocalDate.now().minusDays(4)));
        }catch (TareaInvalidaException e){
            System.err.println(e.getMessage());
        }

        tareas.get(2).marcarCompletada(); //se marca una de ellas como completada(por default no lo estan)

        //llamada al menu
        menuOpciones(sc, tareas);
    }

    /**
     * menu de opciones recurrente para interactuar con el listado de colecciones
     * @param sc
     * @param tareas listado de colecciones
     */
    public static void menuOpciones(Scanner sc, ArrayList<Tarea> tareas) {
        boolean salida = false;
        int eleccion;

        do {
            System.out.println("***MENÚ DE OPCIONES***");
            System.out.println("1. Crear Tarea");
            System.out.println("2. Listar todas las tareas");
            System.out.println("3. Listar tareas pendientes");
            System.out.println("4. Listar tareas completadas");
            System.out.println("5. Buscar tarea por ID");
            System.out.println("6. Marcar tarea como completada");
            System.out.println("7. Marcar tarea como pendiente");
            System.out.println("8. Eliminar tarea");
            System.out.println("9. Salir");
            eleccion = leerInt(sc);

            switch (eleccion) {
                case 1:
                    opcionCrearTarea(sc, tareas);
                    break;
                case 2:
                    listarTareas(tareas);
                    break;
                case 3:
                    listarTareasPendientes(tareas);
                    break;
                case 4:
                    listarTareasCompletadas(tareas);
                    break;
                case 5:
                    buscarTareaPorID(sc, tareas);
                    break;
                case 6:
                    marcarTareaCompletada(sc, tareas);
                    break;
                case 7:
                    marcarTareaPendiente(sc, tareas);
                    break;
                case 8:
                    eliminarTarea(sc, tareas);
                    break;
                case 9:
                    salida = true;
                    break;
                default:
                    System.out.println("Elige una opcion real");
                    break;
            }
        }while (!salida);
    }

    /**
     * metodo auxiliar para leer enteros seguros por consola
     * @param sc
     * @return el entero recibido
     */
    public static int leerInt(Scanner sc) {
        int numero = 0;
        boolean flag = false;
        do {
            try {
                numero = sc.nextInt();
                sc.nextLine();
                flag = true;
            }catch (InputMismatchException e){
                sc.nextLine();
                System.err.println("Error: Introduce un entero.");
            }
        }while (!flag);
        return numero;
    }

    /**
     * metodo que se ejecuta al elegir la opcion Crear Tarea. No crea la tarea, recibe datos y llama
     * a crear tarea
     * @param sc
     * @param tareas
     */
    public static void opcionCrearTarea(Scanner sc, ArrayList<Tarea> tareas) {
        System.out.println("*Crear Tarea*");
        System.out.println("Introduce el titulo");
        String titulo = sc.nextLine();
        System.out.println("Introduce el descripcion");
        String descripcion = sc.nextLine();
        try {
            tareas.add(crearTarea(titulo, descripcion));
            System.out.println("Tarea agregada");
        }catch (TareaInvalidaException e){
            System.err.println(e.getMessage());
        }

    }

    /**
     * metodo para crear tareas con los datos recibidos por parametro
     * @param titulo
     * @param descripcion
     * @return la tarea creada
     * @throws TareaInvalidaException
     */
    public static Tarea crearTarea(String titulo, String descripcion) throws TareaInvalidaException {
        return new Tarea(titulo, descripcion);
    }

    /**
     * llama al mostrarInfo() de todas las tareas del array recibido
     * @param tareas
     */
    public static void listarTareas(ArrayList<Tarea> tareas) {
        System.out.println("*Listado de tareas*");
        for (Tarea tarea : tareas) {
            System.out.println(tarea.mostrarInfo());
        }
    }

    /**
     * llama al mostrarInfo() de las tareas con completada==false del array recibido
     * @param tareas
     */
    public static void listarTareasPendientes(ArrayList<Tarea> tareas) {
        System.out.println("*Listado de tareas pendientes*");
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletada()){
                System.out.println(tarea.mostrarInfo());
            }
        }
    }

    /**
     * llama al mostrarInfo() de las tareas con completada==true del array recibido
     * @param tareas
     */
    public static void listarTareasCompletadas(ArrayList<Tarea> tareas) {
        System.out.println("*Listado de tareas completadas*");
        for (Tarea tarea : tareas) {
            if (tarea.isCompletada()){
                System.out.println(tarea.mostrarInfo());
            }
        }
    }

    /**
     * pide un id por consola y recorre la lista de tareas hasta encontrar la que tiene ese id.
     * luego llama al mostrarInfo de esta tarea.
     * @param sc
     * @param tareas
     */
    public static void buscarTareaPorID(Scanner sc, ArrayList<Tarea> tareas) {
        boolean flag = false;

        System.out.println("*Buscar tarea por ID*");
        System.out.println("Introduce el ID");
        int id = leerInt(sc);

        Tarea t = buscarTarea(id, tareas);
        if (t != null){
            System.out.println(t.mostrarInfo());
            flag = true;
        }

        if (!flag) {
            System.err.println("Error: no hay una tarea con ese id");
        }
    }

    /**
     * pide un id por consola y recorre la lista de tareas hasta encontrar la que tiene ese id
     * llama al metodo marcarCompletada de esa tarea
     * @param sc
     * @param tareas
     */
    public static void marcarTareaCompletada(Scanner sc, ArrayList<Tarea> tareas) {
        boolean flag = false;

        System.out.println("*Marcar tarea completada*");
        System.out.println("Introduce el ID");
        int id = leerInt(sc);

        Tarea t = buscarTarea(id, tareas);
        if (t != null){
            t.marcarCompletada();
            flag = true;
        }
        if (!flag) {
            System.err.println("Error: no hay una tarea con ese id");
        }else {
            System.out.println("Tarea marcada como completada");
        }
    }

    /**
     * pide un id por consola y recorre la lista de tareas hasta encontrar la que tiene ese id
     * llama al metodo marcarPendiente de esa tarea
     * @param sc
     * @param tareas
     */
    public static void marcarTareaPendiente(Scanner sc, ArrayList<Tarea> tareas) {
        boolean flag = false;

        System.out.println("*Marcar tarea pendiente*");
        System.out.println("Introduce el ID");
        int id = leerInt(sc);

        Tarea t = buscarTarea(id, tareas);
        if (t != null){
            t.marcarPendiente();
            flag = true;
        }
        if (!flag) {
            System.err.println("Error: no hay una tarea con ese id");
        }else {
            System.out.println("Tarea marcada como pendiente");
        }
    }

    /**
     * pide un id por consola y recorre la lista de tareas hasta encontrar la que tiene ese id
     * la borra de la lista
     * @param sc
     * @param tareas
     */
    public static void eliminarTarea(Scanner sc, ArrayList<Tarea> tareas) {
        System.out.println("*Eliminar tarea*");
        System.out.println("Introduce el ID");
        int id = leerInt(sc);
        if (tareas.removeIf(t -> t.getId() == id)) { //la intenta borrar con una lambda
            System.out.println("Tarea eliminada.");
        }else {
            System.err.println("Error: no hay una tarea con ese id");
        }
    }

    /**
     * Busca una tarea por ID y la devuelve (o null si no existe)
     */
    private static Tarea buscarTarea(int id, ArrayList<Tarea> tareas) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}