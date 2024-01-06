
public class Contatos {
    private String nome;
    private int ddd;
    private int numero;
    private String email;
    
    public Contatos(String nome, int ddd, int numero, String email) {
        this.nome = nome;
        this.ddd = ddd;
        this.numero = numero;
        this.email = email;
    }

    public Contatos(){

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

