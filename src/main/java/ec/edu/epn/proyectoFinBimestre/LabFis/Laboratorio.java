package ec.edu.epn.proyectoFinBimestre.LabFis;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String nombre;
    private ArrayList <Computadora> listaComputadoras;


    public Laboratorio(String nombre) {
        this.nombre = nombre;
        listaComputadoras = new ArrayList<Computadora>();
    }


    private  void addComputador(Computadora computadora) {
        listaComputadoras.add(computadora);
    }

    public List<Computadora> getListComputadoras() {
        return listaComputadoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Laboratorio [nombre=" + nombre + ", lab=" + listaComputadoras.toString() + "]";
    }
}
