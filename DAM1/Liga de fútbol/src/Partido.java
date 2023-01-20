import java.time.LocalDate;
import java.time.LocalTime;

public class Partido {
    public int numero;
    public static int contadorPartidos;
    private LocalDate fecha;
    private LocalTime hora;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    public Partido(){
    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha, LocalTime hora) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.hora = hora;
        equipoLocal.getNombre();
        equipoVisitante.getNombre();
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
