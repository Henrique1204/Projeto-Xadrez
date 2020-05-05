package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.peca.Peao;
import xadrez.peca.Rei;
import xadrez.peca.Torre;

public class PartidaXadrez
{
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean check;
	private boolean checkMate;

	private List<Peca> pecasTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();

	//Contrutor
	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		this.turno = 1;
		this.jogadorAtual = Cor.BRANCO;
		this.check = false;
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

	public boolean getCheck()
	{
		return this.check;
	}

	public boolean getCheckMate()
	{
		return this.checkMate;
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
		
		if(testeCheck(this.getJogadorAtual()))
		{
			voltarMovimento(origem, destino, pecaCapturada);
			throw new XadrezException("\n  Movimento impossivel, tire o rei do check primeiro.");
		}

		this.check = testeCheck( oponente( this.getJogadorAtual() ) ) ? true : false ;

		if(testeCheckMate(oponente(this.getJogadorAtual())))
		{
			this.checkMate = true;
		}
		else
		{
			avancarTurno();
		}

		return (PecaXadrez) pecaCapturada;
	}

	private Peca moverPeca(Posicao origem, Posicao destino)
	{
		PecaXadrez p = (PecaXadrez) this.tabuleiro.removerPeca(origem);
		p.incrementarContadorMovimento();
		Peca capturada = this.tabuleiro.removerPeca(destino);
		this.tabuleiro.moverPeca(p, destino);

		if(capturada != null)
		{
			this.pecasTabuleiro.remove(capturada);
			this.pecasCapturadas.add(capturada);
		}

		return capturada;
	}

	private void voltarMovimento(Posicao origem, Posicao destino, Peca capturada)
	{
		PecaXadrez p = (PecaXadrez) this.tabuleiro.removerPeca(destino);
		p.decrementarContadorMovimento();
		this.tabuleiro.moverPeca(p, origem);

		if(capturada != null)
		{
			this.tabuleiro.moverPeca(capturada, destino);
			pecasCapturadas.remove(capturada);
			pecasTabuleiro.add(capturada);
		}
	}

	private void validarOrigem(Posicao origem)
	{
		if(!this.tabuleiro.temPeca(origem))
		{
			throw new XadrezException("\n  Nao tem peca nessa posicao");
		}
		if(this.getJogadorAtual() != ( (PecaXadrez) this.tabuleiro.pegarPecas(origem) ).getCor())
		{
			throw new XadrezException("\n  A peca escolhida nao e sua");
		}
		if(!this.tabuleiro.pegarPecas(origem).isPossivelMover())
		{
			throw new XadrezException("\n  Nao existe movimentos possiveis para peca escolhida");
		}
	}

	private void validarDestino(Posicao origem, Posicao destino)
	{
		if(!this.tabuleiro.pegarPecas(origem).movimentoPossivel(destino))
		{
			throw new XadrezException("\n  A peca escolhida nao pode se mover para posicao de destino");
		}
	}

	private Cor oponente(Cor cor)
	{
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	private PecaXadrez rei(Cor cor)
	{
		List<Peca> list  = pecasTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for(Peca p : list)
		{
			if(p instanceof Rei)
			{
				return (PecaXadrez) p;
			}
		}
		throw new IllegalStateException("\n  Nao existe o rei da cor " + cor + "no tabuleiro.");
	}

	private boolean testeCheck(Cor cor)
	{
		Posicao posicaoRei = rei(cor).getPosicaoXadrez().toPosicao();

		List<Peca> pecasOponentes = pecasTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());

		for(Peca p : pecasOponentes)
		{
			boolean[][] matriz = p.movimentosPossiveis();
			if(matriz[posicaoRei.getLinha()] [posicaoRei.getColuna()])
			{
				return true;
			}
		}

		return false;
	}

	private boolean testeCheckMate(Cor cor)
	{
		if(!testeCheck(cor))
		{
			return false;
		}

		List<Peca> lista = pecasTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList()); 

		for(Peca p : lista)
		{
			boolean[][] matriz = p.movimentosPossiveis();
			for(int i = 0; i < this.tabuleiro.getLinha(); i++)
			{
				for(int j = 0; j < this.tabuleiro.getColuna(); j++)
				{
					if(matriz[i][j])
					{
						Posicao origem = ((PecaXadrez)p).getPosicaoXadrez().toPosicao();
						Posicao destino = new Posicao(i,j);
	
						Peca pecaCapturada = moverPeca(origem, destino);

						boolean testeCheck = testeCheck(cor);

						voltarMovimento(origem, destino, pecaCapturada);

						if(!testeCheck)
						{
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public void moverNovaPeca(char coluna, int linha, PecaXadrez peca)
	{
		this.tabuleiro.moverPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
		this.pecasTabuleiro.add(peca);
	}

	private void avancarTurno()
	{
		this.turno++;
		this.jogadorAtual = this.getTurno() % 2 == 0 ? Cor.PRETO : Cor.BRANCO;
	}

	public void configurarInicio()
	{
		moverNovaPeca('a', 1, new Torre(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('d', 1, new Rei(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('h', 1, new Torre(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('a', 2, new Peao(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('b', 2, new Peao(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('c', 2, new Peao(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('d', 2, new Peao(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('e', 2, new Peao(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('f', 2, new Peao(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('g', 2, new Peao(this.tabuleiro, Cor.BRANCO));
		moverNovaPeca('h', 2, new Peao(this.tabuleiro, Cor.BRANCO));


		moverNovaPeca('a', 8, new Torre(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('d', 8, new Rei(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('h', 8, new Torre(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('a', 7, new Peao(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('b', 7, new Peao(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('c', 7, new Peao(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('d', 7, new Peao(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('e', 7, new Peao(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('f', 7, new Peao(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('g', 7, new Peao(this.tabuleiro, Cor.PRETO));
		moverNovaPeca('h', 7, new Peao(this.tabuleiro, Cor.PRETO));
	}
}