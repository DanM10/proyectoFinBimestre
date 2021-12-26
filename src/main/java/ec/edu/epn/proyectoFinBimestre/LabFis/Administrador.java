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

    public String busquedaPorMateria(String materia) {
        String listaComputadora = "";
        Computadora computadora = null;
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
                        computadora=comp;
                        listaComputadora += computadora.getMateria();
                        break;
                    }
                }
            }
        }else {
            listaComputadora = null;
            System.out.println("Nombre de materia inexistente.");
        }

        return listaComputadora;
    }
}
