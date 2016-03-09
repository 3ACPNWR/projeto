package projeto.view;

import projeto.DAO.ClienteDAO;
import projeto.DAO.AcessoBD;
import java.sql.Connection;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.*;
import java.awt.Font; 


public class Saldo implements ActionListener
{
   private Janela janela;
   private Rotulo saldoR, dataR, mesR, diaR,anoR;
   private CaixaDeTexto saldo, data;
   private JButton bConfirmar, bMenu, bSair;
   private JComboBox cMes,cDia, cAno;   
   private String sMes[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
   private String sDia[];
   private String sAno[];
   private ImageIcon icon;
   private JLabel imagem;
   private int iIdioma;
   private ResourceBundle bn = null;
   private String aMes, aDia, aAno, aData;
   
   
   private String GlobaltxtContaU = "";
   
   public Saldo()
   {
      
      
      //Janela
      janela = new Janela("Banco USTJ S.A.");
      //Imagem
      icon = new  ImageIcon(getClass().getResource("icon.png"));
      imagem = new JLabel(icon);
      //Rotulo
      dataR = new Rotulo("Data");
      saldoR = new Rotulo("Saldo");    
      mesR = new Rotulo("Mes");
      diaR = new Rotulo("Dia");
      anoR = new Rotulo("Ano");
      dataR.setFont(new Font("Calibri", Font.PLAIN, 22));
      saldoR.setFont(new Font("Calibri", Font.PLAIN, 22));
      mesR.setFont(new Font("Calibri", Font.PLAIN, 22));
      diaR.setFont(new Font("Calibri", Font.PLAIN, 22));
      anoR.setFont(new Font("Calibri", Font.PLAIN, 22));
      
      //Caixa De Texto
      saldo = new CaixaDeTexto();
      saldo.setEditable( false );
      saldo.setText("R$ 0,00");
      data = new CaixaDeTexto();
      data.setText("Dia");
      //Botao
      bConfirmar = new Botao("Confirmar");
      bMenu      = new Botao("Menu"     );
      bSair      = new Botao("Sair"     );
      //ActionListenr
      bConfirmar.addActionListener(this);
      bMenu.addActionListener(this);
      bSair.addActionListener(this);
      //JComboBox
      cMes = new JComboBox( sMes );   
      
      sDia = new String[31];
      for(int c = 0; c < 31;c++)
      {
         sDia[c] = "" + (c+1);
      }
      
      cDia = new JComboBox( sDia );  
      
      
      sAno = new String[50];
      for(int c = 0; c < 50; c++)
      {
         sAno[c] = "" + (2015 + c);
      }
      
      cAno = new JComboBox( sAno );
      
      
      cMes.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ActionEvent arg0)
               { 
                  aMes = ((String)cMes.getSelectedItem());
               }  
            }); 
            
      cDia.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ActionEvent arg0)
               { 
                  aDia = ((String)cDia.getSelectedItem());
               }  
            }); 
          
      cAno.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ActionEvent arg0)
               { 
                  aAno = ((String)cAno.getSelectedItem());
               }  
            }); 
            
      
            
            
          
      //Add
      janela.getContentPane().add(mesR);
      janela.getContentPane().add(cMes);
      janela.getContentPane().add(diaR);
      janela.getContentPane().add(cDia);
      janela.getContentPane().add(anoR);
      janela.getContentPane().add(cAno);
      janela.getContentPane().add(saldoR);        
      janela.getContentPane().add(saldo);
      janela.getContentPane().add(bConfirmar);
      janela.getContentPane().add(imagem);
      janela.getContentPane().add(bMenu);
      janela.getContentPane().add(bSair);
   
         
      janela.setVisible(true);      
   }
   
   public String getHora() {  
      
    // cria um StringBuilder  
      StringBuilder sb = new StringBuilder();  
   
    // cria um GregorianCalendar que vai conter a hora atual  
      GregorianCalendar d = new GregorianCalendar();  
      
    // anexa do StringBuilder os dados da hora  
      sb.append( d.get( GregorianCalendar.HOUR_OF_DAY ) );  
      sb.append( ":" );  
      sb.append( d.get( GregorianCalendar.MINUTE ) );  
      sb.append( ":" );  
      sb.append( d.get( GregorianCalendar.SECOND ) );  
      
    // retorna a String do StringBuilder  
      return sb.toString();  
     
   
      
   }  
   
  
	
   
   public void setIdioma(int i)
   {
      iIdioma = i;
   }
   
   
   public void traducao()
   {
      
      if(iIdioma == 1)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("pt", "BR"));
         
         dataR.setText(bn.getString("rotulo.data"));
         saldoR.setText(bn.getString("rotulo.saldo"));
         mesR.setText(bn.getString("rotulo.mes"));
         diaR.setText(bn.getString("rotulo.dia"));
         bConfirmar.setText(bn.getString("botao.confirmar"));
         bMenu.setText(bn.getString("botao.menu"));
         bSair.setText(bn.getString("botao.sair"));     
         data.setText(bn.getString("text.data"));
         saldo.setText(bn.getString("text.saldo")); 
         anoR.setText(bn.getString("rotulo.ano"));
      }
      else if(iIdioma == 2)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", Locale.US);
         
         dataR.setText(bn.getString("rotulo.data"));
         saldoR.setText(bn.getString("rotulo.saldo"));
         mesR.setText(bn.getString("rotulo.mes"));
         diaR.setText(bn.getString("rotulo.dia"));
         bConfirmar.setText(bn.getString("botao.confirmar"));
         bMenu.setText(bn.getString("botao.menu"));
         bSair.setText(bn.getString("botao.sair"));
         data.setText(bn.getString("text.data"));
         saldo.setText(bn.getString("text.saldo"));       
         anoR.setText(bn.getString("rotulo.ano"));
      
      }
      else if(iIdioma == 3)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("es", "ES"));
          
         dataR.setText(bn.getString("rotulo.data"));
         saldoR.setText(bn.getString("rotulo.saldo"));
         mesR.setText(bn.getString("rotulo.mes"));
         diaR.setText(bn.getString("rotulo.dia"));
         bConfirmar.setText(bn.getString("botao.confirmar"));
         bMenu.setText(bn.getString("botao.menu"));
         bSair.setText(bn.getString("botao.sair"));
         data.setText(bn.getString("text.data"));
         saldo.setText(bn.getString("text.saldo"));  
         anoR.setText(bn.getString("rotulo.ano"));
      }
      
   }
   
  
   
   public String recebeContaU(String txConta)
   {
      String txtConta = txConta;
      
      GlobaltxtContaU = txtConta;
      return txtConta;
   }
 
   public void actionPerformed(ActionEvent event)
   {
      if ( event.getSource() == bMenu )
      {
         MenuPrincipalGUI m = new MenuPrincipalGUI();
         m.setIdioma(iIdioma);
         m.traducao();
         janela.dispose();
      }
      else if ( event.getSource() == bSair )
      {
         TelaInicial t = new TelaInicial();
         janela.dispose();
      } 
      else if ( event.getSource() == bConfirmar )
      {
         ClienteDAO  cDAO = new ClienteDAO();
         Connection conn = null;
         aData = aAno + aMes + aDia; 
         
         cDAO.setData(aData);
      
         try
         {
            AcessoBD bd = new AcessoBD();
            conn = bd.obtemConexao();
            conn.setAutoCommit(false);
         
         
            String txt = cDAO.consultarSaldo(conn, GlobaltxtContaU); 
            if(txt == null)
            {
               saldo.setText(txt);
            }
            else
            {
               
               if(iIdioma == 1)
               {
                  saldo.setText("Indisponível");
               }else if(iIdioma == 2)
               {
                  saldo.setText("Unavaliable");
               }else if(iIdioma == 3)
               {
                  saldo.setText("Indisponible");
               }
               else
               {
                  saldo.setText("Indisponível");
               }
            }
         
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         
                  
      }
   
   
   
   }
   
}