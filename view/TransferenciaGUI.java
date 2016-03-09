package projeto.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TransferenciaGUI extends JFrame implements ActionListener
{
   private JLabel label1, label2, label3, label4, label5;
   private JTextField text1, text2, text3, text4;
   private JButton bConfirmar, bMenu;
   private ResourceBundle bn = null;
   private int iIdioma = 0; 
      
   
   public TransferenciaGUI()
   {
      super("Banco USJT S.A.");    
      //instancia containners
      Container cont = getContentPane();
      cont.setLayout(new BorderLayout());
      
      JPanel primeiro = new JPanel(new GridLayout(6,2));
      
        
      //instancia objetos
      label1 = new JLabel(" Agencia");
      label2 = new JLabel(" Conta");
      label3 = new JLabel(" Valor");
      label4 = new JLabel(" Codigo");
      label5 = new JLabel("Transferir para... ");
      
      label1.setFont(new Font("Calibri", Font.PLAIN, 22));
      label2.setFont(new Font("Calibri", Font.PLAIN, 22));
      label3.setFont(new Font("Calibri", Font.PLAIN, 22));
      label4.setFont(new Font("Calibri", Font.PLAIN, 22));
      label5.setFont(new Font("Calibri", Font.PLAIN, 22));
   
      text1 = new JTextField();
      text2 = new JTextField();
      text3 = new JTextField();
      text4 = new JTextField();            
   
      bConfirmar = new JButton("Confirmar");
      bConfirmar.addActionListener(this); 
      
      bMenu = new JButton("Menu");
      bMenu.addActionListener(this);   
       
      primeiro.add(label1, BorderLayout.EAST);
      primeiro.add(text1, BorderLayout.CENTER);
      primeiro.add(label2, BorderLayout.WEST);
      primeiro.add(text2, BorderLayout.EAST);
      primeiro.add(label3, BorderLayout.CENTER);
      primeiro.add(text3, BorderLayout.WEST);
      primeiro.add(label4, BorderLayout.CENTER);
      primeiro.add(text4, BorderLayout.WEST);
      primeiro.add(bConfirmar, BorderLayout.EAST);
      primeiro.add(bMenu, BorderLayout.CENTER);
      cont.add(primeiro, BorderLayout.CENTER);
      cont.add(label5, BorderLayout.NORTH);
   
            		
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
       
         bConfirmar.setText(bn.getString("botao.bConfirmar"));
         bMenu.setText(bn.getString("botao.bMenu"));
         label1.setText(bn.getString("rotulo.label1"));
         label2.setText(bn.getString("rotulo.label2"));
         label3.setText(bn.getString("rotulo.label3"));
         label4.setText(bn.getString("rotulo.label4"));
         label5.setText(bn.getString("rotulo.label5"));        
      }
      else if(iIdioma == 2)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", Locale.US);
         
         bConfirmar.setText(bn.getString("botao.bConfirmar"));
         bMenu.setText(bn.getString("botao.bMenu"));
         label1.setText(bn.getString("rotulo.label1"));
         label2.setText(bn.getString("rotulo.label2"));
         label3.setText(bn.getString("rotulo.label3"));
         label4.setText(bn.getString("rotulo.label4"));
         label5.setText(bn.getString("rotulo.label5"));
      
      
         
      }
      else if(iIdioma == 3)
      {
         
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("es", "ES")); 
                 
         bConfirmar.setText(bn.getString("botao.bConfirmar"));
         bMenu.setText(bn.getString("botao.bMenu"));
         label1.setText(bn.getString("rotulo.label1"));
         label2.setText(bn.getString("rotulo.label2"));
         label3.setText(bn.getString("rotulo.label3"));
         label4.setText(bn.getString("rotulo.label4"));
         label5.setText(bn.getString("rotulo.label5"));
      
      }
       
   }  

   public void actionPerformed(ActionEvent evento)
   {
      if ( evento.getSource() == bConfirmar )
      {
          
      }
      
      else if ( evento.getSource() == bMenu )
      {
         MenuPrincipalGUI d = new MenuPrincipalGUI();
         d.setIdioma(iIdioma);
         d.traducao();
         dispose();
          
      }
      
      
   }   
   
}