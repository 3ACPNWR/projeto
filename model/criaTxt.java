package projeto.model;

import java.io.*;
import javax.swing.*;
import java.util.Formatter; //formatar arquivo
 
public class criaTxt{
   
 // public static void main(String[] args){
 
 public void cria(String s)
 {
      File f = new File("projeto/model/texto_cifrado.txt");
      String caminho = f.getAbsolutePath(); 
      
    //tentando criar arquivo
    try
    {
      Formatter saida = new Formatter(caminho);
      saida.format(s);
      saida.close();      
    }
    //mostrando erro em caso se nao for possivel gerar arquivo
    catch(Exception erro){
      //JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
    }
  } 
}
