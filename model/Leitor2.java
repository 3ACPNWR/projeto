import java.io.*;
import java.lang.IllegalStateException;

public class Leitor2
{

   public String lerArquivo()
   {
      try {
         BufferedReader in = new BufferedReader(new FileReader("texto_cifrado.txt"));
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