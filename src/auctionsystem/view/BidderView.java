package auctionsystem.view;

import auctionsystem.RemoteAuctionHouse;
import auctionsystem.common.*;
import auctionsystem.settings.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.logging.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;


/**
 * Form to display an item to a user, and allow them to place bids.
 * Also allows a logged in user to list items.
 * @author Scott Henwood
 */
public class BidderView extends javax.swing.JFrame 
{
    private RemoteAuctionHouse house;
    private Person currentUser;
    //____________________________________________________________________
    public BidderView() 
    {
        initComponents();
        catComboBox.setVisible(false);
        accessRemoteAuctionHouse();
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void accessRemoteAuctionHouse()
    {
        int port = NetworkSettings.getSettingsClass().getPortNumber();
        try {
            String address = NetworkSettings.getSettingsClass().getAddress();
            Registry registry=LocateRegistry.getRegistry(address, port);
            house = (RemoteAuctionHouse) registry.lookup("AuctionHouse");
        } 
        catch (RemoteException | NotBoundException e) {}
    }
    // ------------------------ State controls ----------------------------
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void enterListerState()
    {
        bidPanel.setVisible(false);
        lblCurrentBid.setText("Reserve");
        searchButton.setEnabled(false);
        lookupButton.setEnabled(false);
        ListItemButton.setEnabled(true);
        catComboBox.setVisible(true);
        txtCategory.setVisible(false);
        lblTimeLeft.setVisible(false);
        lblItemState.setText("");
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void exitListerState()
    {
        bidPanel.setVisible(true);
        lblCurrentBid.setText("Current Bid value");
        searchButton.setEnabled(true);
        lookupButton.setEnabled(true);
        ListItemButton.setEnabled(false);
        catComboBox.setVisible(false);
        txtCategory.setVisible(true);
        lblTimeLeft.setVisible(true);
    }
    // ----------------------- showing items ------------------------------
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void displayItem(Item item)
    {
        txtItemId.setText(item.getId());
        txtItemName.setText(item.getName());
        txtCurrentBid.setText("$" + item.getCurrentBidValue());
        txtCategory.setText(item.getCategory());
        lblItemState.setText(item.getTimeLeft() );
        
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jMenuItem1 = new javax.swing.JMenuItem();
        lookupButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtItemId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        lblCurrentBid = new javax.swing.JLabel();
        txtCurrentBid = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        catComboBox = new javax.swing.JComboBox();
        txtCategory = new javax.swing.JTextField();
        lblTimeLeft = new javax.swing.JLabel();
        lblItemState = new javax.swing.JLabel();
        bidPanel = new javax.swing.JPanel();
        lblNextBidValue = new javax.swing.JLabel();
        txtNextBidValue = new javax.swing.JTextField();
        placeBidButton = new javax.swing.JButton();
        ListItemButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenu();
        listMenu = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lookupButton.setText("Look up item");
        lookupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookupButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Item id");

        txtItemId.setText("Item Id");
        txtItemId.setName("txtId"); // NOI18N

        jLabel2.setText("Item Name");

        txtItemName.setText("Item Name");
        txtItemName.setName("txtId"); // NOI18N
        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });

        lblCurrentBid.setText("Current Bid value");

        txtCurrentBid.setText("5");

        lblCategory.setText("Category");
        lblCategory.setName("Category"); // NOI18N

        catComboBox.setModel(new DefaultComboBoxModel(ItemValidator.getValidator().getValidCategories()));

        txtCategory.setText("category");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(catComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jLayeredPane1.setLayer(catComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtCategory, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblTimeLeft.setText("Time left");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblCurrentBid)
                    .addComponent(lblCategory)
                    .addComponent(lblTimeLeft))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtItemName, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtItemId)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCurrentBid)
                                .addGap(34, 34, 34)))
                        .addContainerGap())
                    .addComponent(jLayeredPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblItemState, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentBid)
                    .addComponent(txtCurrentBid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCategory)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimeLeft)
                    .addComponent(lblItemState))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        lblNextBidValue.setText("Your Bid");

        txtNextBidValue.setText("5");

        placeBidButton.setText("Place Bid");
        placeBidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeBidButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bidPanelLayout = new javax.swing.GroupLayout(bidPanel);
        bidPanel.setLayout(bidPanelLayout);
        bidPanelLayout.setHorizontalGroup(
            bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bidPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNextBidValue)
                .addGap(25, 25, 25)
                .addComponent(txtNextBidValue, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(placeBidButton)
                .addContainerGap())
        );
        bidPanelLayout.setVerticalGroup(
            bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bidPanelLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNextBidValue)
                    .addComponent(txtNextBidValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeBidButton))
                .addContainerGap())
        );

        ListItemButton.setText("Submit Listing");
        ListItemButton.setEnabled(false);
        ListItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListItemButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        loginMenu.setText("Login");
        loginMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(loginMenu);

        listMenu.setText("List Item");
        listMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(listMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bidPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ListItemButton)
                        .addGap(18, 18, 18)
                        .addComponent(lookupButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bidPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lookupButton)
                    .addComponent(searchButton)
                    .addComponent(ListItemButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // ----------------------- Event handlers -----------------------------
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void lookupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookupButtonActionPerformed
        try {
            Item item = house.view((txtItemId.getText()));
            if(item != null)
                displayItem(item);
            else
                JOptionPane.showMessageDialog(this,"Item not found");
        } catch (RemoteException ex) {
            Logger.getLogger(BidderView.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lookupButtonActionPerformed
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void placeBidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeBidButtonActionPerformed
        if(currentUser == null)
        {
            JOptionPane.showMessageDialog(this,"You must loggin first.");
            return;
        }
        float bidValue;
        try
        { // remove any dollor signs.
            bidValue = Float.parseFloat(txtNextBidValue.getText());
            house.bid(txtItemId.getText(), bidValue, currentUser);
        }
        catch(NumberFormatException e)
        {
            System.out.println(e);
        }
        catch (RemoteException ex) {
            Logger.getLogger(BidderView.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_placeBidButtonActionPerformed
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                SearchView view = new SearchView(house);

                frame.add(view);
                frame.pack();
                frame.repaint();
                frame.setVisible(true);
            }
        });
    }//GEN-LAST:event_searchButtonActionPerformed
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void loginMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMenuMouseClicked
        try 
        {
            Person person = UserLogin.loginUser(this);
            if (house.loginUser(person))
            {
                currentUser = person;
                JOptionPane.showMessageDialog(this,"User Logged in");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"User Invalid");
            }
            System.out.println(person);
        } catch (RemoteException ex) {
            Logger.getLogger(BidderView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginMenuMouseClicked
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed

    }//GEN-LAST:event_txtItemNameActionPerformed
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void listMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMenuMouseClicked
        enterListerState();
    }//GEN-LAST:event_listMenuMouseClicked
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void ListItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListItemButtonActionPerformed
        if(currentUser == null)
        {
            JOptionPane.showMessageDialog(this,"You must loggin first.");
            return;
        }
        try 
        {
            float reserve;
            reserve = Float.parseFloat(txtCurrentBid.getText());
            Item item = new Item(txtItemId.getText(), txtItemName.getText(),
                                 catComboBox.getSelectedItem().toString(), 
                                 currentUser.getHash(), reserve);
            house.listItem(item, currentUser);
            
            exitListerState();
            JOptionPane.showMessageDialog(this, "Item list successful.");
        } catch (RemoteException ex) {
            Logger.getLogger(BidderView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Item list failed.");
        }
    }//GEN-LAST:event_ListItemButtonActionPerformed
    //**********************************************************************
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
            java.util.logging.Logger.getLogger(BidderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BidderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BidderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BidderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BidderView().setVisible(true);
            }
        });
    }
    //____________________________________________________________________
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ListItemButton;
    protected javax.swing.JPanel bidPanel;
    private javax.swing.JComboBox catComboBox;
    private javax.swing.JButton jButton1;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JLabel lblCategory;
    protected javax.swing.JLabel lblCurrentBid;
    private javax.swing.JLabel lblItemState;
    private javax.swing.JLabel lblNextBidValue;
    private javax.swing.JLabel lblTimeLeft;
    private javax.swing.JMenu listMenu;
    private javax.swing.JMenu loginMenu;
    protected javax.swing.JButton lookupButton;
    private javax.swing.JButton placeBidButton;
    protected javax.swing.JButton searchButton;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtCurrentBid;
    private javax.swing.JTextField txtItemId;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtNextBidValue;
    // End of variables declaration//GEN-END:variables
}