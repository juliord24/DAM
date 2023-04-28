import java.time.LocalDate;
import java.time.LocalTime;

public class PartidoJugado extends PartidoPrevisto{
    
    private int golesLocal;
    private int golesVisitante;
    private Equipo equipoGanador;
    private Equipo equipoPerdedor;
    
    public PartidoJugado(Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha, LocalTime hora, int golesLocal, int golesVisitante) {
        super(equipoLocal, equipoVisitante, fecha, hora);
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        
    }


    public PartidoJugado() {
        
    }


    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }


    public void setEquipoPerdedor(Equipo equipoPerdedor) {
        this.equipoPerdedor = equipoPerdedor;
    }

    @Override
    public String toString(){
        return getEquipoLocal().getNombre() + "-" +  golesLocal + " || " + getEquipoVisitante().getNombre() + "-" + golesVisitante; 
    }


    public Equipo getEquipoGanador() {
        return equipoGanador;
    }


    public Equipo getEquipoPerdedor() {
        return equipoPerdedor;
    }
    
}
