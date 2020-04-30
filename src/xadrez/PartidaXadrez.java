package xadrez;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.peca.Torre;

public class PartidaXadrez
{
	private Tabuleiro tabuleiro;

	//Contrutor
	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		this.configurarInicio();
	}

	public PecaXadrez[][] pegarPecas()
	{
		PecaXadrez[][] matriz = new PecaXadrez[this.tabuleiro.getLinha()][this.tabuleiro.getColuna()];

		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				matriz[i][j] = (PecaXadrez) this.tabuleiro.pegarPecas(i,j);
			}
		}

		return matriz;
	}

	public void configurarInicio()
	{
		this.tabuleiro.moverPeca(new Torre(this.tabuleiro, Cor.BRANCO), new Posicao(0,0));
		this.tabuleiro.moverPeca(new Torre(this.tabuleiro, Cor.BRANCO), new Posicao(0,7));
		this.tabuleiro.moverPeca(new Torre(this.tabuleiro, Cor.PRETO), new Posicao(7,0));
		this.tabuleiro.moverPeca(new Torre(this.tabuleiro, Cor.PRETO), new Posicao(7,7));
	}
}