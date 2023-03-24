package View;

import DBHelper.Helper;
import Model.Books;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class LibraryGUI extends javax.swing.JFrame {

    DefaultTableModel bookModel = null;
    Helper helper = new Helper();

    /**
     * Creates new form LibraryGUI
     */
    public LibraryGUI() {

        initComponents();
        btn_update.setEnabled(false);
        btn_clear.setEnabled(false);
        addToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_book = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_bookName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_author = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_page = new javax.swing.JTextField();
        btn_ok = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "author", "page"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_book);

        jLabel1.setText("Book Name");

        jLabel2.setText("Author");

        jLabel3.setText("Page");

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_clear.setText("clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_delete1.setText("DELETE");
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bookName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_author, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_page, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btn_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(51, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_author, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_page, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addToTable() {
        //tbl_book.setModel(bookModel);
        bookModel = (DefaultTableModel) tbl_book.getModel();
        bookModel.setRowCount(0);
        try {
            ArrayList<Books> b2 = helper.getFromDb();
            for (Books book : b2) {
                Object[] row = {book.getId(), book.getName(), book.getAuthor(), book.getPage()};
                bookModel.addRow(row);
            }
        } catch (Exception ex) {
            System.out.println("hata");
        }
    }


    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed

        // TODO add your handling code here:
        String name = "";
        String author = "";
        int pages = 0;

        try {
            name = txt_bookName.getText();
            author = txt_author.getText();
            pages = Integer.parseInt(txt_page.getText());
            helper.addToDB(name, author, pages);
        } catch (SQLException e) {
            helper.showError(e);
        } catch (NumberFormatException e2) {
            helper.showError(e2);
        }
        addToTable();

    }//GEN-LAST:event_btn_okActionPerformed

    private void tbl_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbl_book.getSelectedRow();
        Books b1 = new Books();
        b1 = helper.getFromDb().get(selectedRow);
        //System.out.println(b1.getAuthor());
        txt_bookName.setText(b1.getName());
        txt_author.setText(b1.getAuthor());
        txt_page.setText(String.valueOf(b1.getPage()));

        btn_update.setEnabled(true);
        btn_ok.setEnabled(false);
        btn_clear.setEnabled(true);
    }//GEN-LAST:event_tbl_bookMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_book.getSelectedRow();
        if (selectedRow >= -2) {
            txt_bookName.setText("");
            txt_author.setText("");
            txt_page.setText("");
            btn_update.setEnabled(false);
            btn_ok.setEnabled(true);
        }
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int selectedRow = tbl_book.getSelectedRow();
        Books b1 = new Books();
        b1 = helper.getFromDb().get(selectedRow);

        Connection conn = null;
        PreparedStatement pst = null;
        String sql = "UPDATE books SET name=? , author=? ,page=? WHERE id=?";

        try {

            conn = helper.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, txt_bookName.getText());
            pst.setString(2, txt_author.getText());
            pst.setInt(3, Integer.parseInt(txt_page.getText()));
            pst.setInt(4, b1.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        addToTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        // TODO add your handling code here:

        int selectedRow = tbl_book.getSelectedRow();
        Books b1 = new Books();

        Connection conn = null;
        PreparedStatement pst = null;
        String sql = "DELETE FROM books WHERE id=?";

        if (selectedRow != -1) {
            try {

                b1 = helper.getFromDb().get(selectedRow);

                conn = helper.getConnection();
                pst = conn.prepareStatement(sql);

                pst.setInt(1, b1.getId());
                pst.executeUpdate();
            } catch (SQLException ex) {
                helper.showError(ex);
            }
            
            addToTable();
        } else
            JOptionPane.showMessageDialog(null, "silinecek öge yok");
            
    }//GEN-LAST:event_btn_delete1ActionPerformed

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
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_book;
    private javax.swing.JTextField txt_author;
    private javax.swing.JTextField txt_bookName;
    private javax.swing.JTextField txt_page;
    // End of variables declaration//GEN-END:variables
}