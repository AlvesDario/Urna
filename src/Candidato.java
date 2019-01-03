
public class Candidato extends Pessoa{
	public int numero;
	public Partido p = new Partido();
	public int cargo;
	public int votos;
	public String cargoToString() {
		String x = "";
		switch(cargo) {
		case 0:
			x = "Deputado Federal"; break;
		case 1:
			x = "Deputado Estadual"; break;
		case 2:
			x = "Senador - 1 vaga"; break;
		case 3:
			x = "Senador - 2 vaga"; break;
		case 4:
			x = "Governador"; break;
		case 5:
			x = "Presidente"; break;
		}
		return x;
	}
}
