import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		//Variavel de escolha
		Scanner scanner = new Scanner(System.in);
		int escolha = 0;
		
		//Arrays que armazenam o Leitores e os Bibliotecarios cadastrados
		ArrayList<Usuario> listaLeitores = new ArrayList<>(); // Vetor Cadastro de Leitores
		ArrayList<Usuario> listaBibliotecario = new ArrayList<>();// Vetor Cadastro de Bibliotecarios
		ArrayList<Livro> listaLivros = new ArrayList<>();//Vetor Cadastro de Livros


		
		while (escolha != 5) { // Continua exibindo o menu até que o usuário escolha a opção de sair
			System.out.println("\n-=-=-=Menu Geral-=-=-=-");
			System.out.print("\n1. Cadastrar Leitor");
			System.out.print("\n2. Cadastrar Bibliotecario");
			System.out.print("\n3. Menu Leitor");
			System.out.print("\n4. Menu Bibliotecario");
			System.out.print("\nEscolha uma opção: ");

			escolha = scanner.nextInt();
			scanner.nextLine();
			
			
			switch (escolha) {
			
			
			case 1: //Cria novo objeto tipo Usuario coloca no array Bibliotecario
				
				System.out.println("-=-=-=-Cadastro de Leitor-=-=-=-=");
				
				System.out.print("\nDigite o nome de usuario: ");
				String nomeLeitor = scanner.nextLine(); //Passar atributo nome do leitor
				
				System.out.print("Digite a senha numerica do usuario: ");
				String senhaLeitor = scanner.nextLine(); //Passar atributo senha do leitor
				
				Usuario novoLeitor = new Usuario(null, null, null); //Cria um objeto do tipo usuario, nome *novoLeitor* com atributos vazios
				
				novoLeitor.setName(nomeLeitor); // Seta nome do objeto novoLeitor de acordo com o que foi passado na variavel nomeLeitor
				novoLeitor.setPassword(senhaLeitor);// Seta senha do objeto novoLeitor de acordo com o que foi passado na variavel senhaLeitor

				listaLeitores.add(novoLeitor);//Adiciona objeto criado ao Array com os Leitores
				
				System.out.println("\nSeu nome de usuario é: " + novoLeitor.getName()); //Imprime o que foi passado no atribuno nome
				System.out.println("\nSua senha é: " + novoLeitor.getPassword()); //Imprime o que foi passado no atribuno senha

				

				break; //Quebra case 1
				
			case 2: //Cria novo objeto tipo Usuario coloca no array Bibliotecario
				
				System.out.println("-=-=-=-Cadastro de Bibliotecario-=-=-=-=");
				
				System.out.print("\nDigite o nome de usuario: ");
				String nomeBibli = scanner.nextLine(); //Passar atributo noome do bibliotecario
				
				System.out.print("Digite a senha numerica do usuario: ");
				String senhaBibli = scanner.nextLine(); //Passar atributo senha do bibliotecario
				
				Usuario novoBibliotecario = new Usuario(null, null, null); //Cria um objeto do tipo usuario, nome *novoBibliotecario* com atributos vazios
				
				novoBibliotecario.setName(nomeBibli); // Seta nome do objeto novoBibliotecario de acordo com o que foi passado na variavel nomeBibli
				novoBibliotecario.setPassword(senhaBibli);// Seta senha do objeto novoBibliotecario de acordo com o que foi passado na variavel senhaBibli
				
				listaBibliotecario.add(novoBibliotecario);//Adiciona objeto criado ao Array com os Bibliotecarios
				
				System.out.println("\nSeu nome de usuario é: " + novoBibliotecario.getName()); //Imprime o que foi passado no atribuno nome
				System.out.println("\nSua senha é: " + novoBibliotecario.getPassword()); //Imprime o que foi passado no atribuno senha
				
				
				
				
				break; //Quebra case 2
			
			case 3:

				System.out.println("-=-=-=-Menu do Leitor-=-=-=-=");
				
				// Autenticador Leitor
				System.out.print("\nDigite seu nome de usuario: ");
				String nomeLeitor1 = scanner.nextLine(); //Cria outra variavel para o nome de Leitor para comparara-la com o atributo nome do objeto ja criado
				System.out.print("Digite sua senha: ");
				String senhaLeitor1 = scanner.nextLine();//Cria outra variavel para a senha de Leitor para comparara-la com o atributo senha do objeto ja criado

				Usuario leitorAutenticado = null; // Cria um novo objeto vazio da da classe Usuario que vai ser comparado com os objetos ja criados no case 1

				for (Usuario leitor : listaLeitores) { //Para cada objeto tipo bibliotecario que está na listaBibliotecario
					if (leitor.getName().equals(nomeLeitor1) && leitor.getPassword().equals(senhaLeitor1)) { //Pegue o atributo nome e o atributo senha e compare com o que foi passado nas variaveis nomeLeitor1 e senhaLeitor1
						leitorAutenticado = leitor; //Objeto criado para autenticar é igual a um dos objetos ja criados no case 2
						break;	
						
					} // // Fecha if dentro do for case 3
				}// Fecha for case 3
				
				if(leitorAutenticado != null) { //Verifica se o objeto criado não está vazio, isso significa que ele é igual a um objeto dentro do array listaLeitores
					System.out.println("Usuário autenticado com Sucesso! " + "\n Seja bem vindo " + leitorAutenticado.getName());
					
					int escolhaLeitor = 0;
					while (escolhaLeitor != 3) { //Começa a Rodar o menu do Leitor
						
						System.out.println("-=-=-=-Menu do Leitor-=-=-=-=");
						System.out.print("\n1. Empréstimo");
						System.out.print("\n2. Devolução");
						System.out.print("\n3. Sair");
						System.out.print("\nEscolha uma opção: ");
						
						escolhaLeitor = scanner.nextInt();
						scanner.nextLine();	
						switch (escolhaLeitor) {
						
						case 1: // Emprestimo
							
							System.out.println("-=-=-=-Lista de Livros para empréstimo-=-=-=-=");
							
							for(Livro livro : listaLivros) { //Varre o array com os livros cadastrados, e imprime os que estão disponiveis
								
								if(livro.getStatus() == "Disponivel") //Se o livro estiver disponivel para emprestimo ele será mostrado na lista
								
								System.out.println();
								System.out.println("Titulo: " + livro.getTitle());
								System.out.println("Autor: " + livro.getAutor());
								System.out.println("Código ISBN: " + livro.getISBN());
								System.out.println("Livro " + livro.getStatus() + " para empréstimpo");
								
							} //Fecha for emprestimo
							
							
							System.out.println("\nDigite o titulo do livro para empréstimo: ");
							String titlEmpres = scanner.nextLine();
							
							System.out.println("Digite o código ISBN do livro para empréstimo");
							int isbnEmpres = scanner.nextInt();
							
							Emprestimo novoEmprestimo = new Emprestimo();
							novoEmprestimo.emprestLivro(titlEmpres, isbnEmpres, listaLivros, leitorAutenticado);
							break;
								
		
						case 2: // Devolução
							
							System.out.println("-=-=-=-Devolução de livros-=-=-=-=");
							
							System.out.println("\nDigite o titulo do livro para devolução: ");
							String titlDev = scanner.nextLine();
							
							System.out.println("Digite o código ISBN do livro para devolução");
							int isbnDev = scanner.nextInt();
							
							Devolucao novaDev = new Devolucao();
							novaDev.devLivro(titlDev, isbnDev, listaLivros, leitorAutenticado);
							
							
							
						case 3://Volta menu geral
							break;
						
						
						default: //Caso usuario escolha opçaõ invalida
							System.out.println("Opção inválida. Por favor, escolha novamente.");
							break; 
						
						

						}//Fecha Switch menu leitor
					
					}//Fecha while menu leitor
					
				}//Fecha if leitorAutenticado
				
				else { //Se o objeto leitorAutenticado estiver vazio é porque não existe um objeto semelhante na listaLeitores
					System.out.println("Usuário não autenticado, por favor cadastre um usuario do tipo Leitor.");
					}
				
				break;//Quebra case 3
				
				
			case 4: 
				
				System.out.println("-=-=-=-Menu do Bibliotecario-=-=-=-=");
				
				// Autenticador Bibliotecario
				System.out.print("\nDigite seu nome de usuario: ");
				String nomeBibli1 = scanner.nextLine(); //Cria outra variavel para o nome de Bibliotecario para comparara-la com o atributo nome do objeto ja criado
				System.out.print("Digite sua senha: ");
				String senhaBibli1 = scanner.nextLine();//Cria outra variavel para a senha de Bibliotecario para comparara-la com o atributo senha do objeto ja criado
				
				Usuario bibliotecarioAutenticado = null; // Cria um novo objeto vasio da da classe Usuaario que vai ser comparado com os objetos ja criados no case 2
			
				for (Usuario bibliotecario : listaBibliotecario) { //Para cada objeto tipo bibliotecario que está na listaBibliotecario
					if (bibliotecario.getName().equals(nomeBibli1) && bibliotecario.getPassword().equals(senhaBibli1)) { //Pegue o atributo nome e o atributo senha e compare com o que foi passado nas variaveis nomeBibli1 e senhaBibli1
						bibliotecarioAutenticado = bibliotecario; //Objeto criado para autenticar é igual a um dos objetos ja criados no case 2
						break;
						
					} // Fecha if dentro do for case 4
				}// Fecha for case 4
				
				if(bibliotecarioAutenticado != null) { //Verifica se o objeto criado não está vazio, isso significa que ele é igual a um objeto dentro do array listaBibliotecario
					System.out.println("Usuário autenticado com Sucesso! " + "\n Seja bem vindo " + bibliotecarioAutenticado.getName());
					
					int escolhaBibliotecario = 0;
					while (escolhaBibliotecario != 2) { //Começa a Rodar o menu do Bibliotecario
						
						System.out.println("-=-=-=-Menu do Bibliotecario-=-=-=-=");
						System.out.print("\n1. Cadastrar Livro");
						System.out.print("\n2. Sair");
						System.out.print("\nEscolha uma opção: ");
					
					escolhaBibliotecario = scanner.nextInt();
					scanner.nextLine();	
					switch (escolhaBibliotecario) {
					
					
					case 1: //Cadastro Livros
						
						System.out.println("-=-=-=-=-=Cadastro de Livros-=-=-=-=-=-");
						
						System.out.print("\n1. Digite o titulo do livro: ");
						String tituloLivro = scanner.nextLine(); //titulo do objeto novoLivro
			
						System.out.print("Digite o nome do autor: ");
						String nomeAutor = scanner.nextLine(); //Nome autor do objeto novoLivro
						
						System.out.print("Digite o código numério para o ISBN: ");
						int isbn = scanner.nextInt(); //código do objeto novoLivro
						
						Livro novoLivro = new Livro(null, null, 0, "Disponivel", null); //Cria um objeto novoLivro
						
						novoLivro.setTitle(tituloLivro); //seta atributo titulo do objeto novoLivro
						novoLivro.setAutor(nomeAutor); //seta  atributo nomeAutor do objeto novoLivro
						novoLivro.setISBN(isbn); //seta atributo ISBN do objeto novoLivro
						
						listaLivros.add(novoLivro);//Adiciona o objeto novoLivro ao array cadastro de livros
						
					
						
					case 2: //Volta para o menu geral
						break;
						
					default: //Caso usuario escolha opçaõ invalida
						System.out.println("Opção inválida. Por favor, escolha novamente.");
						break; 
						
						}//Fecha switch menu Bibliotecario
					
					}//Fecha while menu Bibliotecario
						
						
		
				}//Fecha if bibliotecarioAutenticado
					
				
				else { //Se o objeto bibliotecarioAutenticado estiver vazio é porque não existe um objeto semelhante na listaBibliotecario
					System.out.println("Usuário não autenticado, por favor cadastre um usuario do tipo Bibliotecario.");
				}//Fecha else Bibliotecario não autenticado
				
				break; //Quebra o case 4 
				
			case 5:
			    System.out.println("Lista de Livros: ");
			    for (Livro livro : listaLivros) {
			        System.out.println(livro.toString()); // Supondo que você tenha um método toString() adequado em sua classe Livro
			    }
			    System.out.println("Deseja continuar? (s/n)");
			    String continuar = scanner.next();
			    if (continuar.equalsIgnoreCase("n")) {
			        escolha = 3; // Define a escolha para 3 para sair do loop while
			    }
			    break;
				
			default: //Caso usuario escolha opção invalida
				System.out.println("Opção inválida. Por favor, escolha novamente.");
				break;
				
				
			}//Fecha Switch	
		}//Fecha while	
	}//Fecha publc static void
}//Fecha Main
