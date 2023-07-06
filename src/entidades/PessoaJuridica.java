package entidades;

public class PessoaJuridica extends Pessoa {

	private int numFuncionarios;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String nome, Double rendaAnual, int numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	public int getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(int numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public double calcularImposto() {
		double taxa = 0;

		if (numFuncionarios > 10) {
			taxa = getRendaAnual() * 0.14;
		} else {
			taxa = getRendaAnual() * 0.16;
		}
		return taxa;
	}

}
