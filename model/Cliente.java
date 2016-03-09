//CPF//Nome//Codigo//Agencia//Conta//Senha

//package projeto.view;
package projeto.model;

import javax.swing.*;
import java.util.Formatter;
import java.io.*;
public class Cliente
{
   protected String cpf, nome;
   protected String agencia, conta;
   protected int codigo;
   protected String senha;
      
   
   public Cliente(){}
 
 
   public Cliente(String cp, String nm, String ag, String ct, int cd, String sn)
   {
      this.cpf = cp;
      this.nome = nm;
      this.agencia = ag;
      this.conta = ct;
      this.codigo = cd;
      this.senha = sn;
   }
 
   
   //Get's
   public String getCpf(){
      return this.cpf;}
   public String getNome(){
      return this.nome;}
   public String getAgencia(){
      return this.agencia;}
   public String getConta(){
      return this.conta;}
   public String getSenha(){
      return this.senha;}
   public int getCodigo(){
      return this.codigo;}
  
   //Set's
   public void setCpf(String sA)    {this.cpf = sA;    }
   public void setNome(String sA)   {this.nome = sA;   }
   public void setAgencia(String sA){this.agencia = sA;}
   public void setConta(String sA)  {this.conta = sA;  }
   public void setSenha(String sA)  {this.senha = sA;  }
   public void setCodigo(int iA)    {this.codigo = iA; }
   
   
   //Exibir
   public String exibir()
   {
      String msg = null;
      
      msg += "Codigo:    " + getCodigo();
      msg += "\nNome:      " + getNome();
      msg += "\nCPF:     " + getCpf();
      msg += "\nAgencia: " + getAgencia();
      msg += "\nConta:   " + getConta();
      msg += "\nSenha :    " + getSenha();
      
      return msg;      
   }
   
  
   
   //Salvar em TXT
   
   public void salvar()
   {
      
      String nomeArq= "Usuario " + getCodigo() + ".txt";
      System.out.println(nomeArq);
    //tentando criar arquivo
      try
      {
         Formatter saida = new Formatter(nomeArq);
         saida.format(exibir());
         saida.close();
      
      }
      catch(Exception erro)
      {
         JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
      }
   
   }
   
   
   
   
  
   
   public String[] descripto()
   {
   
      Leitor read = new Leitor();
      String str = read.lerArquivo();
   
      String user[] = str.split(",");
      
      long vet[] = new long[4];
      for(int i = 0; i < vet.length;i++)
      {
         vet[i] = Long.parseLong(user[i]);
      }
      
      return user; 
   }
     
   public int buscaBinaria(String[] vetor, long busca)
   {
      int inicio, meio, fim, resultado;

      inicio = 0;
      fim = vetor.length-1;
      resultado = -1;

      while(inicio <= fim)
      {
         meio = (inicio + fim)/2;

         if(Long.parseLong(vetor[meio].substring(0, 10)) == busca)
         {
            resultado = meio;
            inicio = (fim + 1);
         }
         else
         {
            if(Long.parseLong(vetor[meio].substring(0, 10)) > busca)
            {
               fim = meio - 1;
            }
            else
            {
               inicio = meio + 1;
            }
         }
      }

      return resultado;
   }  
     
   public String cripto() throws Exception
   {
      
      Leitor read = new Leitor();
      String str = read.lerArquivo();
      System.out.println(str);
   
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
      System.out.println(msg);
      CryptoAES caes = new CryptoAES();
      caes.geraChave(new File ("chave.simetrica"));
      caes.geraCifra(bMsgClara, new File ("chave.simetrica"));
      bMsgCifrada = caes.getTextoCifrado();
      //sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
      sMsgCifrada = (prn.hexBytesToString(bMsgCifrada));
      msg +=sMsgCifrada;
      
      criaTxt c = new criaTxt();
      c.cria(msg);
      
      return msg;
   }
   
   
   //ConsultaSaldo()-- DAO
}
   
      
   
