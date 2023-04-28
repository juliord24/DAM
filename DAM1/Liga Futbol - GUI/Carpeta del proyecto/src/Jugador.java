public class Jugador {
    
    private String nombre; //Nombre 
    private String nacionalidad; //Nacionalidad
    private int edad; //Edad

    public Jugador(){
    }
    public Jugador(String nombre, String nacionalidad, int edad){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }
    //Con este método se establecen de manera aleatoria el nombre la nacionalidad y la edad del jugador, el nombre del equipo se obtiene del atributo nombre del objeto Equipo
    public Jugador generarDatos(){
        String nombres[] = {"Francisco", "Bernabe", "Abdelkader", "Jorge", "Hassan", "Jose", "Saul", "Aquilino", "Daniel", "Gustavo", "Luis", "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo","Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa","Caritina", "Carlota", "Baltazar"};
        String apellidos[] = {"Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo","Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego", "Grigalva"};        
        int randomNombre= (int)(Math.random() * (nombres.length - 0 ) + 0) ;
        int randomApellido = (int)(Math.random() * (apellidos.length - 0 ) + 0) ;
        int randomApellido2 = (int)(Math.random() * (apellidos.length - 0 ) + 0) ;
        String nombre = nombres[randomNombre] + " " + apellidos[randomApellido] + " " + apellidos[randomApellido2];
        //--------------------------------------------------------Nombres-------------------------------------------------------------------------------
        String nacionalidades[] = {"Afganistán","Albania","Alemania","Andorra","Angola","Antigua y Barbuda","Arabia Saudita","Argelia","Argentina","Armenia","Australia","Austria","Azerbaiyán","Bahamas","Bangladés","Barbados","Baréin","Bélgica","Belice","Benín","Bielorrusia","Birmania","Bolivia","Bosnia y Herzegovina","Botsuana","Brasil","Brunéi","Bulgaria","Burkina Faso","Burundi","Bután","Cabo Verde","Camboya","Camerún","Canadá","Catar","Chad","Chile","China","Chipre","Ciudad del Vaticano","Colombia","Comoras","Corea del Norte","Corea del Sur","Costa de Marfil","Costa Rica","Croacia","Cuba","Dinamarca","Dominica","Ecuador","Egipto","El Salvador","Emiratos Árabes Unidos","Eritrea","Eslovaquia","Eslovenia","España","Estados Unidos","Estonia","Etiopía","Filipinas","Finlandia","Fiyi","Francia","Gabón","Gambia","Georgia","Ghana","Granada","Grecia","Guatemala","Guyana","Guinea","Guinea ecuatorial","Guinea-Bisáu","Haití","Honduras","Hungría","India","Indonesia","Irak","Irán","Irlanda","Islandia","Islas Marshall","Islas Salomón","Israel","Italia","Jamaica","Japón","Jordania","Kazajistán","Kenia","Kirguistán","Kiribati","Kuwait","Laos","Lesoto","Letonia","Líbano","Liberia","Libia","Liechtenstein","Lituania","Luxemburgo","Madagascar","Malasia","Malaui","Maldivas","Malí","Malta","Marruecos","Mauricio","Mauritania","México","Micronesia","Moldavia","Mónaco","Mongolia","Montenegro","Mozambique","Namibia","Nauru","Nepal","Nicaragua","Níger","Nigeria","Noruega","Nueva Zelanda","Omán","Países Bajos","Pakistán","Palaos","Palestina","Panamá","Papúa Nueva Guinea","Paraguay","Perú","Polonia","Portugal","Reino Unido","República Centroafricana","República Checa","República de Macedonia","República del Congo","República Democrática del Congo","República Dominicana","República Sudafricana","Ruanda","Rumanía","Rusia","Samoa","San Cristóbal y Nieves","San Marino","San Vicente y las Granadinas","Santa Lucía","Santo Tomé y Príncipe","Senegal","Serbia","Seychelles","Sierra Leona","Singapur","Siria","Somalia","Sri Lanka","Suazilandia","Sudán","Sudán del Sur","Suecia","Suiza","Surinam","Tailandia","Tanzania","Tayikistán","Timor Oriental","Togo","Tonga","Trinidad y Tobago","Túnez","Turkmenistán","Turquía","Tuvalu","Ucrania","Uganda","Uruguay","Uzbekistán","Vanuatu","Venezuela","Vietnam","Yemen","Yibuti","Zambia","Zimbabue"};
        int randomNacionalidad= (int)(Math.random() * (nacionalidades.length - 0 ) + 0) ;
        String nacionalidad = nacionalidades[randomNacionalidad];
        //--------------------------------------------------------Nacionalidades-------------------------------------------------------------------------
        
        //--------------------------------------------------------Equipo-------------------------------------------------------------------------
        int edad = (int)(Math.random() * (40 - 18) + 18) ;

        return new Jugador(nombre, nacionalidad, edad);

    }

    @Override
    public String toString(){
        return nombre + " | Nacionalidad: " + nacionalidad + " | Edad: " + edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getEdad() {
        return edad;
    }
}
