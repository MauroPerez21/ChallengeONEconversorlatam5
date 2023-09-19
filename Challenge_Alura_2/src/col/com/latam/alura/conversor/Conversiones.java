package col.com.latam.alura.conversor;

import java.text.DecimalFormat;

public class Conversiones {
	DecimalFormat df = new DecimalFormat("#.00");
	private float dolar = 3950f;
	 private float euro = 4400f;
	    private float francoSuizo = 4600f;
	    private float libra = 5100f;
	    private float peso = 1f;
	    private float rupla = 44f;
	    private float yen = 29f;
	    public float getDolar (){
		    return this.dolar;
		    }
	    public float getEuro (){
	    return this.euro;
	    }
	     public float getFrancoSuizo (){
	    return this.francoSuizo;
	    }
	    public float getLibra (){
	    return this.libra;
	    }
	    public float getPeso (){    
	    return this.peso;
	    }
	    public float getRupla (){
	    return this.rupla;
	    }
	    public float getYen (){
	    return this.yen;
	    } 
	    
	    public float exchange() {
	    	return 3950;	
	    }
	      
	   
}
