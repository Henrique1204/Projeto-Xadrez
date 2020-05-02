package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;

public abstract class PecaXadrez extends Peca
{
	private Cor cor;

	//Contrutor
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor)
	{
		super(tabuleiro);
		this.cor = cor;
	}

	//Getters
	public Cor getCor() {
		return this.cor;
	}

	//Métodos comuns
	protected boolean isPecaInimiga(Posicao posicao)
	{
		PecaXadrez p = (PecaXadrez) this.getTabuleiro().pegarPecas(posicao);

		return p != null && p.getCor() != this.getCor();
	}
}