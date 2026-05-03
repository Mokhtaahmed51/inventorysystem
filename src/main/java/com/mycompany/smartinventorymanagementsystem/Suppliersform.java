/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.smartinventorymanagementsystem;

import SmartInventoryManagementSystem.MyConnection;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mokhtar
 */

   public final class Suppliersform extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Suppliersform.class.getName());

    public Suppliersform() {
        initComponents();
        showSuppliers(); 
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    
   public void showSuppliers() {
    try {
        java.sql.Connection con = MyConnection.getConnection();
        java.sql.Statement st = con.createStatement();
        java.sql.ResultSet rs = st.executeQuery("SELECT * FROM suppliers");
        
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1_supplierform.getModel();
        model.setRowCount(0); 
        
        while(rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("name"), // تم التعديل حسب phpMyAdmin
                rs.getString("phone"),
                rs.getString("address")
            };
            model.addRow(row);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1_suppliername_supplierform = new javax.swing.JLabel();
        jLabel2_phone_supplierform = new javax.swing.JLabel();
        jLabel3_address_supplierform = new javax.swing.JLabel();
        jTextField1_suppliername_supplierform = new javax.swing.JTextField();
        jTextField2_phone_supplierform = new javax.swing.JTextField();
        jTextField3_address_supplierform = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_supplierform = new javax.swing.JTable();
        jButton1_save_supplierform = new javax.swing.JButton();
        jButton2_update_supplierform = new javax.swing.JButton();
        jButton3_delete_supplierform = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(743, 510));

        jLabel1_suppliername_supplierform.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        jLabel1_suppliername_supplierform.setText("Supplier Name");

        jLabel2_phone_supplierform.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        jLabel2_phone_supplierform.setText("Phone");

        jLabel3_address_supplierform.setFont(new java.awt.Font("Inter", 1, 13)); // NOI18N
        jLabel3_address_supplierform.setText("Address");

        jTextField1_suppliername_supplierform.addActionListener(this::jTextField1_suppliername_supplierformActionPerformed);

        jTextField2_phone_supplierform.addActionListener(this::jTextField2_phone_supplierformActionPerformed);

        jTextField3_address_supplierform.addActionListener(this::jTextField3_address_supplierformActionPerformed);

        jTable1_supplierform.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Phone", "Address"
            }
        ));
        jTable1_supplierform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_supplierformMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_supplierform);

        jButton1_save_supplierform.setBackground(new java.awt.Color(0, 204, 51));
        jButton1_save_supplierform.setForeground(new java.awt.Color(255, 255, 255));
        jButton1_save_supplierform.setText("Save");
        jButton1_save_supplierform.addActionListener(this::jButton1_save_supplierformActionPerformed);

        jButton2_update_supplierform.setBackground(new java.awt.Color(51, 102, 255));
        jButton2_update_supplierform.setForeground(new java.awt.Color(255, 255, 255));
        jButton2_update_supplierform.setText("Update");
        jButton2_update_supplierform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2_update_supplierformMouseClicked(evt);
            }
        });
        jButton2_update_supplierform.addActionListener(this::jButton2_update_supplierformActionPerformed);

        jButton3_delete_supplierform.setBackground(new java.awt.Color(204, 0, 0));
        jButton3_delete_supplierform.setForeground(new java.awt.Color(255, 255, 255));
        jButton3_delete_supplierform.setText("Delete");
        jButton3_delete_supplierform.addActionListener(this::jButton3_delete_supplierformActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3_address_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2_phone_supplierform)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1_suppliername_supplierform)
                                .addGap(18, 18, 18)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1_suppliername_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2_phone_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3_address_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3_delete_supplierform)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2_update_supplierform)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1_save_supplierform)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1_suppliername_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1_suppliername_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2_phone_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2_phone_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3_address_supplierform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3_address_supplierform))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3_delete_supplierform)
                    .addComponent(jButton2_update_supplierform)
                    .addComponent(jButton1_save_supplierform))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_suppliername_supplierformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_suppliername_supplierformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_suppliername_supplierformActionPerformed

    private void jTextField2_phone_supplierformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_phone_supplierformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_phone_supplierformActionPerformed

    private void jButton1_save_supplierformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_save_supplierformActionPerformed
        // TODO add your handling code here:
        try {
        java.sql.Connection con = MyConnection.getConnection();
        // استخدمنا name هنا عشان يطابق قاعدة بياناتك
        String sql = "INSERT INTO suppliers (name, phone, address) VALUES (?, ?, ?)";
        java.sql.PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, jTextField1_suppliername_supplierform.getText());
        ps.setString(2, jTextField2_phone_supplierform.getText());
        ps.setString(3, jTextField3_address_supplierform.getText());

        ps.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null, "تم إضافة المورد بنجاح");
        showSuppliers(); // تحديث الجدول فوراً
        
    } catch (HeadlessException | SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "خطأ في الحفظ: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1_save_supplierformActionPerformed

    private void jTable1_supplierformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_supplierformMouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable1_supplierform.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) jTable1_supplierform.getModel();
    
    // بنجيب البيانات من الصف اللي ضغطت عليه ونعرضها في الخانات
    jTextField1_suppliername_supplierform.setText(model.getValueAt(rowIndex, 1).toString());
    jTextField2_phone_supplierform.setText(model.getValueAt(rowIndex, 2).toString());
    jTextField3_address_supplierform.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_jTable1_supplierformMouseClicked

    private void jButton2_update_supplierformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_update_supplierformActionPerformed
        // TODO add your handling code here:
     try {
    // 1. الحصول على الـ ID من الصف المختار في الجدول
    int rowIndex = jTable1_supplierform.getSelectedRow();
    
    if (rowIndex == -1) {
        javax.swing.JOptionPane.showMessageDialog(null, "من فضلك اختر المورد اللي عايز تعدله من الجدول أولاً");
        return;
    }
    
    String id = jTable1_supplierform.getValueAt(rowIndex, 0).toString(); 

    // 2. الاتصال وتعديل جملة الـ SQL (استخدام name بدلاً من supplier_name)
    java.sql.Connection con = MyConnection.getConnection();
    // لاحظ التعديل هنا: name هو الاسم الصح في قاعدة بياناتك
    String sql = "UPDATE suppliers SET name=?, phone=?, address=? WHERE id=?";
    java.sql.PreparedStatement ps = con.prepareStatement(sql);

    // 3. ربط الخانات (Fields) بالقيم الجديدة
    ps.setString(1, jTextField1_suppliername_supplierform.getText());
    ps.setString(2, jTextField2_phone_supplierform.getText());
    ps.setString(3, jTextField3_address_supplierform.getText());
    ps.setString(4, id); 

    // 4. تنفيذ التعديل وتحديث الجدول
    ps.executeUpdate();
    javax.swing.JOptionPane.showMessageDialog(null, "تم تحديث بيانات المورد بنجاح");
    
    showSuppliers(); // تحديث الجدول فوراً عشان تشوف التغيير

} catch (HeadlessException | SQLException e) {
    javax.swing.JOptionPane.showMessageDialog(null, "خطأ في التعديل: " + e.getMessage());
}
    }//GEN-LAST:event_jButton2_update_supplierformActionPerformed

    private void jButton3_delete_supplierformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_delete_supplierformActionPerformed
        // TODO add your handling code here:
        try {
        int rowIndex = jTable1_supplierform.getSelectedRow();
        if (rowIndex == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "اختر المورد اللي عايز تمسحه من الجدول");
            return;
        }
        
        // بنجيب الـ ID عشان نمسحه من قاعدة البيانات
        String id = jTable1_supplierform.getValueAt(rowIndex, 0).toString();
        
        // رسالة تأكيد عشان ميمسحش بالغلط
        int check = javax.swing.JOptionPane.showConfirmDialog(null, "هل أنت متأكد من حذف هذا المورد؟", "تأكيد حذف", javax.swing.JOptionPane.YES_NO_OPTION);
        
        if (check == javax.swing.JOptionPane.YES_OPTION) {
            java.sql.Connection con = MyConnection.getConnection();
            String sql = "DELETE FROM suppliers WHERE id=?";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null, "تم حذف المورد بنجاح");
            showSuppliers();
            
            // فضي الخانات بعد المسح
            jTextField1_suppliername_supplierform.setText("");
            jTextField2_phone_supplierform.setText("");
            jTextField3_address_supplierform.setText("");
        }
        
    } catch (HeadlessException | SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "خطأ في الحذف: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton3_delete_supplierformActionPerformed

    private void jButton2_update_supplierformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_update_supplierformMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton2_update_supplierformMouseClicked

    private void jTextField3_address_supplierformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3_address_supplierformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3_address_supplierformActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Suppliersform().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_save_supplierform;
    private javax.swing.JButton jButton2_update_supplierform;
    private javax.swing.JButton jButton3_delete_supplierform;
    private javax.swing.JLabel jLabel1_suppliername_supplierform;
    private javax.swing.JLabel jLabel2_phone_supplierform;
    private javax.swing.JLabel jLabel3_address_supplierform;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_supplierform;
    private javax.swing.JTextField jTextField1_suppliername_supplierform;
    private javax.swing.JTextField jTextField2_phone_supplierform;
    private javax.swing.JTextField jTextField3_address_supplierform;
    // End of variables declaration//GEN-END:variables
   }