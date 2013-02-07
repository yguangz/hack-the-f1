/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angryelectron.mapviewer;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.ListView;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//com.angryelectron.mapviewer//MapViewer//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "MapViewerTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "com.angryelectron.mapviewer.MapViewerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_MapViewerAction",
preferredID = "MapViewerTopComponent")
@Messages({
    "CTL_MapViewerAction=MapViewer",
    "CTL_MapViewerTopComponent=MapViewer Window",
    "HINT_MapViewerTopComponent=This is a MapViewer window"
})
public final class MapViewerTopComponent extends TopComponent implements ExplorerManager.Provider {

    private ExplorerManager mgr = new ExplorerManager();
    
    public MapViewerTopComponent() {
        initComponents();
        setName(Bundle.CTL_MapViewerTopComponent());
        setToolTipText(Bundle.HINT_MapViewerTopComponent());
        associateLookup(ExplorerUtils.createLookup(mgr, getActionMap()));        
        mgr.setRootContext(new F1MapNode());   

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new ListView();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        
    }

    @Override
    public void componentClosed() {
        
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
    public ExplorerManager getExplorerManager() {
        return mgr;
    }
}
