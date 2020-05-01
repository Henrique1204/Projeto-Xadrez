package xadrez.peca;

import tabuleiroJogo.Posicao;
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

		Posicao p = new Posicao(0, 0);

		//Acima
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna());
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Abaixo
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna());
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Esquerda
		p.setValores(this.posicao.getLinha(), this.posicao.getColuna() - 1);
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Direita
		p.setValores(this.posicao.getLinha(), this.posicao.getColuna() + 1);
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Noroeste
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() - 1);
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Sudoeste
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() - 1);
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Sudeste
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() + 1);
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Nordeste
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() + 1);
		if(this.getTabuleiro().posicaoExiste(p) && this.podeMover(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		return matriz;
	}

	private boolean podeMover(Posicao posicao)
	{
		PecaXadrez p = (PecaXadrez) this.getTabuleiro().pegarPecas(posicao);

		return p == null || p.getCor() != this.getCor();
	}
}
