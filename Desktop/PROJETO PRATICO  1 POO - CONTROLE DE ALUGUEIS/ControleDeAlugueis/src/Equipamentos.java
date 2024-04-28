import java.time.LocalDate;
import java.util.Random;


public class Equipamentos {
	
	private String name;
	private int id;
	private double vlLoc;
	private String dateLoc;
	private String dateDev;
	private String clienteName;
	private int clienteId;
	
	
	// METODO CONSTRUTOR //
	public Equipamentos(String name, int id, double vlLoc, String dateLoc, String dateDev, String clienteName, int clienteId) {
		super();
		this.name = name;
		this.id = id;
		this.vlLoc = vlLoc;
		this.dateLoc = dateLoc;
		this.dateDev = dateDev;
		this.clienteName = clienteName;
		this.clienteId = clienteId;
	}

	// GETS E SETS
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


	public double getVlLoc() {
		return vlLoc;
	}
	public void setVlLoc(double vlLoc) {
		this.vlLoc = vlLoc;
	}


	public String getDateLoc() {
		return dateLoc;
	}
	public void setDateLoc(String dateLoc) {
		this.dateLoc = dateLoc;
	}

	
	public String getClienteName() {
		return clienteName;
	}

	public void setClienteName(String clienteName) {
		this.clienteName = clienteName;
	}
	

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	
	

	public String getDateDev() {
		return dateDev;
	}

	public void setDateDev(String dateDev) {
		this.dateDev = dateDev;
	}

	// METODOS //
    public static int gerarIdProduto() {
        Random rand = new Random();
        return rand.nextInt(8000) + 1000;
    }

	@Override
	public String toString() {
		return "Equipamentos [name=" + name + ", id=" + id + ", vlLoc=" + vlLoc + ", dateLoc=" + dateLoc + ", dateDev="
				+ dateDev + ", clienteName=" + clienteName + ", clienteId=" + clienteId + "]";
	}

    
    
    
}
