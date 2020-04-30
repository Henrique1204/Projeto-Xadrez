package xadrez;

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

	public void moverNovaPeca(char coluna, int linha, PecaXadrez peca)
	{
		this.tabuleiro.moverPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}

	public void configurarInicio()
	{
		moverNovaPeca('a', 8, new Torre(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('h', 8, new Torre(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('a', 1, new Torre(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('h', 1, new Torre(this.tabuleiro, Cor.PRETO));
	}
}