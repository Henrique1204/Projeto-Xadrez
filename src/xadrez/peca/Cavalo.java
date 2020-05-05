package xadrez.peca;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez
{
	//Construtor
	public Cavalo(Tabuleiro tabuleiro, Cor cor)
	{
		super(tabuleiro, cor);
	}

	//Método sobrescrevidos
	@Override
	public String toString()
	{
		return "C";
	}

	@Override
	public boolean[][] movimentosPossiveis()
	{
		boolean[][] matriz = new boolean[this.getTabuleiro().getLinha()] [this.getTabuleiro().getColuna()];

		Posicao p = new Posicao(0,0);

		//Posição 1
		p.setValores(this.posicao.getLinha() - 2, this.posicao.getColuna() - 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posição 2
		p.setValores(this.posicao.getLinha() - 2, this.posicao.getColuna() + 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posição 3
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() - 2);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posição 4
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() - 2);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posição 5
		p.setValores(this.posicao.getLinha() + 2, this.posicao.getColuna() - 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posição 6
		p.setValores(this.posicao.getLinha() + 2, this.posicao.getColuna() + 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posição 7
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() + 2);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posição 8
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() + 2);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		return matriz;
	}
}