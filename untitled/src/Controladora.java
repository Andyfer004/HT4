import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Controladora { /*creamos la clase controladora*/
    public ArrayList<String> datos = new ArrayList<String>();/*creamos un arraylist para guardar los datos del archivo*/
    public IPostfixCalculator calc = new Pcalculator(); /*creamos una instancia de la clase Pcalculator*/



    /**
     * @param nameArchivo
     *
     * Array list para guardar los datos del archivo
     */
    public ArrayList<String> importArchivo(String nameArchivo, IStack<Integer>stack) {/**creamos el metodo para importar el archivo*/
        String fpath = nameArchivo;
        String data = "";
        ArrayList<String> datos = new ArrayList<String>();
        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                datos.add(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return datos;

    }

    /**
     * @param datoAcalcular
     * @return
     *
     * Metodo para calcular los datos del archivo
     */
    public ArrayList<Integer> calcular(ArrayList<String> datoAcalcular, IStack<Integer>stack) { /*creamos el metodo para calcular los datos del archivo*/
        ArrayList<Integer> resultados = new ArrayList<Integer>();
        for (int i = 0; i < datoAcalcular.size(); i++) {
            ArrayList<String> datossepa = calc.getItems(datoAcalcular.get(i));

            for (String dato : datossepa) { /*recorremos los datos del archivo*/
                if (calc.isOperator(dato)) {
                    int a = stack.pull();
                    int b = stack.pull();
                    int resultado = 0;
                    switch (dato) {/**creamos un switch para calcular los datos*/
                        case "+":
                            resultado = calc.suma(a, b);
                            break;
                        case "-":
                            resultado = calc.resta(a, b);
                            break;
                        case "*":
                            resultado = calc.multiplicacion(a, b);
                            break;
                        case "/":
                            resultado = calc.division(a, b);
                            break;
                        default:
                            break;
                    }
                    stack.push(resultado);
                } else {
                    stack.push(Integer.parseInt(dato));
                }
            }
            resultados.add(stack.pull());

        }

        return resultados;
    }

}


