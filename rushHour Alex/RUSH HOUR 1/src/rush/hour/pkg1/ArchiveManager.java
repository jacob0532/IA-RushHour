/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rush.hour.pkg1;

import java.io.*;

/**
 *
 * @author Jacob
 */
public class ArchiveManager {
    public String archiveName;
    int[][] configuration = new int[6][6];
    int[] exit = new int[2];

    public ArchiveManager(String archiveName) {
        this.archiveName = archiveName;
    }
    public String leerArchivo(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String texto="";
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (archiveName);
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null)
              texto+=linea+"\n";
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        setExitAndConfiguration(texto);
        return texto;
    }
    public void escribirArchivo(String texto){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archiveName);
            pw = new PrintWriter(fichero);
            pw.println(texto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                   fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }  
    }
    public void setExitAndConfiguration(String text){
        String[] textSplit2;
        text = text.replace("\n","");
        text = text.replace("{","");
        text = text.replace("}","");
        //System.out.println(text);
        String[] textSplit = text.split(";");
        for (int i = 0; i < 6; i++) {
            textSplit2 = textSplit[i].split(",");
            for (int j = 0; j < textSplit2.length; j++) {
                this.configuration[i][j] = Integer.parseInt(textSplit2[j]);
            }
        }
        textSplit2 = textSplit[6].split(",");
        this.exit[0] = Integer.parseInt(textSplit2[0]);
        this.exit[1] = Integer.parseInt(textSplit2[1]);
    }
    
    public int[][] getConfiguration(){
        
        return configuration;
    }
    public int[] getBoardExit(){
        
        return exit;
    }
    
}
