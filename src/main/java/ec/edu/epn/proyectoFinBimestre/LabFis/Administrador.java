package ec.edu.epn.proyectoFinBimestre.LabFis;

import java.util.ArrayList;
import java.util.List;

public class Administrador {

    ArrayList<Laboratorio> labs;


    public Computadora busquedaPorCodigo(String codigo_Comp) {
        String[] nombre = codigo_Comp.split("_");
        Computadora computadora = null;
        boolean esValidoNombre = false;
        for(Laboratorio n:labs){
            if (n.getNombre().equals(nombre[0])){
                esValidoNombre=true;
            }
        }
        if (esValidoNombre){
            for(Laboratorio n :labs ){
                List <Computadora> listaComputadoras = n.getListComputadoras();
                for(Computadora comp: listaComputadoras){
                    if (comp.getCodigo().equals(codigo_Comp)){
                        computadora=comp;
                        break;
                    }
                }
            }
        }else {
            System.out.println("Nombre de laboratorio inexistente.");
        }
        return computadora;
    }

    public void setLabs(ArrayList<Laboratorio> labs) {
        this.labs = labs;
    }

    public  ArrayList<Computadora> busquedaPorMateria(String materia) {
        ArrayList<Computadora> list_comp = new ArrayList<Computadora>();
        boolean esValido = false;
        for(Laboratorio lab: labs){
            for(int i =0; i < labs.size();i++) {
                if (lab.getListComputadoras().get(i).getMateria().equalsIgnoreCase(materia)) {
                    esValido = true;
                }
            }
        }
        if (esValido){
            for(Laboratorio lab :labs ){
                List <Computadora> listaComputadoras = lab.getListComputadoras();
                for(Computadora comp: listaComputadoras){
                    if (comp.getMateria().equalsIgnoreCase(materia)){
                        list_comp.add(comp);
                    }
                }
            }
            return list_comp;
        }else {
            System.out.println("Nombre de materia inexistente.");
            return null;
        }
    }

    public String borrarComputadoraCodigo(String codigoCom) {
        String resultado = "";
        if(busquedaPorCodigo(codigoCom) != null){
            Computadora auxComputador = busquedaPorCodigo(codigoCom);
            auxComputador.setEstudiante(null);
            resultado = "Computadora eliminada con exito";
        } else{
            resultado = null;
        }
        return resultado;
    }

    public Computadora buscarComputadoraEstudiante(String nombreEstudiante){
        Computadora computadora = null;
        boolean esValidoNombre = false;
        for(Laboratorio aux:labs){
            for(int i=0; i < labs.size();i++) {
                if (aux.getListComputadoras().get(i).getEstudiante().getNombre().equalsIgnoreCase(nombreEstudiante)) {
                    esValidoNombre = true;
                }
            }
        }
        if (esValidoNombre){
            for(Laboratorio n :labs ){
                List <Computadora> listaComputadoras = n.getListComputadoras();
                for(Computadora comp: listaComputadoras){
                    if (comp.getEstudiante().getNombre().equals(nombreEstudiante)){
                        computadora=comp;
                        break;
                    }
                }
            }
        }else {
            System.out.println("Nombre de estudiante inexistente.");
        }
        return computadora;
    }

    public String borrarComputadoraEstudiante(String nombreEstudiante) {
        String resultado = "";
        if(buscarComputadoraEstudiante(nombreEstudiante) != null){
            Computadora aux = buscarComputadoraEstudiante(nombreEstudiante);
            aux.setEstudiante(null);
            resultado = "Computador retirado con exito";
        }else{
            resultado = null;
        }
        return resultado;
    }
}
