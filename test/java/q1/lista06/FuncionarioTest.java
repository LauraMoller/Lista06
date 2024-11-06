/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package q1.lista06;

import java.text.DecimalFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author molle
 */
public class FuncionarioTest {

    private static Funcionario f;
    private static DecimalFormat df;

    @Test
    public void Teste1() {
        f = new Funcionario("Ana", 800);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.PRIMEIRA);
    }

    @Test
    public void Teste2() {
        f = new Funcionario("Ana", 850);
        assertEquals(f.calcularIrpf(), 0);
    }

    @Test
    public void Teste3() {
        f = new Funcionario("Ana", 1903.98);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.PRIMEIRA);
    }

    @Test
    public void Teste4() {
        f = new Funcionario("Ana", 1903.98);
        assertEquals(df.format(f.calcularIrpf()), "0.00");
    }

    @Test
    public void Teste5() {
        f = new Funcionario("Ana", 1903.99);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.SEGUNDA);
    }

    @Test
    public void Teste6() {
        f = new Funcionario("Ana", 1903.99);
        assertEquals(df.format(f.calcularIrpf()), "0.00");
    }    
    
    @Test
    public void Teste7() {
        f = new Funcionario("Ana", 2000);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.SEGUNDA);
    }    
    
    @Test
    public void Teste8() {
        f = new Funcionario("Ana", 2000);
        assertEquals(df.format(f.calcularIrpf()), "7.20");
    }   
    
    @Test
    public void Teste9() {
        f = new Funcionario("Ana", 2826.65);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.SEGUNDA);
    }     
    
    @Test
    public void Teste10() {
        f = new Funcionario("Ana", 2826.65);
        assertEquals(df.format(f.calcularIrpf()), "69.20");
    } 

    @Test
    public void Teste11() {
        f = new Funcionario("Ana", 2826.66);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.TERCEIRA);
    }       
    
    @Test
    public void Teste12() {
        f = new Funcionario("Ana", 2826.66);
        assertEquals(df.format(f.calcularIrpf()), "69.90");
    } 
    
    @Test
    public void Teste13() {
        f = new Funcionario("Ana", 3000);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.TERCEIRA);
    } 
    
    @Test
    public void Teste14() {
        f = new Funcionario("Ana", 3000);
        assertEquals(df.format(f.calcularIrpf()), "95.90");
    }     

    @Test
    public void Teste15() {
        f = new Funcionario("Ana", 3751.05);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.TERCEIRA);
    }     
    
    @Test
    public void Teste16() {
        f = new Funcionario("Ana", 3751.05);
        assertEquals(df.format(f.calcularIrpf()), "207.86");
    }     
    
    @Test
    public void Teste17() {
        f = new Funcionario("Ana", 3751.06);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.QUARTA);
    }   
    
    @Test
    public void Teste18() {
        f = new Funcionario("Ana", 3751.06);
        assertEquals(df.format(f.calcularIrpf()), "207.86");
    }   

    @Test
    public void Teste19() {
        f = new Funcionario("Ana", 4000);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.QUARTA);
    }   
    
    @Test
    public void Teste20() {
        f = new Funcionario("Ana", 4000);
        assertEquals(df.format(f.calcularIrpf()), "263.87");
    }       

    @Test
    public void Teste21() {
        f = new Funcionario("Ana", 4664.68);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.QUARTA);
    }       
    
    @Test
    public void Teste22() {
        f = new Funcionario("Ana", 4664.68);
        assertEquals(df.format(f.calcularIrpf()), "413.42");
    } 
    
    @Test
    public void Teste23() {
        f = new Funcionario("Ana", 4664.69);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.QUINTA);
    }        
    
    @Test
    public void Teste24() {
        f = new Funcionario("Ana", 4664.69);
        assertEquals(df.format(f.calcularIrpf()), "413.42");
    }     
    
    @Test
    public void Teste25() {
        f = new Funcionario("Ana", 5000);
        assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.QUINTA);
    }     
    
    @Test
    public void Teste26() { //precisa ser public e void
        f.setSalario(5000); //intanciando a classe funcionário
        /*if(f.calcularIrpf() == 505.64){
            System.out.println("SIM");
        }*/
        assertEquals(df.format(f.calcularIrpf()), "505.64"); 
    }            
    
    @BeforeAll
    public static void setUpClass() { //ambos precisam ser declarados como atributos
        f = new Funcionario("Ana", 10); //Colocar um valor símbolico que será alterado no teste, serve apenas para passar nas exções
        df = new DecimalFormat("0.00");
    }
    
}
