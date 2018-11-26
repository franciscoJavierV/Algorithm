package proyect_Algor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Modelo {

	FileReader lectura = null;
	PrintWriter pw = null;
	BufferedReader lector = null;
	HashMap<String, String> hash = new HashMap<>();
	private boolean correcto = true;
	String [] a = new String [6];

	public void leer() {
		
		try {
			lectura = new FileReader("txt/commandsyo.txt");
			lector = new BufferedReader(lectura);
			String linea = "asas";
			
			while ((linea = lector.readLine()) != null ) {
			//	linea = lector.readLine();
				// insertar codigo de verificacion de la sentencia
				if(linea != null)
				a = linea.split(" ");
				
				if (a[0].equals("create")) {
					System.out.println(linea);
					System.out.println("create");					
					String ruta = "txt/" + a[1].substring(1, a[1].length() - 1) + ".txt";
					System.out.println(ruta);
					File archivo = new File(ruta);
					if (archivo.exists()== false) {
					archivo.createNewFile();
					hash.put(a[1], a[3]);
					}else {
						System.out.println("ya existe");
					}
					String s = hash.get(a[3]);
					System.out.println(s);
				}
			
				if (a[0].equals("assing")) {
					String old[] = a.clone();
					String valor = a[3];
					String llave = a[1];
					
					System.out.println(linea);
					System.out.println("assign");
					if (hash.containsKey(llave)) {
						hash.replace(old[3], old[1], a[3]);
					} else {
						System.out.println("no hay un archivo creado con ese nombre");
					}
				}
		
				if (a[1].equals("=")) {					
					LinkedList<String> lista = new LinkedList<String>();
					String ruta1 = "txt/" + a[0] + ".txt";
					System.out.println(ruta1);
					String ruta2 = "txt/" + a[2] + ".txt";
					
					
					if(hash.containsValue(a[0])) {
						System.out.println("si contiene");
					}
					
					
					FileReader f = new FileReader(ruta1);
					BufferedReader b = new BufferedReader(f);
					FileWriter w = new FileWriter(ruta1);
					PrintWriter p = new PrintWriter(w);
					String lineas = null;				
					Scanner scan = new Scanner(new File(ruta1));
					if (linea.contains("sort")) {
						
						if (linea.contains("asc")) {
							System.out.println(linea);
							System.out.println("ascending");
							String s;
							while (scan.hasNextLine()) {	
								lineas = scan.nextLine();
								lista.add(lineas);
								System.out.println("linea" + lineas);
							}
							Collections.sort(lista);
							java.util.Iterator<String> iter = lista.iterator();
							String cadena;
							while (iter.hasNext()) {
								cadena = iter.next();
								 pw.println(cadena);
								System.out.println(cadena);
							}
						}						
						else if (linea.contains("des")) {
							System.out.println("descending");
							System.out.println(linea);
							String l = "as";
							while ((l = b.readLine()) != null) {
								System.out.println("entra");
								lista.add(l);
								System.out.println(l);
							}
							
							Collections.sort(lista, Collections.reverseOrder());
							java.util.Iterator<String> iter = lista.iterator();
							String cadena;
							while (iter.hasNext()) {
								cadena = iter.next();
							//	 pw.println(cadena);
								System.out.println(cadena);
							}
						}
						b.close();
						p.close();
					}
					else if (linea.contains("+")){
						System.out.println("igualar");
						// solo igualar
						LinkedList<String> listas = new LinkedList<String>();
							FileReader frr = new FileReader(ruta1);
							BufferedReader brr = new BufferedReader(frr);
							FileWriter fww = new FileWriter(ruta2);
							PrintWriter pww = new PrintWriter(fww);
							String lin = null;
							while ((lin = brr.readLine()) != null) {
								listas.add(lin);
							}
							java.util.Iterator<String> iter = listas.iterator();
							String cadena;
							while (iter.hasNext()) {
								cadena = (String) iter.next();
								pw.println(cadena);
								 System.out.println(cadena);
							}
							if(linea.contains("rem_doubles")) {
								System.out.println("rem_doubles");								
							}
						}
		
					}
			}
	
		}
		catch (
		IOException e) {
			e.printStackTrace();
		}
		
	}

}