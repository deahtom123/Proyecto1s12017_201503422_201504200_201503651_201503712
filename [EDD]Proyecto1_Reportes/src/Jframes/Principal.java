package Jframes;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_departamento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_arbolavl = new javax.swing.JButton();
        btn_dispersa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_activos = new javax.swing.JTextField();
        btn_renta = new javax.swing.JButton();
        btn_activos = new javax.swing.JButton();
        btn_arbolb = new javax.swing.JButton();
        box_usuario = new javax.swing.JComboBox<>();
        box_empresa = new javax.swing.JComboBox<>();
        box_departamento = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_matriz = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbl_activosEmpresa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lbl_activosdepartamento = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lbl_avl = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lbl_rentados = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbl_b = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nombre de un Departamento:");

        jButton1.setText("Mostrar Activos del Departamento");

        btn_arbolavl.setText("AVL del usuario seleccionado");

        btn_dispersa.setText("Matriz Dispersa");
        btn_dispersa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dispersaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de una empresa: ");

        btn_renta.setText("Activos rentados por el usuario seleccionado");

        btn_activos.setText("Mostrar Activos de la Empresa");
        btn_activos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activosActionPerformed(evt);
            }
        });

        btn_arbolb.setText("Arbol B");
        btn_arbolb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_arbolbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_dispersa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_activos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_activos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(box_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(box_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(box_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_arbolavl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_renta, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_arbolb, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 85, Short.MAX_VALUE)
                        .addComponent(btn_dispersa)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_activos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_activos)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(btn_arbolavl)
                        .addGap(22, 22, 22)
                        .addComponent(btn_renta)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_arbolb)))
                .addGap(57, 57, 57))
        );

        jTabbedPane1.addTab("Inicio", jPanel1);

        jScrollPane1.setViewportView(lbl_matriz);

        jTabbedPane1.addTab("Matriz", jScrollPane1);

        jScrollPane2.setViewportView(lbl_activosEmpresa);

        jTabbedPane1.addTab("Activos de la Empresa", jScrollPane2);

        jScrollPane3.setViewportView(lbl_activosdepartamento);

        jTabbedPane1.addTab("Activos del departamento", jScrollPane3);

        jScrollPane4.setViewportView(lbl_avl);

        jTabbedPane1.addTab("AVL del usuario", jScrollPane4);

        jScrollPane5.setViewportView(lbl_rentados);

        jTabbedPane1.addTab("Rentas del Usuario", jScrollPane5);

        jScrollPane6.setViewportView(lbl_b);

        jTabbedPane1.addTab("Arbol B", jScrollPane6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dispersaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dispersaActionPerformed
        // TODO add your handling code here:
        Mostrar(lbl_matriz,jTabbedPane1.indexOfTab("Matriz"),"DIRECCION");
    }//GEN-LAST:event_btn_dispersaActionPerformed

    private void btn_arbolbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_arbolbActionPerformed
        // TODO add your handling code here:
        Mostrar(lbl_b,jTabbedPane1.indexOfTab("Arbol B"),"DIRECCION");
    }//GEN-LAST:event_btn_arbolbActionPerformed

    private void btn_activosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activosActionPerformed
        // TODO add your handling code here:
        String Direccion = "C:\\RED.....ALGO ASI";
        Mostrar(lbl_activosEmpresa,jTabbedPane1.indexOfTab("Activos de la Empresa"),Direccion);
    }//GEN-LAST:event_btn_activosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_departamento;
    private javax.swing.JComboBox<String> box_empresa;
    private javax.swing.JComboBox<String> box_usuario;
    private javax.swing.JButton btn_activos;
    private javax.swing.JButton btn_arbolavl;
    private javax.swing.JButton btn_arbolb;
    private javax.swing.JButton btn_dispersa;
    private javax.swing.JButton btn_renta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_activosEmpresa;
    private javax.swing.JLabel lbl_activosdepartamento;
    private javax.swing.JLabel lbl_avl;
    private javax.swing.JLabel lbl_b;
    private javax.swing.JLabel lbl_matriz;
    private javax.swing.JLabel lbl_rentados;
    private javax.swing.JTextField txt_activos;
    private javax.swing.JTextField txt_departamento;
    // End of variables declaration//GEN-END:variables

    private void Mostrar(JLabel lbl, int index, String path) {
        try {
        jTabbedPane1.setSelectedIndex(index);
        ImageIcon fot = new ImageIcon(path);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(icono);
        lbl.repaint();
        } catch (Exception e) {
            System.out.println("NO SE PUDO CAMBIAR AL INDICE ESPECIFICADO");
        }
    }

}