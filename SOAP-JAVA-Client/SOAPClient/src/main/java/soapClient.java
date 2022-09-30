import utez.Service;
import utez.ServiceService;

import java.util.Scanner;

public class soapClient {
    public static void main(String[] args) {

        ServiceService service = new ServiceService();
        Service port = service.getServicePort();
        //String response = port.responseMessage("Ulises");
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            System.out.println("********  MENU  ********");
            System.out.println("Selecciones una opcion:");
            System.out.println("1.Buscar el numero\n2.Consonantes\n3.Obtener RFC\n4.Salir");
            op = sc.nextInt();
            switch(op){
                case 1:
                        int num;
                        boolean flag=true;
                        do{
                            System.out.println("Ingresa un numero:");
                            num=sc.nextInt();
                            String mensaje = port.adivinador(num);
                            if(mensaje.equals("Perdiste")){
                                System.out.println("Perdiste :(, TRY AGAIN");
                                flag=true;
                            }else if(mensaje.equals("Ganaste")){
                                System.out.println("GANASTE");
                                flag=false;
                            }
                        }while(flag);
                    break;
                case 2:
                    System.out.println("Ingresa una palabra:");
                    String palabra = sc.next();
                    System.out.println("Tu nueva palabra: "+port.consonantes(palabra));
                    break;
                case 3:
                    System.out.println("Ingrese su nombre");
                    String nombre = sc.next().toLowerCase();
                    System.out.println("Ingrese su apellido paterno:");
                    String ap = sc.next().toLowerCase();
                    System.out.println("Ingrese su apellido materno:");
                    String am = sc.next().toLowerCase();
                    System.out.println("Ingrese su fecha de nacimiento: (dd-mm-aaaa)");
                    String fecha = sc.next().toLowerCase();
                    System.out.println("Tu RFC es: "+port.rfc(nombre,ap,am,fecha).toUpperCase());
                    break;
                case 4:
                    System.out.println("CHAO :)");
                    break;
            }
        }while(op!=4);
    }
}
