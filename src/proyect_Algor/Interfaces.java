/*package proyect_Algor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class OrdenarFichero {

	public static void main(String[] args) {
	 {
			
			LinkedList<String> lista = new LinkedList<String>();
			try {
				FileReader fr = new FileReader(ruta1);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(ruta2);
				PrintWriter pw = new PrintWriter(fw);
				String linea = null;
				while ((linea = br.readLine()) != null) {
					lista.add(linea);
				}
				Collections.sort(lista);
				Iterator iter = lista.iterator();
				String cadena;
				while (iter.hasNext()) {
					cadena = (String) iter.next();
					pw.println(cadena);
					System.out.println(cadena);
				}
				
				br.close();
				fr.close();
				pw.close();
				fw.close();
			} catch (FileNotFoundException e) {

				System.err.println("No se ha encontrado el fichero");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
*/