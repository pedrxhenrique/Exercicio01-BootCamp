import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static ContaBancaria contaBancaria;
    public static void main(String[] args) throws Exception {
        var option = -1;
        
        System.out.println("Digite o saldo inicial da sua conta");
        int valorInicial = validarDeposito();
        contaBancaria = new ContaBancaria(valorInicial);

        do {
            System.out.println("Escolha uma das opcoes:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar Dinheiro ");
            System.out.println("5. Pagar Boleto");
            System.out.println("6. Verificar se a conta esta usando cheque especial");
            System.out.println("0. Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> consultarDinheiro();
                case 2 -> consultaCheque();
                case 3 -> depositarGrana();
                case 4 -> sacar();
                case 5 -> pagarBoleto();
                case 6 -> verificarUsoCheque();
                case 0 -> System.exit(0);
                default -> System.out.println("Opcao invalida");
            }
        }while(true);

        }

        private static int validarDeposito(){
            while (true) {
                if (scanner.hasNextInt()) {
                    int valor = scanner.nextInt();
                    scanner.nextLine(); 
                    return valor;
                } else {
                    System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                    scanner.next(); 
                }
            }
        }
        
        private static void consultarDinheiro(){
            contaBancaria.consultarSaldo();
        }

        private static void depositarGrana(){
            System.out.println("digite o valor que voce deseja depositar");
            int deposito = validarDeposito();
            contaBancaria.depositarDinheiro(deposito);
        }


        private static void consultaCheque(){
            contaBancaria.consultarCheque();
        }

        private static void sacar(){
            System.out.println("Digite o valor do saque");
            int saque = validarDeposito();
            contaBancaria.sacarDinheiro(saque);
        }

        private static void verificarUsoCheque(){
            if (contaBancaria.getSaldo() < 0) {
                System.out.println("A conta está usando o cheque especial.");
            } else {
                System.out.println("A conta não está usando o cheque especial.");
            }

        
        }
        private static void pagarBoleto(){
            System.out.println("Digite o valor do boleto");
            int valorBoleto = validarDeposito();
            contaBancaria.sacarDinheiro(valorBoleto);
        }

    }

