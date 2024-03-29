/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webcamstudio.components;

import java.awt.image.BufferedImage;
import webcamstudio.externals.FME;
import webcamstudio.streams.Stream;

/**
 *
 * @author karl
 */
public class FMESettings extends javax.swing.JFrame implements Stream.Listener {
    FME thisFME;
    /**
     * Creates new form FMESettings
     * @param fme
     */
    public FMESettings(FME fme) {
        initComponents();
        // for now we keep this not visible
        lblOW.setVisible(false);
        lblOH.setVisible(false);
        spinOutW.setVisible(false);
        spinOutH.setVisible(false);
        
        thisFME = fme;
        String shortName = "";
        String sourceName = thisFME.getName();
        System.out.println("sourceName: "+sourceName);
        if (sourceName.length() > 9) {
            shortName = sourceName.substring(0, 9)+" ...";
            System.out.println("shortName: "+shortName);
        } else {
            shortName = sourceName;
        }
        lblName.setText(shortName);
        textURL.setText(thisFME.getUrl());
        if (thisFME.getStream().equals("")) {
            textStream.setText("");
            textStream.setEnabled(false);
        } else {
            textStream.setText(thisFME.getStream());
        }
        if (thisFME.getVbitrate().equals("")) {
            spinVideoRate.setValue(0);
            spinVideoRate.setEnabled(false);
        } else {
            spinVideoRate.setValue(Integer.parseInt(thisFME.getVbitrate()));
        }
        if (thisFME.getWidth().equals("")) {
            spinOutW.setValue(0);
            spinOutW.setEnabled(false);
        } else {
            spinOutW.setValue(Integer.parseInt(thisFME.getWidth()));
        }
        if (thisFME.getHeight().equals("")) {
            spinOutH.setValue(0);
            spinOutH.setEnabled(false);
        } else {
            spinOutH.setValue(Integer.parseInt(thisFME.getHeight()));
        }
        if (thisFME.getAbitrate().equals("")) {
            spinAudioRate.setValue(0);
            spinAudioRate.setEnabled(false);
        } else {
            spinAudioRate.setValue(Integer.parseInt(thisFME.getAbitrate()));
        }
        if (thisFME.getMount().equals("")) {
            textMount.setText("");
            textMount.setEnabled(false);
        } else {
            textMount.setText(thisFME.getMount());
        }
        if (thisFME.getPassword().equals("")) {
            textPsw.setText("");
            textPsw.setEnabled(false);
        } else {
            textPsw.setText(thisFME.getPassword());
//            System.out.println("Password: "+thisFME.getPassword());
        }
        if (thisFME.getPort().equals("")) {
            spinPort.setValue(0);
            spinPort.setEnabled(false);
        } else {
            spinPort.setValue(Integer.parseInt(thisFME.getPort()));
        }
        if (thisFME.getKeyInt().equals("")) {
            spinKeyInt.setValue(0);
            spinKeyInt.setEnabled(false);
        } else {
            spinKeyInt.setValue(Integer.parseInt(thisFME.getKeyInt()));
        }
        chkHQMode.setSelected(thisFME.getStandard().equals("HQ"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        lblEncode = new javax.swing.JLabel();
        lblVideoRate = new javax.swing.JLabel();
        lblAudioRate = new javax.swing.JLabel();
        lblrtmpURL = new javax.swing.JLabel();
        lblURL = new javax.swing.JLabel();
        lblStream = new javax.swing.JLabel();
        textURL = new javax.swing.JTextField();
        textStream = new javax.swing.JTextField();
        spinVideoRate = new javax.swing.JSpinner();
        spinAudioRate = new javax.swing.JSpinner();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        lblMount = new javax.swing.JLabel();
        lblPsw = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblKeyInt = new javax.swing.JLabel();
        textMount = new javax.swing.JTextField();
        textPsw = new javax.swing.JPasswordField();
        spinPort = new javax.swing.JSpinner();
        spinKeyInt = new javax.swing.JSpinner();
        lblName = new javax.swing.JLabel();
        lblOW = new javax.swing.JLabel();
        lblOH = new javax.swing.JLabel();
        spinOutW = new javax.swing.JSpinner();
        spinOutH = new javax.swing.JSpinner();
        chkHQMode = new javax.swing.JCheckBox();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FME Settings");
        setResizable(false);

        lblEncode.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblEncode.setText("Encode:");

        lblVideoRate.setText("Video Data Rate:");

        lblAudioRate.setText("Audio Data Rate:");

        lblrtmpURL.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblrtmpURL.setText("RTMP Streaming Url:");

        lblURL.setText("URL:");

        lblStream.setText("Stream:");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        lblMount.setText("Mount:");

        lblPsw.setText("Password:");

        lblPort.setText("Port:");

        lblKeyInt.setText("KeyInt:");

        lblName.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblName.setText("FMEName");

        lblOW.setText("Out Width:");
        lblOW.setEnabled(false);

        lblOH.setText("Out Height:");
        lblOH.setEnabled(false);

        spinOutW.setEnabled(false);

        spinOutH.setEnabled(false);

        chkHQMode.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        chkHQMode.setForeground(new java.awt.Color(180, 1, 1));
        chkHQMode.setText("HQ Mode");
        chkHQMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHQModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblURL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textURL))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStream)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textStream))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMount))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPsw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPsw))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblKeyInt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinKeyInt))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblPort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinPort, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAudioRate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinAudioRate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVideoRate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinVideoRate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEncode)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblrtmpURL)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblOH)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spinOutH, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblOW)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinOutW, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(chkHQMode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(chkHQMode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblrtmpURL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblURL)
                    .addComponent(textURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStream)
                    .addComponent(textStream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEncode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVideoRate)
                    .addComponent(spinVideoRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOW)
                    .addComponent(spinOutW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAudioRate)
                    .addComponent(spinAudioRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinOutH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMount)
                    .addComponent(textMount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPsw)
                    .addComponent(textPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort)
                    .addComponent(spinPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKeyInt)
                    .addComponent(spinKeyInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (thisFME.getUrl().equals("")) {
            
        } else {
            thisFME.setUrl(textURL.getText());
        }
        
        if (thisFME.getStream().equals("")) {
            
        } else {
            thisFME.setStream(textStream.getText());
        }
        
        if (thisFME.getVbitrate().equals("")) {

        } else {
            thisFME.setVbitrate(Integer.toString(spinVideoRate.getValue().hashCode()));
        }
        
//        if (thisFME.getWidth().equals("")) {
//            
//        } else {
//            thisFME.setWidth(Integer.toString(spinOutW.getValue().hashCode()));
//        }
//        
//        if (thisFME.getHeight().equals("")) {
//            
//        } else {
//            thisFME.setHeight(Integer.toString(spinOutH.getValue().hashCode()));
//        }
        
        if (thisFME.getAbitrate().equals("")) {

        } else {
            thisFME.setAbitrate(Integer.toString(spinAudioRate.getValue().hashCode()));
        }
        
        if (thisFME.getMount().equals("")) {
            
        } else {
            thisFME.setMount(textMount.getText());
        }
        
        if (thisFME.getPassword().equals("")) {

        } else {
            char[] password = textPsw.getPassword();
            String psw = String.valueOf(password);
            thisFME.setPassword(psw);
//            System.out.println("Password: "+psw);
        }
        
        if (thisFME.getPort().equals("")) {

        } else {
            thisFME.setPort(Integer.toString(spinPort.getValue().hashCode()));
        }
        
        if (thisFME.getKeyInt().equals("")) {

        } else {
            thisFME.setKeyInt(Integer.toString(spinKeyInt.getValue().hashCode()));
        }
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void chkHQModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHQModeActionPerformed
        if (chkHQMode.isSelected()){
            thisFME.setStandard("HQ");
        } else {
            thisFME.setStandard("STD");
        }
    }//GEN-LAST:event_chkHQModeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox chkHQMode;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel lblAudioRate;
    private javax.swing.JLabel lblEncode;
    private javax.swing.JLabel lblKeyInt;
    private javax.swing.JLabel lblMount;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOH;
    private javax.swing.JLabel lblOW;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblPsw;
    private javax.swing.JLabel lblStream;
    private javax.swing.JLabel lblURL;
    private javax.swing.JLabel lblVideoRate;
    private javax.swing.JLabel lblrtmpURL;
    private javax.swing.JSpinner spinAudioRate;
    private javax.swing.JSpinner spinKeyInt;
    private javax.swing.JSpinner spinOutH;
    private javax.swing.JSpinner spinOutW;
    private javax.swing.JSpinner spinPort;
    private javax.swing.JSpinner spinVideoRate;
    private javax.swing.JTextField textMount;
    private javax.swing.JPasswordField textPsw;
    private javax.swing.JTextField textStream;
    private javax.swing.JTextField textURL;
    // End of variables declaration//GEN-END:variables

    @Override
    public void sourceUpdated(Stream stream) {
        // nothing here.
    }

    @Override
    public void updatePreview(BufferedImage image) {
        // nothing here.
    }
}
