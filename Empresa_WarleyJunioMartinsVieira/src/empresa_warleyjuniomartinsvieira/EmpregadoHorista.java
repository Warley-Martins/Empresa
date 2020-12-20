package empresa_warleyjuniomartinsvieira;
public class EmpregadoHorista  extends Empregado{
    private static double valorHora;
    private int horasTrabalhadas;
    public EmpregadoHorista(String cpf, String nome) {
        super(cpf, nome, 0);
    }
    public static void setValorHora(double valorHora) {
        EmpregadoHorista.valorHora = valorHora;
    }
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public boolean lancarHoras(int novasHorasTrabalhadas){
        if(novasHorasTrabalhadas < 0) return false;
        this.horasTrabalhadas += novasHorasTrabalhadas;
        return true;
    }
    public static double getValorHora() {
        return valorHora;
    }
    @Override
    public double calculaSalario(){
        return valorHora * horasTrabalhadas;
    }
    @Override
    public double getSalario(){
        this.salario = calculaSalario();
        return this.salario;
    }
}





