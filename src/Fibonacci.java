import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("-------------");
        System.out.println("Linear");
        linearFibonacci();
        System.out.println("-------------");
        System.out.println("Recursiva");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int n = scanner.nextInt();
        System.out.println("O valor de Fibonnaci na posição " +n+ " é: " +recursivoFibonacci(n));
    }

    public static void linearFibonacci() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero até 29: ");
        int n = scanner.nextInt();
        int f1 = 0;
        int f2 = 1;
        int aux;
        int[] lista = new int[30];

        if(n < 0 || n >= 30){
            System.out.println("Numero invalido! O numero deve estar entre 0 e 29.");
            return;
        }
        for(int i = 0; i < 30; i++){
            lista[i] = f1;
            aux = f1;
            f1 = f1 + f2;
            f2 = aux;
        }
        System.out.println("O valor de Fibonacci na posição " + n + " é: " + lista[n]);
    }

    public static int recursivoFibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return recursivoFibonacci(n-1) + recursivoFibonacci(n - 2);
    }

}
