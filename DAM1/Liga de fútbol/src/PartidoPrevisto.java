import java.time.LocalDate;
import java.time.LocalTime;

public class PartidoPrevisto extends Partido {
    
    public PartidoPrevisto(){

    }

    public PartidoPrevisto(Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha, LocalTime hora) {
        super(equipoLocal, equipoVisitante, fecha, hora);
    }

    @Override
    public String toString() {
        return "Partido " + numero + ":\nEquipo local: " + getEquipoLocal().getNombre() + " || Equipo visitante: " + getEquipoVisitante().getNombre() + "\nEl " + getFecha() + " a las " + getHora() + "\n";
    }

    

}
