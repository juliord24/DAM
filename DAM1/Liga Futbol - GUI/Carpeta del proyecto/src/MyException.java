public class MyException extends Exception {

    private int errorCode;

    public MyException(int errorCode){
        super();
        this.errorCode = errorCode;
    }
    @Override
    public String getMessage(){
        String message = "";

        switch(errorCode){
            case 0: message = "Porfavor, responde con 's' o 'n', gracias."; break;
            case 1: message = "Porfavor, responde con un número de 0 a 9."; break;
            case 2: message = "Porfavor, introduce un número entero."; break;
            default: break;

        }

        return message;
    }
    
}
