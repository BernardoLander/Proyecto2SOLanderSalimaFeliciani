/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soproyecto2;

/**
 *
 * @author santi
 */
import static java.lang.Thread.sleep;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AI extends Thread {

    private Integer battleDuration;
    private Company swCompany;
    private Company stCompany;
    private Cola ganadores; //Cola provisional
    private Integer stWins;
    private Integer swWins;
    private Semaphore mutex;
    private JLabel[] SWLabels;
    private JLabel[] STLabels;
    public JLabel status;
    private JLabel[] Scorelabels;

    public AI(Integer battleDuration, Company swCompany, Company stCompany, Semaphore mutex) {

        this.battleDuration = battleDuration;
        this.swCompany = swCompany;
        this.stCompany = stCompany;
        this.stWins = 0;
        this.swWins = 0;
        this.mutex = mutex;
        this.ganadores = new Cola();

    }

    /*Character1 = Regular show, Character2 = StarTrek*/
    public void starBattle(Character character1, Character character2) throws InterruptedException {
        
        ActLabels();
        status.setText("Simulando Combate");
        
        Random random = new Random();
        int result = random.nextInt(101);

        try {
            sleep(this.getBattleDuration());
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Como los personajes seleccionados para la pelea estan al tope de la cola de prioridad 1,
        Se desencolan ambas colas de proridad 1 para extraer a los personajes de la cola de espera*/
        ActLabels();
        this.swCompany.getPriority1().desencolar();
        this.stCompany.getPriority1().desencolar();
        
        if (0 <= result && result <= 47) {

            System.out.println("Empieza la batalla entre: " + character1.getName() + " y " + character2.getName());

            Integer statsCharacter1 = character1.getAbility() + character1.getAgility() + character1.getStrength() + character1.getVitality();
            Integer statsCharacter2 = character2.getAbility() + character2.getAgility() + character2.getStrength() + character2.getVitality();

            /*El personaje que gane es encolado a la cola de ganadores 
            y el personaje que perdio no es encolado a ningun sitio (Se pierde el rastro de su nodo y de esa forma se elimina)*/
            if (Objects.equals(statsCharacter1, statsCharacter2)) {

                int finalBlow = random.nextInt(2);

                if (finalBlow == 0) {
                    System.out.println(character1.getName() + " logro acertar un golpe de gracia y se lleva la victoria");

                    this.swWins  ++;

                    this.ganadores.encolar(character1);

                } else {
                    System.out.println(character2.getName() + " logro acertar un golpe de gracia y se lleva la victoria");

                    this.stWins  ++;

                    this.ganadores.encolar(character2);
                }

            } else if (statsCharacter1 > statsCharacter2) {
                System.out.println(character1.getName() + " es el ganador");

                this.swWins ++;

                this.ganadores.encolar(character1);

            } else {
                System.out.println(character2.getName() + " es el ganador");

                this.stWins ++;

                this.ganadores.encolar(character2);

            }

        } else if (47 < result && result <= 67) {

            System.out.println("Empieza la batalla entre: " + character1.getName() + " y " + character2.getName());
            System.out.println("...");
            System.out.println("Ambos los luchadores no pueden continuar. La pelea termina en empate");

            //Ambos personajes vuelven a ser encolados en sus respectivas colas
            this.swCompany.getPriority1().encolar(character1);
            this.stCompany.getPriority1().encolar(character2);

        } else {
            System.out.println("Empieza la batalla entre: " + character1.getName() + " y " + character2.getName());
            System.out.println("Los partipantes no se enceuntran listos. La pelea se cancela");

            //Se encolan en la cola de refuerzos
            this.swCompany.getReinforcements().encolar(character1);
            this.stCompany.getReinforcements().encolar(character2);
        }

    }

    public void ActLabels() throws InterruptedException {
        
        status.setText("Anunciando resultados");
        sleep(300);
        getScorelabels()[0].setText(String.valueOf(getSwWins()));
        getScorelabels()[1].setText(String.valueOf(getStWins()));
        getSWLabels()[0].setText(getSwCompany().getPriority1().leerCabeza().getID());
        setImageLabel(getSWLabels()[1], getSwCompany().getPriority1().leerCabeza().getPath());
        getSWLabels()[2].setText(String.valueOf(getSwCompany().getPriority1().leerCabeza().getVitality()));
        getSWLabels()[3].setText(String.valueOf(getSwCompany().getPriority1().leerCabeza().getAbility()));
        getSWLabels()[4].setText(String.valueOf(getSwCompany().getPriority1().leerCabeza().getStrength()));
        getSWLabels()[5].setText(String.valueOf(getSwCompany().getPriority1().leerCabeza().getAbility()));
        
        getSTLabels()[0].setText(getStCompany().getPriority1().leerCabeza().getID());
        setImageLabel(getSTLabels()[1], getStCompany().getPriority1().leerCabeza().getPath());
        getSTLabels()[2].setText(String.valueOf(getStCompany().getPriority1().leerCabeza().getVitality()));
        getSTLabels()[3].setText(String.valueOf(getStCompany().getPriority1().leerCabeza().getAbility()));
        getSTLabels()[4].setText(String.valueOf(getStCompany().getPriority1().leerCabeza().getStrength()));
        getSTLabels()[5].setText(String.valueOf(getStCompany().getPriority1().leerCabeza().getAbility()));
    }

    public void setImageLabel(JLabel nombrelabel, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(nombrelabel.getWidth(), nombrelabel.getHeight(), nombrelabel.getWidth()));
        nombrelabel.setIcon(icon);
    }

    public Integer getBattleDuration() {
        return battleDuration;
    }

    public void setBattleDuration(Integer battleDuration) {
        this.battleDuration = battleDuration;
    }

    public Integer getStWins() {
        return stWins;
    }

    public void setStWins(Integer stWins) {
        this.stWins = stWins;
    }

    public Integer getSwWins() {
        return swWins;
    }

    public void setSwWins(Integer swWins) {
        this.swWins = swWins;
    }

    public Company getSwCompany() {
        return swCompany;
    }

    public void setSwCompany(Company swCompany) {
        this.swCompany = swCompany;
    }

    public Company getStCompany() {
        return stCompany;
    }

    public void setStCompany(Company stCompany) {
        this.stCompany = stCompany;
    }

    public Cola getGanadores() {
        return ganadores;
    }

    public void setGanadores(Cola ganadores) {
        this.ganadores = ganadores;
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param mutex the mutex to set
     */
    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    /**
     * @return the SWLabels
     */
    public JLabel[] getSWLabels() {
        return SWLabels;
    }

    /**
     * @param SWLabels the SWLabels to set
     */
    public void setSWLabels(JLabel[] SWLabels) {
        this.SWLabels = SWLabels;
    }

    /**
     * @return the STLabels
     */
    public JLabel[] getSTLabels() {
        return STLabels;
    }

    /**
     * @param STLabels the STLabels to set
     */
    public void setSTLabels(JLabel[] STLabels) {
        this.STLabels = STLabels;
    }

    public JLabel getStatus() {
        return status;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    /**
     * @return the Scorelabels
     */
    public JLabel[] getScorelabels() {
        return Scorelabels;
    }

    /**
     * @param Scorelabels the Scorelabels to set
     */
    public void setScorelabels(JLabel[] Scorelabels) {
        this.Scorelabels = Scorelabels;
    }
    
    

}
