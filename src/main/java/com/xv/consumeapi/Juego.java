package com.xv.consumeapi;

import java.util.Random;

public class Juego {
	  private int numeroAdivinar;
	  private Integer puntaje;
	  private boolean primerAcierto;

    public Juego() {
    	reiniciar();
    }

    public void reiniciar() {
        setPuntaje(0);
        setPrimerAcierto(false);
        generarNumeroAdivinar();
    }
    
    private void generarNumeroAdivinar() {
        Random random = new Random();
        numeroAdivinar = random.nextInt(10) + 1;
    }

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isPrimerAcierto() {
		return primerAcierto;
	}

	public void setPrimerAcierto(boolean primerAcierto) {
		this.primerAcierto = primerAcierto;
	}
	
	public void checkNum(Integer numeroRevisar) {
    	if(!primerAcierto && numeroRevisar == numeroAdivinar) {
    		puntaje += 100000;
    		primerAcierto = true;
    	}
    	else if(numeroRevisar == numeroAdivinar) {
    	}
    	else {
    		puntaje -= 10000;
    	}
    	generarNumeroAdivinar();
    }
    
    

}
