package xadrez.peca;

import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez
{
	//Construtor
	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	//Métodos sobrescrevidos
	@Override
	public String toString()
	{
		return "R";
	}

	@Override
	public boolean[][] movimentosPossiveis()
	{
		boolean[][] matriz = new boolean[this.getTabuleiro().getLinha()][this.getTabuleiro().getColuna()];
		return matriz;
	}
}
