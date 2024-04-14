
public class Usuario {

//Atributos
	private String name;
	private String id;
	private String password;

	
	
	
//Construtor	
	public Usuario(String name, String id, String password) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
	}



//Gets e Sets
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}




	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
//Metodos
	public String toString() {
	   return "Nome: " + name + ", Id: " + id + ", Password: " + password;
	    }
	
	
	
	
}
