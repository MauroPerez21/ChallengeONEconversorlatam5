package col.com.latam.alura.conversor;

public class Moneda {
	 
	    protected double value;
	    protected float dolarExchange;
	   // private double valorPresente;
	    Conversiones factor = new Conversiones();
	        public void getCoin(String coin){
	                switch(coin){
	                    case "dolar":
	                    	this.dolarExchange = 1;
	                        break;
	                    case "euro":
	                        this.dolarExchange = factor.getDolar()/factor.getEuro();
	                      
	                        break;
	                    case "francoSuizo":
	                    	this.dolarExchange = factor.getDolar()/factor.getFrancoSuizo();
	                    
	                        break;
	                    case "libra":
	                    	this.dolarExchange = factor.getDolar()/factor.getLibra();
	                      
	                        break;
	                    case "peso":
	                    	this.dolarExchange = factor.getDolar()/factor.getPeso();
	                   
	                        break;
	                    case "rupla":
	                    	this.dolarExchange = factor.getDolar()/factor.getRupla();
	                
	                        break;
	                    case "yen":
	                    	this.dolarExchange = factor.getDolar()/factor.getYen();
	                    
	                        break;
	                }
	              
	        }
	        public float dolarExchange(){
	        return (float) this.dolarExchange;
	        }
	       
	      
}
