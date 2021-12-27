package ec.edu.epn.proyectoFinBimestre.LabFis;

import junit.framework.TestCase;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;


public class AdministradorTest_B_Codigo {
    Administrador admin = new Administrador();
    @Before
    public void setUp(){
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
    }

    @Test
    public void given_List_Labs_when_buscarComputador_then_ok(){
        Computadora actual = admin.busquedaPorCodigo("GAMMA_2");
        String nombreExpected = "GAMMA_2";
        String nombreActual = actual.getCodigo();

        assertEquals(nombreExpected,nombreActual);
    }

    @Test
    public void given_CodigoComputadora_wrong_when_buscarComputadora_then_return_null_and_print_bad_lab(){
        Computadora actual = admin.busquedaPorCodigo("BETA_2");
        assertNull(actual);

    }

    @Test
    public void given_List_Labs_when_busquedaComputadorMateria_then_ok(){
        ArrayList<Computadora> computadorasActuales = admin.busquedaPorMateria("Redes");
        String materiaExpected = "GAMMA_1 GAMMA_2 GAMMA_3 GAMMA_4 GAMMA_5 ";
        String materiaActual = "";
        for (Computadora comp:computadorasActuales){
            materiaActual += comp.getCodigo()+" ";
        }

        assertEquals(materiaExpected, materiaActual);
    }

    @Test
    public void given_materiaComputadora_wrong_busquedaComputadoraMateria_then_return_null_and_print_wrong_materia(){
        ArrayList<Computadora> computadorasActuales = admin.busquedaPorMateria("BDD");
        assertNull(computadorasActuales);
    }
}