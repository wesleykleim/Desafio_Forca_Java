package br.com.fiap.forca;
import javax.swing.JOptionPane;

public class GameInfo {
	
	private int vidas;
	private String dica;
	private String palavra;

	private void setVidas(int vidas) {
		this.vidas = vidas;
	}

	private void setDica(String dica) {
		this.dica = dica;
	}
	
	private void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public String getDica() {
		return this.dica;
	}
	
	public int getVidas() {
		return this.vidas;
	}
	
	public String getPalavra() {
		return this.palavra;
	}
	
	public GameInfo () {
		
		 try {
			 setVidas(Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vidas")));			 
		 } catch (NumberFormatException n) {
			 setVidas(Integer.parseInt(JOptionPane.showInputDialog("Número inválido, tente novamento com um número válido")));
		 } finally {
			
		 }
		 
		setDica(JOptionPane.showInputDialog("Digite a dica"));
		
		setPalavra(JOptionPane.showInputDialog("Digite a palavra"));
	}
	
}
