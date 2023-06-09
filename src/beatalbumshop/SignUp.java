package beatalbumshop;

import beatalbumshop.componment.MyDialog;
import beatalbumshop.dao.CustomerDAO;
import beatalbumshop.dao.CustomerDAOImpl;
import beatalbumshop.dao.Firebase;
import beatalbumshop.dao.UserDAO;
import beatalbumshop.dao.UserDAOImpl;
import beatalbumshop.model.AddressBook;
import beatalbumshop.model.Customer;
import beatalbumshop.model.Item;
import beatalbumshop.model.User;
import beatalbumshop.utils.SendEmail;
import beatalbumshop.utils.TextHelper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 * This class represents the Sign Up frame of the Beat Album Shop application.
 */
public class SignUp extends javax.swing.JFrame {

    ArrayList<User> listUser = new ArrayList<>();
    UserDAO userDAO = new UserDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    int otp = -1;

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
        setLocationRelativeTo(null);
        
        //rounded frame
        setShape(new RoundRectangle2D.Double(0, 0, 1280, 720, 20, 20));
        setSize(1280, 720);
        setLocationRelativeTo(null);
        
        addPlaceholderText(txtEmail, "Email");
        addPlaceholderText(txtPassword, "Password");
        addPlaceholderText(txtPassword2, "Password");
        
        txtEmail.requestFocus();
        txtOTP.setVisible(false);
    }
    
    
    
    /**
     * Adds a placeholder text to the specified text field.
     * The placeholder text is displayed when the text field is empty and not in focus.
     * 
     * @param textField the text field to add the placeholder text to
     * @param placeholderText the placeholder text to display
     */
    private void addPlaceholderText(JTextField textField, String placeholderText) {
        // Save the default foreground color of the text field
        Color defaultColor = textField.getForeground();
        
        // Set the placeholder text
        textField.setText(placeholderText);

        // Add a focus listener to handle the placeholder text
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setForeground(defaultColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholderText);
                }
            }
        });
    }
    
    
    
    /**
     * Returns the maximum ID from the given collection reference and column name.
     * 
     * @param colRef the collection reference to query
     * @param column the name of the column to get the maximum ID from
     * @return the maximum ID from the collection reference and column name
     */
    public static long getMaxID(CollectionReference colRef, String column) {
        try {
            // Create a query to order the documents by albumID in descending order
            Query query = colRef.orderBy(column, Query.Direction.DESCENDING).limit(1);

            ApiFuture<QuerySnapshot> querySnapshotFuture = query.get();

            try {
                QuerySnapshot querySnapshot = querySnapshotFuture.get();
                if (!querySnapshot.isEmpty()) {
                    // Retrieve the first document (with the maximum albumID)
                    DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                    // Get the value of the albumID field
                    return document.getLong(column) + 1;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    
    
    public static void createUser(String email, String password) {
//        Firestore db = Firebase.getFirestore("beat-75a88");
//        CollectionReference colRef = db.collection("users");
//        int userID = getMaxID(colRef, "userID") + 1;
//
//        Date currentDate = new Date();
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        String formattedDate = dateFormat.format(currentDate);
//        //INSERT 
//        User user = new User(userID, email, password, formattedDate, 0);
//        ApiFuture<WriteResult> result = colRef.document(userID + "").set(user);
//
//        try {
//            System.out.println("Update time : " + result.get().getUpdateTime());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    
    
    /**
     * Checks if the given email address is valid.
     *
     * @param email the email address to check
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
        return email.matches(emailRegex);
    }

    
    
    public boolean checkUser() {
//        listUser = (ArrayList<User>) userDAO.getAll();
//        if (listUser != null) {
//            for (User user : listUser) {
//                if (user.getEmail().equalsIgnoreCase(txtEmail.getText())) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    
    
    /**
     * Validates the sign-up form.
     * 
     * @param email the email address entered by the user
     * @param password the password entered by the user
     * @param confirmPassword the confirm password entered by the user
     * @return an error message if the form is invalid, or null if the form is valid
     */
    public String validateFormSigup(String email, String password, String confirmPassword) {
        // Kiểm tra tính hợp lệ của email
        if (email.isEmpty()) {
            txtEmail.requestFocus();
            return "Vui lòng nhập Email";
        } else if (!isValidEmail(email)) {
            txtEmail.requestFocus();
            return "Email sai định dạng";

        }

        if (password.isEmpty()) {
            txtPassword.requestFocus();
            return "Vui lòng nhập Pasword";
        }
        else if(!password.matches("[a-zA-Z0-9]+")) {
            txtPassword.requestFocus();
            return "Password chỉ được chứa các kí tự [a-zA-Z0-9]";
        }
        
        if (!password.equals(confirmPassword)) {
            txtPassword2.requestFocus();
            return "Password và Password Confirm không khớp";
        }
        return null; // Trả về null nếu form hợp lệ
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        windowTitleBar1 = new beatalbumshop.componment.WindowTitleBar();
        pnlContent = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();
        btnSignup = new beatalbumshop.componment.MyButton();
        lblLogin = new javax.swing.JLabel();
        lblContinueAs = new javax.swing.JLabel();
        txtOTP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);

        pnlMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlMain.setLayout(new java.awt.BorderLayout());

        windowTitleBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlMain.add(windowTitleBar1, java.awt.BorderLayout.PAGE_START);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));

        pnlForm.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Sign Up");

        txtEmail.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(82, 82, 82));
        txtEmail.setText("Email");
        txtEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtPassword.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(82, 82, 82));
        txtPassword.setText("jPasswordField1");
        txtPassword.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));

        txtPassword2.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        txtPassword2.setForeground(new java.awt.Color(82, 82, 82));
        txtPassword2.setText("jPasswordField1");
        txtPassword2.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));

        btnSignup.setBackground(new java.awt.Color(0, 0, 0));
        btnSignup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setText("Sign up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("ALREADY HAVE AN ACCOUNT? LOG IN");
        lblLogin.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });

        lblContinueAs.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        lblContinueAs.setText("CONTINUE AS A GUEST");
        lblContinueAs.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        lblContinueAs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblContinueAs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblContinueAsMouseClicked(evt);
            }
        });

        txtOTP.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        txtOTP.setForeground(new java.awt.Color(82, 82, 82));
        txtOTP.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        txtOTP.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblTitle)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogin)
                            .addComponent(lblContinueAs))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnSignup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(txtEmail)
                .addGap(30, 30, 30)
                .addComponent(txtPassword)
                .addGap(30, 30, 30)
                .addComponent(txtPassword2)
                .addGap(30, 30, 30)
                .addComponent(btnSignup, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(lblContinueAs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlFormLayout.createSequentialGroup()
                    .addGap(211, 211, 211)
                    .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(212, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        pnlMain.add(pnlContent, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblContinueAsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContinueAsMouseClicked
        dispose();
        
        boolean check = false; // true if open form buy now
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof Main mainWindow && window.isVisible()) {
                check = true;
            }
        }
        
        if(!check) {
            new Main().setVisible(true);
        }
    }//GEN-LAST:event_lblContinueAsMouseClicked

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_lblLoginMouseClicked

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        String confirmpassword = new String(txtPassword2.getPassword());
        String errorMessage = validateFormSigup(email, password, confirmpassword);
        ArrayList<AddressBook> lAddressBook = new ArrayList<>();
        ArrayList<Item> lBagItem = new ArrayList<>();
        String btnType = evt.getActionCommand();
        
        // co loi
        if (errorMessage != null) {
            MyDialog.display(1, errorMessage);
        }
        else {
            // kiem tra ton tai
            if (btnType.equalsIgnoreCase("Sign up") && customerDAO.checkExitByEmail(email) && userDAO.checkExitByEmail(email)) {
                //chua ton tai - dang signup
                
                //gui email
                int o = (int) (Math.random() * 900000) + 100000;
                otp = o;
                String subject = "WELCOME TO BEAT";
                String recipientName = email;
                String content = "<tr>\n"
                          + "<td class=\"text-center\" style=\"padding: 80px 0 !important;\">\n"
                          + "<h4>" + subject + "</h4>\n"
                          + "<br>\n"
                          + "Dear " + recipientName + ",<br>\n"
                          + "Thank you for creating your personal account on BEAT.<br>\n"
                          + "<br><br>\n"
                          + "Your OTP code is:\n"
                          + "<br><br>\n"
                          + "<h2>" + o + "</h2>\n"
                          + "</td>\n"
                          + "</tr>\n"
                          + "<tr>\n"
                          + "<td>\n"
                          + "<p class=\"text-center\">If you did not request to create an account, please ignore this email, no changes will be made to your account. Another user may have entered your username by mistake, but we encourage you to view our tips for Protecting Your Account if you have any concerns.</p>\n"
                          + "</td>\n"
                          + "</tr>\n";
                System.out.println("1");
                boolean sendStatus = SendEmail.sendFormat(email, email, subject, content);
                //insert OTP into user
                if (!sendStatus) {
                    MyDialog.display(1, "Có lỗi xảy ra trong quá trình gửi email");
                    return;
                }
                //sau khi gui => chuyen sang xac nhan otp
                txtEmail.setEnabled(true);
                txtPassword.setVisible(false);
                txtPassword2.setVisible(false);
                txtOTP.setVisible(true);
                txtOTP.requestFocus();
                btnSignup.setText("Verify Code");
            }
            else if (btnType.equalsIgnoreCase("Verify Code")) {
                if (txtOTP.getText().equals(otp + "") && txtOTP.getText().matches("[0-9]{6}")) {
                    Firestore db = Firebase.getFirestore("beat-75a88");
                    CollectionReference colRef = db.collection("customers");

                    // hash password
                    password = TextHelper.HashPassword(password);

                    boolean result = customerDAO.add(new Customer(lAddressBook, lBagItem, getMaxID(colRef, "id"), email, password));
                    if (result) {
                        dispose();
                        new LogIn().setVisible(true);
                        MyDialog.display(0, "Đăng ký thành công!");
                    }
                } else {

                    MyDialog.display(1, "Wrong code. Try again.");
                    txtOTP.requestFocus();
                }

            }
            else {
                //da ton tai
                Customer c = customerDAO.getByEmail(email);
                if(c.getPassword() == "") {
                    txtEmail.requestFocus();
                    MyDialog.display(1, "Email này đã bị vô hiệu hóa, hãy liên hệ Client service team để khôi phục");
                }
                else {
                    txtEmail.requestFocus();
                    MyDialog.display(1, "Email đã tồn tại vui lòng thử lại");
                }
            }
        }
    }//GEN-LAST:event_btnSignupActionPerformed

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private beatalbumshop.componment.MyButton btnSignup;
    private javax.swing.JLabel lblContinueAs;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtOTP;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword2;
    private beatalbumshop.componment.WindowTitleBar windowTitleBar1;
    // End of variables declaration//GEN-END:variables
}
