package ec.edu.epn.proyectoFinBimestre.LabFis;

import java.util.ArrayList;
import java.util.List;

public class Administrador {

    ArrayList<Laboratorio> labs;


    public Computadora busquedaPorCodigo(String codigo_Comp) {
        Computadora computadora = null;
        for(Laboratorio n :labs ){
            List <Computadora> listaComputadoras = n.getListComputadoras();
            for(Computadora comp: listaComputadoras){
                if (comp.getCodigo().equals(codigo_Comp)){
                    computadora=comp;
                    break;
                }
            }
        }
        return computadora;
    }

    public void setLabs(ArrayList<Laboratorio> labs) {
        this.labs = labs;
    }
}
