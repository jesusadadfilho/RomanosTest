package model;

public class Conversor {
	private char[] valor;
	private String algorismo;
	
	public Conversor(String palavra) {
		if(palavra == " " || palavra == "" || palavra == null) {
			throw new RuntimeException();
		}
		this.algorismo = palavra;
		concertarPalavra(palavra);
		this.inverteVetor();
		this.verificacao();
		this.verificacao2();
	}
	
	private void inverteVetor() {
		int tamanho = this.valor.length;
		char[] arrayAux = new char[tamanho];
		for (int i = 0; i < arrayAux.length; i++) {
		    tamanho--;
		    arrayAux[i] = this.valor[tamanho];
		}
		this.valor = arrayAux;
	}
	
	public void concertarPalavra(String palavra) {
		palavra = palavra.toLowerCase();
		this.valor = palavra.toCharArray();
	}
	
	public String getVetor() {
		String result = "";
		for(char a : this.valor) {
			result += a;
		}
		return result;
	}
	

	public int getResultado() {
		int resultado = 0;
		for(int i = 0; i < this.valor.length; i++) {
				if(this.valor[i] == 'i' || this.valor[i] == 'v' || this.valor[i] == 'x' || this.valor[i] == 'l' || this.valor[i] == 'c' || this.valor[i] == 'd' || this.valor[i] == 'm') {
					if(this.valor[i] == 'i') {
						resultado += 1;
					}
					if(this.valor[i] == 'v'){
						resultado += 5;
						if(this.valor.length > i+1) {
							if(this.valor[i+1] == 'i') {
								resultado -= 2;
							}
						}
					}
					if(this.valor[i] == 'x') {
						resultado += 10;
						if(this.valor.length > i+1) {
							if(this.valor[i+1] == 'i') {
								resultado -= 2;
							}
						}
					}
					if(this.valor[i] == 'l') {
						resultado += 50;
						if(this.valor.length > i+1) {
							if(this.valor[i+1] == 'x') {
								resultado -= 20;
							}
						}
					}
					if(this.valor[i] == 'c') {
						resultado += 100;
						if(this.valor.length > i+1) {
							if(this.valor[i+1] == 'x') {
								resultado -= 20;
							}
						}
					}
					if(this.valor[i] == 'd') {
						resultado += 500;
						if(this.valor.length > i+1) {
							if(this.valor[i+1] == 'c') {
								resultado -= 200;
							}
						}
					}
					
					if(this.valor[i] == 'm') {
						resultado += 1000;
						if(this.valor.length > i+1) {
							if(this.valor[i+1] == 'c') {
								resultado -= 200;
							}
						}
					}
				}
			else {
				throw new IllegalArgumentException("algorismo invalido: " + this.algorismo);
			}
		}
		return resultado;
	}
	
	public boolean verificacao() {
		char[] valores = new char[5];
		int count = 0;
		for(int i = 0; i < this.valor.length; i++) {
			if(i == 0) {
				valores[i] = this.valor[i];
				count += 1;
			}
			if(count > 0) {
				if(valores[count - 1] == this.valor[i]) {
					valores[count] = this.valor[i];
					count += 1;
				}
				if(valores[count - 1] != this.valor[i]) {
					valores[count] = this.valor[i];
					count = 0;
				}
			}
			if(count == 0) {
				valores[count] = this.valor[i];
				count += 1;
			}
			
			if(count == 5) {
				throw new IllegalArgumentException("algorismo invalido: " + this.algorismo);
			}
		}
		return true;
	}
	
	public boolean verificacao2() {
		char[] valores = new char[3];
		int count = 0;
		for(int i = 0; i < this.valor.length; i++) {
			if(i == 0) {
				if(this.valor[i] == 'v' || this.valor[i] == 'l' || this.valor[i] == 'd') {
					valores[i] = this.valor[i];
					count += 1;
				}
			}
			if(count > 0) {
				if(valores[count - 1] == this.valor[i]) {
					if(this.valor[i] == 'v' || this.valor[i] == 'l' || this.valor[i] == 'd') {
						valores[count] = this.valor[i];
						count += 1;
					}
				}
				if(valores[count - 1] != this.valor[i]) {
					if(this.valor[i] == 'v' || this.valor[i] == 'l' || this.valor[i] == 'd') {
						valores[count] = this.valor[i];
						count = 0;
					}
				}
			}
			if(count == 0) {
				if(this.valor[i] == 'v' || this.valor[i] == 'l' || this.valor[i] == 'd') {
					valores[count] = this.valor[i];
					count += 1;
				}
			}
			
			if(count == 3) {
				throw new IllegalArgumentException("algorismo invalido: " + this.algorismo);
			}
		}
		return true;
	}
}
