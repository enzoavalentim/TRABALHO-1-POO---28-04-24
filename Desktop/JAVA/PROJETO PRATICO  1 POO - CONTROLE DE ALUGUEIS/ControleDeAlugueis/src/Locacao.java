import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Locacao {
	
	Scanner scanner = new Scanner(System.in);

	
	public void novaLocacao(String nomeEquipAutentic, int IdEquipAutentic, ArrayList<Equipamentos> listaEquipamentos, Cliente clienteAutentic){
	
		boolean equipEncontrado = false; // Variável para rastrear se o equipamento foi encontrado
		
		for (Equipamentos equipamento : listaEquipamentos) { // Verifica se o s parametros passados conferem com os atribudos de algum dos objetos cliente cadastrados
		if (equipamento.getName().equals(nomeEquipAutentic) && equipamento.getId() == IdEquipAutentic && equipamento.getDateLoc() == null)  { 
			 
			System.out.println("Digite por quanto dias o Produto será Locado: ");
			int nDiasLoca = scanner.nextInt();
			
			
			System.out.println("Locação realizada com sucesso!");
			
			System.out.println("\nDados da Locação:");
			System.out.println("Nome do locatario: " + clienteAutentic.getName() + "- Id " + clienteAutentic.getId()); // Imprime dados do cliente que locou o produto
			System.out.println("\nProduto Locado: " + equipamento.getName()); // Imprime nome do equipamento locado
			System.out.println("Id do produto: " + equipamento.getId()); // Imprime id do equipamento locado
			
			LocalDate dataLoc = LocalDate.now(); // Pega a data do sistema 
			String dataLocString = dataLoc.toString(); // Transforma a data do sistema em String 
			equipamento.setDateLoc(dataLocString); // Seta a data de locação
			System.out.println("Data de empréstimo: " + equipamento.getDateLoc());
			
			LocalDate dataDev = dataLoc.plusDays(nDiasLoca); // Pega data da locação e adiciona o numero de dias desejado para locação 
			String dataDevString = dataDev.toString(); // Transforma a data de devolução em String
			equipamento.setDateDev(dataDevString); // Seta a data de devolução no equipamento
			System.out.println("Data de devolução: " + equipamento.getDateDev()); 
			
			double vlTotalLoc = (equipamento.getVlLoc() * nDiasLoca); // Calcula o valor total da locação
			System.out.println("Valor da locação: " + "R$" + vlTotalLoc);
			
			equipamento.setClienteName(clienteAutentic.getName()); // Seta o nome do cliente que está alugando o equipamento
			equipamento.setClienteId(clienteAutentic.getId());  // Seta o id do cliente que está alugando o equipamento
		
            equipEncontrado = true; 
            break;
            
            
        } // Fecha If
    } // Fecha for

    if (!equipEncontrado) {
        System.out.println("O equipamento está indisponível para locação");
    }
}
	}
