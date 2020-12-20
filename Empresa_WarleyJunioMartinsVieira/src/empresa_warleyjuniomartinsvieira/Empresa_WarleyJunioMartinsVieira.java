package empresa_warleyjuniomartinsvieira;

import java.util.Scanner;

public class Empresa_WarleyJunioMartinsVieira {

    static Scanner input = new Scanner(System.in);
    static final int opcaoEncerraPrograma = 0;
    static final int quantidadeFuncionalidadesPrograma = 16;
    static double empregadoFixoSalarioPadrao = 1045;
    static double empregadohoristaValorHoraPadrao = 80;
    static double empregadoPrestadorServicosValorPadrao = 250;
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        menuApresentacaoPrograma();
        opcaoIniciarValoresTeste();
        int opcaoFuncionalidades;
        do{
            do{
                opcaoFuncionalidades =  atribuirInt(menuFuncionalidades());
            }while(opcaoFuncionalidades < opcaoEncerraPrograma 
                || opcaoFuncionalidades > quantidadeFuncionalidadesPrograma);
            switch(opcaoFuncionalidades){
                case 1 -> cadastrarEmpregadoHorista(empresa);
                case 2 -> cadastrarPrestadorServicos(empresa);
                case 3 -> cadastrarEmpregadoFixo(empresa);
                case 4 -> demitirEmpregadoHorista(empresa);
                case 5 -> encerrarContratoPrestadorServicos(empresa);
                case 6 -> demitirEmpregadoFixo(empresa);
                case 7 -> printarTodosEmpregados(empresa);
                case 8 -> printarTodosEmpregadosFixos(empresa);
                case 9 -> printarEmpregadosPrestadoresServicos(empresa);
                case 10 -> printarEmpregadosHoristas(empresa);
                case 11 -> {
                    var empregado = procurarEmpregadoHorista(empresa);
                    printarEmpregadoHorista(empregado);
                }
                case 12 ->{
                    var empregado = procurarEmpregadoFixo(empresa);
                    printarEmpregadoFixo(empregado);
                }
                case 13 -> {
                    var empregado = procurarPrestadorServico(empresa);
                    printarEmpregadoPrestadoreServico(empregado);
                }
                case 14 -> lancarHorasEmpregadoHorista(empresa);
                case 15 -> lancarServicosPrestados(empresa);
                case 16 -> visualizarGastosEmpresa(empresa);
                case 0 -> encerraPrograma();      
            }
        }while(opcaoFuncionalidades != opcaoEncerraPrograma);  
    }
    private static void menuApresentacaoPrograma() {
        System.out.println("\tProva 2 Programa Empresa"
                         + "\n\tWarley Júnio Martins Vieira"
                         + "\n\tProgramação de Computadores 2");
    }
    private static void opcaoIniciarValoresTeste(){
        System.out.println("\nValores sugeridos para testes: "
                         + "\nSalario do empregado fixo : R$" + empregadoFixoSalarioPadrao
                         + "\nValor cobrado por hora: R$" + + empregadohoristaValorHoraPadrao
                         + "\nValor cobrado por serviço prestado: R$" + empregadoPrestadorServicosValorPadrao);
        EmpregadoHorista.setValorHora(empregadohoristaValorHoraPadrao);
        EmpregadoPrestadorServicos.setValorServico(empregadoPrestadorServicosValorPadrao);
    }
    private static String menuFuncionalidades(){
        return "\nDigite a opção desejada:"
             + "\n(1). Contratar novo empregado horista                (2). Contratar novo prestador de serviços"
             + "\n(3). Contratar novo empregado fixo                   (4). Demitir um empregado horista"
             + "\n(5). Finalizar contrato com prestador de serviços    (6). Demitir empregado fixo"
             + "\n(7). Printar todos os empregados                     (8). Printar todos os empregados fixos"
             + "\n(9). Printar todos os prestador de serviços          (10). Printar todos os empregados horistas  "
             + "\n(11). Procurar um empregado horista                  (12). Procurar um empregado fixo"
             + "\n(13). Procurar um prestador de serviços              (14). Lançar horas de um empregado horista"
             + "\n(15). Lançar serviços prestados de um prestador      (16). Visualizar gastos atuais da empresa   "
             + "\n(0). Encerrar"
             + "\nOpção desejada: ";
    }
    private static void cadastrarEmpregadoHorista(Empresa empresa){
        var mensagemNome = "\nDigite o nome do empregado: ";
            var nome = atribuirString(mensagemNome);
        var mensagemCpf = "Digite o cpf do empregado: ";
            var cpf = atribuirString(mensagemCpf);
        empresa.contratarEmpregadoHorista(new EmpregadoHorista(cpf, nome)); 
    }
    private static void cadastrarPrestadorServicos(Empresa empresa){
        var mensagemNome = "\nDigite o nome do empregado: ";
        var nome = atribuirString(mensagemNome);
        var mensagemCpf = "Digite o cpf do empregado: ";
        var cpf = atribuirString(mensagemCpf);
        empresa.contratarEmpregadoPrestadorServicos(new EmpregadoPrestadorServicos(cpf, nome)); 
    }  
    private static void cadastrarEmpregadoFixo(Empresa empresa){
        var mensagemNome = "\nDigite o nome do empregado: ";
        var nome = atribuirString(mensagemNome);
        var mensagemCpf = "Digite o cpf do empregado: ";
        var cpf = atribuirString(mensagemCpf);
        var mensagemBonus = "Digite o valor do bonus: ";
        var bonus = atribuirDouble(mensagemBonus);
        empresa.contratarEmpregadoContratado(new EmpregadoContratado(cpf, nome,empregadoFixoSalarioPadrao, bonus)); 
    }
    private static void demitirEmpregadoHorista(Empresa empresa){
        var mensagemCpf = "Digite o cpf do empregado: ";
            var cpf = atribuirString(mensagemCpf);
        var resultado = empresa.demitirEmpregadoHorista(cpf);
        System.out.println("\nO empregado horista foi demitido: "+resultado+"!");
    }
    private static void encerrarContratoPrestadorServicos(Empresa empresa){
        var prestadorServicos = procurarPrestadorServico(empresa);
        var mensagemHoras = "\nDigite a quantidade de servicos prestados: ";
        var quantidadeServicos = atribuirInt(mensagemHoras);
        prestadorServicos.adicionarNovoServicoPrestado(quantidadeServicos);
        var resultado = empresa.demitirEmpregadoPrestadorServicos(prestadorServicos.getCpf());
        System.out.println("\nO prestador de servicos foi demitido: "+resultado+"!");
    }
    private static void demitirEmpregadoFixo(Empresa empresa){
        var mensagemCpf = "Digite o cpf do empregado: ";
            var cpf = atribuirString(mensagemCpf);
        var resultado = empresa.demitirEmpregadoContratado(cpf);
        System.out.println("\nO empregado fixo foi demitido: "+resultado+"!");
    }
    private static void printarTodosEmpregados(Empresa empresa){
        printarTodosEmpregadosFixos(empresa);
        printarEmpregadosPrestadoresServicos(empresa);
        printarEmpregadosHoristas(empresa);
    }
    private static void printarTodosEmpregadosFixos(Empresa empresa){
        for(var empregadoAuxiliar : empresa.getEmpregadosContratados()){
            printarEmpregadoFixo(empregadoAuxiliar);
        }
    }
    private static void printarEmpregadosPrestadoresServicos(Empresa empresa){
        for(var empregadoAuxiliar : empresa.getEmpregadosPrestadoresServicos()){
            printarEmpregadoPrestadoreServico(empregadoAuxiliar);
        }
    }
    private static void printarEmpregadosHoristas(Empresa empresa){
        for(var empregadoAuxiliar : empresa.getEmpregadosHoristas()){
            printarEmpregadoHorista(empregadoAuxiliar);
        }
    }
    private static void printarEmpregadoHorista(EmpregadoHorista empregadoAuxiliar){
        System.out.println("\nId: " + empregadoAuxiliar.getId()
                         + "\nNome: " + empregadoAuxiliar.getNome()
                         + "\nCpf: " + empregadoAuxiliar.getCpf()
                         + "\nHoras trabalhadas: " + empregadoAuxiliar.getHorasTrabalhadas() + "h"
                         + "\nValor recebido por hora: R$" + EmpregadoHorista.getValorHora()
                         + "\nValor total: R$" + empregadoAuxiliar.calculaSalario()
        );
    }
    private static void printarEmpregadoPrestadoreServico(EmpregadoPrestadorServicos empregadoAuxiliar){
        System.out.println("\nId: " + empregadoAuxiliar.getId()
                         + "\nNome: " + empregadoAuxiliar.getNome()
                         + "\nCpf: " + empregadoAuxiliar.getCpf()
                         + "\nQuantidade de serviços prestados: " + empregadoAuxiliar.getQuantidadeServicosPrestados()
                         + "\nValor por serviço prestado: R$" + EmpregadoPrestadorServicos.getValorServico()
                         + "\nSalario Total: R$" + empregadoAuxiliar.calculaSalario()
        );
    }
    private static void printarEmpregadoFixo(EmpregadoContratado empregadoContratado){
        System.out.println("\nId: " + empregadoContratado.getId()
                         + "\nNome: " + empregadoContratado.getNome()
                         + "\nCpf: " + empregadoContratado.getCpf()
                         + "\nSalario fixo: R$" + empregadoContratado.getSalario()
                         + "\nBonus Salarial: R$" + empregadoContratado.getBonusSalarial()
                         + "\nSalario Total: R$" + empregadoContratado.calculaSalario()
        );
    }
    private static EmpregadoHorista procurarEmpregadoHorista(Empresa empresa){
        EmpregadoHorista empregadoHorista;
        do{
            var mensagemCpf = "Digite o cpf do empregado: ";
            var cpf = atribuirString(mensagemCpf);
            empregadoHorista = empresa.procurarEmpregadoHorista(cpf);
            if(empregadoHorista != null) return empregadoHorista;
        }while(true);
    }
    private static EmpregadoContratado procurarEmpregadoFixo(Empresa empresa){
        EmpregadoContratado empregadoContratado;
        do{
            var mensagemCpf = "Digite o cpf do empregado: ";
            var cpf = atribuirString(mensagemCpf);
            empregadoContratado = empresa.procurarEmpregadoContratado(cpf);
            if(empregadoContratado != null) return empregadoContratado;
        }while(true);
    }
    private static EmpregadoPrestadorServicos procurarPrestadorServico(Empresa empresa){
        EmpregadoPrestadorServicos empregadoPrestadorServicos;
        do{
            var mensagemCpf = "Digite o cpf do empregado: ";
            var cpf = atribuirString(mensagemCpf);
            empregadoPrestadorServicos = empresa.procurarEmpregadoPrestadorServicos(cpf);
            if(empregadoPrestadorServicos != null) return empregadoPrestadorServicos;
        }while(true);
    }
    private static void lancarHorasEmpregadoHorista(Empresa empresa){
        var empregadoHorista = procurarEmpregadoHorista(empresa);
        var mensagemHoras = "\nDigite a quantidade de horas trabalhadas: ";
        var quantidadeHoras = atribuirInt(mensagemHoras);
        empregadoHorista.setHorasTrabalhadas(quantidadeHoras);
        System.out.println("\nO empregado " + empregadoHorista.getNome()+ ", possui "+empregadoHorista.getHorasTrabalhadas()+" horas trabalhadas!");
    }
    private static void lancarServicosPrestados(Empresa empresa){
        var empregadoPrestadorServicos = procurarPrestadorServico(empresa);
        var mensagemServicos = "\nDigite a quantidade de serviços prestados: ";
        var quantidadeServicos = atribuirInt(mensagemServicos);
        empregadoPrestadorServicos.adicionarNovoServicoPrestado(quantidadeServicos);
        System.out.println("\nO empregado " + empregadoPrestadorServicos.getNome()+ ", possui "+empregadoPrestadorServicos.getQuantidadeServicosPrestados()+" serviços prestados!");
    }
    private static void visualizarGastosEmpresa(Empresa empresa){
        double totalGastosEmpresa = empresa.calculaGastosSalario();
        System.out.println("\nO total de gastos atual da empresa é:"
                        +  "\nR$"+totalGastosEmpresa);
    }
    private static int atribuirInt(String mensagem) {
        int valorAtribuido;
        do{
            try{
                System.out.print(mensagem);
                valorAtribuido = Integer.parseInt(input.nextLine());
                return valorAtribuido;
            }
            catch(Exception e){
                System.out.println("Exeção lançada: " + e.getMessage());
            }
        }while(true);
    }
    private static Double atribuirDouble(String mensagem) {
        Double valorAtribuido;
        do{
            try{
                System.out.print(mensagem);
                valorAtribuido = Double.parseDouble(input.nextLine());
                return valorAtribuido;
            }
            catch(Exception e){
                System.out.println("Exeção lançada: " + e.getMessage());
            }
        }while(true);
    }
    private static String atribuirString(String mensagem) {
        String valorAtribuido;
        do{
                System.out.print(mensagem);
                valorAtribuido = input.nextLine();
                if(!valorAtribuido.isEmpty())return valorAtribuido;
        }while(true);
    }
    private static void encerraPrograma() {
        System.out.println("\nPrograma Encerrado!\n");
    }

}

















