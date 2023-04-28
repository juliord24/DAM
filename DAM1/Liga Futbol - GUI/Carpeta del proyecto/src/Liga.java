import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Liga {
    
    public ArrayList<Equipo> equipos;
    private ArrayList<PartidoPrevisto> partidosPrevistos;
    private ArrayList<PartidoJugado> partidosJugados;
    public Liga(){
        partidosPrevistos = new ArrayList<>();
        partidosJugados = new ArrayList<>();
        equipos = new Equipo().crearEquipos();
    }
    /* 
     * Los métodos planificar/jugar modifican los ArrayList partidosPrevistos/partidosJugados dependiendo de la fase de tal manera que
     * estos almacenan objetos PartidoPrevisto/PartidoJugado necesarios tanto como para imprimir por pantalla los partidos y sus resultados como para determinar los
     * equipos que pasarán a la siguiente fase.
     */
    public void planificarCuartos(){
        ArrayList<Equipo> equipos = new ArrayList<>();
        for(int i = 0; i < this.equipos.size(); i++){
            equipos.add(this.equipos.get(i));
        }
        Equipo equipoLocal, equipoVisitante;
        for(int i = 0; i< 4; i++){
            equipoLocal = equipos.get(0);
            equipos.remove(0);
            Collections.shuffle(equipos);
            equipoVisitante = equipos.get(0);
            equipos.remove(0);

            int dia = (int) (Math.random() * (31 - 1) + 1);
            int horas = (int) (Math.random() * 24);
            int minutos = (int) (Math.random() * 60);
            LocalDate fecha = LocalDate.of(2023, 7, dia);
            LocalTime hora = LocalTime.of(horas, minutos);

            partidosPrevistos.add(new PartidoPrevisto(equipoLocal, equipoVisitante, fecha, hora));
            partidosPrevistos.get(i).numero = 7 - Partido.contadorPartidos;
            Partido.contadorPartidos++;
        }
    }

    public void jugarCuartos(){
        int golesLocal = 0;
        int golesVisitante = 0;
        boolean repetir = false;
        for(int i=0;i<4;i++){
            golesLocal = (int) (Math.random() * 6);
            golesVisitante = (int) (Math.random() * 6);
            do{
                if (golesLocal > golesVisitante){
                    partidosJugados.add(new PartidoJugado(partidosPrevistos.get(i).getEquipoLocal(), partidosPrevistos.get(i).getEquipoVisitante(),
                    partidosPrevistos.get(i).getFecha(), partidosPrevistos.get(i).getHora(), golesLocal, golesVisitante));
                    partidosJugados.get(i).setEquipoGanador(partidosPrevistos.get(i).getEquipoLocal());
                    partidosJugados.get(i).numero = partidosPrevistos.get(i).numero;
                    repetir = false;
                } else if(golesLocal < golesVisitante){
                    partidosJugados.add(new PartidoJugado(partidosPrevistos.get(i).getEquipoLocal(), partidosPrevistos.get(i).getEquipoVisitante(),
                    partidosPrevistos.get(i).getFecha(), partidosPrevistos.get(i).getHora(), golesLocal, golesVisitante));
                    partidosJugados.get(i).setEquipoGanador(partidosPrevistos.get(i).getEquipoVisitante());
                    partidosJugados.get(i).numero = partidosPrevistos.get(i).numero;
                    repetir = false;
                } else{
                    golesLocal = (int) (Math.random() * 6);
                    golesVisitante = (int) (Math.random() * 6);
                    repetir = true;
                }
            } while(repetir);
        }
    }

    public void planificarSemis(){
        this.equipos.clear();
        partidosPrevistos.clear();
        Equipo equipoLocal, equipoVisitante;
        for (int i = 0; i < 4; i++){
            this.equipos.add(partidosJugados.get(i).getEquipoGanador());
        }
        ArrayList<Equipo> equipos = new ArrayList<>();
        for (int i=0;i<this.equipos.size();i++){
            equipos.add(this.equipos.get(i));
        }
        for(int i = 0; i < 2; i++){
            equipoLocal = equipos.get(0);
            equipos.remove(0);
            Collections.shuffle(equipos);
            equipoVisitante = equipos.get(0);
            equipos.remove(0);

            int dia = (int) (Math.random() * (31 - 1) + 1);
            int horas = (int) (Math.random() * 24);
            int minutos = (int) (Math.random() * 60);
            LocalDate fecha = LocalDate.of(2023, 8, dia);
            LocalTime hora = LocalTime.of(horas, minutos);

            partidosPrevistos.add(new PartidoPrevisto(equipoLocal, equipoVisitante, fecha, hora));
            partidosPrevistos.get(i).numero = 7 - Partido.contadorPartidos;
            Partido.contadorPartidos++;
        }
    }

    public void jugarSemis(){
        int golesLocal = 0;
        int golesVisitante = 0;
        boolean repetir = false;
        partidosJugados.clear();
        for(int i=0;i<2;i++){
            golesLocal = (int) (Math.random() * 6);
            golesVisitante = (int) (Math.random() * 6);
            do{
                if (golesLocal > golesVisitante){
                    partidosJugados.add(new PartidoJugado(partidosPrevistos.get(i).getEquipoLocal(), partidosPrevistos.get(i).getEquipoVisitante(),
                    partidosPrevistos.get(i).getFecha(), partidosPrevistos.get(i).getHora(), golesLocal, golesVisitante));
                    partidosJugados.get(i).setEquipoGanador(partidosPrevistos.get(i).getEquipoLocal());
                    partidosJugados.get(i).numero = partidosPrevistos.get(i).numero;
                    repetir = false;
                } else if(golesLocal < golesVisitante){
                    partidosJugados.add(new PartidoJugado(partidosPrevistos.get(i).getEquipoLocal(), partidosPrevistos.get(i).getEquipoVisitante(),
                    partidosPrevistos.get(i).getFecha(), partidosPrevistos.get(i).getHora(), golesLocal, golesVisitante));
                    partidosJugados.get(i).setEquipoGanador(partidosPrevistos.get(i).getEquipoVisitante());
                    partidosJugados.get(i).numero = partidosPrevistos.get(i).numero;
                    repetir = false;
                } else{
                    golesLocal = (int) (Math.random() * 6);
                    golesVisitante = (int) (Math.random() * 6);
                    repetir = true;
                }
            } while(repetir);
        }
    }

    public void planificarFinal(){
        equipos.clear();
        partidosPrevistos.clear();
        Equipo equipoLocal, equipoVisitante;
        for (int i = 0; i < 2; i++){
            equipos.add(partidosJugados.get(i).getEquipoGanador());
        }
        equipoLocal = equipos.get(0);
        equipoVisitante = equipos.get(1);

        int dia = (int) (Math.random() * (31 - 1) + 1);
        int horas = (int) (Math.random() * 24);
        int minutos = (int) (Math.random() * 60);
        LocalDate fecha = LocalDate.of(2023, 9, dia);
        LocalTime hora = LocalTime.of(horas, minutos);

        partidosPrevistos.add(new PartidoPrevisto(equipoLocal, equipoVisitante, fecha, hora));
        partidosPrevistos.get(0).numero = 7 - Partido.contadorPartidos;
        Partido.contadorPartidos++;
    }

    public void jugarFinal(){
        int golesLocal = 0;
        int golesVisitante = 0;
        boolean repetir = false;
        partidosJugados.clear();
        
        golesLocal = (int) (Math.random() * 6);
        golesVisitante = (int) (Math.random() * 6);
        do{
            if (golesLocal > golesVisitante){
                partidosJugados.add(new PartidoJugado(partidosPrevistos.get(0).getEquipoLocal(), partidosPrevistos.get(0).getEquipoVisitante(),
                partidosPrevistos.get(0).getFecha(), partidosPrevistos.get(0).getHora(), golesLocal, golesVisitante));
                partidosJugados.get(0).setEquipoGanador(partidosPrevistos.get(0).getEquipoLocal());
                partidosJugados.get(0).numero = partidosPrevistos.get(0).numero;
                repetir = false;
            } else if(golesLocal < golesVisitante){
                partidosJugados.add(new PartidoJugado(partidosPrevistos.get(0).getEquipoLocal(), partidosPrevistos.get(0).getEquipoVisitante(),
                partidosPrevistos.get(0).getFecha(), partidosPrevistos.get(0).getHora(), golesLocal, golesVisitante));
                partidosJugados.get(0).setEquipoGanador(partidosPrevistos.get(0).getEquipoVisitante());
                partidosJugados.get(0).numero = partidosPrevistos.get(0).numero;
                repetir = false;
            } else{
                golesLocal = (int) (Math.random() * 6);
                golesVisitante = (int) (Math.random() * 6);
                repetir = true;
            }
        } while(repetir);
        
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public ArrayList<PartidoPrevisto> getPartidosPrevistos() {
        return partidosPrevistos;
    }

    public ArrayList<PartidoJugado> getPartidosJugados() {
        return partidosJugados;
    }

    
}
