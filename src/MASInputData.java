/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsemasinputfiles;

/**
 *
 * @author amart
 */
public class MASInputData extends javax.swing.JFrame {

    /**
     * Creates new form MASInputData
     */
    public MASInputData() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        InputFilename = new javax.swing.JTextField();
        OutputFilename = new javax.swing.JTextField();
        NumPopulations = new javax.swing.JComboBox<>();
        NumAreas = new javax.swing.JComboBox<>();
        NumFleets = new javax.swing.JComboBox<>();
        NumIndices = new javax.swing.JComboBox<>();
        PopLabel = new javax.swing.JLabel();
        AreaLabel = new javax.swing.JLabel();
        FleetLabel = new javax.swing.JLabel();
        IndexLabel = new javax.swing.JLabel();
        InputFileButton = new javax.swing.JButton();
        OutputFileButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        TitleLabel = new javax.swing.JLabel();
        StartYearLabel = new javax.swing.JLabel();
        EndYearLabel = new javax.swing.JLabel();
        StartYear = new javax.swing.JTextField();
        EndYear = new javax.swing.JTextField();
        SeasonLabel = new javax.swing.JLabel();
        NumSeas = new javax.swing.JComboBox<>();
        SexLabel = new javax.swing.JLabel();
        SexToggleButton = new javax.swing.JToggleButton();
        FshLenBinLabel = new javax.swing.JLabel();
        FshAgeBinLabel = new javax.swing.JLabel();
        IdxLenBinLabel = new javax.swing.JLabel();
        IdxAgeBinLabel = new javax.swing.JLabel();
        NumFshLenBins = new javax.swing.JComboBox<>();
        NumFshAgeBins = new javax.swing.JComboBox<>();
        NumIdxLenBins = new javax.swing.JComboBox<>();
        NumIdxAgeBins = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        FshLenBinList = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        IdxLenBinList = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        FshAgeBinList = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        IdxAgeBinList = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MASFileGUI");

        InputFilename.setText("Input netCDF filename");

        OutputFilename.setText("Output netCDF filename");

        NumPopulations.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        NumAreas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7" }));

        NumFleets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        NumIndices.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));

        PopLabel.setText("Number of populations");

        AreaLabel.setText("Number of areas");

        FleetLabel.setText("Number of fleets");

        IndexLabel.setText("Number of surveys");

        InputFileButton.setText("Choose Input File");
        InputFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputFileButtonActionPerformed(evt);
            }
        });

        OutputFileButton.setText("Choose Output File");
        OutputFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputFileButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Save Output File");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CloseButton.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        CloseButton.setText("Exit");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        TitleLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        TitleLabel.setText("Model Observation Data Input");

        StartYearLabel.setText("Start year of data");

        EndYearLabel.setText("End year of data");

        StartYear.setText("Start year");
        StartYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartYearActionPerformed(evt);
            }
        });

        EndYear.setText("End year");

        SeasonLabel.setText("Number of seasons");

        NumSeas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        NumSeas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumSeasActionPerformed(evt);
            }
        });

        SexLabel.setText("Number of sexes");

        SexToggleButton.setText("One sex");
        SexToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexToggleButtonActionPerformed(evt);
            }
        });

        FshLenBinLabel.setText("Number of fishery length bins");

        FshAgeBinLabel.setText("Number of fishery age bins");

        IdxLenBinLabel.setText("Number of survey length bins");

        IdxAgeBinLabel.setText("Number of survey age bins");

        NumFshLenBins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2", "3", "4", "5", "6", "7" }));

        NumFshAgeBins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2", "3", "4", "5", "6", "7" }));

        NumIdxLenBins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2", "3", "4", "5", "6", "7" }));

        NumIdxAgeBins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2", "3", "4", "5", "6", "7" }));

        FshLenBinList.setColumns(20);
        FshLenBinList.setRows(5);
        jScrollPane1.setViewportView(FshLenBinList);

        IdxLenBinList.setColumns(20);
        IdxLenBinList.setRows(5);
        jScrollPane2.setViewportView(IdxLenBinList);

        FshAgeBinList.setColumns(20);
        FshAgeBinList.setRows(5);
        jScrollPane3.setViewportView(FshAgeBinList);

        IdxAgeBinList.setColumns(20);
        IdxAgeBinList.setRows(5);
        jScrollPane5.setViewportView(IdxAgeBinList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TitleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InputFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InputFileButton)))
                        .addGap(68, 68, 68)
                        .addComponent(OutputFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(OutputFileButton)
                                        .addGap(81, 81, 81)
                                        .addComponent(CloseButton))
                                    .addComponent(SaveButton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(IdxLenBinLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(NumIdxLenBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(IndexLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(NumIndices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(IdxAgeBinLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(NumIdxAgeBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(136, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(EndYearLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EndYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(StartYearLabel)
                                    .addGap(27, 27, 27)
                                    .addComponent(StartYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(SeasonLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NumSeas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(SexLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SexToggleButton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(AreaLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NumAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(PopLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(NumPopulations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(FleetLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NumFleets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(526, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(FshLenBinLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(NumFshLenBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(NumFshAgeBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FshAgeBinLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OutputFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputFileButton)
                    .addComponent(OutputFileButton)
                    .addComponent(CloseButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveButton)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumPopulations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PopLabel)
                            .addComponent(NumFleets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FleetLabel)
                            .addComponent(IndexLabel)
                            .addComponent(NumIndices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NumAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AreaLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(StartYearLabel)
                                    .addComponent(StartYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EndYearLabel)
                                    .addComponent(EndYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IdxLenBinLabel)
                                    .addComponent(NumIdxLenBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FshLenBinLabel)
                                .addComponent(NumFshLenBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SeasonLabel)
                            .addComponent(NumSeas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FshAgeBinLabel)
                            .addComponent(NumFshAgeBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdxAgeBinLabel)
                            .addComponent(NumIdxAgeBins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SexLabel)
                            .addComponent(SexToggleButton)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputFileButtonActionPerformed
        // handle input file picker button here
        if (evt.getSource() == InputFileButton)
        {
            int returnVal = FileChooser.showOpenDialog(this);
            
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION)
            {
                InputFilename.setText(FileChooser.getSelectedFile().getName());
            }
        }
    }//GEN-LAST:event_InputFileButtonActionPerformed

    private void OutputFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputFileButtonActionPerformed
        // handle input file picker button here
        if (evt.getSource() == OutputFileButton)
        {
            int returnVal = FileChooser.showOpenDialog(this);

            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION)
            {
                OutputFilename.setText(FileChooser.getSelectedFile().getName());
            }
        }
    }//GEN-LAST:event_OutputFileButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // handle save file button here
        if (evt.getSource() == SaveButton)
        {

        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        if (evt.getSource() == CloseButton)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void StartYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartYearActionPerformed

    private void NumSeasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumSeasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumSeasActionPerformed

    private void SexToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexToggleButtonActionPerformed
        // handle sex toggle button here
        if (evt.getSource() == SexToggleButton)
        {
            if (SexToggleButton.getText().equals("One sex"))
            {
                SexToggleButton.setText("Two sexes");
            }
            else
            {
                SexToggleButton.setText("One sex");
            }
        }
    }//GEN-LAST:event_SexToggleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MASInputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MASInputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MASInputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MASInputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MASInputData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AreaLabel;
    private javax.swing.JButton CloseButton;
    private javax.swing.JTextField EndYear;
    private javax.swing.JLabel EndYearLabel;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JLabel FleetLabel;
    private javax.swing.JLabel FshAgeBinLabel;
    private javax.swing.JTextArea FshAgeBinList;
    private javax.swing.JLabel FshLenBinLabel;
    private javax.swing.JTextArea FshLenBinList;
    private javax.swing.JLabel IdxAgeBinLabel;
    private javax.swing.JTextArea IdxAgeBinList;
    private javax.swing.JLabel IdxLenBinLabel;
    private javax.swing.JTextArea IdxLenBinList;
    private javax.swing.JLabel IndexLabel;
    private javax.swing.JButton InputFileButton;
    private javax.swing.JTextField InputFilename;
    private javax.swing.JComboBox<String> NumAreas;
    private javax.swing.JComboBox<String> NumFleets;
    private javax.swing.JComboBox<String> NumFshAgeBins;
    private javax.swing.JComboBox<String> NumFshLenBins;
    private javax.swing.JComboBox<String> NumIdxAgeBins;
    private javax.swing.JComboBox<String> NumIdxLenBins;
    private javax.swing.JComboBox<String> NumIndices;
    private javax.swing.JComboBox<String> NumPopulations;
    private javax.swing.JComboBox<String> NumSeas;
    private javax.swing.JButton OutputFileButton;
    private javax.swing.JTextField OutputFilename;
    private javax.swing.JLabel PopLabel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel SeasonLabel;
    private javax.swing.JLabel SexLabel;
    private javax.swing.JToggleButton SexToggleButton;
    private javax.swing.JTextField StartYear;
    private javax.swing.JLabel StartYearLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
