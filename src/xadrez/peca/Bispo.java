package xadrez.peca;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Bispo extends PecaXadrez
{
	//Construtor
	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	//Métodos sobrescrevidos
	public String toString()
	{
		return "B";
	}

	@Override
	public boolean[][] movimentosPossiveis()
	{
		boolean[][] matriz = new boolean[this.getTabuleiro().getLinha()] [this.getTabuleiro().getColuna()];

		Posicao p = new Posicao(0,0);

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

		//SE
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
