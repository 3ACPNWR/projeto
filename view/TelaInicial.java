package projeto.view;

import projeto.model.Cliente;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font; 
import java.util.Observer;
import java.util.Locale;
import java.util.ResourceBundle;




public class TelaInicial implements ActionListener
{
   private Janela janela;
   private Rotulo codigoR, agenciaR, contaR, senhaR, idiomaR;
   private CaixaDeTexto agencia, conta;
   private JButton confirmar, sair;
   private JPasswordField password;
   private JComboBox caixa;
   private String language[] = {"Select", "Portugues","English","Espanol"};
   private String sIdioma = "";
   private ResourceBundle bn = null;
   private int iIdioma = 0;
  
   public TelaInicial() 
   {      
   	//Janela
      janela = new Janela("Banco USJT - S.A.");      
      //Rotulo
      codigoR  = new Rotulo("Codigo ");
      agenciaR = new Rotulo("Agencia");
      contaR   = new Rotulo("Conta");      
      senhaR   = new Rotulo("Senha ");
      idiomaR    = new Rotulo("Idioma/Language");
      //Tamanho
      codigoR.setFont(new Font("Calibri", Font.PLAIN, 22));
      agenciaR.setFont(new Font("Calibri", Font.PLAIN, 22));
      contaR.setFont(new Font("Calibri", Font.PLAIN, 22));
      senhaR.setFont(new Font("Calibri", Font.PLAIN, 22));
      idiomaR.setFont(new Font("Calibri", Font.PLAIN, 22));
      //Caixa De Texto
      agencia = new CaixaDeTexto();
      conta   = new CaixaDeTexto();      
      //Botao
      confirmar = new Botao("Confirmar");
      sair      = new Botao("Sair");
      //Tamanho
      confirmar.setSize(2,2);  
      sair.setSize(2,2);
      //ActionListener
      confirmar.addActionListener(this);
      sair.addActionListener(this);
      //Password
      password = new JPasswordField( "           " );
      //JComboBox
      caixa = new JComboBox( language );   
      caixa.addItemListener(null);          
      
      //Add
   
      janela.getContentPane().add(agenciaR);
      janela.getContentPane().add(agencia);
      janela.getContentPane().add(contaR);
      janela.getContentPane().add(conta);
      janela.getContentPane().add(senhaR);
      janela.getContentPane().add(password);
      janela.getContentPane().add(idiomaR);
      janela.getContentPane().add(caixa);
      janela.getContentPane().add(confirmar);
      janela.getContentPane().add(sair);   
   
      janela.setVisible(true);
        
      
      caixa.addActionListener(
            new ActionListener() {  
               public void actionPerformed(ActionEvent arg0)
               { 
                  sIdioma = ((String)caixa.getSelectedItem());
                  
                  if(sIdioma.equals(language[1]) )
                  {
                  
                     bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("pt", "BR"));
                     
                     codigoR.setText(bn.getString("rotulo.codigo"));
                     agenciaR.setText(bn.getString("rotulo.agencia"));
                     contaR.setText(bn.getString("rotulo.conta"));
                     senhaR.setText(bn.getString("rotulo.senha"));
                     confirmar.setText(bn.getString("botao.confirmar"));
                     sair.setText(bn.getString("botao.sair"));
                     iIdioma = 1;
                  }
                  else if(sIdioma.equals(language[2]) )
                  {
                     
                     bn = ResourceBundle.getBundle("projeto.view.prj", Locale.US);
                     
                     codigoR.setText(bn.getString("rotulo.codigo"));
                     agenciaR.setText(bn.getString("rotulo.agencia"));
                     contaR.setText(bn.getString("rotulo.conta"));
                     senhaR.setText(bn.getString("rotulo.senha"));
                     confirmar.setText(bn.getString("botao.confirmar"));
                     sair.setText(bn.getString("botao.sair"));
                     iIdioma = 2;
                  
                  } 
                  else if(sIdioma.equals(language[3]) )
                  {
                     bn = ResourceBundle.getBundle("projeto.view.prj", new Locale("es", "ES"));
                     
                     codigoR.setText((bn.getString("rotulo.codigo")));
                     agenciaR.setText((bn.getString("rotulo.agencia")));
                     contaR.setText((bn.getString("rotulo.conta")));
                     senhaR.setText((bn.getString("rotulo.senha")));
                     confirmar.setText((bn.getString("botao.confirmar")));
                     sair.setText((bn.getString("botao.sair")));
                     iIdioma = 3;
                  }
                  
               }  
            }); 
            
   }
   
   public void setConta(String txtCon)
   {
      String txtConta = txtCon;      
   }
   
   
   
   
   public void actionPerformed(ActionEvent event)
   {
      
      if ( event.getSource() == confirmar )
      {
         if(iIdioma == 0)
         {
            JOptionPane.showMessageDialog(null,"Selecione Uma Opção/Select Option","Error",0);
            janela.dispose();
            TelaInicial t = new TelaInicial();         
         }
         else
         {
         
            try
            {
            
               String txtAgencia = agencia.getText();
               String txtConta = conta.getText();
               String txtSenha = String.valueOf(password.getPassword());
               setConta(txtConta);
            
               Long agenciaConta = Long.parseLong((txtAgencia +""+ txtConta));
            
               Cliente c = new Cliente();
            
               try
               {
                  String cripArquivo = c.cripto();
               }
               catch(Exception e)
               {
               //
               }
            
               int x = 0;
            
               String[] arquivoLogin = c.descripto();
            
               int posicaoEncontrada = c.buscaBinaria(arquivoLogin, agenciaConta);
            
               if(posicaoEncontrada >= 0)
               {
                  String posicaoArquivo = arquivoLogin[posicaoEncontrada];
                  String senha = posicaoArquivo.substring(10,14);
               
                  if(senha.equals(txtSenha))
                  {
                     janela.dispose();
                     MenuPrincipalGUI m = new MenuPrincipalGUI();
                     m.setIdioma(iIdioma);
                     m.traducao();
                     m.recebeConta(txtConta);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Senha Inválida/Invalid Passworld!");
                     password.setText("");
                  } 
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Error Account/Erro Conta");
                  password.setText("");
                  agencia.setText("");
                  conta.setText("");
               }  
            }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null, "ERRO/ERROR");
               password.setText("");
               agencia.setText("???");
               conta.setText("???");
            
            }
         }
         
      }
      if ( event.getSource() == sair )
      {
         TelaInicial t = new TelaInicial();
         janela.dispose();
      }
   
   }
   
   
  
   
   
   //Provisorio--
   public static void main(String args[])
   {
      TelaInicial t = new TelaInicial();      
   }
}