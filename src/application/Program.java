package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<PecaXadrez> capturas = new ArrayList<>();

		while(true)
		{
			try {
				UI.clearScreen();
				UI.printPartida(partida, capturas);

				System.out.print("\nOrigem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

				boolean[][] movimentos = partida.possiveisMovimentos(origem);

				UI.clearScreen();
				UI.printTabuleiro(partida.getPecas(), movimentos);

				System.out.print("\nDestino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
	
				PecaXadrez pecaCapturada = partida.executarMovimento(origem, destino);
				if(pecaCapturada != null)
				{
					capturas.add(pecaCapturada);
				}
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