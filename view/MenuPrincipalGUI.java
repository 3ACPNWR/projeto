package projeto.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class MenuPrincipalGUI extends JFrame implements ActionListener
{
   private JLabel lValor1, lValor2, lResultado;
   private JTextField tValor1, tValor2, tResultado;
   private JButton b1, b2, b3, b4, b5, b6;
   private JTextArea area;
   private ResourceBundle bn = null;
   private int iIdioma = 0;   
   
   private String GlobaltxtConta ="";
   
   public  MenuPrincipalGUI()
   {
      super("Banco USJT S.A.");    
      //instancia containners
      Container cont = getContentPane();
      cont.setLayout(new BorderLayout());
      
      JPanel primeiro = new JPanel(new GridLayout(3,1));
        
      JPanel segundo = new JPanel(new GridLayout(3,1));  
      //instancia objetos
      lValor1 = new JLabel("LABEL TESTE");
      tValor1 = new JTextField(10);
      tValor2 = new JTextField(10);
      tResultado = new JTextField(10);
      tResultado.setEditable(false);
   
      area = new JTextArea();
      
   
      b1 = new JButton("Transferencia");
      b1.addActionListener(this); 
      b1.setSize(3,3);
      
      b2 = new JButton("Extrato");
      b2.addActionListener(this);   
      b2.setSize(3,3);
      
      b3 = new JButton("Finalizar sessao");
      b3.addActionListener(this);  
      b3.setSize(3,3);
            
      b4 = new JButton(" Saldo");
      b4.addActionListener(this);  
      b4.setSize(3,3);
      
      b5 = new JButton("Debito automatico");
      b5.addActionListener(this);   
      b5.setSize(3,3);
      
      b6 = new JButton("Saque");
      b6.addActionListener(this);     
      b6.setSize(3,3);
      
      primeiro.add(b1, BorderLayout.NORTH);
      primeiro.add(b2, BorderLayout.SOUTH);
      primeiro.add(b3, BorderLayout.CENTER); 
      
      segundo.add(b4, BorderLayout.NORTH);
      segundo.add(b5, BorderLayout.SOUTH);
      segundo.add(b6, BorderLayout.CENTER); 
      
      
   
      cont.add(primeiro, BorderLayout.EAST);
      cont.add(area, BorderLayout.CENTER);
      cont.add(segundo, BorderLayout.WEST);
      		
      this.setSize(800,600);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);      
   }
	
	
   //ACTION
   public void setIdioma(int i)
   {
      iIdioma = i;
   }
   
   public void traducao()
   {
      
      if(iIdioma == 1)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("pt", "BR"));
       
         b1.setText(bn.getString("botao.b1"));
         b2.setText(bn.getString("botao.b2"));
         b3.setText(bn.getString("botao.b3"));
         b4.setText(bn.getString("botao.b4"));
         b5.setText(bn.getString("botao.b5"));
         b6.setText(bn.getString("botao.b6"));          
      }
      else if(iIdioma == 2)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", Locale.US);
         
         b1.setText(bn.getString("botao.b1"));
         b2.setText(bn.getString("botao.b2"));
         b3.setText(bn.getString("botao.b3"));
         b4.setText(bn.getString("botao.b4"));
         b5.setText(bn.getString("botao.b5"));
         b6.setText(bn.getString("botao.b6"));      
      }
      else if(iIdioma == 3)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("es", "ES"));     
            
         b1.setText(bn.getString("botao.b1"));
         b2.setText(bn.getString("botao.b2"));
         b3.setText(bn.getString("botao.b3"));
         b4.setText(bn.getString("botao.b4"));
         b5.setText(bn.getString("botao.b5"));
         b6.setText(bn.getString("botao.b6"));
      }
       
   }  


   public String recebeConta(String txConta)
   {
      String txtConta = txConta;      
      GlobaltxtConta = txtConta;
      return txtConta;
   }
   
     
   public void actionPerformed(ActionEvent evento)
   {
      if ( evento.getSource() == b1 )
      {
         TransferenciaGUI t = new TransferenciaGUI();
         t.setIdioma(iIdioma);
         t.traducao();
         dispose();
      }
      
      else if ( evento.getSource() == b2 )
      {
         Extrato d = new Extrato();
         d.setIdioma(iIdioma);
         d.traducao();
         dispose();
          
      }
      
      else if ( evento.getSource() == b3 )
      {
         TelaInicial ti = new TelaInicial(); 
         dispose();         
      }
      
      else if ( evento.getSource() == b4 )
      {
         Saldo s = new Saldo();
         s.setIdioma(iIdioma);
         s.traducao();
         s.recebeContaU(GlobaltxtConta);
         dispose();
      }
      
      else if ( evento.getSource() == b5 )
      {
         DebitoAuto e = new DebitoAuto();
         e.setIdioma(iIdioma);
         e.traducao();
         dispose();
      }
      
      else if ( evento.getSource() == b6 )
      {
         SaqueGUI sq = new SaqueGUI();
         sq.setIdioma(iIdioma);
         sq.traducao();
         dispose();
      }
      
   } 
   
     
   
}