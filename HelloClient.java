import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;



public class HelloClient
{
    
  static Hello helloImpl;
  
  public static String traducirMorse(String dato) {
      String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "--.--", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] palabras= {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
      String traduccion="";
      String mayuscula= "";
      String letra = "";
      mayuscula = dato.toUpperCase();
      for (int i=1; i<=dato.length (); i++){
        letra = mayuscula.substring (i-1, i);
        for (int j=0; j<palabras.length; j++){
            if(letra.equals (palabras [j])){
                traduccion = traduccion+ morse[j]+" | ";
            }
        }
    }
      
      return traduccion;
    
  }

  public static void main(String args[])
          
    {
        
      try{
        // create and initialize the ORB
        ORB orb = ORB.init(args, null);

        // get the root naming context
        org.omg.CORBA.Object objRef = 
            orb.resolve_initial_references("NameService");
        // Use NamingContextExt instead of NamingContext. This is 
        // part of the Interoperable naming Service.  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        
        //peticiÃ³n por consola de dato
        System.out.println ("Empezamos el programa");

        System.out.println ("Por favor introduzca la palabra para ser traducida a Morse:");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //CreaciÃ³n de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine ();
        String salida=traducirMorse(entradaTeclado);
 
        // resolve the Object Reference in Naming
        String name = "Hello";
        helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

        System.out.println("Obtained a handle on server object: " + helloImpl);
        System.out.println("Tu texto en Español: "+entradaTeclado);
        System.out.println("MORSE: "+salida);
        helloImpl.shutdown();

        } catch (Exception e) {
          System.out.println("ERROR : " + e) ;
          e.printStackTrace(System.out);
          }
    }

}