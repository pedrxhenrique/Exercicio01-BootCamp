public class ContaBancaria {

    private int saldo = 0;
    private int chequeEspecial;
    private int valorUsadoChequeEspecial;
    private int chequeEspecialFinal;

    public ContaBancaria(int saldo) {
        this.saldo = saldo;
        definirCheque();
    }

    public int getSaldo() {
        return saldo;

    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
        definirCheque();
    }

    public int getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(int chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void depositarDinheiro(int valor) {
        if (valor >= 0) {
            if (valorUsadoChequeEspecial > 0) {
                int taxa = (int) (valorUsadoChequeEspecial * 0.20);
                if (valor >= taxa) {
                    valor -= taxa;
                    valorUsadoChequeEspecial = 0;
                    System.out.println("Taxa de 20% sobre o cheque especial usado: " + taxa + " reais.");
                } else {
                    valorUsadoChequeEspecial -= valor;
                    valor = 0;
                    System.out.println("Parte da taxa de 20% paga: " + valor + " reais.");
                }
            }
            saldo += valor;
            definirCheque();
            System.out.println("Voce depositou " + valor);
        } else {
            System.out.println("Voce nao pode depositar abaixo de 1 real");
        }

    }

    public void consultarSaldo() {
        System.out.println("O seu saldo eh de " + saldo);
    }

    public void definirCheque() {
        if (saldo <= 500) {
            chequeEspecialFinal = 50;
        } else {
            chequeEspecialFinal = saldo / 2;
        }
    }

    public void consultarCheque() {
        definirCheque();
        System.out.println("o seu cheque eh de " + chequeEspecialFinal);
    }

    public void sacarDinheiro(int saque) {
        int valorTotal = saldo + chequeEspecialFinal;
        if (valorTotal >= saque) {
            if (saldo < saque) {
                valorUsadoChequeEspecial += saque - saldo;
                saldo = 0;
                chequeEspecialFinal -= valorUsadoChequeEspecial;
            } else {
                valorTotal -= saque;

            }
            System.out.println("voce sacou " + saque + " reais");
        } else {
            System.out.println("Voce nao possui esse valor, voce so tem " + saldo + " em sua conta bancaria");
        }
    }

}
