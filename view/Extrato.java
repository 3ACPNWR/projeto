package projeto.view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font; 
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.*;
import javax.swing.*;
import java.util.Date;
   import java.awt.Font; 

public class Extrato implements ActionListener
{
   private Janela janela;
   private JButton bSete, bQuinze, bMenu, bConfirm, bSair, bPerson ;
   private Rotulo personIR,aux,extR;
   private CaixaDeTexto personI,personF;
   private ImageIcon icon;
   private JLabel imagem;
   private int iIdioma;
   private ResourceBundle bn = null;
   private String mensagem;
   
   
   public Extrato()
   {
      //Janela
      janela = new Janela("Banco USJT S.A."); 
      //
      icon = new  ImageIcon(getClass().getResource("ext.png"));
      imagem = new JLabel(icon);     
      //Botão
      bSete    = new Botao("7 Dias");
      bQuinze  = new Botao("15 Dias");
      bMenu    = new Botao("Menu");
      bConfirm = new Botao("Confirmar");  
      bSair    = new Botao("Sair");
      bPerson  = new Botao("Personalizado");   
      //ActionListener
      bSete.addActionListener(this);
      bQuinze.addActionListener(this);
      bMenu.addActionListener(this);
      bConfirm.addActionListener(this);
      bSair.addActionListener(this);
      bPerson.addActionListener(this);
      //Rótulo
      aux = new Rotulo(" ");
      extR = new Rotulo(getHora());
      extR.setFont(new Font("Calibri", Font.ITALIC, 18));
      //Caixa de Texto
      personI = new CaixaDeTexto();  
      personF = new CaixaDeTexto();   
      personI.setEditable(false);  
      personF.setEditable(false);           
      //Add
      janela.getContentPane().add(aux);
      janela.getContentPane().add(imagem);
      janela.getContentPane().add(bSete);
      janela.getContentPane().add(bQuinze);
      janela.getContentPane().add(bMenu);
      janela.getContentPane().add(bPerson);
      janela.getContentPane().add(personI);
      janela.getContentPane().add(personF);
      janela.getContentPane().add(bConfirm);
      janela.getContentPane().add(bSair);
      janela.getContentPane().add(extR);
      
      janela.setVisible(true);
      
      personI.setText("Digite a Data(DDMMAAAA)");
      personF.setText("Digite a Data(DDMMAAAA)");
      
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
         
         bSete.setText(bn.getString("botao.sete"));
         bQuinze.setText(bn.getString("botao.quinze"));
         bMenu.setText(bn.getString("botao.menu"));
         bConfirm.setText(bn.getString("botao.confirmar"));
         bSair.setText(bn.getString("botao.sair"));
         bPerson.setText(bn.getString("botao.personalizado"));
         personI.setText(bn.getString("text.personI"));
         personF.setText(bn.getString("text.personF"));
         
      }
      else if(iIdioma == 2)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", Locale.US);
         
         bSete.setText(bn.getString("botao.sete"));
         bQuinze.setText(bn.getString("botao.quinze"));
         bMenu.setText(bn.getString("botao.menu"));
         bConfirm.setText(bn.getString("botao.confirmar"));
         bSair.setText(bn.getString("botao.sair"));
         bPerson.setText(bn.getString("botao.personalizado"));
         personI.setText(bn.getString("text.personI"));
         personF.setText(bn.getString("text.personF"));
         
         
      }
      else if(iIdioma == 3)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("es", "ES"));
          
         bSete.setText(bn.getString("botao.sete"));
         bQuinze.setText(bn.getString("botao.quinze"));
         bMenu.setText(bn.getString("botao.menu"));
         bConfirm.setText(bn.getString("botao.confirmar"));
         bPerson.setText(bn.getString("botao.personalizado"));
         personI.setText(bn.getString("text.personI"));
         personF.setText(bn.getString("text.personF"));
      }
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
      
      if ( event.getSource() == bSair )
      {
         TelaInicial t = new TelaInicial();
         janela.dispose();
      }
      if(event.getSource() == bPerson && iIdioma == 1 )
      {
         String sI = JOptionPane.showInputDialog((bn.getString("show.msg1")));
         String sF = JOptionPane.showInputDialog((bn.getString("show.msg2")));
         personI.setText(sI);  
         personF.setText(sF);  
      }
      else if(event.getSource() == bPerson && iIdioma == 2 )
      {
         String sI = JOptionPane.showInputDialog((bn.getString("show.msg1")));
         String sF = JOptionPane.showInputDialog((bn.getString("show.msg2")));
         personI.setText(sI);  
         personF.setText(sF);  
         
      }
      else if(event.getSource() == bPerson && iIdioma == 3 )
      {
         String sI = JOptionPane.showInputDialog((bn.getString("show.msg1")));
         String sF = JOptionPane.showInputDialog((bn.getString("show.msg2")));
         personI.setText(sI);  
         personF.setText(sF);  
         
      }
   
   
   
   }
     

}