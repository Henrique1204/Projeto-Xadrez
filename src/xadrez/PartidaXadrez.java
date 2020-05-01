package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.peca.Torre;

public class PartidaXadrez
{
	private Tabuleiro tabuleiro;

	//Contrutor
	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		this.configurarInicio();
	}

	public PecaXadrez[][] pegarPecas()
	{
		PecaXadrez[][] matriz = new PecaXadrez[this.tabuleiro.getLinha()][this.tabuleiro.getColuna()];

		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				matriz[i][j] = (PecaXadrez) this.tabuleiro.pegarPecas(i,j);
			}
		}

		return matriz;
	}

	public PecaXadrez executarMovimento(PosicaoXadrez origemPosicao, PosicaoXadrez destinoPosicao)
	{
		Posicao origem = origemPosicao.toPosicao();
		Posicao destino = destinoPosicao.toPosicao();

		validarOrigem(origem);
		validarDestino(origem, destino);

		Peca pecaCapturada = moverPeca(origem, destino);

		return (PecaXadrez) pecaCapturada;
	}

	private Peca moverPeca(Posicao origem, Posicao destino)
	{
		Peca p = this.tabuleiro.removerPeca(origem);
		Peca capturada = this.tabuleiro.removerPeca(destino);

		this.tabuleiro.moverPeca(p, destino);

		return capturada;
	}

	private void validarOrigem(Posicao origem)
	{
		if(!this.tabuleiro.temPeca(origem))
		{
			throw new XadrezException("N�o tem pe�a nessa posic��o");
		}
		if(!this.tabuleiro.pegarPecas(origem).isPossivelMover())
		{
			throw new XadrezException("N�o existe movimentos poss�veis para pe�a escolhida");
		}
	}

	private void validarDestino(Posicao origem, Posicao destino)
	{
		if(!this.tabuleiro.pegarPecas(origem).movimentosPossiveis(destino))
		{
			throw new XadrezException("A pe�a escolhida n�o pode se mover para posi��o de destino");
		}
	}

	public void moverNovaPeca(char coluna, int linha, PecaXadrez peca)
	{
		this.tabuleiro.moverPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
		
	}

	public void configurarInicio()
	{
		moverNovaPeca('a', 8, new Torre(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('h', 8, new Torre(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('a', 1, new Torre(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('h', 1, new Torre(this.tabuleiro, Cor.PRETO));
	}
}