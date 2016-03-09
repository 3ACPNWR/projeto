package projeto.view;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class Janela extends JFrame {
	public Janela(String sT) {
		setTitle(sT);
		setBounds(50, 50, 800,600);
		setLayout(new GridLayout(6,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
		//setResizable(false);
	}
}