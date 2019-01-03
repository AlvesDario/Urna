package model;

public class Voto {
	public int numero;
	private Candidato deputadoFederal, deputadoEstadual, senador01, senador02, governador, presidente;
	private Eleitor eleitor;
	
	public void VOTAR(int NUMERO, Candidato DF, Candidato DE, Candidato S1, Candidato S2, Candidato G, Candidato P, Eleitor eleitor) {
		this.numero = NUMERO;
		this.deputadoFederal = DF;
		this.deputadoEstadual = DE;
		this.senador01 = S1;
		this.senador02 = S2;
		this.governador = G;
		this.presidente = P;
		this.eleitor = eleitor;
	}
	
	public void getVoto() {
		System.out.println();
	}
	
}
