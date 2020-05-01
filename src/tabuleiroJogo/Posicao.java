package tabuleiroJogo;

public class Posicao
{
	private int linha, coluna;

	//Construtor
	public Posicao(int linha, int coluna)
	{
		this.setLinha(linha);
		this.setColuna(coluna);
	}

	//Getters
	public int getLinha()
	{
		return this.linha;
	}

	public int getColuna()
	{
		return this.coluna;
	}

	//Setters
	public void setLinha(int linha)
	{
		this.linha = linha;
	}

	public void setColuna(int coluna)
	{
		this.coluna = coluna;
	}

	//métodos sobrescrevidos
	@Override
	public String toString()
	{
		return this.getLinha() + ", " + this.getColuna();
	}

	//Métodos comuns

	public void setValores(int linha, int coluna)
	{
		this.linha = linha;
		this.coluna = coluna;
	}
}