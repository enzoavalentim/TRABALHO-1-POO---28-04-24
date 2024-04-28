import java.util.Random;

public class Cliente {
		
	private String name;
	private int id;
	
	
	// METODO CONSTRUTOR //
	
	public Cliente(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	// GETS E SETS //
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	// METODOS //
	
    public static int gerarIdCliente() {
        Random rand = new Random();
        return rand.nextInt(80000) + 10000;
    }

	@Override
	public String toString() {
		return "Cliente [name=" + name + ", id=" + id + "]";
	}
	
	
	
}
