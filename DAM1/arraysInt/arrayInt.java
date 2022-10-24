import java.util.Scanner;

public class arrayInt {
    /* esta clase dispone de métodos que ayudan a la hora de operar con un array.
     * en la clase que contiene el main están usados todos estos métodos por lo que te puede servir de ejemplo de como se usan
     * recalcar que estos métodos están pensados para trabajar con arrays tipo int exclusivamente
     * y por último quiero decir que aún soy muy principiante y es posible que el código no sea lo más eficiente posible o los términos que uso no sean los más correctos, pido comprensión y acepto críticas constructivas.
    */
    public static int dim(){
        //pide al usuario el valor de la dimension del array, es útil si quieres inicializar(que no definir) el array en el método main pero quieres poder elejir por pantalla la dimensión de este.
        int a = 5;
        Scanner kb = new Scanner(System.in);
        System.out.print("Escoge la dimension del array: "); a = kb.nextInt();
        return a;
    }   
    public static int[] crear(){
        //sirve para inicializar y cargar por pantalla un array, si no usamos la función dim() podemos escoger nosotros mismos la dimensión
        int dim = dim();
        int arr[] = new int[dim];
        Scanner kb = new Scanner(System.in);
        for( int i=0; i<dim; i++) {
            System.out.print("Carga la posicion " + i + " del array: "); arr[i]= kb.nextInt();}
        return arr; 
    }
    public static void ver(int arr[],int dim){
        //visualiza el array que le pasemos como parámetro, en el parametro dim es recomendable usar .length (Ej: nombreDelArray.length)
        for( int i=0; i<dim; i++) {
            System.out.println("La posicion " + i + " del array es " + arr[i]);
            } 
    }
    public static int suma(int arr[], int dim){
        //suma los elementos del array y muestra el resultado
        int i = 0, suma = 0; 
        do {
            suma = suma + arr[i];
            i = i + 1;
            if (i>dim-1){
                System.out.println("La suma de los valores del array es: " + suma );
            }
            } while (i<dim); 
            return suma;
    }
    public static int suma_r(int arr[], int dim){
        //suma los elementos del array y devuelve el resultado
        int i = 0, suma = 0; 
        do {
            suma = suma + arr[i];
            i = i + 1;
            } while (i<dim); 
            return suma;
    }
    public static void media(int arr[], int dim){
        //calcula la media de los elementos del array y muestra el resultado
        int suma = suma_r(arr, dim);
        int media = suma/dim;
        System.out.println("La media de los valores del array es: " + media );
    }
    public static int media_r(int arr[], int dim){
        //calcula la media de los elementos del array y devuelve el resultado
        int i = 0, suma = 0, media=0;
        do {
            suma = suma + arr[i];
            i = i + 1;
            if (i>dim-1){
                media = suma/dim;
            }
            } while (i<dim);
            return media;
    }
    public static void sup_media(int arr[], int dim) {
        //muestra los elementos del array superiores a la media
        int i = 0, suma = 0, media=0;
        do {
            suma = suma + arr[i];
            i = i + 1;
            if (i>dim-1){
                media = suma/dim;
            }
            } while (i<dim);
            for (i=0; i<dim; i++){
                if (arr[i]>media) {
                    System.out.println(arr[i] + " es mayor que la media(" + media + ")");
                }
                }
    }
    public static void mayor(int arr[], int dim) {
        //muestra el valor más grande del array
        int mayor=arr[0], i;
            for(i=1; i<dim; i++) {
                if (arr[i]>mayor) {
                    mayor = arr[i];
                }
                if (i>=dim-1) {
                System.out.println("El valor más grande del array es " + mayor);
            }
        }
    }
    public static void menor(int arr[], int dim) {
        //muestra el valor más pequeño del array
        int menor=arr[0], i;
            for(i=1; i<dim; i++) {
                if (arr[i]<menor) {
                    menor = arr[i];
                }
                if (i>=dim-1) {
                System.out.println("El valor más pequeño del array es " + menor);
            }
        }
    }
    public static int[] arr_sup(int arr[], int dim){
        //guarda los elementos del array que le pasemos por parámetro, superiores a un número dado, en otro array y muestra por pantalla y devuelve este último
        int i, num, z=0, cont=0;
        Scanner kb = new Scanner(System.in);
        System.out.print("Se guardaran los datos del array superiores a: "); num = kb.nextInt();
        for (i=0;i<dim;i++) {
            if (arr[i]>num){
                cont++;
            }
        }int arr1[] = new int[cont]; 
        for (i=0; i<dim;i++){
            if (arr[i]>num){
                arr1[z]=arr[i];
                z++;
            }
        }
        for (i=0;i<cont;i++){
            System.out.println("Se ha guardado el valor: " + arr1[i] + " en la posición " + i);
        }
        return arr1;
    }
    public static int[] arr_media(int arr[], int dim){
        //guarda los elementos del array que le pasemos por parámetro,superiores a la media, en otro array y muestra por pantalla y devuelve este último
        int i, media = media_r(arr, dim), z=0, cont=0;
        System.out.print("Se guardaran los datos del array superiores a la media(" + media + ")\n"); 
        for (i=0;i<dim;i++) {
            if (arr[i]>media){
                cont++;
            }
        }int arr1[] = new int[cont]; 
        for (i=0; i<dim;i++){
            if (arr[i]>media){
                arr1[z]=arr[i];
                z++;
            }
        }
        for (i=0;i<cont;i++){
            System.out.println("Se ha guardado el valor: " + arr1[i] + " en la posición " + i);
        }
        return arr1;
    }
    public static int[] arr_suma2Arrays(int arr[],int arr1[], int dimA, int dimB) {
        //crea un array sumando otros dos ya existentes que le pasemos por parámetro y devuelve el nuevo array
        if (dimA>=dimB) {
            int arr2[] = new int[dimB];
        for (int i=0;i<dimB;i++){
            arr2[i] = arr[i] + arr1[i];
        }
        return arr2;
        } else {
            int arr2[] = new int[dimA];
        for (int i=0;i<dimA;i++){
            arr2[i] = arr[i] + arr1[i];
        }
        return arr2;}  
    }
    public static void arr_buscar(int arr[]){
        //busca un número introducido por teclado en el array que le pasemos por parámetro y muestra en que posición se encuentra el número
        Scanner kb = new Scanner(System.in); int num;
        System.out.print("Introduce el número a buscar: "); num = kb.nextInt();
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==num){
                System.out.println("El número " + num + " se encuentra en la posición " + i + " del array");
            } else {System.out.println("El número " + num + " no se encuentra en el array");}
        }      
    }
}//código escrito por Julio, @julio_rd24 en instagram

