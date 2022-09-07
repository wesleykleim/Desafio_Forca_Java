package br.com.fiap.forca;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Forca {
	
	private GameInfo info;
	
	private String cryptoPalavra;
	private String letrasEncontradas = "";
	private boolean finalizado;
	private int vidas;
	
	public Forca (GameInfo info) {
		
		this.info = info;
	
	}
	
	public void setarValores() {
		
		String palavra = info.getPalavra();
		
		Pattern pattern = Pattern.compile(".", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		
		this.cryptoPalavra = pattern.matcher(palavra).replaceAll("*");
		
		finalizado = false;
		
		vidas = info.getVidas();
		
	}
	
	public void inicializarJogo () {
		
		setarValores();
		
		String palavra = info.getPalavra();
		
		while(!this.finalizado && this.vidas > 0) {
			String input = JOptionPane.showInputDialog("Dica: " + this.info.getDica() + ".\n" + "Palavra Atual: " + this.cryptoPalavra + ".\n" + "Quantidade de vidas: " + this.vidas + ".\n" + "Letras não achadas: " + this.letrasEncontradas + ".\n" + "Digite uma letra:");			
			
				if(input.length() == 1) {
					
					String letraInput = String.valueOf(input.charAt(0));
					
					if(palavra.contains(letraInput)){
						
						for(int i = 0; i < palavra.length(); i++) {
							
							String letraPalavra = String.valueOf(palavra.charAt(i));
							
							if(letraPalavra.equals(letraInput)) {
								
								 String tempEncriptado = this.cryptoPalavra;
						
								 String novoEncriptado = tempEncriptado.substring(0,i) + letraPalavra + tempEncriptado.substring(i + 1);
						
								 this.cryptoPalavra = novoEncriptado;		
								 
							}
						
						}
						
						if(palavra.equals(cryptoPalavra)) {
							this.finalizado = true;
						}
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Não contém a letra " + letraInput);
						
						this.letrasEncontradas += letraInput + " ";
						
						this.vidas -= 1;
	
					}
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Digite apenas 1 caractere");
					
				}

		  }
		
		if(vidas == 0) {
			JOptionPane.showMessageDialog(null, "Voce perdeu o jogo!");
		}
		
		if(this.finalizado) {
			JOptionPane.showMessageDialog(null, "Parabéns, voce acertou a palavra " + palavra + "!");
		}
		
	}

}
