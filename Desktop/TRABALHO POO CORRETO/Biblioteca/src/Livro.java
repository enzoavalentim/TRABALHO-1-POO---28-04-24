import java.time.LocalDate;

public class Livro {
	
	private String title;
	private String autor;
	private int ISBN;
	private String status;
	 private LocalDate data;
	

	
//Construtor
	public Livro(String title, String autor, int isbn, String status, LocalDate data) {
		super();
		this.title = title;
		this.autor = autor;
		this.ISBN = isbn;
		this.status = status;
		this.data = data;
	}


//Gets e Sets
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}



	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}



	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}



	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


    public String toString() {
        String dataString = (data != null) ? data.toString() : "Data não especificada";
        return "Livro{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN=" + ISBN +
                ", status='" + status + '\'' +
                ", data=" + dataString +
                '}';
    }
	
	
	
	
}
