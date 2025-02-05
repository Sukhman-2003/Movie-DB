
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class search_actor extends javax.swing.JFrame {

    /**
     * Creates new form search_actor
     */
    public search_actor() {
        initComponents();
          setSize(950, 700);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static BufferedImage scale(BufferedImage src, int w, int h) {
        BufferedImage img
                = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++) {
            ys[y] = y * hh / h;
        }
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEARCH ACTOR ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 30, 240, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(240, 100, 470, 40);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 160, 150, 40);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 220, 870, 410);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 20, 59, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code h  
try
        {
            int x = 10;
            jPanel1.removeAll();
              String actor=jTextField1.getText();
              actor = actor.replaceAll(" ", "%20");
            String ans = MyClient.searchActor(actor);
            System.out.println(ans);
            

            JSONObject mainobj = new JSONObject(ans);
            JSONArray arr = mainobj.getJSONArray("results");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject subobj = (JSONObject) arr.get(i);
                JSONArray subarr = subobj.getJSONArray("known_for");
                
                for(int j=0;j< subarr.length(); j++){
                    upcoming_design obj = new upcoming_design();
                    
                    JSONObject subsubobj = (JSONObject) subarr.get(j);
                    
                    
//                    JSONObject subsubobj = (JSONObject) arr.get(j);
//                    JSONArray subarr = subobj.getJSONArray("known_for");

            
             String title = "";
                if (subsubobj.has("title")) {
                    title = subsubobj.get("title").toString();
                  obj.jLabel1.setText(title);
//
//
                }
                if (subsubobj.has("name")) {
                    title = subsubobj.get("name").toString();
                     obj.jLabel1.setText(title);

//
                }
//
                String release_date = "";
                if (subsubobj.has("release_date")) {
                    release_date = subsubobj.get("release_date").toString();
                     obj.jLabel4.setText(release_date);
                     
                     
                     
                     
//
                }
                if (subsubobj.has("first_air_date")) {
                    release_date = subsubobj.get("first_air_date").toString();
                    obj.jLabel4.setText(release_date);
//
//
                }
                String poster_path = subsubobj.get("poster_path").toString();
                if (poster_path.equals("null"))
                {
                    continue;
                }
//                
//                
                try {
                    BufferedImage bi = ImageIO.read(new URL("https://image.tmdb.org/t/p/w200" + poster_path));

                    bi = scale(bi, 180, 150);

                    obj.jLabel2.setIcon(new ImageIcon(bi));
                    

                } catch (Exception e) {
                    e.printStackTrace();
            }

             String overviewString = subsubobj.get("overview").toString();
              String overview = "";
                    String[] n = overviewString.split("(?<=\\G.{" + 39 + "})");
                    for (String string : n) {
                        overview += string + " " + "\n" + " ";
                    }
                obj.jTextArea1.setText(overview);
                int id = Integer.parseInt(subsubobj.get("id").toString());

                String ans1 = MyClient.Check_button(id);

                if (ans1.equalsIgnoreCase("success")) {
                    obj.jButton1.setText("ADDED");
                } else {
                    obj.jButton1.setText("ADD");
                }

                obj.jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MyClient.add_fav_movies(id);
                        if (ans.equalsIgnoreCase("fail")) {
                            obj.jButton1.setText("ADD");
                        } else {
                            obj.jButton1.setText("ADDED");
                        }

                    }
                });


                obj.setBounds(x, 10, 270, 380);
                x = x + 290;
                jPanel1.add(obj);
                jPanel1.repaint();
                obj.repaint();
                

               System.out.println(title);
                System.out.println(poster_path);
                System.out.println(release_date);
                System.out.println(overview);
                System.out.println("--------------------------------------------------------------------------------------------------");
                
                }

            }
            jPanel1.setPreferredSize(new Dimension(290*arr.length(),420));
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       home obj= new home();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**.
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
            java.util.logging.Logger.getLogger(search_actor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search_actor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search_actor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search_actor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_actor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
