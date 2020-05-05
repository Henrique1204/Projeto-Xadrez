package xadrez.peca;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez
{
	private PartidaXadrez partida;

	//Construtor
	public Rei(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) {
		super(tabuleiro, cor);
		this.partida = partida;
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

		//Movimento especial Roque
		if(this.getContadorMovimentos() == 0 && !partida.getCheck())
		{
			//Movimento especial Roque pequeno
			Posicao posicaoTorre1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);

			if(testeRoque(posicaoTorre1))
			{
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);

				if(this.getTabuleiro().pegarPecas(p1) == null && this.getTabuleiro().pegarPecas(p2) == null)
				{
					matriz[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
			}

			//Movimento especial Roque grande
			Posicao posicaoTorre2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);

			if(testeRoque(posicaoTorre2))
			{
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
				Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);

				if(this.getTabuleiro().pegarPecas(p1) == null && this.getTabuleiro().pegarPecas(p2) == null && this.getTabuleiro().pegarPecas(p3) == null)
				{
					matriz[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}
			}
		}

		return matriz;
	}

	//Métodos comuns
	private boolean podeMover(Posicao posicao)
	{
		PecaXadrez p = (PecaXadrez) this.getTabuleiro().pegarPecas(posicao);

		return p == null || p.getCor() != this.getCor();
	}

	private boolean testeRoque(Posicao posicao)
	{
		PecaXadrez p = (PecaXadrez)this.getTabuleiro().pegarPecas(posicao);

		return p != null && p instanceof Torre && p.getCor() == this.getCor() && p.getContadorMovimentos() == 0;
	}
}
