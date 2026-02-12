import java.time.LocalDate;

/**
 * Clase de objetos de tipo Tarea
 * @author Miguel Abadía
 * @version 1,0
 */
public class Tarea {
    //el id que reciben las instancias. va aumentando segun se usa
    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    private LocalDate fechaCreacion;

    /**
     * constructor1. asigna el titulo y descripcion recibido y asume el resto de datos
     * @param titulo
     * @param descripcion
     * @throws TareaInvalidaException
     */
    public Tarea(String titulo, String descripcion) throws TareaInvalidaException {
        setTitulo(titulo);
        setDescripcion(descripcion);
        this.completada = false;
        this.fechaCreacion = LocalDate.now();
        this.id = contadorId++; //al final para que no haga ++ si algo da error y no se crea el objeto
    }

    /**
     * constructor2. asigna el titulo, descripcion y fechaCreacion. asume el resto de datos
     * @param titulo
     * @param descripcion
     * @param fechaCreacion
     * @throws TareaInvalidaException
     */
    public Tarea(String titulo, String descripcion, LocalDate fechaCreacion) throws TareaInvalidaException {
        setTitulo(titulo);
        setDescripcion(descripcion);
        this.completada = false;
        setFechaCreacion(fechaCreacion);
        this.id = contadorId++; //al final para que no haga ++ si algo da error y no se crea el objeto
    }

    public static int getContadorId() {
        return contadorId;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * chequea que el titulo no esté vacío y si lo está lanza un error
     * @param titulo
     * @throws TareaInvalidaException
     */
    public void setTitulo(String titulo) throws TareaInvalidaException {
        if (titulo.trim().isEmpty()){
            throw new TareaInvalidaException("ERROR: Debe haber un titulo para la tarea");
        }else {
            this.titulo = titulo;
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    public void marcarPendiente() {
        this.completada = false;
    }

    /**
     * chequea que la fecha no sea futura y lanza un error en caso de serlo
     * @param fechaCreacion
     * @throws TareaInvalidaException
     */
    public void setFechaCreacion(LocalDate fechaCreacion) throws TareaInvalidaException {
        if (fechaCreacion.isAfter(LocalDate.now())) {
            throw new TareaInvalidaException("La fecha no puede ser futura");
        }
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * un toString modificado
     * @return
     */
    public String mostrarInfo(){
        return "*TAREA id:" + this.id + "*" +
                "\nTitulo: " + this.titulo +
                "\nDescripcion: " + this.descripcion +
                "\nFecha creacion: " + this.fechaCreacion +
                "\nCompletada: " + this.completada + "\n";
    }
}
