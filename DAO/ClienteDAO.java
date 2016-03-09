//CPF//Nome//Codigo//Agencia//Conta//Senha
package projeto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.*;
import projeto.model.Cliente;
import projeto.view.Saldo;

public class ClienteDAO
{
   private String cpf, nome;
   private String agencia, conta;
   private int codigo;
   private String senha;
   public String sData;
   
   Cliente c = new Cliente();
   
   public ClienteDAO()
   {
      codigo = c.getCodigo();
      cpf = c.getCpf();
      nome = c.getNome();
      agencia = c.getAgencia();
      conta = c.getConta();
      senha = c.getSenha();  
   }
   
   public void setData(String d)
   {
      sData = d;
   }
   
   
   //Inclusão, Consulta, Alteração e Exclusão
   
   public String consultarSaldo(Connection conn, String cont)
   {
      String sqlSelect = "SELECT * FROM saldo WHERE conta = ? and data_saldo = ?";
      PreparedStatement stm = null;
      ResultSet rs = null;  
      String sConta = cont;
      String sA = "";
      
      
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         stm.setString(1,sConta);
         stm.setString(2,sData);
         rs = stm.executeQuery();
         while(rs.next())
         {
            sA = rs.getString("saldo");
         }
         stm.close();         
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }   
      
      return sA;
   }
   
   public void debAuto(Connection conn,String cp,String serv,String oper,String dat,String consum)
   {
      String sCpf = cp;
      String sServ = serv;
      String sOper = oper;
      String sData = dat;
      String sConsum = consum;
      String sqlInsert = "INSERT INTO debauto(id_operacao, cpf, servico, operadora, data_deb, consumidor ) VALUES(?, ?, ?, ?, ?, ?)";
      PreparedStatement stm = null;
      int iA = 2;
      try
      {
         stm = conn.prepareStatement(sqlInsert); 
         stm.setInt(1,iA);
         stm.setString(2,sCpf);
         stm.setString(3,sServ);
         stm.setString(4, sOper);
         stm.setString(5,sData);
         stm.setString(6,sConsum);
         stm.execute();         
         
         stm.close();         
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      System.out.println("OK");      
      
   }
   
   public void transferir(Connection conn,String age,String con,double valor)
   {
      int iA = 3;
      String sAg = age;
      String sCon = con;
      double dValor = valor; 
      int iCod = 4422;
      String sqlInsert = "INSERT INTO transferencia(id_operacao,agencia,conta,valor,id_transf) VALUES (?, ?, ?, ?, ?)";
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setInt(1,iA);
         stm.setString(2,sAg);
         stm.setString(3, sCon);
         stm.setDouble(4,dValor);
         stm.setInt(5,iCod);
         stm.execute();
         
         stm.close();  
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   
      
      
   }
   
   public void extrato(Connection conn, String cp, String data)
   {
      //id_operacao, cpf, valor, data_ext
      String sCpf = cp;
      String sData = data;
      String sqlSelect = "SELECT * FROM extrato where cpf = ? AND data_ext >= ?";
      PreparedStatement stm = null;
      ResultSet rs = null;  
      String sA = "****** Extrato ********\n";
      
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         stm.setString(1,sCpf);
         stm.setString(2,sData);
         rs = stm.executeQuery();
         while(rs.next())
         {           
            sA += "Data:  " +  rs.getString("data_ext") + "\n";
            sA += "Saldo: " +  rs.getString("saldo") + "\n";
            
         }
         stm.close();         
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
      JOptionPane.showMessageDialog(null,sA);
      
   }
   
   public void InsertExtrato(Connection conn, String cp, double sal)
   {
      String sqlInsert = "INSERT INTO extrato(id_operacao , cpf , saldo , data_ext) VALUES(?,?,?,?)";
      PreparedStatement stm = null;
      int iA = 4;
      String sCpf = cp;
      double dSaldo = sal;
      String sData = "20151010";
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setInt(1,iA);
         stm.setString(2,sCpf);
         stm.setDouble(3,dSaldo);
         stm.setString(4,sData);
         stm.execute();
      
         stm.close(); 
      }        
      catch(Exception e)
      {
         e.printStackTrace();
      }      
   
   }
   
   
   //cpf, id_operacao, saldo_disp ,saldo_mes
   public void updateSaldo(Connection conn,String cont, double sal)
   {
      String sqlInsert = "UPDATE saldo SET saldo_disp = ? WHERE conta = ?";
      PreparedStatement stm = null;  
      String sConta = cont;
      double dSaldo = sal;   
      try
      {  
         stm.setDouble(1,dSaldo);
         stm.setString(2,sConta);
         stm.execute();
         stm.close(); 
      
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   
   
   public static void main(String args[])
   {
      ClienteDAO c = new ClienteDAO();
      Connection conn = null; 
       
      try
      {
         AcessoBD bd = new AcessoBD();
         conn = bd.obtemConexao();
         conn.setAutoCommit(false);
       //c.consultarSaldo(conn,"292427");
       //c.consultarSaldo(conn,"23498798712");
       //c.consultarSaldo(conn,"42340910230");
       
       
       
      //c.debAuto(conn,"42340910230","1","333333","20150303","3456");
        // c.transferir(conn,"2233","234329",12.0);
       // c.extrato(conn,"12309834429","20151111");
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
   }
   
   
   
   
  
   
   
}