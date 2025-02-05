
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;


public class home extends javax.swing.JFrame {

    
    public home() {
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        setSize(1000, 1000);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        jPanel1.setVisible(false);
        jPanel5.setVisible(false);
        
       ImageIcon ic2 = new ImageIcon("src/my_uploads/barbie.jpg");
       Image img1 = ic2.getImage().getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic3 = new ImageIcon(img1);
       jLabel7.setIcon(ic3);
       
       ImageIcon ic4 = new ImageIcon("src/my_uploads/oppenheimer.jpg");
        img1 = ic4.getImage().getScaledInstance(jLabel2.getWidth(), jLabel12.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic5 = new ImageIcon(img1);
       jLabel12.setIcon(ic5);
       
       ImageIcon ic6 = new ImageIcon("src/my_uploads/friends.jpg");
       img1 = ic6.getImage().getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic7 = new ImageIcon(img1);
       jLabel9.setIcon(ic7);
       
       ImageIcon ic8 = new ImageIcon("src/my_uploads/avengers.jpg");
       img1 = ic8.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic9 = new ImageIcon(img1);
       jLabel3.setIcon(ic9);
       
       ImageIcon ic10 = new ImageIcon("src/my_uploads/avatar.jpg");
       img1 = ic10.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic11 = new ImageIcon(img1);
       jLabel5.setIcon(ic11);
       
       ImageIcon ic12 = new ImageIcon("src/my_uploads/frozen.jpg");
       img1 = ic12.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic13 = new ImageIcon(img1);
       jLabel4.setIcon(ic13);
       
       ImageIcon ic14 = new ImageIcon("src/my_uploads/awake.jpg");
       img1 = ic14.getImage().getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic15 = new ImageIcon(img1);
       jLabel10.setIcon(ic15);
       
       ImageIcon ic16 = new ImageIcon("src/my_uploads/aquaman.jpg");
       img1= ic16.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic17 = new ImageIcon(img1);
       jLabel6.setIcon(ic17);
       
       ImageIcon ic18 = new ImageIcon("src/my_uploads/megan.jpg");
       img1 = ic18.getImage().getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic19 = new ImageIcon(img1);
       jLabel8.setIcon(ic19);
       
       ImageIcon ic20 = new ImageIcon("src/my_uploads/rocky_rani.jpg");
       img1 = ic20.getImage().getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ic21 = new ImageIcon(img1);
       jLabel13.setIcon(ic21);
       
       
        String un = global.un;
        jLabel11.setText(un);
        
        String ue = global.ue;
        
        String adds = global.adds;
        
        String pho = global.pho;
        
        
        ImageIcon ic=new ImageIcon(pho);
               Image img=ic.getImage().getScaledInstance(jButton10.getWidth(), jButton10.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon ic1 = new ImageIcon(img);
               
        jButton10.setIcon(ic1);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("MORE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 80, 90, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(310, 30, 270, 40);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 204, 204));
        jButton3.setText("SEARCH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(380, 80, 110, 40);

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 204, 204));
        jButton4.setText("EXPLORE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(300, 230, 110, 40);

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 204, 204));
        jButton5.setText("EXPLORE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(300, 500, 110, 40);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        jButton1.setText("SEARCH MOVIE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 20, 120, 25);

        jButton6.setText("SEARCH TV SHOW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(30, 60, 140, 25);

        jButton7.setText("SEARCH ACTOR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(30, 100, 130, 25);

        jButton8.setText("SEARCH MOVIE HOUSE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(10, 140, 170, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(110, 20, 190, 190);

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TOP TRENDING");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 230, 150, 50);

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOP UP COMING");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 500, 160, 50);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(490, 10, 170, 180);

        jLabel7.setText("jLabel3");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 10, 140, 180);

        jLabel8.setText("jLabel3");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(160, 10, 150, 180);

        jLabel9.setText("jLabel3");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(320, 10, 160, 180);

        jLabel12.setText("jLabel12");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(673, 10, 160, 180);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 290, 840, 200);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(null);

        jLabel4.setText("jLabel4");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(170, 10, 160, 190);

        jLabel5.setText("jLabel4");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 10, 150, 190);

        jLabel6.setText("jLabel4");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(510, 10, 150, 190);

        jLabel10.setText("jLabel4");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(340, 10, 160, 190);

        jLabel13.setText("jLabel13");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(670, 10, 160, 190);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 560, 840, 210);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(null);

        jButton10.setText("profile photo");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10);
        jButton10.setBounds(30, 10, 140, 170);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(30, 186, 140, 30);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(590, 30, 200, 220);

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setForeground(new java.awt.Color(204, 204, 204));
        jButton9.setText("SETTING");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(800, 30, 100, 30);

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setForeground(new java.awt.Color(204, 204, 204));
        jButton11.setText("LOGOUT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(15, 10, 80, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
top_upcoming obj= new top_upcoming();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

              top_trending obj= new top_trending();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
search_movie obj=new search_movie();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
search_tv_shows obj=new search_tv_shows();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
search_actor obj=new search_actor();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
Movie_house obj=new Movie_house();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       User_Edit_Profile obj=new User_Edit_Profile();
       obj.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    int check = 0;
    int flag = 0;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(check == 0){
            jPanel1.setVisible(true);
            
            flag = 1;
        }
        
        if(check == 1){
            jPanel1.setVisible(false);
            flag = 0;
        }
        
        if(flag == 0){
            check = 0;
        }
        
        if(flag == 1){
            check = 1;
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    int check2 = 0;
    int flag2 = 0;
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
        if(check2 == 0){
            jPanel5.setVisible(true);
            flag2 = 1;
        }
        
        if(check2 == 1){
            jPanel5.setVisible(false);
            flag2 = 0;
        }
        
        if(flag2 == 0){
            check2 = 0;
        }
        
        if(flag2 == 1){
            check2 = 1;
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        User_Login obj = new User_Login();
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 String ans=jTextField1.getText();
              ans = ans.replaceAll(" ", "%20");
            
            System.out.println(ans);
        //String ans = jTextField1.getText();
  
  multisearch obj = new multisearch(ans);
obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
