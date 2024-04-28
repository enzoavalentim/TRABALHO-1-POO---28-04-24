import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class Locacao {
	
	
	Scanner scanner = new Scanner(System.in);

	
	public void novaLocacao(String nomeEquipAutentic, int IdEquipAutentic, ArrayList<Equipamentos> listaEquipamentos, Cliente clienteAutentic, ArrayList<Alugueis> listaAluguel){
	
		boolean equipEncontrado = false; // Variável para rastrear se o equipamento foi encontrado
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		for (Equipamentos equipamento : listaEquipamentos) { // Verifica se o s parametros passados conferem com os atribudos de algum dos objetos cliente cadastrados
		

			
			if (equipamento.getName().equals(nomeEquipAutentic) && equipamento.getId() == IdEquipAutentic && equipamento.getDateLoc() == null)  { 
			 
			System.out.println("\nDigite por quanto dias o Produto será Locado: ");
			int nDiasLoca = scanner.nextInt();
			
			
			System.out.println("Locação realizada com sucesso!");
			
			System.out.println("\nDados da Locação:");
			System.out.println("\nNome do locatario: " + clienteAutentic.getName() + " - Id " + clienteAutentic.getId()); // Imprime dados do cliente que locou o produto
			System.out.println("\nProdutSo Locado: " + equipamento.getName()); // Imprime nome do equipamento locado
			System.out.println("Id do produto: " + equipamento.getId()); // Imprime id do equipamento locado
			
			
			  LocalDate dataLoc = LocalDate.now(); // Pega a data do sistema 
              equipamento.setDateLoc(dataLoc.format(formatter)); // Seta a data de locação formatada
              
              System.out.println("Data de empréstimo: " + equipamento.getDateLoc());
              
              LocalDate dataDev = dataLoc.plusDays(nDiasLoca); // Pega data da locação e adiciona o número de dias desejado para locação 
              equipamento.setDateDev(dataDev.format(formatter)); // Seta a data de devolução formatada
              
              System.out.println("Data de devolução: " + equipamento.getDateDev()); 
              
              double vlTotalLoc = (equipamento.getVlLoc() * nDiasLoca); // Calcula o valor total da locação
              System.out.println("Valor da locação: " + "R$" + vlTotalLoc);
              
              equipamento.setClienteName(clienteAutentic.getName()); // Seta o nome do cliente que está alugando o equipamento
              equipamento.setClienteId(clienteAutentic.getId());  // Seta o id do cliente que está alugando o equipamento
              
              Alugueis novoAluguel = new Alugueis(equipamento.getName(), equipamento.getId(), vlTotalLoc, equipamento.getDateLoc(), equipamento.getDateDev(), equipamento.getClienteName(), equipamento.getClienteId());              
              listaAluguel.add(novoAluguel); 
              equipEncontrado = true;
              break;
            
            
        } // Fecha If
    } // Fecha for

    if (!equipEncontrado) {
        System.out.println("O equipamento está indisponível para locação ou ainda não foi cadastrado");
    }
}
	}