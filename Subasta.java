import java.util.ArrayList;
public class Subasta
{
    private ArrayList<Lote> lotes;
    private int numeroDeLotesSiguiente;
    public Subasta()
    {
        lotes=new ArrayList<Lote>();
        numeroDeLotesSiguiente=1;
    }
    
    public void ingresarLote(String descripcion){
        lotes.add(new Lote(numeroDeLotesSiguiente, descripcion));
        numeroDeLotesSiguiente++;
    }
    
    public void mostrarLotes(){
        for(Lote lote:lotes){
            System.out.println(lote.toString());
        }
    }
    
    public void ofertaPara(int numeroDeLote, Persona ofertante, long valor){
        Lote loteElegido=getLote(numeroDeLote);
        boolean exito=false;
        
        if(loteElegido!=null){
            exito=loteElegido.ofertarPara(new Oferta(ofertante, valor));
        }
        if(exito){
            System.out.println("La oferta para el lote No "+numeroDeLote+"resultó exitoso");
        }else{
            Oferta ofertaMaxima=loteElegido.getOfertaMaxima();
            System.out.println("El lote no "+numeroDeLote+" tiene una oferta de: "+ofertaMaxima.getMonto());
        }
    }
    
    public Lote getLote(int numeroDeLote){
        if((numeroDeLote>=1)&&(numeroDeLote<numeroDeLotesSiguiente)){
            Lote loteElegido=lotes.get(numeroDeLote-1);
            if(loteElegido.getNumero()!=numeroDeLote){
                System.out.println("Error interno: se retornó el lote Nº.: "+loteElegido.getNumero()+" en lugar de "+numeroDeLote);
            }
            return loteElegido;
        }else{
            System.out.println("El lote número: "+numeroDeLote+" no existe");
            return null;
        }
    }
    
    public void mostrarAdjudicados(){
        for(Lote lote:lotes){
            System.out.println(lote.mostrarGanador());
        }
    }
}
