/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soproyecto2;

/**
 *
 * @author lander
 */
import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SO extends Thread  {
    
    private Company Company1;
    private int Company1CharCounter;
    private Company Company2;
    private int Company2CharCounter;
    private int countCycle;
    private Semaphore mutex;
    
    private JLabel[] SWPriority1Labels;
    private JLabel[] SWPriority2Labels;
    private JLabel[] SWPriority3Labels;
    
    private JLabel[] STPriority1Labels;
    private JLabel[] STPriority2Labels;
    private JLabel[] STPriority3Labels;
    
    private JTextArea[] ReinforcementLabels;
    
    private JTextArea[] QueueAreas;
    
    
    public  SO(Company Company1 , Company Company2, Semaphore mutex){
        
        this.Company1 = Company1;
        this.Company2 = Company2;
        this.countCycle = 0;
        this.mutex = mutex;
        this.Company1CharCounter = 0;
        this.Company2CharCounter = 0;
    }
    
    public Character[] combatientes() throws InterruptedException{
        
        ActLabels();
        
        Character[] CharacteswArray = new Character[2];
        Character swCharacter = null;
        Character stCharacter = null;
        
        if(!Company1.getPriority1().esVacia()){
        
            swCharacter = getCompany1().getPriority1().leerCabeza();
        
        }else{
            
            if(!Company1.getPriority2().esVacia()){
                
                swCharacter = getCompany1().getPriority2().leerCabeza();
                getCompany1().getPriority2().desencolar();
                getCompany1().getPriority1().encolar(swCharacter);
            
            }else{
            
                if(!Company1.getPriority3().esVacia()){
                
                swCharacter = getCompany1().getPriority3().leerCabeza();
                    getCompany1().getPriority3().desencolar();
                    getCompany1().getPriority1().encolar(swCharacter);
                
                }else{
                    
                    if(!Company1.getReinforcements().esVacia()){
                
                        swCharacter = getCompany1().getReinforcements().leerCabeza();
                        getCompany1().getReinforcements().desencolar();
                        getCompany1().getPriority1().encolar(swCharacter);
                    
                }else{
                        
                        System.out.println("pNo hay mas luchadores disponibles");
                        return null;
                    }
                
                }
            
            }
        
        }
        
        
        
        if(!Company2.getPriority1().esVacia()){
        
            stCharacter = getCompany2().getPriority1().leerCabeza();
        
        }else{
            
            if(!Company2.getPriority2().esVacia()){
                
                stCharacter = getCompany2().getPriority2().leerCabeza();
                getCompany2().getPriority2().desencolar();
                getCompany2().getPriority1().encolar(stCharacter);
            
            }else{
            
                if(!Company2.getPriority3().esVacia()){
                
                stCharacter = getCompany2().getPriority3().leerCabeza();
                    getCompany2().getPriority3().desencolar();
                    getCompany2().getPriority1().encolar(stCharacter);
                
                }else{
                    
                    if(!Company2.getReinforcements().esVacia()){
                
                        stCharacter = getCompany2().getReinforcements().leerCabeza();
                        getCompany2().getReinforcements().desencolar();
                        getCompany2().getPriority1().encolar(stCharacter);
                    
                }else{
                        
                        System.out.println("pNo hay mas luchadores disponibles");
                        return null;
                    }
                
                }
            
            }
        
        }
        
        CharacteswArray[0] = swCharacter;
        CharacteswArray[1] = stCharacter;
        
        return CharacteswArray;
        
    }
    
    
    
    public void actualizarColas(){
        
        Nodo pAux;
        
        
        if(!Company1.getPriority1().esVacia()){
            pAux = getCompany1().getPriority1().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    pAux = pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority1().esVacia()){
            pAux = getCompany2().getPriority1().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    pAux = pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        
        
        if(!Company1.getPriority2().esVacia()){
            pAux = getCompany1().getPriority2().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany1().getPriority1().encolar(pAux.getElemento());
                    pAux = pAux.getpNext();
                    getCompany1().getPriority2().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority2().esVacia()){
            pAux = getCompany2().getPriority2().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany2().getPriority1().encolar(pAux.getElemento());
                    pAux = pAux.getpNext();
                    getCompany2().getPriority2().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        
        
        
        
        if(!Company1.getPriority3().esVacia()){
            pAux = getCompany1().getPriority3().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany1().getPriority2().encolar(pAux.getElemento());
                    pAux = pAux.getpNext();
                    getCompany1().getPriority3().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux= pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority3().esVacia()){
            pAux = getCompany2().getPriority3().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany2().getPriority2().encolar(pAux.getElemento());
                    pAux= pAux.getpNext();
                    getCompany2().getPriority3().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux= pAux.getpNext();
                }
            }
        }
        
        this.setCountCycle(getCountCycle()+1);
        
        if (getCountCycle() >= 2){
            
            if (Math.random() >= 0.2) {
                
                getCompany1().CreateCharacter();
                getCompany2().CreateCharacter();
            }
        }
        
        
        checkReinforcements(Company1);
        checkReinforcements(Company2);
       
        
       ActLabels();
    }
    
    public void checkReinforcements(Company company) {
        
        if (!company.getReinforcements().esVacia()) {
        
        Nodo pAux = company.getReinforcements().getpFirst();
        company.getReinforcements().desencolar();
        
        if (Math.random() >= 0.6) {
            company.getPriority1().encolar(pAux.getElemento());
        } else {
            company.getReinforcements().encolar(pAux.getElemento());
        }
        }
    }
    
    public void ActLabels(){
        
        Character[] previewSW1 = getCompany1().getPriority1().ObtenerCola();
        Character[] previewSW2 = getCompany1().getPriority2().ObtenerCola();
        Character[] previewSW3 = getCompany1().getPriority3().ObtenerCola();
        
        Character[] previewST1 = getCompany2().getPriority1().ObtenerCola();
        Character[] previewST2 = getCompany2().getPriority2().ObtenerCola();
        Character[] previewST3 = getCompany2().getPriority3().ObtenerCola();
        
        Refresh(previewSW1,getSWPriority1Labels());
        Refresh(previewSW2,getSWPriority2Labels());
        Refresh(previewSW3,getSWPriority3Labels());
        Refresh(previewST1,getSTPriority1Labels());
        Refresh(previewST2,getSTPriority2Labels());
        Refresh(previewST3,getSTPriority3Labels());
        
        getQueueAreas()[0].setText(Company1.getPriority1().ColaInformation());
        getQueueAreas()[1].setText(Company1.getPriority2().ColaInformation());
        getQueueAreas()[2].setText(Company1.getPriority3().ColaInformation());
        getQueueAreas()[3].setText(Company2.getPriority1().ColaInformation());
        getQueueAreas()[4].setText(Company2.getPriority2().ColaInformation());
        getQueueAreas()[5].setText(Company2.getPriority3().ColaInformation());
        
        getReinforcementLabels()[0].setText(Company1.getReinforcements().ColaInformation());
        getReinforcementLabels()[1].setText(Company2.getReinforcements().ColaInformation());
        
    }
    
    public void Refresh(Character[] preview, JLabel[] labels ) {
        
    int countLabel = 0;
    int countChar = 0;
    
    while (countChar < preview.length && countLabel < labels.length) {
        
        if (preview[countChar] != null) {
            setImageLabel(labels[countLabel], preview[countChar].getPath());
            labels[countLabel+1].setText(preview[countChar].getID()); 
        } else {
            setImageLabel(labels[countLabel], "src/resources/NA.png");
            labels[countLabel+1].setText("NA"); 
            
        }
        
        countChar++;
        countLabel += 2;
    }       
}

    
    public void setImageLabel(JLabel nombrelabel, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(nombrelabel.getWidth(), nombrelabel.getHeight(), nombrelabel.getWidth()));
        nombrelabel.setIcon(icon);
    }
    

    /**
     * @return the Company1
     */
    public Company getCompany1() {
        return Company1;
    }

    /**
     * @param Company1 the Company1 to set
     */
    public void setCompany1(Company Company1) {
        this.Company1 = Company1;
    }

    /**
     * @return the Company2
     */
    public Company getCompany2() {
        return Company2;
    }

    /**
     * @param Company2 the Company2 to set
     */
    public void setCompany2(Company Company2) {
        this.Company2 = Company2;
    }

    /**
     * @return the countCycle
     */
    public int getCountCycle() {
        return countCycle;
    }

    /**
     * @param countCycle the countCycle to set
     */
    public void setCountCycle(int countCycle) {
        this.countCycle = countCycle;
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
     * @return the Company1CharCounter
     */
    public int getCompany1CharCounter() {
        return Company1CharCounter;
    }

    /**
     * @param Company1CharCounter the Company1CharCounter to set
     */
    public void setCompany1CharCounter(int Company1CharCounter) {
        this.Company1CharCounter = Company1CharCounter;
    }

    /**
     * @return the Company2CharCounter
     */
    public int getCompany2CharCounter() {
        return Company2CharCounter;
    }

    /**
     * @param Company2CharCounter the Company2CharCounter to set
     */
    public void setCompany2CharCounter(int Company2CharCounter) {
        this.Company2CharCounter = Company2CharCounter;
    }

    /**
     * @return the SWPriority1Labels
     */
    public JLabel[] getSWPriority1Labels() {
        return SWPriority1Labels;
    }

    /**
     * @param SWPriority1Labels the SWPriority1Labels to set
     */
    public void setSWPriority1Labels(JLabel[] SWPriority1Labels) {
        this.SWPriority1Labels = SWPriority1Labels;
    }

    /**
     * @return the SWPriority2Labels
     */
    public JLabel[] getSWPriority2Labels() {
        return SWPriority2Labels;
    }

    /**
     * @param SWPriority2Labels the SWPriority2Labels to set
     */
    public void setSWPriority2Labels(JLabel[] SWPriority2Labels) {
        this.SWPriority2Labels = SWPriority2Labels;
    }

    /**
     * @return the SWPriority3Labels
     */
    public JLabel[] getSWPriority3Labels() {
        return SWPriority3Labels;
    }

    /**
     * @param SWPriority3Labels the SWPriority3Labels to set
     */
    public void setSWPriority3Labels(JLabel[] SWPriority3Labels) {
        this.SWPriority3Labels = SWPriority3Labels;
    }

    /**
     * @return the STPriority1Labels
     */
    public JLabel[] getSTPriority1Labels() {
        return STPriority1Labels;
    }

    /**
     * @param STPriority1Labels the STPriority1Labels to set
     */
    public void setSTPriority1Labels(JLabel[] STPriority1Labels) {
        this.STPriority1Labels = STPriority1Labels;
    }

    /**
     * @return the STPriority2Labels
     */
    public JLabel[] getSTPriority2Labels() {
        return STPriority2Labels;
    }

    /**
     * @param STPriority2Labels the STPriority2Labels to set
     */
    public void setSTPriority2Labels(JLabel[] STPriority2Labels) {
        this.STPriority2Labels = STPriority2Labels;
    }

    /**
     * @return the STPriority3Labels
     */
    public JLabel[] getSTPriority3Labels() {
        return STPriority3Labels;
    }

    /**
     * @param STPriority3Labels the STPriority3Labels to set
     */
    public void setSTPriority3Labels(JLabel[] STPriority3Labels) {
        this.STPriority3Labels = STPriority3Labels;
    }

    /**
     * @return the ReinforcementLabels
     */
    public JTextArea[] getReinforcementLabels() {
        return ReinforcementLabels;
    }

    /**
     * @param ReinforcementLabels the ReinforcementLabels to set
     */
    public void setReinforcementLabels(JTextArea[] ReinforcementLabels) {
        this.ReinforcementLabels = ReinforcementLabels;
    }

    /**
     * @return the QueueAreas
     */
    public JTextArea[] getQueueAreas() {
        return QueueAreas;
    }

    /**
     * @param QueueAreas the QueueAreas to set
     */
    public void setQueueAreas(JTextArea[] QueueAreas) {
        this.QueueAreas = QueueAreas;
    }
}

