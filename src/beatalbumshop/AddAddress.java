package beatalbumshop;

import beatalbumshop.componment.MyButton;
import beatalbumshop.componment.MyDialog;
import beatalbumshop.componment.MyTextField;
import beatalbumshop.dao.Firebase;
import beatalbumshop.model.Customer;
import beatalbumshop.model.LoggedInUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.internal.NonNull;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddAddress extends javax.swing.JPanel {

    Customer cus = (Customer) LoggedInUser.getCurrentUser();

    private String oldAddressType;
    private String oldAddress;
    private String oldFullName;
    private String oldPhoneNumber;

    public void setOldAddressType(String oldAddressType) {
        this.oldAddressType = oldAddressType;
    }

    public void setOldAddress(String oldAddress) {
        this.oldAddress = oldAddress;
    }

    public void setOldFullName(String oldFullName) {
        this.oldFullName = oldFullName;
    }

    public void setOldPhoneNumber(String oldPhoneNumber) {
        this.oldPhoneNumber = oldPhoneNumber;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public MyTextField getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(MyTextField txtAddress) {
        this.txtAddress = txtAddress;
    }

    public MyTextField getTxtAddressType() {
        return txtAddressType;
    }

    public void setTxtAddressType(MyTextField txtAddressType) {
        this.txtAddressType = txtAddressType;
    }

    public MyTextField getTxtFullName() {
        return txtFullName;
    }

    public void setTxtFullName(MyTextField txtFullName) {
        this.txtFullName = txtFullName;
    }

    public MyTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public void setTxtPhoneNumber(MyTextField txtPhoneNumber) {
        this.txtPhoneNumber = txtPhoneNumber;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = (MyButton) btnSave;
    }

    /**
     * Creates new form AddAddress
     */
    public AddAddress() {
        initComponents();
        btnSave.setFont(new Font("Open Sans", 0, 16));
        btnSave.setBackground(new Color(0, 162, 47));
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    public void backToAccount() {
        JPanel pnlTabContent = (JPanel) getParent();
        CardLayout c = (CardLayout) pnlTabContent.getLayout();
        c.show(pnlTabContent, "account");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myLabel1 = new beatalbumshop.componment.MyLabel();
        txtAddressType = new beatalbumshop.componment.MyTextField();
        txtFullName = new beatalbumshop.componment.MyTextField();
        myLabel2 = new beatalbumshop.componment.MyLabel();
        txtAddress = new beatalbumshop.componment.MyTextField();
        myLabel3 = new beatalbumshop.componment.MyLabel();
        myLabel4 = new beatalbumshop.componment.MyLabel();
        txtPhoneNumber = new beatalbumshop.componment.MyTextField();
        btnSave = new beatalbumshop.componment.MyButton();
        lblTitle = new javax.swing.JLabel();
        btnClose = new beatalbumshop.componment.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        myLabel1.setText("Address Type:");

        txtAddressType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        myLabel2.setText("Full Name:");

        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        myLabel3.setText("Address:");

        myLabel4.setText("Phone Number:");

        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSave.setBackground(new java.awt.Color(0, 162, 47));
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 162, 47)));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Address");

        btnClose.setBackground(null);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beatalbumshop/resources/images/icons/back.png"))); // NOI18N
        btnClose.setPreferredSize(new java.awt.Dimension(70, 50));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAddressType, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String btnSaveText = btnSave.getText();
        System.out.println(btnSaveText);

        if (btnSaveText.equals("ADD")) {
            String newAddressType = txtAddressType.getText();
            String newAddress = txtAddress.getText();
            String newFullName = txtFullName.getText();
            String newPhoneNumber = txtPhoneNumber.getText();

            Map<String, Object> newAddressBookData = new HashMap<>();
            newAddressBookData.put("addressType", newAddressType);
            newAddressBookData.put("address", newAddress);
            newAddressBookData.put("fullName", newFullName);
            newAddressBookData.put("phoneNumber", newPhoneNumber);

            Firestore db = (Firestore) Firebase.getFirestore("beat-75a88");
            String id = String.valueOf(cus.getID());
            DocumentReference documentRef = db.collection("customers").document(id);
            documentRef.update("lAddressBook", FieldValue.arrayUnion(newAddressBookData));
            MyDialog.display(0, "Add Address Successfully");

            backToAccount();

        } else if (btnSaveText.equals("UPDATE")) {
            Map<String, Object> oldAddressBookData = new HashMap<>();
            oldAddressBookData.put("addressType", oldAddressType);
            oldAddressBookData.put("address", oldAddress);
            oldAddressBookData.put("fullName", oldFullName);
            oldAddressBookData.put("phoneNumber", oldPhoneNumber);

            Map<String, Object> newAddressBookData = new HashMap<>();
            String newAddressType = txtAddressType.getText();
            String newAddress = txtAddress.getText();
            String newFullName = txtFullName.getText();
            String newPhoneNumber = txtPhoneNumber.getText();

            newAddressBookData.put("addressType", newAddressType);
            newAddressBookData.put("address", newAddress);
            newAddressBookData.put("fullName", newFullName);
            newAddressBookData.put("phoneNumber", newPhoneNumber);

            // Thực hiện cập nhật dữ liệu
            if (oldAddressType.equals(newAddressType) && oldAddress.equals(newAddress) && oldFullName.equals(newFullName) && oldPhoneNumber.equals(newPhoneNumber)) {
                // Không có sự thay đổi trong dữ liệu
                MyDialog.display(0, "No changes in address data");
            } else {
                //Thực hiện cập nhật dữ liệu trong Firestore
                Firestore db = (Firestore) Firebase.getFirestore("beat-75a88");
                String id = String.valueOf(cus.getID());
                DocumentReference documentRef = db.collection("customers").document(id);

                documentRef.update("lAddressBook", FieldValue.arrayRemove(oldAddressBookData)); // Xóa dữ liệu cũ
                documentRef.update("lAddressBook", FieldValue.arrayUnion(newAddressBookData)); // Thêm dữ liệu mới

                MyDialog.display(0, "Update Address Successfully");
                backToAccount();
            }

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        backToAccount();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private beatalbumshop.componment.MyButton btnClose;
    private beatalbumshop.componment.MyButton btnSave;
    private javax.swing.JLabel lblTitle;
    private beatalbumshop.componment.MyLabel myLabel1;
    private beatalbumshop.componment.MyLabel myLabel2;
    private beatalbumshop.componment.MyLabel myLabel3;
    private beatalbumshop.componment.MyLabel myLabel4;
    private beatalbumshop.componment.MyTextField txtAddress;
    private beatalbumshop.componment.MyTextField txtAddressType;
    private beatalbumshop.componment.MyTextField txtFullName;
    private beatalbumshop.componment.MyTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
