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

	//M�todo sobrescrevidos
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

		//Posi��o 1
		p.setValores(this.posicao.getLinha() - 2, this.posicao.getColuna() - 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posi��o 2
		p.setValores(this.posicao.getLinha() - 2, this.posicao.getColuna() + 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posi��o 3
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() - 2);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posi��o 4
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() - 2);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posi��o 5
		p.setValores(this.posicao.getLinha() + 2, this.posicao.getColuna() - 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posi��o 6
		p.setValores(this.posicao.getLinha() + 2, this.posicao.getColuna() + 1);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posi��o 7
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() + 2);
		if(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Posi��o 8
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