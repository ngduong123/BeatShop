package beatalbumshop;

import beatalbumshop.componment.MyDialog;
import beatalbumshop.dao.UserDAO;
import beatalbumshop.dao.UserDAOImpl;
import beatalbumshop.model.User;
import beatalbumshop.utils.ClearComponent;
import beatalbumshop.utils.SendEmail;
import beatalbumshop.utils.TextHelper;
import beatalbumshop.utils.TimeHelper;
import beatalbumshop.utils.Validator;
import java.awt.Rectangle;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * The ManagementUser class handles the user management functionality within the Beat Album Shop application.
 * It provides methods for adding and updating user information, as well as setting user status to inactive.
 */
public class ManagementUser extends javax.swing.JPanel {

    ArrayList<User> lUser = new ArrayList<>(); //List User
    DefaultTableModel model;
    UserDAO userDAO = new UserDAOImpl();
    int index = -1;

    /**
     * Creates new form ManagementUser.
     */
    public ManagementUser() {
        initComponents();
        txtDateCreated.setEnabled(false);

        //table
        //tao model
        model = new DefaultTableModel();

        // Set the table model to the tblAlbum table
        tblUser.setModel(model);

        //disable table editing
        tblUser.setDefaultEditor(Object.class, null);

        //table header
        String[] colNames = {"User ID", "Email", "Password", "Date Created", "Role"};
        model.setColumnIdentifiers(colNames);

        //column width
        tblUser.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblUser.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblUser.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblUser.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblUser.getColumnModel().getColumn(3).setPreferredWidth(80);

        //table data
        fillToTable();

        tblUser.requestFocus();
    }

    
    
    /**
     * Clear the form by resetting the index and clearing the selection and components.
     */
    public void clearForm() {
        index = -1;
        tblUser.getSelectionModel().clearSelection(); //bo chon tren table
        ClearComponent.clear(lblUserID, txtEmail, txtPassword, txtDateCreated, rdoAdmin, rdoStaff, rdoStaff);
    }

    
    
    /**
     * Select a row in the table and show its details.
     * @param i The index of the row to be selected.
     */
    public void selectRow(int i) {
        if (i >= 0 && tblUser.getRowCount() > 0) {
            index = i;
            tblUser.setRowSelectionInterval(index, index);
            showDetail();
            //scroll toi dong duoc chon
            tblUser.scrollRectToVisible(new Rectangle(tblUser.getCellRect(index, 0, true)));
            
            if(tblUser.getValueAt(index, 2).toString().equals("")) {
                btnDelete.setText("Active");
            }
            else {
                btnDelete.setText("Inactive");
            }
        }
    }

    
    
    /**
     * Find the index of a user in the list based on its ID.
     * @param userID The ID of the user to find.
     * @return The index of the user in the list, or -1 if not found.
     */
    public Integer findUserIndex(long userID) {
        for (User user : lUser) {
            if ((user.getID() + "").equalsIgnoreCase(userID + "")) {
                return lUser.indexOf(user);
            }
        }
        return -1;
    }

    
    
    /**
     * Show the details of the selected user.
     */
    public void showDetail() {
        
        User user = new User();

        //lay ID trong cot dau tien cua hang duoc chon
        String id = tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString();

        //tim album co ID trong lAlbum
        user = lUser.get(findUserIndex(Integer.parseInt(id)));

        //do du lieu tu User user len form
        lblUserID.setText(user.getID() + "");
        txtEmail.setText(user.getEmail());
        txtPassword.setText(user.getPassword());
        txtDateCreated.setText(user.getDateCreated());
        long role = user.getRole();
        if (role == 0) {
            rdoStaff.setSelected(true);
        }
        else if (role == 1) {
            rdoAdmin.setSelected(true);
        }
        else {
            buttonGroup1.clearSelection();
        }

        //lblImage.setIcon(ImageResizing.ImageResizing("src/beatalbumshop/resources/images/users/" + user.getUsername() + ".png", lblImage.getWidth() - 1, lblImage.getHeight()));
    }

    
    
    /**
     * Fill data from the user list to the table.
     */
    public void fillToTable() {
        lUser = (ArrayList<User>) userDAO.getAll();

        model.setRowCount(0); //clear rows in the table
        
        //them tung dong vao
        if (lUser != null) {
            for (User user : lUser) {
                String role = "";
                if (user.getRole() == 0){
                    role = "Staff";
                }
                else if (user.getRole() == 1){
                    role = "Admin";
                }
                
                model.addRow(new Object[]{user.getID(), user.getEmail(), user.getPassword(), user.getDateCreated(), role});
            }
        }
    }
    
    
    
    /**
     * Checks if a user with the specified email already exists in the user list.
     *
     * @return {@code false} if a user with the same email exists, {@code true} otherwise.
     */
    public boolean checkUser() {
        if (lUser != null) {
            for (User user : lUser) {
                if (user.getEmail().equalsIgnoreCase(txtEmail.getText())) {
                    return false;
                }
            }
        }
        return true;
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlTabContent = new javax.swing.JPanel();
        rdoAdmin = new beatalbumshop.componment.MyRadioButton();
        rdoStaff = new beatalbumshop.componment.MyRadioButton();
        lblEmail = new beatalbumshop.componment.MyLabel();
        txtEmail = new beatalbumshop.componment.MyTextField();
        lblPassword = new beatalbumshop.componment.MyLabel();
        txtPassword = new beatalbumshop.componment.MyTextField();
        btnNew = new beatalbumshop.componment.MyButton();
        btnAdd = new beatalbumshop.componment.MyButton();
        btnUpdate = new beatalbumshop.componment.MyButton();
        btnDelete = new beatalbumshop.componment.MyButton();
        lblRole = new beatalbumshop.componment.MyLabel();
        lblDateCreated = new beatalbumshop.componment.MyLabel();
        txtDateCreated = new beatalbumshop.componment.MyTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new beatalbumshop.componment.MyTable();
        lblID2 = new beatalbumshop.componment.MyLabel();
        lblUserID = new beatalbumshop.componment.MyLabel();

        pnlTabContent.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(rdoAdmin);
        rdoAdmin.setText("Admin");
        rdoAdmin.setFocusPainted(false);

        buttonGroup1.add(rdoStaff);
        rdoStaff.setText("Staff");
        rdoStaff.setFocusPainted(false);

        lblEmail.setForeground(new java.awt.Color(80, 80, 80));
        lblEmail.setText("Email:");

        txtEmail.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        txtEmail.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtEmail.setNextFocusableComponent(txtPassword);

        lblPassword.setForeground(new java.awt.Color(80, 80, 80));
        lblPassword.setText("Password:");

        txtPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        txtPassword.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtPassword.setNextFocusableComponent(lblDateCreated);

        btnNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNew.setText("New");
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdd.setText("Add");
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnUpdate.setText("Update");
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(215, 46, 46));
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 46, 46)));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Inactive");
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblRole.setForeground(new java.awt.Color(80, 80, 80));
        lblRole.setText("Role:");

        lblDateCreated.setForeground(new java.awt.Color(80, 80, 80));
        lblDateCreated.setText("Date Created:");

        txtDateCreated.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        txtDateCreated.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUserMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        lblID2.setForeground(new java.awt.Color(80, 80, 80));
        lblID2.setText("ID");

        javax.swing.GroupLayout pnlTabContentLayout = new javax.swing.GroupLayout(pnlTabContent);
        pnlTabContent.setLayout(pnlTabContentLayout);
        pnlTabContentLayout.setHorizontalGroup(
            pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTabContentLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTabContentLayout.createSequentialGroup()
                        .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlTabContentLayout.createSequentialGroup()
                                    .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlTabContentLayout.createSequentialGroup()
                                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(32, 32, 32)))
                                    .addGap(44, 44, 44)
                                    .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                        .addComponent(lblUserID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(pnlTabContentLayout.createSequentialGroup()
                                    .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDateCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlTabContentLayout.createSequentialGroup()
                                            .addComponent(rdoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rdoStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtDateCreated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(lblID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(497, 497, 497)))
                .addGap(30, 30, 30))
        );
        pnlTabContentLayout.setVerticalGroup(
            pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabContentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateCreated, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String dateCreated = TimeHelper.getCurrentDateTime();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        int role = 0;
        if (rdoStaff.isSelected()) {
            role = 0;
        }
        else if (rdoAdmin.isSelected()) {
            role = 1;
        }

        //validate
        ArrayList<String> errors = new ArrayList<>();

        if (!rdoAdmin.isSelected() && !rdoStaff.isSelected()){
            errors.add("Vui lòng chọn Role\n");
        }
        errors.add((!Validator.isNotNull((JTextField) txtPassword, password)) ? "Vui lòng nhập Password\n" : "");
        errors.add((!Validator.isNotNull((JTextField) txtEmail, email)) ? "Vui lòng nhập Email\n" : "");
        
        if (!checkUser()) {
            errors.add("Email đã tồn tại\n");
        }
        
        Collections.reverse(errors);
        String e = "";
        for (String s : errors) e += s;

        //co loi
        if (!e.isEmpty()) {
            MyDialog.display(1, e);
            return;
        }

        //add
        //get max id
        int rowCount = tblUser.getRowCount();
        int max = 0;
        for (int i = 0; i < rowCount; i++) {
            Object value = tblUser.getValueAt(i, 0);
            if (Integer.parseInt(value.toString()) > max) {
                max = Integer.parseInt(value.toString());
            }
        }
        int id = max + 1;

        boolean result = userDAO.add(new User(role, id, email, password));

        if (result) {
            //them thanh cong
            fillToTable();
            selectRow(findUserIndex(id));
        } else {
            //them that bai
            MyDialog.display(1, "Có lỗi xảy ra.");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        int role = 0;
        if (rdoStaff.isSelected()) {
            role = 0;
        } else if (rdoAdmin.isSelected()) {
            role = 1;
        }

        //validate
        ArrayList<String> errors = new ArrayList<>();

        errors.add((!Validator.isNotNull((JTextField) txtEmail, email)) ? "Vui lòng nhập Email\n" : "");
        errors.add((!Validator.isNotNull((JTextField) txtPassword, password)) ? "Vui lòng nhập Password\n" : "");

        Collections.reverse(errors);
        
        String e = "";
        for (String s : errors) {
            e += s;
        }

        //co loi
        if (!e.isEmpty()) {
            MyDialog.display(1, e);
            return;
        }

        //update
        int id = Integer.parseInt(tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString());
        boolean result = userDAO.updateByID(new User(role, id, email, password));

        if (result) {
            //update thanh cong
            fillToTable();
            selectRow(findUserIndex(id));
        } else {
            //update that bai
            MyDialog.display(1, "Có lỗi xảy ra.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //delete
        if(tblUser.getSelectedRow() < 0) {
            MyDialog.display(1, "Vui lòng chọn dòng cần xóa");
            return;
        }
        String id = tblUser.getValueAt(tblUser.getSelectedRow(), 0).toString();
        long idU = Long.parseLong(id);
        User u = userDAO.getByID(idU);
        int otp = 0;
        String pass = "";
        
        int active = 0; //0:inactive    1:active
        if(btnDelete.getText().equalsIgnoreCase("inactive")) {
            u.setPassword(pass);
            btnDelete.setText("Active");
        }
        else if(btnDelete.getText().equalsIgnoreCase("active")) {
            otp = (int) (Math.random() * 900000) + 100000;
            pass = otp + "";
            u.setPassword(pass);
            btnDelete.setText("Inactive");
            active = 1;
        }
        
        boolean result = userDAO.updateByID(new User(u.getRole(), u.getID(), u.getEmail(), pass));

        if (result) {
            //update thanh cong
            fillToTable();
            selectRow(findUserIndex(idU));
            
            String subject = "";
            String recipient = "";
            String content = "";
            
            if(active == 0) {
                // send email order has been changed
                subject = "YOUR EMAIL " + u.getEmail() + " HAS BEEN INACTIVE";
                recipient = u.getEmail();

                content = "" +
                    "<p>Dear " + u.getEmail() + ",</p>\n" +
                    "<p>We hope this email finds you well. We would like to inform you that your account with us has been inactive for an extended period of time. We value your participation and want to ensure that you have the opportunity to continue enjoying our services.</p> <br>\n" +
                    "<p>To reactivate your account, we kindly request you to contact our Client service team. They will guide you through the reactivation process and assist you with any queries or concerns you may have.</p> <br>\n";
            }
            else if(active == 1) {
                // send email order has been changed
                subject = "YOUR EMAIL " + u.getEmail() + " HAS BEEN ACTIVE";
                recipient = u.getEmail();

                content = "" +
                    "<p>Dear " + u.getEmail() + ",</p>\n" +
                    "<p>We are pleased to inform you that your account with us has been successfully reactivated. We appreciate your prompt action and are delighted to have you back as an active member of our community.</p> <br>\n" +
                    "<p>As a part of the reactivation process, we have generated a new password for your account. Please find your new password below:</p> <br>\n" +
                    "<br><br>\n" +
                    "<h2>" + otp + "</h2>\n";
            }

            boolean sendStatus = SendEmail.sendOrderStatusEmail(recipient, recipient, subject, content); 
            if(!sendStatus) {
                MyDialog.display(1, "Có lỗi trong quá trình gửi Email");
            }
        }
        else {
            //update that bai
            MyDialog.display(1, "Có lỗi xảy ra.");
        }
        
////        //delete image
////        File imageFile = new File("src/beatalbumshop/resources/images/users/" + id + ".png");
////        if (imageFile.exists()) {
////            if (!imageFile.delete()) {
////                //delete that bai
////                MyDialog.display(1, "Có lỗi xảy ra.");
////                return;
////            }
////        }
//
//        boolean result = userDAO.deleteByID(id);
//
//        if (result) {
//            //delete thanh cong
//            fillToTable();
//
//            //xoa 1 dong cuoi
//            if (lUser.size() == 0) {
//                clearForm();
//            } //xoa dong cuoi
//            else if (index == lUser.size()) {
//                selectRow(index - 1);
//            } else {
//                selectRow(index);
//            }
//        } else {
//            //delete that bai
//            MyDialog.display(1, "Có lỗi xảy ra.");
//        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMousePressed
        selectRow(tblUser.getSelectedRow());
    }//GEN-LAST:event_tblUserMousePressed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearForm();
        txtEmail.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private beatalbumshop.componment.MyButton btnAdd;
    private beatalbumshop.componment.MyButton btnDelete;
    private beatalbumshop.componment.MyButton btnNew;
    private beatalbumshop.componment.MyButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private beatalbumshop.componment.MyLabel lblDateCreated;
    private beatalbumshop.componment.MyLabel lblEmail;
    private beatalbumshop.componment.MyLabel lblID2;
    private beatalbumshop.componment.MyLabel lblPassword;
    private beatalbumshop.componment.MyLabel lblRole;
    private beatalbumshop.componment.MyLabel lblUserID;
    private javax.swing.JPanel pnlTabContent;
    private beatalbumshop.componment.MyRadioButton rdoAdmin;
    private beatalbumshop.componment.MyRadioButton rdoStaff;
    private beatalbumshop.componment.MyTable tblUser;
    private beatalbumshop.componment.MyTextField txtDateCreated;
    private beatalbumshop.componment.MyTextField txtEmail;
    private beatalbumshop.componment.MyTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
