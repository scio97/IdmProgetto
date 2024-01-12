package com.marcoarcarisi.demo.treno;
import com.marcoarcarisi.demo.treno.exception.*;

import java.util.ArrayList;

public class Treno {
	private ArrayList<Vagone> vagoni = new ArrayList<>();
	private String input;

	public Treno(String input) throws TrenoException {
		this.input = input;
		if (input.length() < 1) {
			throw new IllegalArgumentException("Input non valido per la creazione del treno.");
		} else if (input.charAt(0) != 'H') {
			throw new LocomotivaNonInTestaException(input);
		} else if (input.indexOf('R') != input.lastIndexOf('R')) {
			throw new TroppiRistorantiException(input);
		} else {
			Locomotiva locomitiva = new Locomotiva();
			vagoni.add(locomitiva);

				for(int i = 1; i < input.length(); ++i) {
					char tipoVagone = input.charAt(i);
					if(tipoVagone == 'H'){
						throw new MultipleLocomotiveException(input);
					}
					Vagone vagone = this.creaVagone(tipoVagone);
					vagoni.add(vagone);

				}

				if (this.pesoTotale() > locomitiva.getPesoTrainabile()) {
					throw new PesoEccessivoException(input);
				} else {
					boolean cargo = false;
					boolean passeggeri = false;
					boolean ristorante = false;

					for(int i = 0; i < input.length(); ++i) {
						if (input.charAt(i) == 'R') {
							ristorante = true;
						}

						if (input.charAt(i) == 'C' && passeggeri) {
							throw new IncompatibilitaCargoException(input);
						}

						if (input.charAt(i) == 'C') {
							cargo = true;
						}

						if (input.charAt(i) == 'P' && cargo) {
							throw new IncompatibilitaCargoException(input);
						}

						if (input.charAt(i) == 'P') {
							passeggeri = true;
						}
					}

					/*if (ristorante && input.charAt(input.length() / 2) != 'R') {
                    throw new PosizioneRistoranteException(input);
                }*/
				}
			}
		}

	public String getInput(){
		return this.input;
	}

	public ArrayList<Vagone> getVagoni() {
		return this.vagoni;
	}

	private Vagone creaVagone(char tipoVagone) {
		switch (tipoVagone) {
		case 'C':
			return new Cargo();
		case 'P':
			return new Passeggero();
		case 'R':
			return new Ristorante();
		default:
			throw new CarattereNonCompatibile(input);
		}
	}

	@Override
	public String toString() {
		return "Treno{" +
				"vagoni=" + vagoni +
				'}';
	}

	public double pesoTotale(){
		double peso=0;
		for(int i=0; i<vagoni.size();i++){
			peso+=vagoni.get(i).getPeso();
		}
		return peso;
	}

	public double lunghezzaTotale(){
		double lunghezza=0;
		for(int i=0; i<vagoni.size();i++){
			lunghezza+=vagoni.get(i).getLunghezza();
		}
		return lunghezza;
	}

	public double velocita() {
		return 300.0 - this.pesoTotale() / 200.0;
	}
}