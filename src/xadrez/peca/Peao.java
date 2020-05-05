package xadrez.peca;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez
{
	//Contrutor
	public Peao(Tabuleiro tabuleiro, Cor cor)
	{
		super(tabuleiro, cor);
	}

	//Métodos sobrescrevidos
	@Override
	public String toString()
	{
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis()
	{
		boolean[][] matriz = new boolean[this.getTabuleiro().getLinha()] [this.getTabuleiro().getColuna()];

		Posicao p = new Posicao(0,0);

		int sentido = (this.getCor() == Cor.BRANCO) ? -1 : 1;
		Posicao p2 = new Posicao(posicao.getLinha() + sentido , posicao.getColuna());

		p.setValores(posicao.getLinha() + sentido , posicao.getColuna());
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		p.setValores(posicao.getLinha() + (sentido * 2) , posicao.getColuna());
		if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p) && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().temPeca(p2) && this.getContadorMovimentos() == 0)
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		p.setValores(posicao.getLinha() + sentido , posicao.getColuna() - 1);
		if(getTabuleiro().posicaoExiste(p) && isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		p.setValores(posicao.getLinha() + sentido , posicao.getColuna() + 1);
		if(getTabuleiro().posicaoExiste(p) && isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		return matriz;
	}
}
