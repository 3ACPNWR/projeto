/*Deve permitir o cadastro de débito automático para as contas de água,
luz e telefone, informando para isso o código da operadora (devem estar
previamente cadastradas no banco de dados), a data de débito e o código
do consumidor. O cadastro do débito deve ser armazenado e o sistema deve
realizar o lançamento e o débito na conta do cliente, conforme a programação.*/

package projeto.view;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.Font; 


public class DebitoAuto  implements ActionListener
{
   private Janela janela;
   private Rotulo servicoR, codigoOpR, dataDebR, codConsuR, aux;
   private CaixaDeTexto codigoOp, data, codConsu;
   private JButton bConfirmar, bMenu, bSair;
   private JComboBox caixa;
   private String serv[] = new String[4]; //{"Selecione","Agua","Luz","Telefone"};
   private int iIdioma = 0;
   private ResourceBundle bn = null;
   
   
   public DebitoAuto()
   {
      bn = ResourceBundle.getBundle("projeto.view.prj");
      //Janela
      janela = new Janela("Banco USJT S.A.");
      //Servico
      serv[0] = bn.getString("string.selecao");
      serv[1] = bn.getString("string.agua");
      serv[2] = bn.getString("string.luz");
      serv[3] = bn.getString("string.fone");
      //Rotulo
      servicoR  = new Rotulo("Servico");
      codigoOpR = new Rotulo("Operadora(cod) ");
      dataDebR     = new Rotulo("Data de Débito ");
      codConsuR = new Rotulo("Consumidor(cod)");
      aux       = new Rotulo(getHora());
      servicoR.setFont(new Font("Calibri", Font.PLAIN, 22));
      codigoOpR.setFont(new Font("Calibri", Font.PLAIN, 22));
      dataDebR.setFont(new Font("Calibri", Font.PLAIN, 22));
      codConsuR.setFont(new Font("Calibri", Font.PLAIN, 22));
      aux.setFont(new Font("Calibri", Font.PLAIN, 22));
      
      //Caixa de Texto
      codigoOp = new CaixaDeTexto();
      data = new CaixaDeTexto();
      codConsu = new CaixaDeTexto();
      //Botão
      bConfirmar = new Botao("Confirmar");
      bMenu      = new Botao("Menu     ");
      bSair      = new Botao("Sair     ");
      //ActionListener
      bConfirmar.addActionListener(this); 
      bMenu.addActionListener(this);
      bSair.addActionListener(this);
      //JComboBox
      caixa = new JComboBox( serv );   
      //Add
      janela.getContentPane().add( servicoR);
      janela.getContentPane().add(caixa); 
      janela.getContentPane().add(codigoOpR);
      janela.getContentPane().add(codigoOp);
      janela.getContentPane().add(dataDebR);
      janela.getContentPane().add(data);
      janela.getContentPane().add(codConsuR);
      janela.getContentPane().add(codConsu);
      janela.getContentPane().add(bConfirmar);
      janela.getContentPane().add(bMenu);
      janela.getContentPane().add(aux);
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
         
         servicoR.setText(bn.getString("rotulo.servico"));
         codigoOpR.setText(bn.getString("rotulo.codigoOp"));
         dataDebR.setText(bn.getString("rotulo.dataDeb"));
         codConsuR.setText(bn.getString("rotulo.codigoCons"));
         bConfirmar.setText(bn.getString("botao.confirmar"));
         bMenu.setText(bn.getString("botao.menu"));
         bSair.setText(bn.getString("botao.sair"));
         String aux[] = {(bn.getString("string.selecao")),(bn.getString("string.agua")),(bn.getString("string.luz")),(bn.getString("string.fone"))};
         serv = aux;
         
      }
      else if(iIdioma == 2)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", Locale.US);
         
         servicoR.setText(bn.getString("rotulo.servico"));
         codigoOpR.setText(bn.getString("rotulo.codigoOp"));
         dataDebR.setText(bn.getString("rotulo.dataDeb"));
         codConsuR.setText(bn.getString("rotulo.codigoCons"));
         bConfirmar.setText(bn.getString("botao.confirmar"));
         bMenu.setText(bn.getString("botao.menu"));
         bSair.setText(bn.getString("botao.sair"));
       
         String aux[] = {(bn.getString("string.selecao")),(bn.getString("string.agua")),(bn.getString("string.luz")),(bn.getString("string.fone"))};
         serv = aux;      
      }
      else if(iIdioma == 3)
      {
         bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("es", "ES"));
         
         servicoR.setText(bn.getString("rotulo.servico"));
         codigoOpR.setText(bn.getString("rotulo.codigoOp"));
         dataDebR.setText(bn.getString("rotulo.dataDeb"));
         codConsuR.setText(bn.getString("rotulo.codigoCons"));
         bConfirmar.setText(bn.getString("botao.confirmar"));
         bMenu.setText(bn.getString("botao.menu"));
         bSair.setText(bn.getString("botao.sair"));
      
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
   
   
   }

   
   //Provisório
   public static void main(String args[])
   {
      DebitoAuto debauto = new DebitoAuto();
   }
     



}