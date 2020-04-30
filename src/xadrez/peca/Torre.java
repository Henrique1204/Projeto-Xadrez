package xadrez.peca;

import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez
{
	//Contrutor
	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	//Métodos sobrescrevidos
	@Override
	public String toString()
	{
		return "T";
	}
}
