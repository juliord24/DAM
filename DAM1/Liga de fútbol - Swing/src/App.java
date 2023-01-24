import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class App extends JFrame implements ActionListener{
    Liga liga;
    JLabel bienvenida, elegir, lista, team1L, team2L, team3L, team4L, team5L, team6L, team7L, team8L;
    ArrayList<JLabel> teamsL;
    JButton siInfo, noInfo, team1, team2, team3, team4, team5, team6, team7, team8, comenzar;
    JLabel presentacionCuartos, cuartosPrevistos, cuartosResultados, semisPrevistos, semisResultados, finalPrevisto, finalResultado;
    JButton verCuartosResultados, verSemisPrevistos, verSemisResultados, verFinalPrevisto, verFinalResultado;
    public App(){
        liga = new Liga();
        Font letra = new Font("Courier New", Font.PLAIN, 15);
        bienvenida = new JLabel("Bienvenido a la liga Futbol Frontier, ¿quieres ver información acerca de los equipos y sus jugadores?");
        bienvenida.setFont(letra);
        bienvenida.setBounds(10, 30, 1000, 15);

        siInfo = new JButton("Si");
        siInfo.addActionListener(this);
        siInfo.setBounds(980, 10, 50, 50);
        
        noInfo = new JButton("No");
        noInfo.addActionListener(this);
        noInfo.setBounds(1050, 10, 50, 50);

        elegir = new JLabel("Elige el equipo del cual quieras ver la información.");
        elegir.setFont(letra);
        elegir.setBounds(10, 30, 1000, 15);

        lista = new JLabel("<html><body>Real Madrid<br><br>Juventus<br><br>Manchester City<br><br>Atlético de Madrid<br><br>Al-Nassr<br><br>Barcelona<br><br>Paris Saint-Germain<br><br>Albacete Balompié</body></html>");
        lista.setFont(letra);
        lista.setBounds(10, 30, 500, 350);

        team1 = new JButton();
        team1.addActionListener(this);
        team1.setBounds(130, 70, 15, 15);
        
        team2 = new JButton();
        team2.addActionListener(this);
        team2.setBounds(100, 108, 15, 15);
        
        team3 = new JButton();
        team3.addActionListener(this);
        team3.setBounds(165, 145, 15, 15);
        
        team4 = new JButton();
        team4.addActionListener(this);
        team4.setBounds(190, 180, 15, 15);
        
        team5 = new JButton();
        team5.addActionListener(this);
        team5.setBounds(98, 216, 15, 15);
        
        team6 = new JButton();
        team6.addActionListener(this);
        team6.setBounds(104, 252, 15, 15);
        
        team7 = new JButton();
        team7.addActionListener(this);
        team7.setBounds(198, 288, 15, 15);
        
        team8 = new JButton();
        team8.addActionListener(this);
        team8.setBounds(182, 325, 15, 15);

        teamsL = new ArrayList<>();
        team1L = new JLabel(liga.getEquipos().get(0).toString());
        team1L.setFont(letra);
        team1L.setBounds(20, 360, 900, 310);
        team1L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team1L);

        team2L = new JLabel(liga.getEquipos().get(1).toString());
        team2L.setFont(letra);
        team2L.setBounds(20, 360, 900, 310);
        team2L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team2L);

        team3L = new JLabel(liga.getEquipos().get(2).toString());
        team3L.setFont(letra);
        team3L.setBounds(20, 360, 900, 310);
        team3L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team3L);

        team4L = new JLabel(liga.getEquipos().get(3).toString());
        team4L.setFont(letra);
        team4L.setBounds(20, 360, 900, 310);
        team4L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team4L);

        team5L = new JLabel(liga.getEquipos().get(4).toString());
        team5L.setFont(letra);
        team5L.setBounds(20, 360, 900, 310);
        team5L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team5L);

        team6L = new JLabel(liga.getEquipos().get(5).toString());
        team6L.setFont(letra);
        team6L.setBounds(20, 360, 900, 310);
        team6L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team6L);

        team7L = new JLabel(liga.getEquipos().get(6).toString());
        team7L.setFont(letra);
        team7L.setBounds(20, 360, 900, 310);
        team7L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team7L);

        team8L = new JLabel(liga.getEquipos().get(7).toString());
        team8L.setFont(letra);
        team8L.setBounds(20, 360, 900, 310);
        team8L.setBorder(BorderFactory.createLineBorder(Color.black));
        teamsL.add(team8L);

        comenzar = new JButton("Continuar");
        comenzar.setBounds(1150, 620, 100, 50);
        comenzar.addActionListener(this);

        liga.planificarCuartos();
        presentacionCuartos = new JLabel("Desde este mismo instante comienza la liga Futbol Frontier, estos son los primeros partidos de la competición, los cuartos de final.");
        presentacionCuartos.setFont(letra);
        presentacionCuartos.setBounds(10, 30, 1400, 15);

        cuartosPrevistos = new JLabel(liga.getPartidosPrevistos().get(0).toString() + liga.getPartidosPrevistos().get(1).toString() + liga.getPartidosPrevistos().get(2).toString() + liga.getPartidosPrevistos().get(3).toString() + "</body></html>");
        cuartosPrevistos.setFont(letra);
        cuartosPrevistos.setBounds(15, 35, 1000, 300);

        verCuartosResultados = new JButton("Resultados");
        verCuartosResultados.setBounds(1150, 620, 100, 50);
        verCuartosResultados.addActionListener(this);

        liga.jugarCuartos();
        cuartosResultados = new JLabel("<html><body><br>Partido " + liga.getPartidosJugados().get(0).numero + ": " + liga.getPartidosJugados().get(0).toString()
        + "<br><br>Partido " + liga.getPartidosJugados().get(1).numero + ": " + liga.getPartidosJugados().get(1).toString()
        + "<br><br>Partido " + liga.getPartidosJugados().get(2).numero + ": " + liga.getPartidosJugados().get(2).toString()
        + "<br><br>Partido " + liga.getPartidosJugados().get(3).numero + ": " + liga.getPartidosJugados().get(3).toString());
        cuartosResultados.setBounds(15, 35, 1000, 200);
        cuartosResultados.setFont(letra);

        liga.planificarSemis();
        verSemisPrevistos = new JButton("Continuar");
        verSemisPrevistos.setBounds(comenzar.getBounds());
        verSemisPrevistos.addActionListener(this);

        semisPrevistos = new JLabel(liga.getPartidosPrevistos().get(0).toString() + liga.getPartidosPrevistos().get(1).toString() + "</body></html>");
        semisPrevistos.setFont(letra);
        semisPrevistos.setBounds(15, 35, 1000, 150);

        liga.jugarSemis();
        verSemisResultados = new JButton("Resultados");
        verSemisResultados.setBounds(verCuartosResultados.getBounds());
        verSemisResultados.addActionListener(this);

        semisResultados = new JLabel("<html><body><br>Partido " + liga.getPartidosJugados().get(0).numero + ": " + liga.getPartidosJugados().get(0).toString()
        + "<br><br>Partido " + liga.getPartidosJugados().get(1).numero + ": " + liga.getPartidosJugados().get(1).toString());
        semisResultados.setBounds(15, 35, 1000, 100);
        semisResultados.setFont(letra);

        liga.planificarFinal();
        verFinalPrevisto = new JButton("Continuar");
        verFinalPrevisto.setBounds(comenzar.getBounds());
        verFinalPrevisto.addActionListener(this);

        finalPrevisto = new JLabel(liga.getPartidosPrevistos().get(0).toString() + "</body></html>");
        finalPrevisto.setFont(letra);
        finalPrevisto.setBounds(15, 35, 1000, 100);

        liga.jugarFinal();
        verFinalResultado = new JButton("Resultado");
        verFinalResultado.setBounds(verCuartosResultados.getBounds());
        verFinalResultado.addActionListener(this);
        
        finalResultado = new JLabel("<html><body><br>Partido " + liga.getPartidosJugados().get(0).numero + ": " + liga.getPartidosJugados().get(0).toString());
        finalResultado.setBounds(15, 35, 1000, 50);
        finalResultado.setFont(letra);
    }

    public void frame(){
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);
        setTitle("Selección de estadísticas");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(255, 255, 255));
        add(bienvenida);
        add(siInfo); add(noInfo);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == siInfo){
            remove(bienvenida);
            remove(siInfo);
            remove(noInfo);
            repaint();
            add(elegir);
            add(lista);
            add(team1); add(team2); add(team3); add(team4); add(team5); add(team6); add(team7); add(team8); add(comenzar);
        } else if(e.getSource() == team1){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team1L);
            repaint();
        } else if(e.getSource() == team2){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team2L);
            repaint();
        } else if(e.getSource() == team3){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team3L);
            repaint();
        } else if(e.getSource() == team4){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team4L);
            repaint();
        } else if(e.getSource() == team5){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team5L);
            repaint();
        } else if(e.getSource() == team6){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team6L);
            repaint();
        } else if(e.getSource() == team7){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team7L);
            repaint();
        } else if(e.getSource() == team8){
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            add(team8L);
            repaint();
        } else if(e.getSource() == comenzar){
            remove(elegir); remove(lista); remove(team1); remove(team2); remove(team3); remove(team4); remove(team5); remove(team6); remove(team7); remove(team8);
            for(int i = 0; i < teamsL.size(); i++){
                remove(teamsL.get(i));
            }
            remove(comenzar);
            add(presentacionCuartos);
            add(cuartosPrevistos);
            add(verCuartosResultados);
            repaint();
        } else if(e.getSource() == noInfo){
            remove(bienvenida);
            remove(siInfo);
            remove(noInfo);
            add(presentacionCuartos);
            add(cuartosPrevistos);
            add(verCuartosResultados);
            repaint();
        } else if(e.getSource() == verCuartosResultados){
            add(cuartosResultados);
            remove(cuartosPrevistos);
            remove(verCuartosResultados);
            add(verSemisPrevistos);
            presentacionCuartos.setText("Estos son los resultados de la fase de cuartos:");
            repaint();
        } else if(e.getSource() == verSemisPrevistos){
            remove(verSemisPrevistos);
            remove(cuartosResultados);
            presentacionCuartos.setText("Los emparejamientos para las semifinales son:");
            add(semisPrevistos);
            add(verSemisResultados);
            repaint();
        } else if(e.getSource() == verSemisResultados){
            remove(semisPrevistos);
            remove(verSemisResultados);
            presentacionCuartos.setText("Estos son los resultados de las semifinales:");
            add(semisResultados);
            add(verFinalPrevisto);
            repaint();
        } else if(e.getSource() == verFinalPrevisto){
            remove(semisResultados);
            remove(verFinalPrevisto);
            presentacionCuartos.setText("Este es el partido final:");
            add(finalPrevisto);
            add(verFinalResultado);
            repaint();
        } else if(e.getSource() == verFinalResultado){
            remove(finalPrevisto);
            remove(verFinalResultado);
            presentacionCuartos.setText("Y así termina la clasificatoria, " + liga.getPartidosJugados().get(0).getEquipoGanador().getNombre() + " es el ganador. Muchas gracias a todos los javaspectadores por apoyar esta competición.");
            add(finalResultado);
            repaint();
        }
    }
    public static void main(String[] args) {
        new App().frame();
    }
}