import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Scanner;

@WebService(name = "Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {

    @WebMethod(operationName = "responseMessage")
    public String responseMessage(@WebParam(name = "message") String message){
        return "El mensaje recibido fue "+message;
    }

    @WebMethod(operationName = "adivinador")
    public String adivinador(@WebParam(name = "numero") int num){
        int alea = (int)(Math.random()*3+1);
        String mensaje;
        if(num==alea){
            mensaje="Ganaste";
        }else{
            mensaje="Perdiste";
        }
        return mensaje;
    }

    @WebMethod(operationName = "consonantes")
    public String consonantes(@WebParam(name = "palabra") String palabra) {
        String newpalabra;
        palabra = palabra.toLowerCase();
        newpalabra = palabra.replace("a", "");
        newpalabra=newpalabra.replace("e","");
        newpalabra=newpalabra.replace("i","");
        newpalabra=newpalabra.replace("o","");
        newpalabra=newpalabra.replace("u","");

        return newpalabra;
    }

    @WebMethod(operationName = "rfc")
    public String rfc(@WebParam(name = "datos") String nombre,String ap, String am, String fecha){
        String rfc = String.valueOf(ap.charAt(0));
        String homo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String homoclave="";
        for (int i=0;i<3;i++){
            int alea=(int)(Math.random()*homo.length());
            char letra = homo.charAt(alea);
            homoclave+=letra;
        }
        rfc+=ap.charAt(1);
        rfc+=am.charAt(0);
        rfc+=nombre.charAt(0);
        rfc+=fecha.charAt(8);
        rfc+=fecha.charAt(9);
        rfc+=fecha.charAt(3);
        rfc+=fecha.charAt(4);
        rfc+=fecha.charAt(0);
        rfc+=fecha.charAt(1);
        rfc+=homoclave;
        return rfc;
    }

    public static void main(String[] args) {
        System.out.println("Inicialitating server...");
        Endpoint.publish("http://localhost:80/Service",new Service());
        System.out.println("watting request...");
    }
}
