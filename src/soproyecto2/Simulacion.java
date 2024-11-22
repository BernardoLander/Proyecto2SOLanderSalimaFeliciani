/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soproyecto2;

/**
 *
 * @author salima
 */
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simulacion extends Thread{
    
    private Company company1;
    private Company company2;
    private SO so;
    private AI ai;
    private Semaphore mutex;
    
    
    public Simulacion(Company company1, Company company2, SO so, AI ai){
        
        this.company1 = company1;
        this.company2 = company2;
        this.so = so;
        this.ai =  ai;
        this.mutex = new Semaphore(1);
    }
    
    @Override
    public void run(){
        //Creacion de personajes
        for (int i = 0; i < 20; i++) { //When the simulation is started, it generates the first 20 characters
            getCompany1().CreateCharacter();
            getCompany2().CreateCharacter();
        }
        
        
        while (true) {
            try {
                //Escogencia de primeros luchadores
                sleep(300); 
                getAi().getStatus().setText("Esperando");
                Character[] Brawlers= getSo().combatientes();
                System.out.println("Combatientes escogidos");
                getAi().starBattle(Brawlers[0], Brawlers[1]);
                
                getAi().getStatus().setText("Simulando Combate");
                getSo().getMutex().acquire();
                sleep(1000);
                getSo().actualizarColas();
                System.out.println("Colas actualizadas");
                getSo().getMutex().release();
                
                Nodo pAux = getCompany1().getPriority1().getpFirst();
                System.out.println("Prioridad 1: ");
                while (pAux != null){
                    System.out.println(pAux.getElemento().getName());
                    pAux = pAux.getpNext();
                }
                
                System.out.println("\n------------------------------------------\n");
                
                pAux = getCompany1().getPriority2().getpFirst();
                System.out.println("Prioridad 2: ");
                while (pAux != null){
                    System.out.println(pAux.getElemento().getName());
                    pAux = pAux.getpNext();
                }
                
                System.out.println("\n------------------------------------------\n");
                
                pAux = getCompany1().getPriority3().getpFirst();
                System.out.println("Prioridad 3: ");
                while (pAux != null){
                    System.out.println(pAux.getElemento().getName());
                    pAux = pAux.getpNext();
                }
                
                System.out.println("\n------------------------------------------\n");
                
                
                
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
            
        
        
    }

    /**
     * @return the company1
     */
    public Company getCompany1() {
        return company1;
    }

    /**
     * @param company1 the company1 to set
     */
    public void setCompany1(Company company1) {
        this.company1 = company1;
    }

    /**
     * @return the company2
     */
    public Company getCompany2() {
        return company2;
    }

    /**
     * @param company2 the company2 to set
     */
    public void setCompany2(Company company2) {
        this.company2 = company2;
    }

    /**
     * @return the so
     */
    public SO getSo() {
        return so;
    }

    /**
     * @param so the so to set
     */
    public void setSo(SO so) {
        this.so = so;
    }

    /**
     * @return the ai
     */
    public AI getAi() {
        return ai;
    }

    /**
     * @param ai the ai to set
     */
    public void setAi(AI ai) {
        this.ai = ai;
    }
}


