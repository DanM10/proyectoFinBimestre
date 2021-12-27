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
        String computadorasActuales = admin.busquedaPorMateria("Redes");
        String materiaExpected = "Redes";
        String materiaActual = computadorasActuales;
        assertEquals(materiaExpected, materiaActual);
    }

    @Test
    public void given_materiaComputadora_wrong_busquedaComputadoraMateria_then_return_null_and_print_wrong_materia(){
        String computadorasActuales = admin.busquedaPorMateria("BDD");
        assertNull(computadorasActuales);
    }

    @Test
    public void given_List_Labs_when_borrarComputadorCodigo_then_ok(){
        String computadoraEliminada = admin.borrarComputadoraCodigo("GAMMA_2");
        String resultadoExpected = "Computadora eliminada con exito";
        String resultadoActual = computadoraEliminada;

        assertEquals(resultadoExpected,resultadoActual);
    }

    @Test
    public void given_codigoComputador_wrong_when_quitarComputadorCodigo_then_return_null_and_print_bad_lab(){
        String computadorasActuales = admin.borrarComputadoraCodigo("BETA_9");

        assertNull(computadorasActuales);
    }

    @Test
    public void given_List_Labs_when_quitarComputadorEstudiante_then_ok(){
        String computadorEliminado = admin.borrarComputadoraEstudiante("Estudiante_1");
        String resultadoExpected = "Computador retirado con exito";
        String resultadoActual = computadorEliminado;

        assertEquals(resultadoExpected, resultadoActual);
    }

    @Test
    public void given_nombreEstudiante_wrong_when_quitarComputadorEstudiante_then_return_null_and_print_bad_estudiante(){
        String computadorEliminado = admin.borrarComputadoraEstudiante("Estudiante");
        assertNull(computadorEliminado);
    }
}