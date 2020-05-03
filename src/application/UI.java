package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI
{
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void clearScreen()
	{
		System.out.println("\003[H\033[2J");
		System.out.flush();
	}

	public static PosicaoXadrez lerPosicaoXadrez(Scanner sc)
	{
		try {
			String s = sc.nextLine();

			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));

			return new PosicaoXadrez(coluna, linha);
		}
		catch (RuntimeException e)
		{
			throw new InputMismatchException("Erro lendo posicao de xadrez, valores validos sao a1 ate h8!");
		}
	}

	public static void printTabuleiro(PecaXadrez[][] pecas)
	{
		System.out.println("  ===================");

		for(int i = 0; i < pecas.length; i++)
		{
			System.out.print((8 - i) + " | ");
			for(int j = 0; j < pecas.length; j++)
			{
				printPeca(pecas[i][j], false);
			}
			System.out.println("|");
		}
		System.out.println("  ===================");
		System.out.println("    A B C D E F G H");
	}

	public static void printPartida(PartidaXadrez partida, List<PecaXadrez> capturas)
	{
		printTabuleiro(partida.getPecas());

		printPecasCapturadas(capturas);

		System.out.println("\nTunro: " + partida.getTurno());
		String cor = (partida.getTurno() % 2 == 0) ? "\u001B[33m" : "\u001B[37m" ;
		System.out.println("Vez do jogador: " + cor + partida.getJogadorAtual() + ANSI_RESET);
	}

	public static void printTabuleiro(PecaXadrez[][] pecas, boolean[][] possiveisMovimentos)
	{
		System.out.println("  ===================");

		for(int i = 0; i < pecas.length; i++)
		{
			System.out.print((8 - i) + " | ");
			for(int j = 0; j < pecas.length; j++)
			{
				printPeca(pecas[i][j], possiveisMovimentos[i][j]);
			}
			System.out.println("|");
		}

		System.out.println("  ===================");
		System.out.println("    A B C D E F G H");
	}

	private static void printPeca(PecaXadrez peca, boolean fundo)
	{
		if(fundo)
		{
			System.out.print(ANSI_BLUE_BACKGROUND);
		}

		if(peca != null)
		{
			if(peca.getCor() == Cor.BRANCO)
			{
				System.out.print(ANSI_WHITE + peca + " " + ANSI_RESET);
			}
			else
			{
				System.out.print(ANSI_YELLOW + peca + " " + ANSI_RESET);
			}
		}
		else
		{
			System.out.print("- " + ANSI_RESET);
		}
	}

	public static void printPecasCapturadas(List<PecaXadrez> capturas)
	{
		List<PecaXadrez> pecasBrancas = capturas.stream().filter(x -> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
		List<PecaXadrez> pecasPretas = capturas.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());

		System.out.println("\n| Pecas capturadas:");
		System.out.println("----------------------");
		System.out.print(ANSI_WHITE + "| Branco: ");
		System.out.println(Arrays.toString(pecasBrancas.toArray()));
		System.out.print(ANSI_YELLOW + "| Preto: ");
		System.out.println(Arrays.deepToString(pecasPretas.toArray()));
		System.out.print(ANSI_RESET);
		
	}
}
