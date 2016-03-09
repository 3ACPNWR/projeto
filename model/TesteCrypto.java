package projeto.model;

import java.io.File;
import javax.swing.*;
import java.util.Formatter;
import projeto.model.*;
public class TesteCrypto
{
   public static void main(String[] args) throws Exception
   {
   
      Leitor read = new Leitor();
      String str = read.lerArquivo();
   
      String sMsgClara = str;
      String sMsgCifrada = null;
      String sMsgDecifrada = null;
      String msg = "";
      byte[] bMsgClara = null;
      byte[] bMsgCifrada = null;
      byte[] bMsgDecifrada = null;
   
   // Instancia objeto da classe Impressora
      Impressora prn = new Impressora();
   // Converte o texto String dado no equivalente byte[]
      bMsgClara = sMsgClara.getBytes("ISO-8859-1");
   // Imprime o texto original em String
      msg += sMsgClara;
      System.out.println(msg);
      
   /*
   /   * Criptografia AES --------------------------------------------------------------
   */
   // Imprime Texto
      CryptoAES caes = new CryptoAES();
   // Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
      caes.geraChave(new File ("chave.simetrica"));
   // Gera a cifra AES da mensagem dada, com a chave simetrica dada
      caes.geraCifra(bMsgClara, new File ("chave.simetrica"));
   // Recebe o texto cifrado
      bMsgCifrada = caes.getTextoCifrado();
   // Converte o texto byte[] no equivalente String
      sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
   // Imprime o texto cifrado em String
      msg +=sMsgCifrada;
        
      String nomeArq="model/texto_cifrado.txt";
      try
      {
         Formatter saida = new Formatter(nomeArq);
         saida.format(msg);
         System.out.println(msg);
       }  
     //mostrando erro em caso se nao for possivel gerar arquivo
      catch(Exception erro){
         JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
      }
   }

}
