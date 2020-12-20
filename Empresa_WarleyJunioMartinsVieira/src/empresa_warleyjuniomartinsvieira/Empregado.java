package empresa_warleyjuniomartinsvieira;
public class Empregado {
   private static int quantidadeEmpregados;
   private int id;
   private String cpf;
   private String nome;
   protected double salario;
    public Empregado(String cpf, String nome, double salario) {
        quantidadeEmpregados++;
        this.id = quantidadeEmpregados;
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }
    public static int getQuantidadeEmpregados() {
        return quantidadeEmpregados;
    }
    public int getId() {
        return id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double calculaSalario(){
        return this.salario;
    }
}




