import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Liga liga = new Liga();
        Scanner kb = new Scanner(System.in);
        String res1 = "";
        char charRes1 = ' ';
        int intRes1 = 0;
        boolean repetir = true;
        do{
            try{
                System.out.print("Bienvenido a la liga Futbol Frontier, ¿quieres ver información acerca de los equipos y sus jugadores? (s/n) "); res1 = kb.next();
                charRes1 = res1.toLowerCase().charAt(0);
                if (charRes1 != 's' && charRes1 != 'n'){
                    throw new MyException(0);
                } else{
                    repetir = false;
                }
            } catch(MyException e){
                System.out.println(e.getMessage());
            }
        }while (repetir == true);
        do{
            if(charRes1 == 's'){
                boolean repetir1;
                System.out.println("\nLista de equipos:\n1.Real Madrid\n2.Juventus\n3.Manchester City\n4.Atlético de Madrid\n5.Al-Nassr\n6.Barcelona\n7.Paris Saint-Germain\n8.Albacete Balompié");
                do{
                    repetir1 = false;
                    try{
                        System.out.println("\nElige el equipo del cual quieras ver la información introducienco su número(1-8) o introduce un 9 para verlos todos a la vez. Introduce un 0 para cerrar este menú.");
                        intRes1 = kb.nextInt();
                        if (intRes1 < 0 || intRes1 > 9){
                            throw new MyException(1);
                        } else if (intRes1 >= 1 && intRes1 <=8){
                            System.out.println(liga.getEquipos().get(intRes1 - 1).toString());
                        } else if(intRes1 == 9){
                            for(int i = 0; i<liga.getEquipos().size(); i++)
                            System.out.println(liga.getEquipos().get(i).toString());
                        } 
                    } catch(InputMismatchException e){
                        System.out.println("Porfavor introduce un número entero.");
                        repetir1 = true;
                        kb.nextLine();
                    } catch(MyException e){
                        System.out.println(e.getMessage());
                        repetir1 = true;
                    }
                }while(repetir1 == true);
            } 
        }while(intRes1 != 0);
        kb.nextLine(); 
        
        liga.planificarCuartos();
        System.out.println("\nDesde este mismo instante comienza la liga Futbol Frontier, estos son los primeros partidos de la competición, los cuartos de final: (pulsa enter para continuar)"); kb.nextLine() ;
        for(int i = 0; i < liga.getPartidosPrevistos().size(); i++){
            System.out.println(liga.getPartidosPrevistos().get(i).toString());
        }
        
        liga.jugarCuartos();
        System.out.print("Pulsa enter para descubrir los ganadores de esta primera fase."); kb.nextLine();
        for(int i=0; i<liga.getPartidosPrevistos().size();i++){
            System.out.println("\nPartido " + liga.getPartidosJugados().get(i).numero + ": " + liga.getPartidosJugados().get(i).toString());
        }
        
        liga.planificarSemis();
        System.out.print("\nSolo los mejores pueden avanzar puestos en el campeonato, pulsa enter y descubre quienes se enfrentarán en las semifinales.");kb.nextLine();
        System.out.println();
        for(int i = 0; i < liga.getPartidosPrevistos().size(); i++){
            System.out.println(liga.getPartidosPrevistos().get(i).toString());
        }
        
        liga.jugarSemis();
        System.out.print("Nos acercamos a la final y estás a un enter de conocer los equipos que la jugarán."); kb.nextLine();
        for(int i=0; i<liga.getPartidosPrevistos().size();i++){
            System.out.println("\nPartido " + liga.getPartidosJugados().get(i).numero + ": " + liga.getPartidosJugados().get(i).toString());
        }
        
        liga.planificarFinal();
        System.out.println("\nBueno bueno bueno, ya tenemos a nuestros finalistas, este será el último partido.\n");
        System.out.println(liga.getPartidosPrevistos().get(0).toString());
        
        liga.jugarFinal();
        System.out.println("¿Estás listo para conocer el ganador del torneo?, venga que lo estás deseando dale al enter!!!"); kb.nextLine();
        System.out.println("\nPartido " + liga.getPartidosJugados().get(0).numero + ": " + liga.getPartidosJugados().get(0).toString());

        System.out.println("\nENHORABUENA a " + liga.getPartidosJugados().get(0).getEquipoGanador().getNombre() + "!!!");
        kb.close();
    }
}
