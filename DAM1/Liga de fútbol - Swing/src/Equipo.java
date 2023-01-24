import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
    
    private String nombre; //Nombre oficial del equipo
    private String sede; //Ciudad donde tiene su sede
    private String pais; //País
    private String estadio; //Nombre del estadio donde juegan
    private LocalDate fecha; //Fecha de fundación 
    private ArrayList<Jugador> listaJugadores; //Lista de jugadores 

    public Equipo(String nombre, String sede, String pais, String estadio, int añoFundacion, int mesFundacion, int diaFundacion){
        this.nombre = nombre; 
        this.sede = sede;
        this.pais = pais;
        this.estadio = estadio;
        fecha = LocalDate.of(añoFundacion, mesFundacion, diaFundacion);
        listaJugadores = new ArrayList<>();
    }
    public Equipo(){
        
    }

    public String getNombre(){
        return nombre;
    }

    public void hacerListaJugadores(){ //Guarda 11 objetos jugador con atributos aleatorios en listaJugadores
        for(int i=0; i< 11;i++){
            listaJugadores.add(new Jugador().generarDatos());
        }
    }

    public ArrayList<Equipo> crearEquipos(){
        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo("Real Madrid", "Madrid", "España", "Santiago Bernabéu", 1902, 3, 6));                                  
        equipos.add(new Equipo("Juventus", "Turín", "Italia", "Alliazn", 1897, 11, 1));
        equipos.add(new Equipo("Manchester City", "Manchester", "Inglaterra", "Etihad", 1880, 11, 23));
        equipos.add(new Equipo("Atlético de Madrid", "Madrid", "España", "Metropolitano", 1903, 4, 26));
        equipos.add(new Equipo("Al-Nassr", "Riad", "Arabia Saudita", "Mrsool Park", 1955, 11, 24));
        equipos.add(new Equipo("Barcelona", "Barcelona", "España", "Camp Nou", 1899, 11, 29));
        equipos.add(new Equipo("Paris Saint-Germain", "París", "Francia", "Parque de los Príncipes", 1970, 8, 12));
        equipos.add(new Equipo("Albacete Balompié", "Albacete", "España", "Carlos Belmonte", 1960, 9, 9));
        for (int i=0 ;i<equipos.size();i++){
            equipos.get(i).hacerListaJugadores();
        }

        return equipos;
    }

    public void muestraListaJugadores(){
        for (int i=0; i<listaJugadores.size(); i++){
            System.out.println(listaJugadores.get(i));
        }
    }
    @Override 
    public String toString(){
        return "<html><body>Nombre del equipo: " + nombre + "<br>Sede: " + sede + "<br>Pais: " + pais + "<br>Estadio: " + estadio + "<br>Fecha:" + fecha
                + "<br><br>Jugador 1: " + listaJugadores.get(0).toString() + "<br>Jugador 2: " + listaJugadores.get(1).toString() + "<br>Jugador 3: " + listaJugadores.get(2).toString()
                + "<br>Jugador 4: " + listaJugadores.get(3).toString() + "<br>Jugador 5: " + listaJugadores.get(4).toString() + "<br>Jugador 6: " + listaJugadores.get(5).toString() + "<br>Jugador 7: " + listaJugadores.get(6).toString()
                + "<br>Jugador 8: " + listaJugadores.get(7).toString() + "<br>Jugador 9: " + listaJugadores.get(8).toString() + "<br>Jugador 10: " + listaJugadores.get(9).toString() + "<br>Jugador 11: " + listaJugadores.get(10).toString() + "</body></html>"; 
    }
}
