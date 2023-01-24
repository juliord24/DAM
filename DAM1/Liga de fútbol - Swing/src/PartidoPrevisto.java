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
        return "<html><body><br>Partido " + numero + ":<br>Equipo local: " + getEquipoLocal().getNombre() + " || Equipo visitante: " + getEquipoVisitante().getNombre() + "<br>El " + getFecha() + " a las " + getHora() + "<br>";
    }

    

}
