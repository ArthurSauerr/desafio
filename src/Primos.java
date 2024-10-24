import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int n = scanner.nextInt();
        List<Integer> numerosPrimos = encontrarPrimos(n);
        System.out.println("Números primos até " + n + ": " + numerosPrimos);
        System.out.println("-------------");
        System.out.println("Recursiva");
        System.out.print("Digite um numero: ");
        int n2 = scanner.nextInt();
        List<Integer> numerosPrimos2 = encontrarPrimosRecursivo(n, 2, new ArrayList<>());
        System.out.println("Números primos até " + n2 + ": " + numerosPrimos2);
    }

    public static List<Integer> encontrarPrimos(int n) {
        List<Integer> listaDeInteiros = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            listaDeInteiros.add(i);
        }

        int limite = (int) Math.sqrt(n) + 1;
        for (int i = 2; i <= limite; i++) {
            if (listaDeInteiros.contains(i)) {
                for (int j = i * i; j <= n; j += i) {
                    listaDeInteiros.remove(Integer.valueOf(j));
                }
            }
        }
        return listaDeInteiros;
    }

    public static List<Integer> encontrarPrimosRecursivo(int n, int i, List<Integer> listaDePrimos) {
        if (i > n) {
            return listaDePrimos;
        }
        if (isPrimo(i, 2)) {
            listaDePrimos.add(i);
        }
        return encontrarPrimosRecursivo(n, i + 1, listaDePrimos);
    }
    private static boolean isPrimo(int num, int divisor) {
        if (num < 2) return false;
        if (divisor * divisor > num) return true;
        if (num % divisor == 0) return false;

        return isPrimo(num, divisor + 1);
    }
}