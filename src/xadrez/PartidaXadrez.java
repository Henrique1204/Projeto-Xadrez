package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.peca.Rei;
import xadrez.peca.Torre;

public class PartidaXadrez
{
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;

	//Contrutor
	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		this.turno = 1;
		this.jogadorAtual = Cor.BRANCO;
		this.configurarInicio();
	}

	//Getters
	public int getTurno()
	{
		return this.turno;
	}

	public Cor getJogadorAtual()
	{
		return this.jogadorAtual;
	}

	public PecaXadrez[][] getPecas()
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

	public boolean[][] possiveisMovimentos(PosicaoXadrez origem)
	{
		Posicao posicao = origem.toPosicao();

		validarOrigem(posicao);
		return this.tabuleiro.pegarPecas(posicao).movimentosPossiveis();
	}

	public PecaXadrez executarMovimento(PosicaoXadrez origemPosicao, PosicaoXadrez destinoPosicao)
	{
		Posicao origem = origemPosicao.toPosicao();
		Posicao destino = destinoPosicao.toPosicao();

		validarOrigem(origem);
		validarDestino(origem, destino);

		Peca pecaCapturada = moverPeca(origem, destino);
		avancarTurno();

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
			throw new XadrezException("Não tem peça nessa posicção");
		}
		if(this.getJogadorAtual() != ( (PecaXadrez) this.tabuleiro.pegarPecas(origem) ).getCor())
		{
			throw new XadrezException("A peça escolhida não é sua");
		}
		if(!this.tabuleiro.pegarPecas(origem).isPossivelMover())
		{
			throw new XadrezException("Não existe movimentos possíveis para peça escolhida");
		}
	}

	private void validarDestino(Posicao origem, Posicao destino)
	{
		if(!this.tabuleiro.pegarPecas(origem).movimentoPossivel(destino))
		{
			throw new XadrezException("A peça escolhida não pode se mover para posição de destino");
		}
	}

	public void moverNovaPeca(char coluna, int linha, PecaXadrez peca)
	{
		this.tabuleiro.moverPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}

	private void avancarTurno()
	{
		this.turno++;
		this.jogadorAtual = this.getTurno() % 2 == 0 ? Cor.PRETO : Cor.BRANCO;
	}

	public void configurarInicio()
	{
		moverNovaPeca('a', 1, new Torre(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('h', 1, new Rei(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('a', 8, new Torre(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('h', 8, new Rei(this.tabuleiro, Cor.PRETO));
	}
}