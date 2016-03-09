package exemplo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exemplo.model.Funcionario;
import exemplo.view.CadastrarTela;

public class CadastrarControle extends CadastrarTela {
	private Funcionario funcionario;
	
	public CadastrarControle() {
		addCadastrarListener(new CadastrarListener());
		addVisualizarListener(new VisualizarListener());
		addSairListener(new SairListener());
		funcionario = new Funcionario();
	}

	class CadastrarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			funcionario.setCodigo(getCodigo());
			funcionario.setNome(getNome());
			funcionario.setSalario(getSalario());
		}
	}

	class VisualizarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Codigo: "
					+ funcionario.getCodigo() + "\nNome: " + funcionario.getNome()
					+ "\nSalário: " + funcionario.getSalario());
		}
	}

	class SairListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}