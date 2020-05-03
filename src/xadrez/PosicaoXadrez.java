package xadrez;

import tabuleiroJogo.Posicao;

public class PosicaoXadrez {
	private int linha;
	private char coluna;

	//Construtor
	public PosicaoXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8)
		{
			throw new XadrezException("Erro: valores validos sao de a1 ate h8");
		}

		this.coluna = coluna;
		this.linha = linha;
	}

	//Getters
	public int getLinha() {
		return linha;
	}

	public char getColuna() {
		return coluna;
	}

	//Métodos sobrescrevidos
	public String toString()
	{
		return "" + this.getLinha() + this.getColuna();
	}

	//Métodos comuns
	protected Posicao toPosicao()
	{
		return new Posicao(8 - this.getLinha(), this.getColuna() - 'a');
	}

	protected static PosicaoXadrez fromPosicao(Posicao posicao)
	{
		return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());	
	}
}
