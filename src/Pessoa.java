
public class Pessoa {
	private String rg, cpf, nome;
	private char sexo;
	
	public String getDados() {
		String dados = rg+"\n";
		dados+=cpf+"\n";
		dados+=nome+"\n";
		dados+=sexo;
		return dados;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSexo(char sexo) {
		if(String.valueOf(sexo).toUpperCase() == "M" || String.valueOf(sexo).toUpperCase() == "F")
			this.sexo = sexo;
		else
			System.out.println("Inválido");
	}
}
