import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Caminho do arquivo: ");
        String caminho = sc.nextLine();

        File arquivo = new File(caminho);
        String pasta = arquivo.getParent();
        new File(pasta + "/out").mkdir();
        String destino = pasta + "/out/summary.csv";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminho));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(destino));

            String linha = leitor.readLine();
            while (linha != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                double preco = Double.parseDouble(partes[1]);
                int qtd = Integer.parseInt(partes[2]);
                double total = preco * qtd;

                escritor.write(nome + "," + total);
                escritor.newLine();

                linha = leitor.readLine();
            }

            leitor.close();
            escritor.close();
            System.out.println("Arquivo criado em: " + destino);

        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever arquivo.");
        }

        sc.close();
    }
}
