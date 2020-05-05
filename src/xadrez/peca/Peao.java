package xadrez.peca;

import java.util.Scanner;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez
{
	Scanner sc = new Scanner(System.in);
	private PartidaXadrez partida;

	//Contrutor
	public Peao(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida)
	{
		super(tabuleiro, cor);
		this.partida = partida;
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

		//Movimento especial enPassant
		if(this.posicao.getLinha() == 3)
		{
			Posicao esquerda = new Posicao(this.posicao.getLinha(), this.posicao.getColuna() - 1);
			if(this.getTabuleiro().posicaoExiste(esquerda) && this.isPecaInimiga(esquerda) && this.getTabuleiro().pegarPecas(esquerda) == partida.getEnPassant())
			{
				matriz[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
			}

			Posicao direita = new Posicao(this.posicao.getLinha(), this.posicao.getColuna() + 1);
			if(this.getTabuleiro().posicaoExiste(direita) && this.isPecaInimiga(direita) && this.getTabuleiro().pegarPecas(direita) == partida.getEnPassant())
			{
				matriz[direita.getLinha() - 1][direita.getColuna()] = true;
			}
		}

		return matriz;
	}
}
