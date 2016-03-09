package projeto.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SaqueGUI extends JFrame implements ActionListener
{
   private JLabel labelSaque;
   
   private JButton bSq1, bSq2, bSq3, bSq4, bSq5, bSq6, bSq7, bSq8,bMenu, bConfirma;
   private JTextArea area;
   private ResourceBundle bn = null;
   private int iIdioma = 0;
  
   
   
   public SaqueGUI()
   {
      super("Banco USJT S.A.");    
      //instancia containners
      Container cont = getContentPane();
      cont.setLayout(new BorderLayout());
      
      JPanel primeiro = new JPanel(new GridLayout(4,1));
        
      JPanel segundo= new JPanel(new GridLayout(4,1));
      
      JPanel terceiro= new JPanel(new GridLayout(1,2));  
      
      //instancia objetos
      labelSaque = new JLabel("TELA SAQUE");
      
      area = new JTextArea();
      area.setEditable(false);
   
      
   
      bSq1 = new JButton("R$20,00");
      bSq1.addActionListener(this); 
      
      bSq2 = new JButton("R$50,00");
      bSq2.addActionListener(this);   
      
      bSq3 = new JButton("R$100,00");
      bSq3.addActionListener(this);   
            
      bSq4 = new JButton("R$150,00");
      bSq4.addActionListener(this);   
      
      bSq5 = new JButton("R$200,00");
      bSq5.addActionListener(this);   
      
      bSq6 = new JButton("R$250,00");
      bSq6.addActionListener(this);
      
      bSq7 = new JButton("R$300,00");
      bSq7.addActionListener(this);     
      
      bSq8 = new JButton("Outros Valores");
      bSq8.addActionListener(this);
      
     bMenu = new JButton("Menu");
     bMenu.addActionListener(this);
      
      bConfirma = new JButton("Confirmar");
      bConfirma.addActionListener(this);
            
      primeiro.add(bSq1, BorderLayout.NORTH);
      primeiro.add(bSq2, BorderLayout.SOUTH);
      primeiro.add(bSq3, BorderLayout.CENTER); 
      primeiro.add(bSq7, BorderLayout.CENTER);
      
      
      segundo.add(bSq4, BorderLayout.NORTH);
      segundo.add(bSq5, BorderLayout.SOUTH);
      segundo.add(bSq6, BorderLayout.CENTER);
      segundo.add(bSq8, BorderLayout.CENTER); 
      
      terceiro.add(bMenu);
      terceiro.add(bConfirma);
      
      
   
      cont.add(primeiro, BorderLayout.EAST);
      cont.add(labelSaque, BorderLayout.NORTH);
      cont.add(area, BorderLayout.CENTER);
      cont.add(segundo, BorderLayout.WEST);
      cont.add(terceiro, BorderLayout.SOUTH);
      		
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
       
         bSq1.setText(bn.getString("botao.bSq1"));
         bSq2.setText(bn.getString("botao.bSq2"));
         bSq3.setText(bn.getString("botao.bSq3"));
         bSq4.setText(bn.getString("botao.bSq4"));
         bSq5.setText(bn.getString("botao.bSq5"));
         bSq6.setText(bn.getString("botao.bSq6"));
         bSq7.setText(bn.getString("botao.bSq7"));
         bSq8.setText(bn.getString("botao.bSq8"));  
        bMenu.setText(bn.getString("botao.bMenu"));
         bConfirma.setText(bn.getString("botao.bConfirma")); 
         labelSaque.setText(bn.getString("label.saque"));
      
      }
      else if(iIdioma == 2)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", Locale.US);
         
         bSq1.setText(bn.getString("botao.bSq1"));
         bSq2.setText(bn.getString("botao.bSq2"));
         bSq3.setText(bn.getString("botao.bSq3"));
         bSq4.setText(bn.getString("botao.bSq4"));
         bSq5.setText(bn.getString("botao.bSq5"));
         bSq6.setText(bn.getString("botao.bSq6"));
         bSq7.setText(bn.getString("botao.bSq7"));
         bSq8.setText(bn.getString("botao.bSq8"));  
        bMenu.setText(bn.getString("botao.bMenu"));
         bConfirma.setText(bn.getString("botao.bConfirma")); 
         labelSaque.setText(bn.getString("label.saque"));
                  
      }
      else if(iIdioma == 3)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("es", "ES"));     
            
         bSq1.setText(bn.getString("botao.bSq1"));
         bSq2.setText(bn.getString("botao.bSq2"));
         bSq3.setText(bn.getString("botao.bSq3"));
         bSq4.setText(bn.getString("botao.bSq4"));
         bSq5.setText(bn.getString("botao.bSq5"));
         bSq6.setText(bn.getString("botao.bSq6"));
         bSq7.setText(bn.getString("botao.bSq7"));
         bSq8.setText(bn.getString("botao.bSq8"));  
        bMenu.setText(bn.getString("botao.bMenu"));
         bConfirma.setText(bn.getString("botao.bConfirma"));      
         labelSaque.setText(bn.getString("label.saque"));   
      }
       
   }  

   
   public void actionPerformed(ActionEvent evento)
   {
   	
      if ( evento.getSource() == bConfirma )
      {
          
      }
      
      else if ( evento.getSource() ==bMenu )
      {
         MenuPrincipalGUI d = new MenuPrincipalGUI();
         d.setIdioma(iIdioma);
         d.traducao();
         dispose();
          
      }
      
   }   
   
}