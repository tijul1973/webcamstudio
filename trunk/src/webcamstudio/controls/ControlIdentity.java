/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ControlShapes.java
 *
 * Created on 2010-01-12, 23:53:15
 */
package webcamstudio.controls;

import webcamstudio.components.SourceListener;
import webcamstudio.sources.VideoSource;

/**
 *
 * @author pballeux
 */
public class ControlIdentity extends javax.swing.JPanel implements Controls {

    private VideoSource source = null;
    private String label = "Identity";
    private SourceListener listener = null;

    /** Creates new form ControlShapes */
    public ControlIdentity(VideoSource source) {
        initComponents();
        this.source = source;
        txtName.setText(source.getName());
        lblWarning.setVisible(false);
        btnApply.setEnabled(!alreadyExists(source.getLocation()));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio.Languages");
        label = bundle.getString("IDENTITY");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnApply = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        jLabel1.setText(bundle.getString("NAME")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txtName.setText("jTextField1");
        txtName.setName("txtName"); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });

        btnApply.setText(bundle.getString("APPLY")); // NOI18N
        btnApply.setName("btnApply"); // NOI18N
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        lblWarning.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblWarning.setForeground(java.awt.Color.red);
        lblWarning.setText(bundle.getString("IDENTITY_ALREADY_TAKEN")); // NOI18N
        lblWarning.setName("lblWarning"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApply)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApply)
                    .addComponent(lblWarning))
                .addContainerGap(230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        btnApply.setEnabled(true);
        if (txtName.getText() != null) {
            if (!alreadyExists(txtName.getText())) {
                btnApply.doClick();
            } else {
                btnApply.setEnabled(false);
            }
        }
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        VideoSource.loadedSources.remove(source.getLocation());
        source.setName(txtName.getText());
        source.setLocation(txtName.getText());
        VideoSource.loadedSources.put(source.getName(), source);
        if (listener != null) {
            listener.sourceUpdate(source);
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        btnApply.setEnabled(!alreadyExists(txtName.getText()));
    }//GEN-LAST:event_txtNameFocusLost

    private boolean alreadyExists(String name) {
        boolean retValue = false;
        if (name!=null){
        retValue = VideoSource.loadedSources.containsKey(name);
        lblWarning.setVisible(false);
        if (retValue) {
            if (!source.equals(VideoSource.loadedSources.get(name))) {
                retValue = true;
            } else {
                retValue = false;
            }
        }
        lblWarning.setVisible(retValue);
        }
        return retValue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void removeControl() {
        source = null;
    }

    @Override
    public void setListener(SourceListener l) {
        listener = l;
    }
}
