import java.util.Scanner;
/* esta clase contiene el metodo main que ejecuta todos los métodos de la otra clase
 * al ejecutar la función main se despliega un menú de opciones por el que se puede navegar
 * la mayoria de las variables son locales porque el programa está pensado para operar cada opción del menú por separado, 
    el array principal si que está definido de manera global porque con él se opera en la mayoría de las opciones.
 * por la misma razón los métodos no suelen devolver ningun valor, y si lo devuelven no se almacena en variable globales
 * 
 */

public class menuArraysInt {
    public static void main(String[] args) {
            int opt; char res = 'o';
            Scanner kb = new Scanner(System.in); 
            //definimos el array principal
            int arr[] = new int [0];
    //desplegamos un menú de opciones que solo se cerrará si el usuario lo indica
    do {
            System.out.print("\nElije una de las siguientes opciones:(teclea su número)\n0.Crear y cargar el array\n1.Visualización de los valores del array." + 
            "\n2.Realizar la suma y la media de los valores del arrayInt.\n3.Visualizar los elementos del array superiores a la media."+
            "\n4.Visualizar el número más alto y el más bajo del array.\n" + "5.Buscamos un número dado en el array." +
            "\n6.Desplegar menú de opciones avanzado\n"); opt = kb.nextInt(); System.out.println();
        if (opt == 0) {
            //inicializamos el array y lo cargamos
                arr =  arrayInt.crear();
                System.out.print("\n¿Deseas continuar en el programa? (s/n) "); res = kb.next().charAt(0); System.out.println();
        }
        if(opt == 1) {
            //visualizamos el array
            arrayInt.ver(arr, arr.length);
            System.out.print("\n¿Deseas continuar en el programa? (s/n) "); res = kb.next().charAt(0); System.out.println();
        }
        if (opt==2) {
            //hacemos la suma y la media del array 
            arrayInt.suma(arr, arr.length);
            arrayInt.media(arr, arr.length);
            System.out.print("\n¿Deseas continuar en el programa? (s/n) "); res = kb.next().charAt(0); System.out.println();
        }
        if (opt == 3) {
            //mostramos los elementos del array superiores a la media
            arrayInt.sup_media(arr, arr.length);
            System.out.print("\n¿Deseas continuar en el programa? (s/n) "); res = kb.next().charAt(0); System.out.println(); }
        
        if (opt == 4) {
            //mostramos el número más alto y el más bajo del array
            arrayInt.mayor(arr, arr.length);
            arrayInt.menor(arr, arr.length);
            System.out.print("\n¿Deseas continuar en el programa? (s/n) "); res = kb.next().charAt(0); System.out.println(); 
        }
        if (opt == 5) {
            //buscamos un número dado por teclado dentro de un array dado por parámetro y mostramos donde está
            arrayInt.arr_buscar(arr);
            System.out.print("\n¿Deseas continuar en el programa? (s/n) "); res = kb.next().charAt(0); System.out.println();
        }
        //si el usuario elige esta opción se despliga otro menú de opciones, esto lo hice simplemente por estética del menú
        if (opt == 6) {
            do {
                System.out.println("1.Guardar en un segundo array los datos del primer array superiores a un valor dado.\n"+
                "2.Guardar en un segundo array los datos del array superiores a la media del primer array\n" + 
                "3.Creamos dos nuevos arrays y sumamos los valores de sus respecrivas posdiciones para crear un tercer array con los valores de la suma.\n "); opt = kb.nextInt();
                if (opt == 1) {
                    //creamos un array con los datos de otro array, dado por parámetro, superiores a un numero dado
                    arrayInt.arr_sup(arr, arr.length);
                    System.out.print("\n¿Deseas continuar en el menú avanzado? (s/n) "); res = kb.next().charAt(0); System.out.println(); 
                }
                if (opt == 2) {
                    //creamos un array con los datos de otro array, dado por parámetro, superiores a la media del array dado por parámetro
                    arrayInt.arr_media(arr, arr.length);
                    System.out.print("\n¿Deseas continuar en el menú avanzado? (s/n) "); res = kb.next().charAt(0); System.out.println();
//como podéis ver, hasta el momento ninguna opción guarda datos en varibles, no lo necesitamos, la siguiente opción si que lo hace puesto que necesita las variables como parámetros para el método
                }
                if (opt == 3) {
                    //creamos dos arrays de dimensión y valores definidos por el usuario y sumamos los valores de sus posiciones para crear otro array con esos valores
                    int arr1[]= arrayInt.crear(); System.out.print("\nCrea el segundo array:"); System.out.println();
                    int arr2[]= arrayInt.crear(); 
                    int arr3[]=arrayInt.arr_suma2Arrays(arr1, arr2, arr1.length, arr2.length);
                    arrayInt.ver(arr3, arr3.length);
                    System.out.print("\n¿Deseas continuar en el menú avanzado? (s/n) "); res = kb.next().charAt(0); System.out.println();
                }
            } while (res != 'n'); 
        }
        // al salir del bucle le damos a la variable res un valor cualquiera pero distinto de n para que el programa no se cierre directamente y vuelva a aparecer el menú principal
        res = 's';
    }while (res!= 'n');
    } 
} //código escrito por Julio, @julio_rd24 en instagram