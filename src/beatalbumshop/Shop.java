package beatalbumshop;

import beatalbumshop.componment.MyLabel;
import beatalbumshop.dao.AlbumDAO;
import beatalbumshop.dao.AlbumDAOImpl;
import beatalbumshop.model.Album;
import beatalbumshop.utils.ImageResizing;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Shop extends javax.swing.JPanel {
    AlbumDAO albumDAO = new AlbumDAOImpl();
    ArrayList<Album> lAlbum = new ArrayList<>();
        
    public Shop() {
        initComponents();
        
        pnlListAlbum.setLayout(new GridLayout(0, 4, 20, 20)); // 1028
        pnlListAlbum.setBorder(new EmptyBorder(20, 20, 20, 20));
        lAlbum = (ArrayList<Album>) albumDAO.getAll();

        for(Album album : lAlbum) {
            showAlbumCard(album);
        }
    }
    
    
    
    public void showAlbumCard(Album album) {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl.setBackground(Color.WHITE);
        pnl.setSize(new Dimension(227, 300));
        pnl.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnl.add(new JLabel(ImageResizing.ImageResizing("src/beatalbumshop/resources/images/albums/" + album.getAlbumID() + ".png", 227, 227)));

        MyLabel lblName = new MyLabel("<html>" + album.getAlbumName() + "</html>");
        lblName.setPreferredSize(new Dimension(227, 50));
        lblName.setFont(new Font("Open Sans", 0, 18));
        pnl.add(lblName);

        MyLabel lblPrice = new MyLabel("$" + album.getAlbumPrice());
        lblPrice.setFont(new Font("Open Sans", 0, 14));
        pnl.add(lblPrice);

        pnl.setName(album.getAlbumID() + "");
        pnl.addMouseListener(showInfo);

        pnlListAlbum.add(pnl);
    }
    
    
    
    MouseAdapter showInfo = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            JPanel s = (JPanel) e.getSource();
            int id = Integer.parseInt(s.getName());
            
            new AlbumDetail(id).setVisible(true);
        }
    };
    
    
    
    public void search(String search) {
        // Xóa các panel hiện có trong pnlListAlbum
        pnlListAlbum.removeAll();
        
        // Cập nhật lại giao diện
        pnlListAlbum.revalidate();
        pnlListAlbum.repaint();
        
        for(Album album : lAlbum) {
            if(album.getAlbumName().toLowerCase().contains(search.toLowerCase())) {
                showAlbumCard(album);
            }
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

        myScrollPane1 = new beatalbumshop.componment.MyScrollPane();
        pnlListAlbum = new javax.swing.JPanel();
        txtSearch = new beatalbumshop.componment.MyTextField();
        lblSearch = new beatalbumshop.componment.MyLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1030, 658));
        setMinimumSize(new java.awt.Dimension(1030, 658));

        myScrollPane1.setBackground(null);
        myScrollPane1.setBorder(null);
        myScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlListAlbum.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlListAlbumLayout = new javax.swing.GroupLayout(pnlListAlbum);
        pnlListAlbum.setLayout(pnlListAlbumLayout);
        pnlListAlbumLayout.setHorizontalGroup(
            pnlListAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        pnlListAlbumLayout.setVerticalGroup(
            pnlListAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        myScrollPane1.setViewportView(pnlListAlbum);

        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setText("Search:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(myScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private beatalbumshop.componment.MyLabel lblSearch;
    private beatalbumshop.componment.MyScrollPane myScrollPane1;
    private javax.swing.JPanel pnlListAlbum;
    private beatalbumshop.componment.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}