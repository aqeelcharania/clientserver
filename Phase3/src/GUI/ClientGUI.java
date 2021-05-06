package GUI;

import client.ChatClient;
import common.ChatIF;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;


public class ClientGUI extends javax.swing.JFrame implements ChatIF
{
    final public static String DEFAULT_HOST = "localhost";
    final public static int DEFAULT_PORT = 5555;
    ExtendedClient client;

    public ClientGUI() {
        initComponents();
        initHtmlDocument();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        hostTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        aqeel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTp = new javax.swing.JTextPane();
        connectBtn = new javax.swing.JButton();
        messageTf = new javax.swing.JTextField();
        sendBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimpleChatMLO Client");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setText("Host:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jLabel1, gridBagConstraints);

        hostTf.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        hostTf.setText(ClientGUI.DEFAULT_HOST);
        hostTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostTfActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(hostTf, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jLabel2, gridBagConstraints);

        portTf.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        portTf.setText(Integer.toString(ClientGUI.DEFAULT_PORT));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(portTf, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setText("Nickname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jLabel3, gridBagConstraints);

        aqeel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        aqeel.setText("Aqeel");
        aqeel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aqeelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(aqeel, gridBagConstraints);

        chatTp.setEditable(false);
        chatTp.setBorder(null);
        chatTp.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(chatTp);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        connectBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        connectBtn.setText("Connect");
        connectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(connectBtn, gridBagConstraints);

        messageTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                messageTfKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(messageTf, gridBagConstraints);

        sendBtn.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(sendBtn, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private static final Logger LOG = Logger.getLogger(ClientGUI.class.getName());

    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtnActionPerformed
        try 
        {
          client = new ExtendedClient(hostTf.getText(), Integer.valueOf(portTf.getText()), aqeel.getText().toString(), this);
          //send(String.format("!nick %s", nickTf.getText().toString()));
          this.connectBtn.setEnabled(false);
        } 
        catch(IOException exception) 
        {
          display("<b color='red'>Error: Can't setup connection! Please check the Host and Port and check again!<b>");
          this.connectBtn.setEnabled(true);//System.exit(1);
        }
    }//GEN-LAST:event_connectBtnActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        send();
    }//GEN-LAST:event_sendBtnActionPerformed

    private void messageTfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageTfKeyTyped
        if (evt.getKeyChar()=='\n')
	{
            send();
        }
    }//GEN-LAST:event_messageTfKeyTyped

    private void aqeelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aqeelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aqeelActionPerformed

    private void hostTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hostTfActionPerformed

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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClientGUI frame = new ClientGUI();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void send()
    {
        if (client.isConnected())
        {
            client.handleMessageFromClientUI(messageTf.getText());
            messageTf.setText("");
        }
    }
    
    public void send(String msg)
    {
        if (client.isConnected())
        {
            client.handleMessageFromClientUI(msg);
        }
    }
    
    public void initHtmlDocument()
    {
        HTMLDocument htmlDoc = (HTMLDocument) chatTp.getDocument();
        Element[] roots = htmlDoc.getRootElements(); // #0 is the HTML element, #1 the bidi-root
        Element body = null;
        for( int i = 0; i < roots[0].getElementCount(); i++ ) {
            Element element = roots[0].getElement( i );
            if( element.getAttributes().getAttribute( StyleConstants.NameAttribute ) == HTML.Tag.BODY ) {
                body = element;
                break;
            }
        }
        try
        {
            htmlDoc.insertAfterEnd( body, "<div></div>" );
        }
        catch (BadLocationException | IOException e)
        {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    /**
     * Implementation of ChatIF Interface.
     * @param message The message that the user wishes to send to the server.
     */
    @Override
    public void display(String message)
    {
        HTMLDocument htmlDoc = (HTMLDocument) chatTp.getDocument();
        String content = "<div>" + message + "</div>";

        Element[] roots = htmlDoc.getRootElements(); // #0 is the HTML element, #1 the bidi-root
        Element body = null;
        for( int i = 0; i < roots[0].getElementCount(); i++ ) {
            Element element = roots[0].getElement( i );
            if( element.getAttributes().getAttribute( StyleConstants.NameAttribute ) == HTML.Tag.DIV )
            {
                body = element;
                break;
            }
        }
        try
        {
                htmlDoc.insertBeforeEnd( body, content );
        }
        catch (BadLocationException | IOException e)
        {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        chatTp.setCaretPosition(chatTp.getDocument().getLength());


    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aqeel;
    private javax.swing.JTextPane chatTp;
    private javax.swing.JButton connectBtn;
    private javax.swing.JTextField hostTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageTf;
    private javax.swing.JTextField portTf;
    private javax.swing.JButton sendBtn;
    // End of variables declaration//GEN-END:variables
}
