/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soproyecto2;

/**
 *
 * @author santi
 */
public class Character {
    
    private String Name;
    private String Path;
    private String ID;
    private int Priority;
    private int priorityCounter;
    
    //Si son true, son de calidad
    private int AbilityQuality;
    private int VitalityQuality;
    private int StrengthQuality;
    private int AgilityQuality;
    
    //Valores de los atributos
    private int Ability;
    private int Vitality;
    private int Strength;
    private int Agility;

    public Character(String ID, String Name, String Path, int AbilityQuality, int VitalityQuality, int StrengthQuality, int AgilityQuality, int Ability, int Vitality, int Strength, int Agility) {
        this.Name = Name;
        this.Path = Path;
        this.ID = ID;
        this.priorityCounter = 0;
        this.AbilityQuality = AbilityQuality;
        this.VitalityQuality = VitalityQuality;
        this.StrengthQuality = StrengthQuality;
        this.AgilityQuality = AgilityQuality;
        this.Ability = Ability;
        this.Vitality = Vitality;
        this.Strength = Strength;
        this.Agility = Agility;
    }
    
    

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Path
     */
    public String getPath() {
        return Path;
    }

    /**
     * @param Path the Path to set
     */
    public void setPath(String Path) {
        this.Path = Path;
    }

    /**
     * @return the Priority
     */
    public int getPriority() {
        return Priority;
    }

    /**
     * @param Priority the Priority to set
     */
    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    /**
     * @return the AbilityQuality
     */
    public int getAbilityQuality() {
        return AbilityQuality;
    }

    /**
     * @param AbilityQuality the AbilityQuality to set
     */
    public void setAbilityQuality(int AbilityQuality) {
        this.AbilityQuality = AbilityQuality;
    }

    /**
     * @return the VitalityQuality
     */
    public int getVitalityQuality() {
        return VitalityQuality;
    }

    /**
     * @param VitalityQuality the VitalityQuality to set
     */
    public void setVitalityQuality(int VitalityQuality) {
        this.VitalityQuality = VitalityQuality;
    }

    /**
     * @return the StrengthQuality
     */
    public int getStrengthQuality() {
        return StrengthQuality;
    }

    /**
     * @param StrengthQuality the StrengthQuality to set
     */
    public void setStrengthQuality(int StrengthQuality) {
        this.StrengthQuality = StrengthQuality;
    }

    /**
     * @return the AgilityQuality
     */
    public int getAgilityQuality() {
        return AgilityQuality;
    }

    /**
     * @param AgilityQuality the AgilityQuality to set
     */
    public void setAgilityQuality(int AgilityQuality) {
        this.AgilityQuality = AgilityQuality;
    }

    /**
     * @return the Ability
     */
    public int getAbility() {
        return Ability;
    }

    /**
     * @param Ability the Ability to set
     */
    public void setAbility(int Ability) {
        this.Ability = Ability;
    }

    /**
     * @return the Vitality
     */
    public int getVitality() {
        return Vitality;
    }

    /**
     * @param Vitality the Vitality to set
     */
    public void setVitality(int Vitality) {
        this.Vitality = Vitality;
    }

    /**
     * @return the Strength
     */
    public int getStrength() {
        return Strength;
    }

    /**
     * @param Strength the Strength to set
     */
    public void setStrength(int Strength) {
        this.Strength = Strength;
    }

    /**
     * @return the Agility
     */
    public int getAgility() {
        return Agility;
    }

    /**
     * @param Agility the Agility to set
     */
    public void setAgility(int Agility) {
        this.Agility = Agility;
    }

    /**
     * @return the priorityCounter
     */
    public int getPriorityCounter() {
        return priorityCounter;
    }

    /**
     * @param priorityCounter the priorityCounter to set
     */
    public void setPriorityCounter(int priorityCounter) {
        this.priorityCounter = priorityCounter;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    
    
}

