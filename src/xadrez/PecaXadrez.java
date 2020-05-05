package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;

public abstract class PecaXadrez extends Peca
{
	private Cor cor;
	private int contadorMovimentos;

	//Contrutor
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor)
	{
		super(tabuleiro);
		this.cor = cor;
		this.contadorMovimentos = 0;
	}

	//Getters
	public Cor getCor() {
		return this.cor;
	}

	public int getContadorMovimentos()
	{
		return this.contadorMovimentos;
	}

	//Métodos comuns
	protected boolean isPecaInimiga(Posicao posicao)
	{
		PecaXadrez p = (PecaXadrez) this.getTabuleiro().pegarPecas(posicao);

		return p != null && p.getCor() != this.getCor();
	}

	public PosicaoXadrez getPosicaoXadrez()
	{
		return PosicaoXadrez.fromPosicao(posicao);
	}

	public void incrementarContadorMovimento()
	{
		this.contadorMovimentos++;
	}

	public void decrementarContadorMovimento()
	{
		this.contadorMovimentos--;
	}
}