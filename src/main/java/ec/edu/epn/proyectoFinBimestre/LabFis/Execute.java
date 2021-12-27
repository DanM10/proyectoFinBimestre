package ec.edu.epn.proyectoFinBimestre.LabFis;

import java.util.ArrayList;

public class Execute {
    public static void main(String[] args) {
        System.out.println("==Admin Execute, first story 2 task");
        //Environment
        Administrador admin = new Administrador();
        ArrayList<Laboratorio> labs = new ArrayList<Laboratorio>();
        Credencial credencial = new Credencial("123","1230","123");
        labs.add(new Laboratorio("GAMMA"));
        for(int i =1;i<6;i++) {
            String aux1 = "GAMMA_"+i;
            String aux3 = "Codigo_Estudiante_"+i;
            String aux4 = "Estudiante_"+i;
            Estudiante auxEst = new Estudiante(aux3,aux4,"123");
            labs.get(0).getListComputadoras().add(new Computadora(aux1,8,credencial,auxEst,"Redes"));
        }
        admin.setLabs(labs);

        Computadora pc1 = admin.busquedaPorCodigo("GAMMA_2");
        System.out.println(pc1.toString());
        ArrayList<Computadora> pc2 = admin.busquedaPorMateria("Redes");
        System.out.println("Computadoras con la materia Redes: ");
        for(Computadora pc : pc2){
            System.out.println(pc.toString());
        }
        System.out.println(" ");
        Computadora pc3 = admin.busquedaPorCodigo("BETA_100");
        System.out.println(pc3+" Tiene que ser nulo");
        ArrayList<Computadora> pc4 = admin.busquedaPorMateria("Metodologias");
        System.out.println(pc4+ " Tiene que ser nulo");
    }
}
