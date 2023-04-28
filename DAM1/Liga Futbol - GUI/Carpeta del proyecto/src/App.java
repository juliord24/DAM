import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class App {

    private static Liga liga;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JPanel inicioPanel;
    private JButton comenzarButton;
    private JPanel infoPanel;
    private JComboBox equipoComboBox;
    private JComboBox jugadorComboBox;
    private JLabel equipoLabel;
    private JLabel jugadorLabel;
    private JPanel cuartosPanel;
    private JProgressBar progressBar1;
    private JLabel cuartos1;
    private JLabel cuartos2;
    private JLabel cuartos3;
    private JLabel cuartos4;
    private JButton cuartosButton;
    private JLabel cuartosLabel1;
    private JLabel cuartosLabel2;
    private JLabel cuartosLabel3;
    private JLabel cuartosLabel4;
    private JPanel semisPanel;
    private JButton semisButton;
    private JLabel semisLabel1;
    private JLabel semisLabel2;
    private JPanel finalPanel;

    private static Conexion conexion;
    private JLabel finalLabel, finalPrevistaLabel, finalJugadaLabel;
    private JButton finalButton;
    private JMenuBar menuBar;
    private ArrayList<JLabel> semisLabel, semisPrevistasLabel, semisJugadasLabel;

    private ArrayList<JLabel> cuartosLabel, cuartosPrevistosLabel, cuartosJugadosLabel;
    private String nombreEquipoSeleccionado;
    private Equipo equipoSeleccionado;

    public App() {
        //desactivo las pestañas para poder controlar por donde se mueve el usuario e ir activandolas más tarde
        tabbedPane1.setEnabled(false);
        comenzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i < 100; i++){
                            progressBar1.setValue(i);
                            progressBar1.setString(i + " %");
                            try {
                                Thread.sleep(20);
                            }
                                /* if(i == 50){
                                    Thread.sleep(1500);
                                } else if(i == 60){
                                    Thread.sleep(100);
                                } else if(i == 65){
                                    Thread.sleep(100);
                                } else if(i == 70){
                                    Thread.sleep(100);
                                } else if(i == 75){
                                    Thread.sleep(100);
                                } else if(i == 80){
                                    Thread.sleep(100);
                                } else if(i == 85){
                                    Thread.sleep(100);
                                } else if(i == 90){
                                    Thread.sleep(100);
                                } else if(i == 99){
                                    Thread.sleep(1000);

                                }
                                else{
                                    Thread.sleep(20);
                                } */

                             catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        tabbedPane1.setSelectedIndex(1);
                        tabbedPane1.setEnabled(true);
                        tabbedPane1.setEnabledAt(0,false);
                        tabbedPane1.setEnabledAt(3, false);
                        tabbedPane1.setEnabledAt(4, false);
                    }
                });
                hilo.start();
                comenzarButton.setEnabled(false);
                liga = new Liga();
                liga.planificarCuartos();
                conexion = new Conexion();
                for(int i = 0; i< liga.getEquipos().size(); i++){
                    equipoComboBox.addItem(liga.getEquipos().get(i).getNombre());
                }
                cuartosLabel = new ArrayList<>();
                cuartosPrevistosLabel = new ArrayList<>();
                cuartosJugadosLabel = new ArrayList<>();
                cuartosLabel.add(cuartosLabel1); cuartosLabel.add(cuartosLabel2); cuartosLabel.add(cuartosLabel3); cuartosLabel.add(cuartosLabel4);
                for(int i=0;i<cuartosLabel.size();i++){
                    cuartosLabel.get(i).setText(liga.getPartidosPrevistos().get(i).toString());
                    cuartosPrevistosLabel.add(new JLabel());
                    cuartosJugadosLabel.add(new JLabel());
                    cuartosPrevistosLabel.get(i).setText(cuartosLabel.get(i).getText());
                }
            }
        });

        JMenu basesMenu = new JMenu("Base de datos");
        JMenuItem guardarEquipos = new JMenuItem("Guardar equipos y jugadores");
        menuBar.add(basesMenu);
        basesMenu.add(guardarEquipos);
        JMenuItem cargarEquipos = new JMenuItem("Cargar equipos y jugadores");
        basesMenu.add(cargarEquipos);

        guardarEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        conexion.insertEquipos();
                    }
                });
                hilo.start();
            }
        });

        cargarEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            ResultSet rs;
                            for(int i=0;i<liga.getEquipos().size();i++){
                                rs = conexion.selectJugadores(liga.getEquipos().get(i).getNombre());
                                rs.next();
                                for(int j=0;j<liga.getEquipos().get(i).getListaJugadores().size();j++){
                                    liga.getEquipos().get(i).getListaJugadores().set(j, new Jugador(rs.getString("Nombre"), rs.getString("Nacionalidad"), rs.getInt("Edad")));
                                    rs.next();
                                }
                            }
                            equipoComboBox.setSelectedIndex(0);
                        } catch (SQLException ex){
                            ex.printStackTrace();
                        }
                    }
                });
                hilo.start();
            }
        });

        equipoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreEquipoSeleccionado = (String) equipoComboBox.getSelectedItem();
                for(int i = 0; i < equipoComboBox.getItemCount(); i++){
                    if(equipoComboBox.getSelectedItem().equals(liga.getEquipos().get(i).getNombre())){
                        equipoSeleccionado = liga.getEquipos().get(i);
                    }
                }
                jugadorComboBox.removeAllItems();
                equipoLabel.setIcon(equipoSeleccionado.getIcono());
                jugadorLabel.setIcon(new ImageIcon("media/pepe.png"));
                for(int i=0; i<equipoSeleccionado.getListaJugadores().size(); i++){
                    jugadorComboBox.addItem(equipoSeleccionado.getListaJugadores().get(i).getNombre());
                }
            }
        });
        cuartosButton.addActionListener(new ActionListener() {
            int switcher = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switcher == 0){

                    liga.jugarCuartos();
                    for(int i=0;i<cuartosLabel.size();i++){
                        cuartosLabel.get(i).setText(liga.getPartidosJugados().get(i).toString());
                        cuartosJugadosLabel.get(i).setText(cuartosLabel.get(i).getText());
                    }
                    switcher = 1;
                    cuartosButton.setText("Previstos");
                    tabbedPane1.setEnabledAt(3, true);

                    semisLabel = new ArrayList<>();
                    semisLabel.add(semisLabel1); semisLabel.add(semisLabel2);
                    semisPrevistasLabel = new ArrayList<>();
                    semisJugadasLabel = new ArrayList<>();

                    liga.planificarSemis();
                    for(int i=0;i<liga.getPartidosPrevistos().size();i++){
                        semisLabel.get(i).setText(liga.getPartidosPrevistos().get(i).toString());
                        semisPrevistasLabel.add(new JLabel());
                        semisJugadasLabel.add(new JLabel());
                        semisPrevistasLabel.get(i).setText(semisLabel.get(i).getText());
                    }
                } else if(switcher == 1){
                    for(int i=0;i<cuartosLabel.size();i++){
                        cuartosLabel.get(i).setText(cuartosPrevistosLabel.get(i).getText());
                    }
                    switcher = 2;
                    cuartosButton.setText("Jugados");
                } else if(switcher == 2){
                    for(int i=0;i<cuartosLabel.size();i++){
                        cuartosLabel.get(i).setText(cuartosJugadosLabel.get(i).getText());
                    }
                    switcher=1;
                    cuartosButton.setText("Previstos");
                }
            }
        });
        semisButton.addActionListener(new ActionListener() {
            int switcher = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switcher == 0){
                    liga.jugarSemis();
                    for(int i=0;i<semisLabel.size();i++){
                        semisLabel.get(i).setText(liga.getPartidosJugados().get(i).toString());
                        semisJugadasLabel.get(i).setText(semisLabel.get(i).getText());
                    }
                    switcher = 1;
                    semisButton.setText("Previstos");
                    liga.planificarFinal();
                    tabbedPane1.setEnabledAt(4, true);
                    finalLabel.setText(liga.getPartidosPrevistos().get(0).toString());
                    finalPrevistaLabel = new JLabel();
                    finalJugadaLabel = new JLabel();
                    finalPrevistaLabel.setText(finalLabel.getText());
                } else if(switcher == 1){
                    for(int i=0;i<semisLabel.size();i++){
                        semisLabel.get(i).setText(semisPrevistasLabel.get(i).getText());
                    }
                    switcher = 2;
                    semisButton.setText("Jugados");
                } else if(switcher == 2){
                    for(int i=0;i<semisLabel.size();i++){
                        semisLabel.get(i).setText(semisJugadasLabel.get(i).getText());
                    }
                    switcher = 1;
                    semisButton.setText("Previstos");
                }
            }
        });
        finalButton.addActionListener(new ActionListener() {
            int switcher = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switcher == 0){
                    liga.jugarFinal();
                    finalLabel.setText(liga.getPartidosJugados().get(0).toString());
                    finalJugadaLabel.setText(finalLabel.getText());
                    switcher = 1;
                    finalButton.setText("Previsto");
                } else if(switcher == 1){
                    finalLabel.setText(finalPrevistaLabel.getText());
                    switcher = 2;
                    finalButton.setText("Jugado");
                } else if(switcher == 2){
                    finalLabel.setText(finalJugadaLabel.getText());
                    switcher = 1;
                    finalButton.setText("Previsto");
                }
            }
        });
    }

    public static Liga getLiga() {
        return liga;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if(conexion!= null){
                        conexion.getConexion().close();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


}
