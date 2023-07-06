package entidades;

public class PessoaFisica extends Pessoa {

	private double gastoSaude;

	public PessoaFisica() {

	}

	public PessoaFisica(String nome, double rendaAnual, double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public double calcularImposto() {

		double taxa = 0;

		if (getRendaAnual() <= 20000) {

			taxa = getRendaAnual() * 0.15;

		} else {

			taxa = getRendaAnual() * 0.25;

		}

		if (gastoSaude > 0) {
			taxa -= (gastoSaude / 2);
		}

		return taxa;
	}

}
