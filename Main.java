import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
//    Pessoas pessoas = new Pessoas();
//    Não precisava estanciar antes.
    public static void main(String[] args) {
        ArrayList<Pessoas> pessoas = new ArrayList<>();
        Scanner s= new Scanner(System.in);
        String teste="";
        System.out.println("Vamos informas as pessoas e o sexo delas.");
        System.out.println("Por favor informe o nome e sexo separado por virgula. Para o sexo por favor utilizar masculino ou feminino");
        System.out.println("Digite 'acabou' para encerrar.");

        while(true){
            teste=s.nextLine();
            if (teste.equalsIgnoreCase("acabou")) {
                break;
            }
            String[] separador = teste.split(",");
            if (separador.length < 2) {
                System.out.println("Formato inválido! Use: nome,sexo");
                continue;
                // volta para pedir novamente
            }
//            System.out.println(separador[0]);
//            System.out.println(separador[1]);
            String nome=separador[0].trim();
            String sexo=separador[1].trim();
            pessoas.add(new Pessoas(nome,sexo));
        }
        System.out.println("*************************");
        System.out.println("Esse é na ordem informada.");
        for(Pessoas p : pessoas){

            System.out.println(p);
        }
        System.out.println("*************************");
        System.out.println("Esse é na ordem alfabetica.");
        pessoas.sort(Comparator.comparing(Pessoas::getNome));
        for(Pessoas p : pessoas){
            System.out.println(p);
        }
        System.out.println("*************************");
        System.out.println("Esse é pela ordem do sexo.");
        pessoas.sort(Comparator.comparing(Pessoas::getSexo).thenComparing(Pessoas::getNome));
        for(Pessoas p : pessoas){
            System.out.println(p);
        }
        System.out.println("\n--- Lista Masculina ---");
        pessoas.stream().filter(pessoa -> pessoa.getSexo().equalsIgnoreCase("Masculino")).forEach(System.out::println);

        System.out.println("\n--- Lista Feminina ---");
        pessoas.stream().filter(p -> p.getSexo().equalsIgnoreCase("Feminino")).forEach(System.out::println);


    }
}