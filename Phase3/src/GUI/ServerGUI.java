package GUI;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ServerGUI extends javax.swing.JFrame {

    public ExtendedServer sv;
    
    public ServerGUI() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        portTf = new javax.swing.JTextField();
        connectBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientsList = new javax.swing.JList<>();
        testMsgBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimpleChatMLO Server");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel1, gridBagConstraints);

        portTf.setText("5555");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(portTf, gridBagConstraints);

        connectBtn.setBackground(new java.awt.Color(102, 255, 102));
        connectBtn.setText("Start Server");
        connectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(connectBtn, gridBagConstraints);

        jLabel2.setText("Clients:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel2, gridBagConstraints);

        clientsList.setModel(this.getClientList());
        jScrollPane1.setViewportView(clientsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        testMsgBtn.setText("Send Test Message to Clients");
        testMsgBtn.setEnabled(false);
        testMsgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testMsgBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(testMsgBtn, gridBagConstraints);

        refreshBtn.setText("Refresh Client List");
        refreshBtn.setEnabled(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        getContentPane().add(refreshBtn, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtnActionPerformed
        if (sv!=null)
        {
            if (sv.isListening())
            {
                try {
                    sv.close();
                } catch (IOException ex) {
                    Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                connectBtn.setText("Start Server");
                connectBtn.setBackground(Color.decode("#66ff66"));
                testMsgBtn.setEnabled(false);
                refreshBtn.setEnabled(false);
                return;
            }
        }
        
        int port = -1;
        try
        {
            port = Integer.valueOf(portTf.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Invalid Port number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        if (port == -1)
        {
            return;
        } 
        
        sv = new ExtendedServer(port);

        try 
        {
            sv.listen(); //Start listening for connections
            connectBtn.setBackground(Color.decode("#cc0000"));
            connectBtn.setText("Stop Server");
            testMsgBtn.setEnabled(true);
            refreshBtn.setEnabled(true);
            
        } 
        catch (Exception ex) 
        {
            System.out.println("ERROR - Could not listen for clients!");
        }
    }

    private void testMsgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testMsgBtnActionPerformed
        sv.sendServerTestMessage();
    }

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        clientsList.setModel(getClientList());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ServerGUI frame = new ServerGUI();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    public DefaultListModel getClientList()
    {
        /* Create model */        
        DefaultListModel<String> dlm = new DefaultListModel<>();

        try
        {
            
            String ul = sv.getUserList();
            String[] users = ul.split(("\n"));
            if (users.length == 0)
            {
                dlm.addElement("No Clients");
                return dlm;
            }
            else
            {
                for (String u : users)
                {
                    dlm.addElement(u);
                }
            }
            
        }
        catch (Exception e)
        {
            dlm.addElement("Server is not Listening for Clients...");
        }
        
        return dlm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> clientsList;
    private javax.swing.JButton connectBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField portTf;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton testMsgBtn;
    
}
