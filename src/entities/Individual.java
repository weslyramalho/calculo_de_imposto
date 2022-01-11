package entities;

public class Individual extends Contribuinte  {
	private Double gastoComSaude;
	
	
	public Individual(String nome, Double rendaAnual, Double gastoComSaude) {
		super(nome, rendaAnual);
		this.gastoComSaude = gastoComSaude;
	}
	
	public Double getGastoComSaude() {
		return gastoComSaude;
	}

	public void setGastoComSaude(Double gastoComSaude) {
		this.gastoComSaude = gastoComSaude;
	}

	@Override
	public Double imposto(Double taxa) {
		
		if(rendaAnual < 20000) {
			taxa = (15/100)*rendaAnual;
		}else if(rendaAnual >= 20000) {
			if(gastoComSaude > 0) {
				taxa = (25/100)*rendaAnual - (50/100)*gastoComSaude;
			}else {
				taxa = (25/100)*rendaAnual;
			}
		}
		return taxa;
		
	}

}
