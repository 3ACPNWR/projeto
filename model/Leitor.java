package projeto.model;

import java.io.*;
import java.lang.IllegalStateException;


public class Leitor
{

   public String lerArquivo()
   {
      try 
      {
         File f = new File("projeto/model/texto_decifrado.txt");
         String caminho = f.getAbsolutePath();
         
         BufferedReader in = new BufferedReader(new FileReader(caminho));
         String str;
         StringBuffer buf = new StringBuffer();
         while (in.ready()) {
            str = in.readLine();
            buf.append(str);
         }
         in.close();
         return buf.toString();
      } 
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
}