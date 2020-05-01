package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Program
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();

		while(true)
		{
			try {
				UI.clearScreen();
				UI.printTabuleiro(partida.pegarPecas());

				System.out.print("\nOrigem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

				System.out.print("\nDestino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

				PecaXadrez pecaCapturada = partida.executarMovimento(origem, destino);
			}
			catch (XadrezException e)
			{
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e)
			{
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}