package beatalbumshop;

import beatalbumshop.AboutUs;
import beatalbumshop.Home;
import beatalbumshop.LogIn;
import beatalbumshop.Shop;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class Main extends javax.swing.JFrame {
    JButton [] btnMenuList;
    Color gray = new Color(50, 50, 50);

    public Main() {
        initComponents();
        
        //rounded frame
        setShape(new RoundRectangle2D.Double(0, 0, 1280, 720, 20, 20));
        setSize(1280, 720);
        setLocationRelativeTo(null);
        
        // tab
        pnlTabContent.setLayout(new CardLayout());
        pnlTabContent.add(new Home(), "home");
        pnlTabContent.add(new Shop(), "shop");
        pnlTabContent.add(new AboutUs(), "aboutus");
        pnlTabContent.add(new LogIn(), "login");
        
        btnMenuList = new JButton[] {btnHome, btnShop, btnAboutUs, btnLogIn};
        for(JButton btn : btnMenuList) {
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // mau chu
                    for(JButton btn : btnMenuList) {
                        btn.setForeground(gray);
                    }
                    JButton b = (JButton)e.getSource();
                    b.setForeground(Color.BLACK);
                    
                    // show tab
                    String name = e.getActionCommand().toLowerCase().replaceAll(" ", "");
                    CardLayout c = (CardLayout) pnlTabContent.getLayout();
                    c.show(pnlTabContent, name);
                }
            });
        }
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
        windowTitleBar = new beatalbumshop.componment.WindowTitleBar();
        pnlSideBar = new javax.swing.JPanel();
        btnHome = new beatalbumshop.componment.MyButton();
        btnShop = new beatalbumshop.componment.MyButton();
        btnAboutUs = new beatalbumshop.componment.MyButton();
        btnLogIn = new beatalbumshop.componment.MyButton();
        pnlTabContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Beat To Beat");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlMain.setLayout(new java.awt.BorderLayout());

        windowTitleBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        windowTitleBar.setFrame(this);
        pnlMain.add(windowTitleBar, java.awt.BorderLayout.PAGE_START);

        pnlSideBar.setBackground(new java.awt.Color(255, 255, 255));
        pnlSideBar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        pnlSideBar.setPreferredSize(new java.awt.Dimension(250, 658));

        btnHome.setBackground(null);
        btnHome.setText("Home");
        btnHome.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setMargin(new java.awt.Insets(2, 20, 3, 14));

        btnShop.setBackground(null);
        btnShop.setText("Shop");
        btnShop.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnShop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnShop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShop.setMargin(new java.awt.Insets(2, 20, 3, 14));

        btnAboutUs.setBackground(null);
        btnAboutUs.setText("About Us");
        btnAboutUs.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnAboutUs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAboutUs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAboutUs.setMargin(new java.awt.Insets(2, 20, 3, 14));

        btnLogIn.setBackground(null);
        btnLogIn.setText("Log In");
        btnLogIn.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnLogIn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogIn.setMargin(new java.awt.Insets(2, 20, 3, 14));

        javax.swing.GroupLayout pnlSideBarLayout = new javax.swing.GroupLayout(pnlSideBar);
        pnlSideBar.setLayout(pnlSideBarLayout);
        pnlSideBarLayout.setHorizontalGroup(
            pnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnShop, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(btnAboutUs, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(btnLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        pnlSideBarLayout.setVerticalGroup(
            pnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSideBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnAboutUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
        );

        pnlMain.add(pnlSideBar, java.awt.BorderLayout.LINE_START);

        pnlTabContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabContent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlTabContentLayout = new javax.swing.GroupLayout(pnlTabContent);
        pnlTabContent.setLayout(pnlTabContentLayout);
        pnlTabContentLayout.setHorizontalGroup(
            pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1029, Short.MAX_VALUE)
        );
        pnlTabContentLayout.setVerticalGroup(
            pnlTabContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
        );

        pnlMain.add(pnlTabContent, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        btnHome.doClick();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private beatalbumshop.componment.MyButton btnAboutUs;
    private beatalbumshop.componment.MyButton btnHome;
    private beatalbumshop.componment.MyButton btnLogIn;
    private beatalbumshop.componment.MyButton btnShop;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSideBar;
    private javax.swing.JPanel pnlTabContent;
    private beatalbumshop.componment.WindowTitleBar windowTitleBar;
    // End of variables declaration//GEN-END:variables
}