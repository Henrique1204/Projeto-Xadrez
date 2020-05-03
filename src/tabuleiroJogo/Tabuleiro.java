package tabuleiroJogo;

public class Tabuleiro
{
	private int linha, coluna;
	private Peca[][] pecas;

	//Construtor
	public Tabuleiro(int linha, int coluna)
	{
		if(linha < 1 || coluna < 1)
		{
			throw new TabuleiroException("\n  Valor de [linha] e [coluna] devem ser maiores do que zero.");
		}

		this.linha = linha;
		this.coluna = coluna;
		pecas = new Peca[linha][coluna];
	}

	//Getters
	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	//M�todos comuns
	public Peca pegarPecas(int linha, int coluna)
	{
		if(!posicaoExiste(linha, coluna))
		{
			throw new TabuleiroException("\n  Posicao nao encontrada no tabuleiro.");
		}

		return pecas[linha][coluna];
	}

	public Peca pegarPecas(Posicao posicao)
	{
		if(!posicaoExiste(posicao))
		{
			throw new TabuleiroException("\n  Peca nao encontrada no tabuleiro.");
		}

		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void moverPeca(Peca peca, Posicao posicao)
	{
		if(temPeca(posicao))
		{
			throw new TabuleiroException("\n  Ja existe uma peca nessa posicao.");
		}

		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}

	public boolean posicaoExiste(int linha, int coluna)
	{
		return linha >= 0 && linha < this.getLinha() && coluna >= 0 && coluna < this.getColuna();
	}

	public boolean posicaoExiste(Posicao posicao)
	{
			return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	public boolean temPeca(Posicao posicao)
	{
		if(!posicaoExiste(posicao))
		{
			throw new TabuleiroException("\n  Posicao nao encontrada no tabuleiro.");
		}

		return pegarPecas(posicao) != null;
	}

	public Peca removerPeca(Posicao posicao)
	{
		if(!posicaoExiste(posicao))
		{
			throw new TabuleiroException("\n  Posicao nao encontrada no tabuleiro.");
		}

		if(pegarPecas(posicao) == null)
		{
			return null;
		}

		Peca aux = pegarPecas(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
}