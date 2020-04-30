package application;

import xadrez.PecaXadrez;

public class UI
{
	public static void printTabuleiro(PecaXadrez[][] pecas)
	{
		System.out.println("  ===================");

		for(int i = 0; i < pecas.length; i++)
		{
			System.out.print((8 - i) + " | ");
			for(int j = 0; j < pecas.length; j++)
			{
				printPeca(pecas[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("  ===================");
		System.out.println("  A B C D E F G H");
	}

	private static void printPeca(PecaXadrez peca)
	{
		System.out.print(peca == null ? "- " : peca + " ");
	}
}
