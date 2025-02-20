public class PessoaFisica extends Contribuinte{
    private double gastosComSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public double calcularImposto() {
        double imposto;
        if (rendaAnual < 20000.00) {
            imposto = rendaAnual * 0.15;
        } else {
            imposto = rendaAnual * 0.25;
        }
        imposto -= gastosComSaude * 0.50;
        return imposto < 0 ? 0 : imposto;
    }
}
