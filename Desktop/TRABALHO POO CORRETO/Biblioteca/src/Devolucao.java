import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Devolucao {
    
    public void devLivro(String titlDev, int isbnDev, ArrayList<Livro> listaLivros, Usuario leitorAutenticado) {
        boolean livroEncontrado1 = false; // Variável para rastrear se o livro foi encontrado
        Scanner scanner = new Scanner(System.in);

        for (Livro livro : listaLivros) {
            if (livro.getTitle().equals(titlDev) && livro.getISBN() == isbnDev && livro.getStatus().equals("Indisponível")) {
                livro.setStatus("Disponivel");
                
               
                
                System.out.println("Digite a data de devolução (formato: yyyy-MM-dd): "); //Usuario digita data que está devolvendo o livro
                String dataDevolucaoStr = scanner.nextLine();
                LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr); // Converte a String que o usuario digitou para data
                
                LocalDate dataDev = livro.getData().plusDays(10); //Data prevista para devolução do livro
                
                System.out.println("Livro: " + livro.getTitle() + " " + livro.getISBN() + " Devolvido com sucesso");
                
                if (dataDevolucao.isEqual(livro.getData())) {
                    System.out.println("Parabéns " + leitorAutenticado + ", você devolveu o livro na data certa!");}
                
                else {
                    // Calcula a diferença em dias entre a data de devolução e a data prevista
                    long diasDeAtraso = dataDev.until(dataDevolucao, ChronoUnit.DAYS);
                    
                    // Calcula a multa com base no número de dias de atraso
                    double multa = diasDeAtraso * 0.50;
                    
                    System.out.println("Você devolveu o livro com " + diasDeAtraso + " dias de atraso. "
                                       + "A multa é de R$ " + multa);
                }
                
                
                
       
                
                
                
                livroEncontrado1 = true;
                break; // Se o livro for encontrado e estiver indisponível, interrompe o loop
            }
        }
        
        if (!livroEncontrado1) {
            System.out.println("Livro indisponível para devolução");
        }
    }
}
