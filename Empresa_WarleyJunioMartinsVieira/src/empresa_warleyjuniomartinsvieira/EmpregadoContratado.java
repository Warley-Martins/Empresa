package empresa_warleyjuniomartinsvieira;
public class EmpregadoContratado extends Empregado{
    private double bonusSalarial;
    public EmpregadoContratado(String cpf, String nome, double salario, double bonusSalarial) {
        super(cpf, nome, salario);
        this.bonusSalarial = bonusSalarial;
    }
    public double getBonusSalarial() {
        return bonusSalarial;
    }
    public void setBonusSalarial(double bonusSalarial) {
        this.bonusSalarial = bonusSalarial;
    }
    @Override
    public double calculaSalario() {
        return this.salario + this.bonusSalarial; 
    }
}



