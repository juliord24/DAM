import java.sql.*;
public class Conexion {

    private Connection conexion;
    private Statement statement;
    private Liga liga;


    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + "bbdd", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            statement = conexion.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        liga = App.getLiga();
        crearTablas();
    }


    public void crearTablas(){
        try{
            statement.executeUpdate("CREATE TABLE `equiposJulio` (\n" +
                    " `nombre` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',\n" +
                    " `sede` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',\n" +
                    " `pais` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',\n" +
                    " `estadio` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',\n" +
                    " `fecha` DATE NULL DEFAULT NULL,\n" +
                    " PRIMARY KEY (`nombre`) USING BTREE\n" +
                    ")\n" +
                    "COLLATE='latin1_swedish_ci'\n" +
                    "ENGINE=InnoDB\n" +
                    ";\n");
            statement.executeUpdate("CREATE TABLE `jugadoresJulio` (\n" +
                    "\t`Nombre` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',\n" +
                    "\t`Nacionalidad` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',\n" +
                    "\t`Edad` INT(11) NULL DEFAULT NULL,\n" +
                    "\t`Equipo` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',\n" +
                    "\tINDEX `FK_Jugadores_Equipos` (`Equipo`) USING BTREE,\n" +
                    "\tCONSTRAINT `FK_Jugadores_Equipos` FOREIGN KEY (`Equipo`) REFERENCES `equiposJulio` (`nombre`) ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                    ")\n" +
                    "COLLATE='latin1_swedish_ci'\n" +
                    "ENGINE=InnoDB\n" +
                    ";\n");
        } catch(SQLSyntaxErrorException e){

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertEquipos() {
        try{
            statement.executeUpdate("delete from jugadoresJulio");
            statement.executeUpdate("delete from equiposJulio");
            for(int i=0;i<liga.getEquipos().size();i++){
                statement.executeUpdate("insert into equiposJulio (nombre, sede, pais, estadio, fecha) values ('" +
                        liga.getEquipos().get(i).getNombre() + "', '" +
                        liga.getEquipos().get(i).getSede() + "', '" +
                        liga.getEquipos().get(i).getPais() + "', '" +
                        liga.getEquipos().get(i).getEstadio() + "', '" +
                        liga.getEquipos().get(i).getFecha() + "');");
            }
            insertJugadores();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    private void insertJugadores() {
        for(int i=0;i<liga.getEquipos().size();i++){
            for(int j=0;j<liga.getEquipos().get(i).getListaJugadores().size();j++){
                try {
                    statement.executeUpdate("INSERT INTO jugadoresJulio (nombre, nacionalidad, edad, equipo) VALUES ('" +
                            liga.getEquipos().get(i).getListaJugadores().get(j).getNombre() + "', '" +
                            liga.getEquipos().get(i).getListaJugadores().get(j).getNacionalidad() + "', " +
                            liga.getEquipos().get(i).getListaJugadores().get(j).getEdad() + ", '" +
                            liga.getEquipos().get(i).getNombre() + "');");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public ResultSet selectJugadores(String nombreEquipo) {
        try {
            return statement.executeQuery("select * from jugadoresJulio where equipo = (select nombre from equiposJulio where nombre = '" + nombreEquipo + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
