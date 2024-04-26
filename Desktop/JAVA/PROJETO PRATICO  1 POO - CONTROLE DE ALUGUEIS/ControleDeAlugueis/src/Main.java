import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int escolha = 0;
		
ArrayList<Equipamentos> listaEquipamentos = new ArrayList<>(); // Vetor Cadastro de Equipamentos
ArrayList<Cliente> listaClientes = new ArrayList<>(); // Vetor Cadastro de Clientes


	while (escolha != 7) {
	
		System.out.println("-=-=-=Menu Geral-=-=-=-");
		System.out.print("\n1. Cadastar Cliente");
		System.out.print("\n2. Cadastrar Produto");
		System.out.print("\n3. Aluguel de equipamentos");
		System.out.print("\n4. Devolução de equipamentos");
		System.out.print("\n5. Central de relatórios");
		System.out.print("\nEscolha uma das opções: ");
	
		escolha = scanner.nextInt();
		scanner.nextLine();
		
		switch (escolha) {
		
		
		case 1: // CADASTRO DE CLIENTES //
			
			System.out.println("\n-=-=-=-Cadastro de Cliente-=-=-=-=");
			
			Cliente novoCliente = new Cliente(null, 0); // Cria um objeto tipo cliente vazio

			System.out.print("\nDigite o nome do cliente: ");
			String nomeCliente = scanner.nextLine(); //Passar atributo nome do Cliente
			novoCliente.setName(nomeCliente); // Seta o nome de acordo com o parametro passado

			
			 
			
			int newId; // Setar Id do cliente
			boolean idUnico = false;

			do {
			    
			    newId = Cliente.gerarIdCliente(); // Gera um ID aleatório para o cliente
			    
			    
			    idUnico = true; // Assume que o ID é único
			    for(Cliente cliente : listaClientes) {
			        if (cliente.getId() == newId) {
			            idUnico = false; // O ID não é único, então precisamos gerar um novo
			            break; // Sai do loop assim que encontrar um ID duplicado
			        }
			    }
			} while (!idUnico); 
			
			
			novoCliente.setId(newId); // Seta o id de acordo com o parametro passado
			
			
			listaClientes.add(novoCliente); // Adiciona o Cliente a lista de Clientes cadastrados
			
			System.out.println("\nCliente Cadastrado com Sucesso!");
			System.out.println("\nNome: " + novoCliente.getName());
			System.out.println("Id: " + novoCliente.getId());
			break;
			
		case 2: // CADASTRO DE EQUIPAMENTOS //

		    System.out.println("-=-=-=-Cadastro de Produto-=-=-=-=");

		    Equipamentos novoProduto = new Equipamentos(null, 0, 0, null, null, null, 0); // Cria um objeto tipo equipamento vazio

		    System.out.print("\nDigite o tipo do produto: ");
		    String nomeProduto = scanner.nextLine(); // Passar atributo nome do Equipamento
		    novoProduto.setName(nomeProduto); // Seta o nome de acordo com o parametro passado

		    int newIdProd; // Setar Id do Produto
		    boolean idUnicoProd = false;

		    do {
		        newIdProd = Equipamentos.gerarIdProduto(); // Gera um ID aleatório para o produto

		        idUnicoProd = true; // Assume que o ID é único
		        for (Equipamentos equipamento : listaEquipamentos) {
		            if (equipamento.getId() == newIdProd) {
		                idUnicoProd = false; // O ID não é único, então precisamos gerar um novo
		                break; // Sai do loop assim que encontrar um ID duplicado
		            }
		        }
		    } while (!idUnicoProd);

		    novoProduto.setId(newIdProd);

		    System.out.print("\nDigite o valor da diaria do produto: ");
		    double vlDiaria = scanner.nextDouble(); // Setar o valor da diaria do equipamento
		    novoProduto.setVlLoc(vlDiaria);

		    listaEquipamentos.add(novoProduto); // Adiciona o equipamento cadastrado a lista de equipamentos 

		    System.out.println("\nNovo equipamento cadastrado com sucesso!");
		    System.out.println("\nNome: " + novoProduto.getName());
		    System.out.println("Id: " + novoProduto.getId());
		    System.out.println("Valor da Locação diaria: " + "R$" + novoProduto.getVlLoc());

		    break;

			
		case 3:	// ALUGUEL DE EQUIPAMENTOS // 
			
		    System.out.println("-=-=-=-Aluguel de Equipamentos-=-=-=-=");
		    System.out.println("\nLista de Clientes Cadastrados:");
		    for(Cliente cliente:listaClientes) {
		        System.out.println("\nNome: " + cliente.getName());
		        System.out.println("Id: " + cliente.getId());
		    }
		    
		    System.out.println("\nDigite o nome do Locatário: ");
		    String nomeCliAutentic = scanner.nextLine();  
		    
		    System.out.println("\nDigite o Id do Locatário: ");
		    int IdCliAutentic = scanner.nextInt(); 
		    
		    Cliente clienteAutentic = null;
		    
		    for (Cliente cliente : listaClientes) {
		        if (cliente.getName().equals(nomeCliAutentic) && cliente.getId() == IdCliAutentic)  { 
		            clienteAutentic = cliente;
		            break;
		        } 
		    }
		    
		    if (clienteAutentic == null) {
		        System.out.println("Este Cliente não existe no sistema"); 
		        break; // 
		    }
		    
		    System.out.println("\nLocatario: " + clienteAutentic.getName());
		    
		    System.out.println("\nLista de Equipamentos Disponiveis:");
		    
		    boolean nenhumEquipamentoDisponivel = true;
		    for(Equipamentos equipamento : listaEquipamentos) {
		        if(equipamento.getDateLoc() == null) {
		            nenhumEquipamentoDisponivel = false;
		            System.out.println("\nNome " + equipamento.getName());
		            System.out.println("Id " + equipamento.getId());
		            System.out.println("Valor da Diaria: " + "R$" + equipamento.getVlLoc());
		        }
		    }
		    
		    if (nenhumEquipamentoDisponivel) {
		        System.out.println("\nNenhum equipamento disponível para locação.");
		        break; // Se não houver equipamento disponível, sair do case 3
		    }
		    
		    System.out.println("\nDigite o nome do Equipamento a ser locado: ");
		    String nomeEquipAutentic = scanner.next();  
		    
		    System.out.println("\nDigite o Id do equipamento a ser locado: ");
		    int IdEquipAutentic = scanner.nextInt(); 
		    
		    Locacao novaLoc = new Locacao();
		    novaLoc.novaLocacao(nomeEquipAutentic, IdEquipAutentic, listaEquipamentos, clienteAutentic);
		    break;

			
		case 4: // DEVOLUÇÃO DE EQUIPAMENTOS //
			
			System.out.println("\nLista de Clientes Cadastrados:");
			for(Cliente cliente:listaClientes) { // Vai mostrar todos os clientes cadastrados
				
				System.out.println("\nNome: " + cliente.getName());
				System.out.println("Id: " + cliente.getId());
			}
			
			System.out.println("\nDigite o nome do cliente que está fazendo a devolução: ");
			String nomeCliDev = scanner.nextLine();
			
			System.out.println("Digite o ID do cliente que está fazendo a devolução: ");
			int idCliDev = scanner.nextInt();
			
			Devolucao novaDev = new Devolucao();
			novaDev.novaDevolucao(nomeCliDev, idCliDev, listaClientes, listaEquipamentos);
			
			break;
			
			
	
		case 5: // CENTRAL DE  RELATORIOS 
			
			int escolhaRelatorios = 0;
			while (escolha != 6) {
				
				System.out.println("-=-=-=CENTRAL DE RELATÓRIOS-=-=-=-");
				System.out.print("\n1. Lista de equipamentos cadastrados");
				System.out.print("\n2. Lista de clientes cadastrados");
				System.out.print("\n3. Lista de alugueis");
				System.out.print("\n4. Lista de alugueis por cliente");
				System.out.print("\n5. Relatório mensal e faturamento");
				System.out.print("\n6. Sair");
				System.out.print("\nEscolha uma das opções: ");
				
				escolha = scanner.nextInt();
				scanner.nextLine();
				
				switch (escolha) {
				
				case 1: // IMPRIMIR TODOS EQUIPAMENTOS CADASTRADOS 
					
					if (listaEquipamentos.isEmpty()) {
						
						System.out.println("Nenhum equipamento cadastrado no momento");	
					}
					
					else {
					System.out.println("\nLista de equipamentos cadastrados"); 
						
					for(Equipamentos equipamento : listaEquipamentos) {
						
						System.out.println("\nNome: " + equipamento.getName());
						System.out.println("Id: " + equipamento.getId());
						System.out.println("Valor da locação diaria: " + equipamento.getVlLoc());
						System.out.println(equipamento.getClienteName());
						if(equipamento.getDateLoc() == null) {
							
							System.out.println("Status: Disponivel para locação");
							} // Fecha if
						
						else {
							System.out.println("Status: indisponivel para locação");
							} // Fecha else
						
						} // fecha for
					} // Fecha else
					
					break;
				
				case 2: // IMPRIMIR TODOS OS CLIENTES CADASTRADOS // 
					
					
					if (listaClientes.isEmpty()) {
						
						System.out.println("Nenhum cliente cadastrado no momento");	
					}
					
					else {
					System.out.println("\nLista de clientes cadastrados");
					
					for(Cliente cliente:listaClientes) {
						
						System.out.println("\n" + cliente.getName());
						System.out.println(cliente.getId());
						}
					}
					
				
					
					
					
				} // Fecha Switch central de relatórios 
				
			} // Fecha While central de relatórios			
			
		
		} // Fecha Switch principal
}// Fecha While Principal
			
		
	} // Fecha Public Static void Main



} // Fecha class Main

