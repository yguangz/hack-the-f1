/**
 * Femulator - MIDI Mapper and F1 Emulator control for Traktor
 * Copyright 2013, Andrew Bythell <abythell@ieee.org>
 * http://angryelectron.com/femulator
 *
 * Femulator is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * Femulator is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Femulator.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angryelectron.femulator.mapeditor;

import com.angryelectron.femulator.f1api.F1LearnMode;
import com.angryelectron.femulator.f1api.F1Service;
import com.angryelectron.femulator.f1api.F1Utils;
import com.angryelectron.libf1.F1Entry;
import com.angryelectron.libf1.F1Entry.Direction;
import java.awt.event.ItemEvent;
import java.util.Collection;
import javax.swing.DefaultComboBoxModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.StatusDisplayer;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//com.angryelectron.femulator.mapeditor//Editor//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "EditorTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "com.angryelectron.femulator.mapeditor.EditorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_EditorAction",
preferredID = "EditorTopComponent")
@Messages({
    "CTL_EditorAction=Editor",
    "CTL_EditorTopComponent=Editor Window",
    "HINT_EditorTopComponent=This is a Editor window"
})
public final class EditorTopComponent extends TopComponent implements LookupListener {

    private Result<F1Entry> result = null;
    private F1Entry currentEntry = null;
    private F1LearnMode learnMode = new F1LearnMode();
    private Result<F1Entry> learnResult = null;
    
    public EditorTopComponent() {
        initComponents();        
        setName(Bundle.CTL_EditorTopComponent());
        setToolTipText(Bundle.HINT_EditorTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);                        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        commandComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        channelTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        noteTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        f1ComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        directionComboBox = new javax.swing.JComboBox();
        learnButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setEnabled(false);

        mainPanel.setEnabled(false);

        nameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.nameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel2.text")); // NOI18N

        commandComboBox.setModel(new DefaultComboBoxModel(F1Utils.listMidiCommands()));
        commandComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.commandComboBox.toolTipText")); // NOI18N
        commandComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                commandComboBoxItemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel3.text")); // NOI18N

        channelTextField.setText(org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.channelTextField.text")); // NOI18N
        channelTextField.setToolTipText(org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.channelTextField.toolTipText")); // NOI18N
        channelTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                channelTextFieldKeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel4.text")); // NOI18N

        noteTextField.setText(org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.noteTextField.text")); // NOI18N
        noteTextField.setToolTipText(org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.noteTextField.toolTipText")); // NOI18N
        noteTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noteTextFieldKeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel5.text")); // NOI18N

        f1ComboBox.setModel(new DefaultComboBoxModel(F1Utils.listF1Controls()));
        f1ComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.f1ComboBox.toolTipText")); // NOI18N
        f1ComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                f1ComboBoxItemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.jLabel6.text")); // NOI18N

        directionComboBox.setModel(new DefaultComboBoxModel(Direction.values()));
        directionComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.directionComboBox.toolTipText")); // NOI18N
        directionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                directionComboBoxItemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(learnButton, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.learnButton.text")); // NOI18N
        learnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learnButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(saveButton, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.saveButton.text")); // NOI18N
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(EditorTopComponent.class, "EditorTopComponent.cancelButton.text")); // NOI18N
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(50, 50, 50)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(learnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(f1ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noteTextField)
                            .addComponent(channelTextField)
                            .addComponent(commandComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(directionComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nameLabel)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(nameLabel)
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(commandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(channelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(noteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(f1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(directionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(learnButton)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (currentEntry != null) {
            String command = commandComboBox.getSelectedItem().toString();
            Direction direction = (Direction) directionComboBox.getSelectedItem();
            String control = f1ComboBox.getSelectedItem().toString();
            Integer channel = Integer.parseInt(channelTextField.getText());
            Integer note = Integer.parseInt(noteTextField.getText());            
            currentEntry.setMidiCommandName(command);
            currentEntry.setChannel(channel);
            currentEntry.setNote(note);
            currentEntry.setControlName(control);
            currentEntry.setDirection(direction);  
            saveButton.setEnabled(false);
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void commandComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_commandComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            saveButton.setEnabled(true);
        }
    }//GEN-LAST:event_commandComboBoxItemStateChanged

    private void channelTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_channelTextFieldKeyTyped
        saveButton.setEnabled(true);
    }//GEN-LAST:event_channelTextFieldKeyTyped

    private void noteTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteTextFieldKeyTyped
        saveButton.setEnabled(true);
    }//GEN-LAST:event_noteTextFieldKeyTyped

    private void f1ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_f1ComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            saveButton.setEnabled(true);
        }
    }//GEN-LAST:event_f1ComboBoxItemStateChanged

    private void directionComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_directionComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            saveButton.setEnabled(true);
        }
    }//GEN-LAST:event_directionComboBoxItemStateChanged

    private void learnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_learnButtonActionPerformed
        F1Service f1 = F1Utils.getF1Service();
        try {
            /*
             * TODO: does this run on a separate thread, or does it block?
             * perhaps a dialog should prompt for a button press and give
             * the user the option to cancel...
             */
            learnMode.start(f1.getDevice().getDeviceName());
        } catch (Exception ex) {
            StatusDisplayer.getDefault().setStatusText(ex.getMessage());
        }
        saveButton.setEnabled(false);
        learnButton.setEnabled(false);
        cancelButton.setEnabled(true);
        StatusDisplayer.getDefault().setStatusText("Press any key on the " + f1.getDevice().getDeviceName());
    }//GEN-LAST:event_learnButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        saveButton.setEnabled(true);
        cancelButton.setEnabled(false);
        learnButton.setEnabled(true);
        learnMode.stop();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField channelTextField;
    private javax.swing.JComboBox commandComboBox;
    private javax.swing.JComboBox directionComboBox;
    private javax.swing.JComboBox f1ComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton learnButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField noteTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        result = WindowManager.getDefault().findTopComponent("MapTopComponent").getLookup().lookupResult(F1Entry.class);
        result.addLookupListener(this);

        learnResult = learnMode.getLookup().lookupResult(F1Entry.class);
        learnResult.addLookupListener(this);

        mainPanel.setVisible(false);
    }

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
        learnResult.removeLookupListener(this);
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public void resultChanged(LookupEvent ev) {      
        Collection<? extends F1Entry> allEntries = result.allInstances();
        if (!allEntries.isEmpty()) {
            F1Entry entry = allEntries.iterator().next();
            this.nameLabel.setText(entry.getName());
            this.commandComboBox.setSelectedItem(entry.getMidiCommandName());
            this.channelTextField.setText(entry.getChannel().toString());
            this.noteTextField.setText(entry.getNote().toString());
            this.f1ComboBox.setSelectedItem(entry.getControlName());
            this.directionComboBox.setSelectedItem(entry.getDirection());
            this.currentEntry = entry;
            mainPanel.setVisible(true);
            saveButton.setEnabled(false);
            currentEntry = entry;
        } else {
            mainPanel.setVisible(false);
            currentEntry = null;
        }
        
        Collection<? extends F1Entry> learnEntries = learnResult.allInstances();
        if (!learnEntries.isEmpty()) {
            saveButton.setEnabled(true);
            cancelButton.setEnabled(false);
            learnButton.setEnabled(true);     
            F1Entry entry = learnEntries.iterator().next();
            this.commandComboBox.setSelectedItem(entry.getMidiCommandName());
            this.channelTextField.setText(entry.getChannel().toString());
            this.noteTextField.setText(entry.getNote().toString());
            learnMode.stop();
        }
    }  
}
