/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import soproyecto2.AI;
import soproyecto2.Company;
import soproyecto2.SO;
import soproyecto2.Simulacion;

public class InterfazPrincipal extends javax.swing.JFrame {
    

    Semaphore mutex = new Semaphore(1);
    String SWNames[] = {"Luke", "DarthVader", "PrincessLeia", "HanSolo", "Yoda", "Obi-WanKenobi", "EmperorPalpatine", "Chewbacca", "R2-D2", "C-3PO", "Anakin", "Kylo", "Rey", "Boba","MaceWindu","Qui","Padne","Ahsoka","Lando","Conde","Jabba"};

    String SWPhotos[] = {"src/resources/LukeSkywalker.png", "src/resources/DarthVader.png", "src/resources/PrincessLeia.png", "src/resources/HanSolo.png", "src/resources/Yoda.png", "src/resources/Obi-WanKenobi.png", "src/resources/EmperorPalpatine.png", "src/resources/Chewbacca.png", "src/resources/R2-D2.png", "src/resources/C-3PO.png", "src/resources/anakin.png", "src/resources/Kylo.png", "src/resources/Rey.png","src/resources/Boba.png","src/resources/MaceWindu.png","src/resources/Qui.png","src/resources/Padme.png","src/resources/Ahsoka.png","src/resources/Lando.png","src/resources/Conde.png","src/resources/Jabba.png"};

    String STNames[] = {"CaptainJames", "Spocks", "DrBonesMcCoy", "CommOfficerUhura", "Hikaru", "Scotty", "Jean-Luc", "Data", "Worf", "Deanna", "William", "Benjamin", "CaptainJaneway", "7Of9", "Quark", "Geordi", "TPol", "Odo", "MirrorBeverlyCrusher", "Chakotay"};

    String STPhotos[] = {"src/resources/CaptainJames.png", "src/resources/Spocks.png", "src/resources/DrBonesMcCoy.png", "src/resources/CommOfficerUhura.png", "src/resources/Hikaru.png", "src/resources/Scotty.png", "src/resources/Jean-Luc.png", "src/resources/Data.png", "src/resources/Worf.png", "src/resources/Deanna.png", "src/resources/William.png", "src/resources/Benjamin.png", "src/resources/CaptainJaneway.png", "src/resources/7Of9.png", "src/resources/Quark.png", "src/resources/Geordi.png", "src/resources/TPol.png", "src/resources/Odo.png", "src/resources/MirrorBeverlyCrusher.png", "src/resources/Chakotay.png"};
    
    

    Company SWCompany = new Company('W', SWNames, SWPhotos);
    Company STCompany = new Company('T', STNames, STPhotos);

    AI ai = new AI(5000, SWCompany, STCompany, mutex );
    SO so = new SO(SWCompany, STCompany, mutex);
    

    Simulacion simulacion = new Simulacion(SWCompany, STCompany, so, ai);


    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
        
        setImageLabel(FondoLabel, "src/resources/spacefondo.png");
        
        TimeField.setText(String.valueOf(ai.getBattleDuration()/1000));
        JLabel[] AISWLabels = {SWIDLabel, SWFighterLabel, SWHPLabel, SWHabilityLabel, SWAtkLabel, SWAgilitylabel};
        JLabel[] AISTLabels = {STIDLabel, STFighterLabel, STHPLabel, STHabilityLabel, STATKLabel, STAgilityLabel};
        
        JLabel[] SWPriority1Labels = {SWpr1_1image, SWpr1_1ID,SWpr1_2image, SWpr1_2ID,SWpr1_3image, SWpr1_3ID,SWpr1_4image, SWpr1_4ID };
        JLabel[] SWPriority2Labels = {SWpr2_1image, SWpr2_1ID,SWpr2_2image, SWpr2_2ID,SWpr2_3image, SWpr2_3ID,SWpr2_4image, SWpr2_4ID };
        JLabel[] SWPriority3Labels = {SWpr3_1image, SWpr3_1ID,SWpr3_2image, SWpr3_2ID,SWpr3_3image, SWpr3_3ID,SWpr3_4image, SWpr3_4ID };
        
        JLabel[] STPriority1Labels = {STpr1_1image, STpr1_1ID,STpr1_3image, STpr1_2ID,STpr1_2image, STpr1_3ID,STpr1_4image, STpr1_4ID };
        JLabel[] STPriority2Labels = {STpr2_1image, STpr2_1ID,STpr2_2image, STpr2_2ID,STpr2_3image, STpr2_3ID,STpr2_4image, STpr2_4ID };
        JLabel[] STPriority3Labels = {STpr3_1image, STpr3_1ID,STpr3_2image, STpr3_2ID,STpr3_3image, STpr3_3ID,STpr3_4image, STpr3_4ID };
        
        
        JTextArea[] QueueLabels = {SWpr1,SWpr2,SWpr3,STpr1,STpr2,STpr3};
        
        JTextArea[] ReinforcementsLabels = {SWReinArea,STReinArea};
        
        JLabel[] ScoreLabels = {SWScore,STScore};
        
        ai.setScorelabels(ScoreLabels);
        
        
        so.setSWPriority1Labels(SWPriority1Labels);
        so.setSWPriority2Labels(SWPriority2Labels);
        so.setSWPriority3Labels(SWPriority3Labels);
        
        so.setSTPriority1Labels(STPriority1Labels);
        so.setSTPriority2Labels(STPriority2Labels);
        so.setSTPriority3Labels(STPriority3Labels);
        
        so.setQueueAreas(QueueLabels);
        
        so.setReinforcementLabels(ReinforcementsLabels);
        
        ai.setSWLabels(AISWLabels);
        ai.setSTLabels(AISTLabels);
        ai.setStatus(IAStatusLabel);
        ai.getStatus().setText("Iniciando");
        
        simulacion.start();
    }
    
    public void setImageLabel (JLabel nombrelabel, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(nombrelabel.getWidth(), nombrelabel.getHeight(), nombrelabel.getWidth()));
        nombrelabel.setIcon(icon);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SWFighterLabel = new javax.swing.JLabel();
        STFighterLabel = new javax.swing.JLabel();
        SWHPLabel = new javax.swing.JLabel();
        SWHabilityLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SWAtkLabel = new javax.swing.JLabel();
        SWAgilitylabel = new javax.swing.JLabel();
        STHPLabel = new javax.swing.JLabel();
        STHabilityLabel = new javax.swing.JLabel();
        STATKLabel = new javax.swing.JLabel();
        STAgilityLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SWIDLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        STIDLabel = new javax.swing.JLabel();
        SWpr1_4ID = new javax.swing.JLabel();
        SWpr1_4image = new javax.swing.JLabel();
        SWpr1_3ID = new javax.swing.JLabel();
        SWpr1_3image = new javax.swing.JLabel();
        SWpr1_2ID = new javax.swing.JLabel();
        SWpr1_2image = new javax.swing.JLabel();
        SWpr1_1ID = new javax.swing.JLabel();
        SWpr1_1image = new javax.swing.JLabel();
        SWReinforcements = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SWReinArea = new javax.swing.JTextArea();
        TimeField = new javax.swing.JTextField();
        TimeButton = new javax.swing.JButton();
        statusIA = new javax.swing.JLabel();
        IAStatusLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SWpr1 = new javax.swing.JTextArea();
        STReinforcements1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        STReinArea = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        SWScore = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        SWpr2_4ID = new javax.swing.JLabel();
        SWpr2_4image = new javax.swing.JLabel();
        SWpr2_3ID = new javax.swing.JLabel();
        SWpr2_3image = new javax.swing.JLabel();
        SWpr2_2ID = new javax.swing.JLabel();
        SWpr2_2image = new javax.swing.JLabel();
        SWpr2_1ID = new javax.swing.JLabel();
        SWpr2_1image = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        SWpr2 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        SWpr3_4ID = new javax.swing.JLabel();
        SWpr3_4image = new javax.swing.JLabel();
        SWpr3_3ID = new javax.swing.JLabel();
        SWpr3_3image = new javax.swing.JLabel();
        SWpr3_2ID = new javax.swing.JLabel();
        SWpr3_2image = new javax.swing.JLabel();
        SWpr3_1ID = new javax.swing.JLabel();
        SWpr3_1image = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        SWpr3 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        STpr1_4image = new javax.swing.JLabel();
        STpr1_1ID = new javax.swing.JLabel();
        STpr1_1image = new javax.swing.JLabel();
        STpr1_2ID = new javax.swing.JLabel();
        STpr1_2image = new javax.swing.JLabel();
        STpr1_3ID = new javax.swing.JLabel();
        STpr1_3image = new javax.swing.JLabel();
        STpr1_4ID = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        STpr1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        STScore = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        STpr2_1ID = new javax.swing.JLabel();
        STpr2_1image = new javax.swing.JLabel();
        STpr2_2ID = new javax.swing.JLabel();
        STpr2_2image = new javax.swing.JLabel();
        STpr2_3ID = new javax.swing.JLabel();
        STpr2_3image = new javax.swing.JLabel();
        STpr2_4ID = new javax.swing.JLabel();
        STpr2_4image = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        STpr2 = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        STpr3_1ID = new javax.swing.JLabel();
        STpr3_1image = new javax.swing.JLabel();
        STpr3_2ID = new javax.swing.JLabel();
        STpr3_2image = new javax.swing.JLabel();
        STpr3_3ID = new javax.swing.JLabel();
        STpr3_3image = new javax.swing.JLabel();
        STpr3_4ID = new javax.swing.JLabel();
        STpr3_4image = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        STpr3 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        FondoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(SWFighterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 150, 150));
        getContentPane().add(STFighterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 150, 150));

        SWHPLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWHPLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(SWHPLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 68, 40));

        SWHabilityLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWHabilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(SWHabilityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 68, 35));

        jLabel3.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado de la IA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, 35));

        SWAtkLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWAtkLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(SWAtkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 68, 35));

        SWAgilitylabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWAgilitylabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(SWAgilitylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 68, 35));

        STHPLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STHPLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(STHPLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 68, 35));

        STHabilityLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STHabilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(STHabilityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, 65, 40));

        STATKLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STATKLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(STATKLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 510, 65, 36));

        STAgilityLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STAgilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(STAgilityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 71, 35));

        jLabel9.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID : ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        SWIDLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        SWIDLabel.setText(" ");
        getContentPane().add(SWIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 50, -1));

        jLabel10.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID : ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        STIDLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        STIDLabel.setText(" ");
        getContentPane().add(STIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 40, -1));

        SWpr1_4ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr1_4ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr1_4ID.setText("ID: ");
        getContentPane().add(SWpr1_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 30, -1));
        getContentPane().add(SWpr1_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 50));

        SWpr1_3ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr1_3ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr1_3ID.setText("ID: ");
        getContentPane().add(SWpr1_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 30, -1));
        getContentPane().add(SWpr1_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 50, 50));

        SWpr1_2ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr1_2ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr1_2ID.setText("ID: ");
        getContentPane().add(SWpr1_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 30, -1));
        getContentPane().add(SWpr1_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 50, 50));

        SWpr1_1ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr1_1ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr1_1ID.setText("ID: ");
        getContentPane().add(SWpr1_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 30, -1));
        getContentPane().add(SWpr1_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 50, 50));

        SWReinforcements.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        SWReinforcements.setForeground(new java.awt.Color(255, 255, 255));
        SWReinforcements.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/RefuerzosOscuros.png"))); // NOI18N
        SWReinforcements.setText("REFUERZOS:");
        getContentPane().add(SWReinforcements, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 110, 40));

        SWReinArea.setBackground(new java.awt.Color(0, 0, 0));
        SWReinArea.setColumns(20);
        SWReinArea.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWReinArea.setForeground(new java.awt.Color(255, 255, 255));
        SWReinArea.setRows(5);
        jScrollPane1.setViewportView(SWReinArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 310, 30));

        TimeField.setBackground(new java.awt.Color(0, 0, 0));
        TimeField.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        TimeField.setForeground(new java.awt.Color(255, 255, 255));
        TimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeFieldActionPerformed(evt);
            }
        });
        getContentPane().add(TimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 620, 80, -1));

        TimeButton.setBackground(new java.awt.Color(0, 0, 0));
        TimeButton.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        TimeButton.setForeground(new java.awt.Color(255, 255, 255));
        TimeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Duracion.png"))); // NOI18N
        TimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(TimeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 610, 110, 40));
        getContentPane().add(statusIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 710, 160, -1));

        IAStatusLabel.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        IAStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        IAStatusLabel.setText("   ");
        getContentPane().add(IAStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 200, -1));

        SWpr1.setEditable(false);
        SWpr1.setBackground(new java.awt.Color(0, 0, 0));
        SWpr1.setColumns(20);
        SWpr1.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr1.setForeground(new java.awt.Color(255, 255, 255));
        SWpr1.setRows(5);
        SWpr1.setToolTipText("");
        jScrollPane3.setViewportView(SWpr1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 400, 50));

        STReinforcements1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        STReinforcements1.setForeground(new java.awt.Color(255, 255, 255));
        STReinforcements1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/RefuerzosOscuros.png"))); // NOI18N
        STReinforcements1.setText("REFUERZOS:");
        getContentPane().add(STReinforcements1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 600, 110, 40));

        STReinArea.setBackground(new java.awt.Color(0, 0, 0));
        STReinArea.setColumns(20);
        STReinArea.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STReinArea.setForeground(new java.awt.Color(255, 255, 255));
        STReinArea.setRows(5);
        jScrollPane4.setViewportView(STReinArea);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 630, 310, 30));

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/titulo.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        SWScore.setFont(new java.awt.Font("SimSun-ExtG", 1, 24)); // NOI18N
        SWScore.setForeground(new java.awt.Color(255, 255, 255));
        SWScore.setText(" ");
        getContentPane().add(SWScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 40, -1));

        jLabel21.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Prioridad2.png"))); // NOI18N
        jLabel21.setText("PRIORIDAD 2");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 110, -1));

        SWpr2_4ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr2_4ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr2_4ID.setText("ID: ");
        getContentPane().add(SWpr2_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 30, -1));
        getContentPane().add(SWpr2_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 50, 50));

        SWpr2_3ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr2_3ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr2_3ID.setText("ID: ");
        getContentPane().add(SWpr2_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 30, -1));
        getContentPane().add(SWpr2_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 50, 50));

        SWpr2_2ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr2_2ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr2_2ID.setText("ID: ");
        getContentPane().add(SWpr2_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 30, -1));
        getContentPane().add(SWpr2_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 50, 50));

        SWpr2_1ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr2_1ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr2_1ID.setText("ID: ");
        getContentPane().add(SWpr2_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 30, -1));
        getContentPane().add(SWpr2_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 50, 50));

        SWpr2.setEditable(false);
        SWpr2.setBackground(new java.awt.Color(0, 0, 0));
        SWpr2.setColumns(20);
        SWpr2.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr2.setForeground(new java.awt.Color(255, 255, 255));
        SWpr2.setRows(5);
        SWpr2.setToolTipText("");
        jScrollPane8.setViewportView(SWpr2);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 400, 50));

        jLabel23.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Prioridad3.png"))); // NOI18N
        jLabel23.setText("PRIORIDAD 3");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 110, -1));

        SWpr3_4ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr3_4ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr3_4ID.setText("ID: ");
        getContentPane().add(SWpr3_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 30, -1));
        getContentPane().add(SWpr3_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 50, 50));

        SWpr3_3ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr3_3ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr3_3ID.setText("ID: ");
        getContentPane().add(SWpr3_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 30, -1));
        getContentPane().add(SWpr3_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 50, 50));

        SWpr3_2ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr3_2ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr3_2ID.setText("ID: ");
        getContentPane().add(SWpr3_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 30, -1));
        getContentPane().add(SWpr3_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 50, 50));

        SWpr3_1ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr3_1ID.setForeground(new java.awt.Color(255, 255, 255));
        SWpr3_1ID.setText("ID: ");
        getContentPane().add(SWpr3_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 30, -1));
        getContentPane().add(SWpr3_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 50, 50));

        SWpr3.setEditable(false);
        SWpr3.setBackground(new java.awt.Color(0, 0, 0));
        SWpr3.setColumns(20);
        SWpr3.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        SWpr3.setForeground(new java.awt.Color(255, 255, 255));
        SWpr3.setRows(5);
        SWpr3.setToolTipText("");
        jScrollPane9.setViewportView(SWpr3);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 400, 50));

        jLabel25.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Prioridad1.png"))); // NOI18N
        jLabel25.setText("PRIORIDAD 1");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 70, 110, -1));
        getContentPane().add(STpr1_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 100, 50, 50));

        STpr1_1ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr1_1ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr1_1ID.setText("ID: ");
        getContentPane().add(STpr1_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 30, -1));
        getContentPane().add(STpr1_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 50, 50));

        STpr1_2ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr1_2ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr1_2ID.setText("ID: ");
        getContentPane().add(STpr1_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, 30, -1));
        getContentPane().add(STpr1_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 100, 50, 50));

        STpr1_3ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr1_3ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr1_3ID.setText("ID: ");
        getContentPane().add(STpr1_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 160, 30, -1));
        getContentPane().add(STpr1_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 100, 50, 50));

        STpr1_4ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr1_4ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr1_4ID.setText("ID: ");
        getContentPane().add(STpr1_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 160, 30, -1));

        STpr1.setEditable(false);
        STpr1.setBackground(new java.awt.Color(0, 0, 0));
        STpr1.setColumns(20);
        STpr1.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr1.setForeground(new java.awt.Color(255, 255, 255));
        STpr1.setRows(5);
        STpr1.setToolTipText("");
        jScrollPane12.setViewportView(STpr1);

        getContentPane().add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 400, 50));

        jLabel26.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Score.png"))); // NOI18N
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        STScore.setFont(new java.awt.Font("SimSun-ExtG", 1, 24)); // NOI18N
        STScore.setForeground(new java.awt.Color(255, 255, 255));
        STScore.setText(" ");
        getContentPane().add(STScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 40, -1));

        jLabel28.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Prioridad2.png"))); // NOI18N
        jLabel28.setText("PRIORIDAD 2");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 110, -1));

        STpr2_1ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr2_1ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr2_1ID.setText("ID: ");
        getContentPane().add(STpr2_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 30, -1));
        getContentPane().add(STpr2_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 290, 50, 50));

        STpr2_2ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr2_2ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr2_2ID.setText("ID: ");
        getContentPane().add(STpr2_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 340, 30, -1));
        getContentPane().add(STpr2_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 280, 50, 50));

        STpr2_3ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr2_3ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr2_3ID.setText("ID: ");
        getContentPane().add(STpr2_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 340, 30, -1));
        getContentPane().add(STpr2_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 280, 50, 50));

        STpr2_4ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr2_4ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr2_4ID.setText("ID: ");
        getContentPane().add(STpr2_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 340, 30, -1));
        getContentPane().add(STpr2_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 280, 50, 50));

        STpr2.setEditable(false);
        STpr2.setBackground(new java.awt.Color(0, 0, 0));
        STpr2.setColumns(20);
        STpr2.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr2.setForeground(new java.awt.Color(255, 255, 255));
        STpr2.setRows(5);
        STpr2.setToolTipText("");
        jScrollPane15.setViewportView(STpr2);

        getContentPane().add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 400, 50));

        jLabel30.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Prioridad3.png"))); // NOI18N
        jLabel30.setText("PRIORIDAD 3");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, 110, -1));

        STpr3_1ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr3_1ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr3_1ID.setText("ID: ");
        getContentPane().add(STpr3_1ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, 30, -1));
        getContentPane().add(STpr3_1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 50, 50));

        STpr3_2ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr3_2ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr3_2ID.setText("ID: ");
        getContentPane().add(STpr3_2ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 520, 30, -1));
        getContentPane().add(STpr3_2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 50, 50));

        STpr3_3ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr3_3ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr3_3ID.setText("ID: ");
        getContentPane().add(STpr3_3ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 520, 30, -1));
        getContentPane().add(STpr3_3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 460, 50, 50));

        STpr3_4ID.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr3_4ID.setForeground(new java.awt.Color(255, 255, 255));
        STpr3_4ID.setText("ID: ");
        getContentPane().add(STpr3_4ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 520, 30, -1));
        getContentPane().add(STpr3_4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 460, 50, 50));

        STpr3.setEditable(false);
        STpr3.setBackground(new java.awt.Color(0, 0, 0));
        STpr3.setColumns(20);
        STpr3.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        STpr3.setForeground(new java.awt.Color(255, 255, 255));
        STpr3.setRows(5);
        STpr3.setToolTipText("");
        jScrollPane16.setViewportView(STpr3);

        getContentPane().add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 540, 400, 50));

        jLabel13.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("HP: ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, 35));

        jLabel14.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Habilidad:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, 35));

        jLabel15.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ataque: ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, -1, 35));

        jLabel18.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Agilidad:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, -1, 35));

        jLabel19.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("HP: ");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, -1, 35));

        jLabel20.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Habilidad:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, -1, 35));

        jLabel22.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Ataque:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, -1, 35));

        jLabel24.setFont(new java.awt.Font("SimSun-ExtG", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Agilidad:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, -1, 35));

        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/prueba.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 460, -1));

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Prioridad1.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 110, -1));
        getContentPane().add(FondoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeFieldActionPerformed

    private void TimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeButtonActionPerformed
        // TODO add your handling code here:
        ai.setBattleDuration(Integer.parseInt(TimeField.getText())*1000);
        JOptionPane.showMessageDialog(this, "Duracion de Batalla Cambiada con Exito");
    }//GEN-LAST:event_TimeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoLabel;
    private javax.swing.JLabel IAStatusLabel;
    private javax.swing.JLabel STATKLabel;
    private javax.swing.JLabel STAgilityLabel;
    private javax.swing.JLabel STFighterLabel;
    private javax.swing.JLabel STHPLabel;
    private javax.swing.JLabel STHabilityLabel;
    private javax.swing.JLabel STIDLabel;
    private javax.swing.JTextArea STReinArea;
    private javax.swing.JLabel STReinforcements1;
    private javax.swing.JLabel STScore;
    private javax.swing.JTextArea STpr1;
    private javax.swing.JLabel STpr1_1ID;
    private javax.swing.JLabel STpr1_1image;
    private javax.swing.JLabel STpr1_2ID;
    private javax.swing.JLabel STpr1_2image;
    private javax.swing.JLabel STpr1_3ID;
    private javax.swing.JLabel STpr1_3image;
    private javax.swing.JLabel STpr1_4ID;
    private javax.swing.JLabel STpr1_4image;
    private javax.swing.JTextArea STpr2;
    private javax.swing.JLabel STpr2_1ID;
    private javax.swing.JLabel STpr2_1image;
    private javax.swing.JLabel STpr2_2ID;
    private javax.swing.JLabel STpr2_2image;
    private javax.swing.JLabel STpr2_3ID;
    private javax.swing.JLabel STpr2_3image;
    private javax.swing.JLabel STpr2_4ID;
    private javax.swing.JLabel STpr2_4image;
    private javax.swing.JTextArea STpr3;
    private javax.swing.JLabel STpr3_1ID;
    private javax.swing.JLabel STpr3_1image;
    private javax.swing.JLabel STpr3_2ID;
    private javax.swing.JLabel STpr3_2image;
    private javax.swing.JLabel STpr3_3ID;
    private javax.swing.JLabel STpr3_3image;
    private javax.swing.JLabel STpr3_4ID;
    private javax.swing.JLabel STpr3_4image;
    private javax.swing.JLabel SWAgilitylabel;
    private javax.swing.JLabel SWAtkLabel;
    private javax.swing.JLabel SWFighterLabel;
    private javax.swing.JLabel SWHPLabel;
    private javax.swing.JLabel SWHabilityLabel;
    private javax.swing.JLabel SWIDLabel;
    private javax.swing.JTextArea SWReinArea;
    private javax.swing.JLabel SWReinforcements;
    private javax.swing.JLabel SWScore;
    private javax.swing.JTextArea SWpr1;
    private javax.swing.JLabel SWpr1_1ID;
    private javax.swing.JLabel SWpr1_1image;
    private javax.swing.JLabel SWpr1_2ID;
    private javax.swing.JLabel SWpr1_2image;
    private javax.swing.JLabel SWpr1_3ID;
    private javax.swing.JLabel SWpr1_3image;
    private javax.swing.JLabel SWpr1_4ID;
    private javax.swing.JLabel SWpr1_4image;
    private javax.swing.JTextArea SWpr2;
    private javax.swing.JLabel SWpr2_1ID;
    private javax.swing.JLabel SWpr2_1image;
    private javax.swing.JLabel SWpr2_2ID;
    private javax.swing.JLabel SWpr2_2image;
    private javax.swing.JLabel SWpr2_3ID;
    private javax.swing.JLabel SWpr2_3image;
    private javax.swing.JLabel SWpr2_4ID;
    private javax.swing.JLabel SWpr2_4image;
    private javax.swing.JTextArea SWpr3;
    private javax.swing.JLabel SWpr3_1ID;
    private javax.swing.JLabel SWpr3_1image;
    private javax.swing.JLabel SWpr3_2ID;
    private javax.swing.JLabel SWpr3_2image;
    private javax.swing.JLabel SWpr3_3ID;
    private javax.swing.JLabel SWpr3_3image;
    private javax.swing.JLabel SWpr3_4ID;
    private javax.swing.JLabel SWpr3_4image;
    private javax.swing.JButton TimeButton;
    private javax.swing.JTextField TimeField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel statusIA;
    // End of variables declaration//GEN-END:variables
}
