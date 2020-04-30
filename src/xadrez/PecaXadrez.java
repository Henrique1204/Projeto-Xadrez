package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Tabuleiro;

public class PecaXadrez extends Peca
{
	private Cor cor;

	//Contrutor
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor)
	{
		super(tabuleiro);
		this.cor = cor;
	}

	//Getters
	public Cor getCor() {
		return this.cor;
	}
}
