package br.com.fiap.forca;
import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		
		boolean perguntarDenovo = true;
		
		GameInfo informacaoJogo = new GameInfo();
		
		Forca forca = new Forca(informacaoJogo);
		
		forca.inicializarJogo();
		
		while(perguntarDenovo) {
			
			int input = JOptionPane.showConfirmDialog(null, 
	                "Quer jogar novamente?", "Quer jogar novamente?", JOptionPane.YES_NO_OPTION);
			
			if(input == 1) {
				
				perguntarDenovo = false;
				
			} else {
				
				forca = new Forca(new GameInfo());
				
				forca.inicializarJogo();
				
			}
			
		}
		
	}

}
