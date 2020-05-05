package xadrez.peca;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rainha extends PecaXadrez
{
	//Construtor
	public Rainha(Tabuleiro tabuleiro, Cor cor)
	{
		super(tabuleiro, cor);
	}

	//Métodos sobrescrevidos
	@Override
	public String toString()
	{
		return "D";
	}

	@Override
	public boolean[][] movimentosPossiveis()
	{
		boolean[][] matriz = new boolean[this.getTabuleiro().getLinha()][this.getTabuleiro().getColuna()];

		Posicao p = new Posicao(0,0);

		//Cima
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna());

		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//NO
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() - 1);

		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
			p.setColuna(p.getColuna() - 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Esquerda
		p.setValores(this.posicao.getLinha(), this.posicao.getColuna() - 1);

		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//SO
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() - 1);

		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
			p.setColuna(p.getColuna() - 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Baixo
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna());

		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//SE
		p.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() + 1);

		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
			p.setColuna(p.getColuna() + 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//Direita
		p.setValores(this.posicao.getLinha(), this.posicao.getColuna() + 1);

		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		//NE
		p.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() + 1);
		while(this.getTabuleiro().posicaoExiste(p) && !this.getTabuleiro().temPeca(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
			p.setColuna(p.getColuna() + 1);
		}
		if(this.getTabuleiro().posicaoExiste(p) && this.isPecaInimiga(p))
		{
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		return matriz;
	}
	
}
