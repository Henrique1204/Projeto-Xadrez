package tabuleiroJogo;

public abstract class Peca
{
	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	//Contrutor
	public Peca(Tabuleiro tabuleiro)
	{
		this.posicao = null;
		this.tabuleiro = tabuleiro;
	}

	//Getters
	protected Tabuleiro getTabuleiro()
	{
		return this.tabuleiro;
	}

	//M�todos abstratos
	public abstract boolean[][] movimentosPossiveis();

	//M�todos implementados
	public final boolean movimentoPossivel(Posicao posicao)
	{		
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}

	public final boolean isPossivelMover()
	{
		boolean[][] matriz = movimentosPossiveis();

		for(int i = 0; i < matriz.length; i++)
		{
			for(int j = 0; j < matriz.length; j++)
			{
				if(matriz[i][j])
				{
					return true;
				}
			}
		}

		return true;
	}
}
