import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Andy Fuentes
 * USE CODIGO DE LA HOJA DE TRABAJO 2 DEL GRUPO
 */
/** creamos la clase principal */
public class Principal {

    /**
     * @param args
     * @return void
     * Realiza la ejecucion del programa
     */
    public static void main(String[] args) {
        /** creamos las instancias de las clases */
        IStackFactory miFactory = new IStackFactory();
        Controladora miControladora = new Controladora();
        Pcalculator calculator = new Pcalculator();
        Scanner scan = new Scanner(System.in);
        int eleccion;
        do {
/** creamos el menu */
            System.out.println("Bienvenido al programa de calculadora");
            System.out.println("Porfavor ingrese la ruta de su archivo: ");
            String fileString = scan.nextLine();
            System.out.println("Porfavor seleccione una opcion");
            System.out.println("1. Array list");
            System.out.println("2. Vector");
            System.out.println("3. list");
            System.out.println("4.double list");
            eleccion = scan.nextInt();
            switch (eleccion) {
                /** creamos el switch para las opciones */
                case 1:
    /** creamos el array list para los datos */
                    ArrayList<String> datos = miControladora.importArchivo(fileString, miFactory.getStack(eleccion));
                    ArrayList<Integer> resultados = miControladora.calcular(datos, miFactory.getStack(eleccion));

                    for (int i = 0; i < resultados.size(); i++) {
                        System.out.println("El resultado de la operacion " + (i+1) + " es: " + resultados.get(i));
                    }
                    break;
                    /** creamos el vector para los datos */
                case 2:
                    ArrayList<String> datos2 = miControladora.importArchivo(fileString, miFactory.getStack(eleccion));
                    ArrayList<Integer> resultados2 = miControladora.calcular(datos2, miFactory.getStack(eleccion));
                            for (int i = 0; i < resultados2.size(); i++) {
                            System.out.println("El resultado de la operacion " + (i+1) + " es: " + resultados2.get(i));
                        }

                    /** creamos la lista para los datos */
                case 3:
                    ArrayList<String> datos3 = miControladora.importArchivo(fileString, miFactory.getStack(eleccion));
                    ArrayList<Integer> resultados3 = miControladora.calcular(datos3, miFactory.getStack(eleccion));
                    for (int i = 0; i < resultados3.size(); i++) {
                        System.out.println("El resultado de la operacion " + (i+1) + " es: " + resultados3.get(i));
                    }
                    /** creamos la lista doble para los datos */
                    case 4:
                    ArrayList<String> datos4 = miControladora.importArchivo(fileString, miFactory.getStack(eleccion));
                    ArrayList<Integer> resultados4 = miControladora.calcular(datos4, miFactory.getStack(eleccion));
                    for (int i = 0; i < resultados4.size(); i++) {
                        System.out.println("El resultado de la operacion " + (i+1) + " es: " + resultados4.get(i));
                    }
                    break;
                default:
                    System.out.println("Porfavor ingrese una opcion valida");
                    break;
            }
        } while (eleccion != 4);
    }
}






