import java.util.ArrayList;
import java.util.Scanner;

public class Devolucao {
	
	Scanner scanner = new Scanner(System.in);
    
    public void novaDevolucao(String nomeCliDev, int idCliDev, ArrayList<Cliente> listaClientes, ArrayList<Equipamentos> listaEquipamentos, ArrayList<Alugueis> listaAluguel) {
        boolean clienteEncontrado = false;
        for (Cliente cliente : listaClientes) { // Procura o cliente digitado
            if (cliente.getName().equals(nomeCliDev) && cliente.getId() == idCliDev) { // Encontra cliente que esta alugando
                clienteEncontrado = true;
                
                System.out.println("\nEquipamentos alugados por " + nomeCliDev + ":");
                
                boolean equipamentoEncontrado = false;
                
                for (Equipamentos equipamento : listaEquipamentos) { // Procura os equipamentos que o cliente alugou 
                    if (equipamento.getDateLoc() != null && equipamento.getClienteName().equals(nomeCliDev) && equipamento.getClienteId() == idCliDev) {
                        System.out.println("\nNome: " + equipamento.getName());
                        System.out.println("ID: " + equipamento.getId());
                        System.out.println("Data da Locação: " + equipamento.getDateLoc());
                        System.out.println("Data da devolução: " + equipamento.getDateDev());
                        equipamentoEncontrado = true;
                    }
                }
                
                if (!equipamentoEncontrado) {
                    System.out.println("Nenhum equipamento alugado por " + nomeCliDev + ".");
                    break;
                	} 
                
                else {
                    break; // Sai do loop de clientes após encontrar os equipamentos alugados
                	}
            }
        }
        
        	if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado.");
            return; // Sai do método se o cliente não for encontrado
        	}
        	
        	
        	
        	
        	
        	
        
        System.out.println("\nDIgite o nome do equipamento que será devolvido: ");
        String nomeEquipDev = scanner.nextLine();
        System.out.println("Digite o Id do equipamento que será devolvido: ");
        int idEquipDev = scanner.nextInt();
        
        for (Equipamentos equipamento : listaEquipamentos) { // Devolução dos equipamentos que o cliente alugou
            if (equipamento.getName().equals(nomeEquipDev) && equipamento.getId() == idEquipDev && equipamento.getClienteName().equals(nomeCliDev) && equipamento.getClienteId() == idCliDev) {
                System.out.println("Você está devolvendo o equipamento: " + equipamento.getName() + " /nID - " + equipamento.getId());
                System.out.println("Obrigado por utilizar nossos serviços " + equipamento.getClienteName() + " volte sempre!");
                
                equipamento.setClienteName(null);
                equipamento.setClienteId(0);
                equipamento.setDateLoc(null);
                equipamento.setDateDev(null);
                
                return; // Sai do método após encontrar e devolver o equipamento
            }
        }
        
        
        System.out.println("Equipamento não encontrado ou não está alugado por " + nomeCliDev + ".");
    }
}
