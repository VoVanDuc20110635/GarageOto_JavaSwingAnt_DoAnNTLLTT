/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WINDOWS 10
 */
public class testFindWithoutCombobox extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    private JTextField searchField;
    private JList<String> suggestionList;

    private List<String> data = List.of("Anh", "Đức", "Toàn", "Hà", "Khiêm", "Tiến");
    public testFindWithoutCombobox() {
        initComponents();
        searchField = new JTextField();
        suggestionList = new JList<>();

        setLayout(new BorderLayout());
        add(searchField, BorderLayout.NORTH);
        add(new JScrollPane(suggestionList), BorderLayout.CENTER);

        searchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not used
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    selectSuggestion();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                updateSuggestions(searchField.getText());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }
    private void updateSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        for (String item : data) {
            if (item.toLowerCase().startsWith(prefix.toLowerCase())) {
                suggestions.add(item);
            }
        }

        String[] suggestionArray = suggestions.toArray(new String[0]);
        suggestionList.setListData(suggestionArray);

        // Show suggestions popup (JPopupMenu) below the search field
        if (!suggestions.isEmpty()) {
            Point location = searchField.getLocationOnScreen();
            suggestionList.setLocation(location.x, location.y + searchField.getHeight());
            suggestionList.setVisibleRowCount(Math.min(suggestions.size(), 5));
            suggestionList.setVisible(true);
        } else {
            suggestionList.setVisible(false);
        }
    }
    private void selectSuggestion() {
        int selectedIndex = suggestionList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedValue = suggestionList.getSelectedValue();
            searchField.setText(selectedValue);
            suggestionList.setVisible(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(testFindWithoutCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testFindWithoutCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testFindWithoutCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testFindWithoutCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testFindWithoutCombobox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
