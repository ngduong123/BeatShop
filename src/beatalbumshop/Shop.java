package beatalbumshop;

import beatalbumshop.componment.MyLabel;
import beatalbumshop.dao.AlbumDAO;
import beatalbumshop.dao.AlbumDAOImpl;
import beatalbumshop.model.Album;
import beatalbumshop.utils.ImageHelper;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * The Shop class represents a custom panel used for displaying a list of albums.
 * It provides functionality for searching, sorting, and displaying album cards.
 */
public class Shop extends javax.swing.JPanel {
    AlbumDAO albumDAO = new AlbumDAOImpl();
    ArrayList<Album> lAlbum = new ArrayList<>();
    int clickCount = 0;
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    
    /**
     * Creates a new Shop panel.
     */
    public Shop() {
        initComponents();
        pnlListAlbum.setLayout(new GridLayout(0, 4, 20, 20)); // 1028
        pnlListAlbum.setBorder(new EmptyBorder(20, 20, 20, 20));
        lAlbum = (ArrayList<Album>) albumDAO.getAll();
        
        for(Album album : lAlbum) {
            if(album.getInStock() > 0) {
                showAlbumCard(album);
            }
        }
    }
    
    
    
    /**
     * Sorts the given list of albums by price in descending order.
     *
     * @param lAlbum the list of albums to sort
     */
    public static void sortByPriceDescending(ArrayList<Album> lAlbum) {
        Collections.sort(lAlbum, new Comparator<Album>() {
            @Override
            public int compare(Album album1, Album album2) {
                return album2.getPrice().compareTo(album1.getPrice());
            }
        });
    }
    
    /**
     * Sorts the given list of albums by price in ascending order.
     *
     * @param lAlbum the list of albums to sort
     */
    public static void sortByPriceAscending(ArrayList<Album> lAlbum) {
        Collections.sort(lAlbum, new Comparator<Album>() {
            @Override
            public int compare(Album album1, Album album2) {
                return album1.getPrice().compareTo(album2.getPrice());
            }
        });
    }
    
    
    /**
     * Displays an album card for the given album.
     *
     * @param album the album to display
     */
    public void showAlbumCard(Album album) {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl.setBackground(Color.WHITE);
        pnl.setSize(new Dimension(227, 300));
        pnl.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel lblImage = new JLabel();
        try {
            URL url = new URL("https://firebasestorage.googleapis.com/v0/b/beat-75a88.appspot.com/o/albums%2F" + album.getAlbumID() + ".png?alt=media");
            Image image = ImageIO.read(url);
            lblImage.setIcon(ImageHelper.resizing(image, 227, 227));
        } catch(Exception ex) {
            lblImage.setIcon(null);
            ex.printStackTrace();
        }
        pnl.add(lblImage);

        MyLabel lblName = new MyLabel("<html>" + album.getAlbumName() + "</html>");
        lblName.setPreferredSize(new Dimension(227, 50));
        lblName.setFont(new Font("Open Sans", 0, 18));
        pnl.add(lblName);
        
        MyLabel lblArtist = new MyLabel("<html>" + album.getArtist()+ "</html>");
        lblArtist.setFont(new Font("Open Sans", 0, 14));
        pnl.add(lblArtist);

        MyLabel lblPrice = new MyLabel("$" + album.getPrice());
        lblPrice.setFont(new Font("Open Sans", 0, 14));
        pnl.add(lblPrice);
        
        pnl.setName(album.getAlbumID() + "");
        pnl.addMouseListener(showInfo);

        pnlListAlbum.add(pnl);
    }
    
    
    
    /**
     * MouseAdapter implementation to handle the mouse click event on album panels.
     */
    MouseAdapter showInfo = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            JPanel s = (JPanel) e.getSource();
            String id = s.getName();
            
//            new AlbumDetail(id).setVisible(true);
            JPanel pnlTabContent = (JPanel) getParent();
            pnlTabContent.add(new AlbumDetail(id), "albumdetailpanel");
            
            Main.showTab("albumdetailpanel");
        }
    };
    
    
    
    /**
     * Searches the albums based on the given search string.
     *
     * @param search the search string
     */
    public void search(String search) {
        // Xóa các panel hiện có trong pnlListAlbum
        pnlListAlbum.removeAll();
        
        // Cập nhật lại giao diện
        pnlListAlbum.revalidate();
        pnlListAlbum.repaint();
        
        for(Album album : lAlbum) {
            if(album.getInStock() > 0) {
                if((album.getAlbumName().toLowerCase() + " " + album.getArtist().toLowerCase()).contains(search.toLowerCase())) {
                    showAlbumCard(album);
                }
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
        cboSort = new javax.swing.JComboBox<>();

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

        cboSort.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        cboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No filter", "Price High to Low", "Price Low to High" }));
        cboSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSortActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboSort, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSort, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(myScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cboSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSortActionPerformed
        pnlListAlbum.removeAll();
        String text = (String) cboSort.getSelectedItem();

        if (text.toLowerCase().equalsIgnoreCase("price low to high")) {
            sortByPriceAscending(lAlbum);
        }
        else if (text.toLowerCase().equalsIgnoreCase("price high to low")) {
            sortByPriceDescending(lAlbum);
        }

        for (Album album : lAlbum) {
            if(album.getInStock() > 0) {
                showAlbumCard(album);
            }
        }
    }//GEN-LAST:event_cboSortActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboSort;
    private beatalbumshop.componment.MyLabel lblSearch;
    private beatalbumshop.componment.MyScrollPane myScrollPane1;
    private javax.swing.JPanel pnlListAlbum;
    private beatalbumshop.componment.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
