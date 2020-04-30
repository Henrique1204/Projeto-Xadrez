package tabuleiroJogo;

public class Peca
{
	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	//Contrutor
	public Peca(Tabuleiro tabuleiro)
	{
		this.posicao = null;
		this.tabuleiro = tabuleiro;
	}

	//Getters
	protected Tabuleiro getTabuleiro()
	{
		return this.tabuleiro;
	}

}
