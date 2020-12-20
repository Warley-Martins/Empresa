package empresa_warleyjuniomartinsvieira;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<EmpregadoPrestadorServicos> empregadosPrestadoresServicos = new ArrayList<EmpregadoPrestadorServicos>(); 
    private ArrayList<EmpregadoHorista> empregadosHoristas = new ArrayList<EmpregadoHorista>(); 
    private ArrayList<EmpregadoContratado> empregadosContratados = new ArrayList<EmpregadoContratado>();
    public Empresa() {
    }

    public ArrayList<EmpregadoPrestadorServicos> getEmpregadosPrestadoresServicos() {
        return empregadosPrestadoresServicos;
    }

    public ArrayList<EmpregadoHorista> getEmpregadosHoristas() {
        return empregadosHoristas;
    }

    public ArrayList<EmpregadoContratado> getEmpregadosContratados() {
        return empregadosContratados;
    }
    public boolean contratarEmpregadoPrestadorServicos(EmpregadoPrestadorServicos novoEmpregadoPrestadorServicos){
        if(novoEmpregadoPrestadorServicos == null) return false;
        this.empregadosPrestadoresServicos.add(novoEmpregadoPrestadorServicos);
        return true;
    }
    public boolean contratarEmpregadoHorista(EmpregadoHorista novoEmpregadoHorista){
        if(novoEmpregadoHorista == null) return false;
        this.empregadosHoristas.add(novoEmpregadoHorista);
        return true;
    }
    public boolean contratarEmpregadoContratado(EmpregadoContratado novoEmpregadoContratado){
        if(novoEmpregadoContratado == null) return false;
        this.empregadosContratados.add(novoEmpregadoContratado);
        return true;
    }
    public boolean demitirEmpregadoPrestadorServicos(String cpf){
        var empregadoPrestadorServicosDemitito = procurarEmpregadoPrestadorServicos(cpf);
        if(empregadoPrestadorServicosDemitito == null) return false;
        this.empregadosPrestadoresServicos.remove(empregadoPrestadorServicosDemitito);
        return true;
    }
    public boolean demitirEmpregadoHorista(String cpf){
        var empregadoHoristaDemitido = this.empregadosHoristas
                                                        .stream()
                                                        .filter(eps -> eps.getCpf().equals(cpf))
                                                        .findFirst()
                                                        .orElse(null);
        if(empregadoHoristaDemitido == null) return false;
        this.empregadosHoristas.remove(empregadoHoristaDemitido);
        return true;
    }
    public boolean demitirEmpregadoContratado(String cpf){
        var empregadoContratadoDemitito = this.empregadosContratados
                                                        .stream()
                                                        .filter(eps -> eps.getCpf().equals(cpf))
                                                        .findFirst()
                                                        .orElse(null);
        if(empregadoContratadoDemitito == null) return false;
        this.empregadosContratados.remove(empregadoContratadoDemitito);
        return true;
    }
    public EmpregadoHorista procurarEmpregadoHorista(String cpf){
        return this.empregadosHoristas
                                                        .stream()
                                                        .filter(eps -> eps.getCpf().equals(cpf))
                                                        .findFirst()
                                                        .orElse(null);
    }
    public EmpregadoContratado procurarEmpregadoContratado(String cpf){
        return this.empregadosContratados
                                                        .stream()
                                                        .filter(epc -> epc.getCpf().equals(cpf))
                                                        .findFirst()
                                                        .orElse(null);
    }
    public EmpregadoPrestadorServicos procurarEmpregadoPrestadorServicos(String cpf){
        return this.empregadosPrestadoresServicos
                                                        .stream()
                                                        .filter(eps -> eps.getCpf().equals(cpf))
                                                        .findFirst()
                                                        .orElse(null);
    }
    public double calculaGastosSalario(){
        double totalSalario = 0;
        for(var auxiliarEmpregado : this.empregadosContratados){
            totalSalario += auxiliarEmpregado.calculaSalario();
        }
        for(var auxiliarEmpregado : this.empregadosHoristas){
            totalSalario += auxiliarEmpregado.calculaSalario();
        }
        for(var auxiliarEmpregado : this.empregadosPrestadoresServicos){
            totalSalario += auxiliarEmpregado.calculaSalario();
        }
        return totalSalario;
    }
    
}




