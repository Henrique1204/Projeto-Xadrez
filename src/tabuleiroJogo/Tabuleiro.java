package tabuleiroJogo;

public class Tabuleiro
{
	private int linha, coluna;
	private Peca[][] pecas;

	//Construtor
	public Tabuleiro(int linha, int coluna)
	{
		this.setLinha(linha);
		this.setColuna(coluna);
		pecas = new Peca[linha][coluna];
	}

	//Getters
	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	//Setters
	public void setLinha(int linha) {
		this.linha = linha;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	
}
