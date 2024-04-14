import java.util.ArrayList;
import java.time.LocalDate;

public class Emprestimo {
	
//Metodos
	
	public void emprestLivro(String titlEmpres, int isbnEmpres, ArrayList<Livro> listaLivros, Usuario leitorAutenticado){
	
		
		boolean livroEncontrado = false; // Variável para rastrear se o livro foi encontrado

		for (Livro livro : listaLivros) {
		    if (livro.getTitle().equals(titlEmpres) && livro.getISBN() == isbnEmpres && livro.getStatus().equals("Disponivel")) {
		        System.out.println("Empréstimo realizado com sucesso!");
		        System.out.println();
		        System.out.println("Dados do empréstimo:");
		        System.out.println("Título: " + livro.getTitle());
		        System.out.println("Autor: " + livro.getAutor());
		        System.out.println("Código ISBN: " + livro.getISBN());
		       
		        LocalDate dataEmpres = LocalDate.now();
		        livro.setData(dataEmpres);
		        System.out.println("Data do empréstimo: " + livro.getData());
		        LocalDate dataDev = dataEmpres.plusDays(10);
		        System.out.println("Data de devolução: " + dataDev);
		        
		        livro.setStatus("Indisponível");
		        
		        livroEncontrado = true;
		        
		        break; // Se o livro for encontrado e estiver disponível, interrompe o loop
		    }
		}

		
		
		if (!livroEncontrado) {
		    System.out.println("Livro indisponível para empréstimo");
		}

	}
	
}


		
		//Usuario bibliotecarioAutenticado = null; // Cria um novo objeto vasio da da classe Usuaario que vai ser comparado com os objetos ja criados no case 2
		
		//for (Usuario bibliotecario : listaBibliotecario) { //Para cada objeto tipo bibliotecario que está na listaBibliotecario
			//if (bibliotecario.getName().equals(nomeBibli1) && bibliotecario.getPassword().equals(senhaBibli1)) { //Pegue o atributo nome e o atributo senha e compare com o que foi passado nas variaveis nomeBibli1 e senhaBibli1
				//bibliotecarioAutenticado = bibliotecario; //Objeto criado para autenticar é igual a um dos objetos ja criados no case 2
				//break;
		
		
		
	

//}
