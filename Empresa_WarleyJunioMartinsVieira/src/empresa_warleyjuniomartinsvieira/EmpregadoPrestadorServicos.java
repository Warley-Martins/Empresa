package empresa_warleyjuniomartinsvieira;
public class EmpregadoPrestadorServicos extends Empregado {
    private static double valorServico;
    private int quantidadeServicosPrestados;
    public EmpregadoPrestadorServicos(String cpf, String nome) {
        super(cpf, nome, 0);
    }
    public static void setValorServico(double valorServico) {
        EmpregadoPrestadorServicos.valorServico = valorServico;
    }
    public static double getValorServico() {
        return valorServico;
    }
    public int getQuantidadeServicosPrestados() {
        return this.quantidadeServicosPrestados;
    }
    public void adicionarNovoServicoPrestado(int quantidadeServicos){
        this.quantidadeServicosPrestados += quantidadeServicos;
    }
    @Override
    public double getSalario() {
        setSalario(valorServico);
        return this.salario;
    }
    @Override
    public double calculaSalario(){
        return valorServico * this.quantidadeServicosPrestados;
    }
}







