
import com.mashape.unirest.http.*;
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

public class top_trending extends javax.swing.JFrame {

    public top_trending() {
        initComponents();
        setSize(1000, 700);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        getTopTrending();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    void getTopTrending() {
        try {
            int x = 10;
            jPanel1.removeAll();

            String ans = MyClient.topTrending();
            System.out.println(ans);

            JSONObject mainobj = new JSONObject(ans);
            JSONArray arr = mainobj.getJSONArray("results");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject subobj = (JSONObject) arr.get(i);

                Top_Trending_Design obj = new Top_Trending_Design();

                String title = "";
                if (subobj.has("title")) {
                    title = subobj.get("title").toString();

                    obj.jLabel1.setText(title);
                }
                if (subobj.has("name")) {
                    title = subobj.get("name").toString();
                    obj.jLabel1.setText(title);
                }

                String release_date = "";
                if (subobj.has("release_date")) {
                    release_date = subobj.get("release_date").toString();
                    obj.jLabel4.setText(release_date);
                }
                if (subobj.has("first_air_date")) {
                    release_date = subobj.get("first_air_date").toString();
                    obj.jLabel4.setText(release_date);
                }

                String poster_path = subobj.get("poster_path").toString();

                try {
                    BufferedImage bi = ImageIO.read(new URL("https://image.tmdb.org/t/p/w200" + poster_path));

                    bi = scale(bi, 180, 150);

                    obj.jLabel2.setIcon(new ImageIcon(bi));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String overviewString = subobj.get("overview").toString();
                
                String overview = "";
                    String[] n = overviewString.split("(?<=\\G.{" + 39 + "})");
                    for (String string : n) {
                        overview += string + " " + "\n" + " ";
                    }

                obj.jTextArea1.setText(overview);

                int id = Integer.parseInt(subobj.get("id").toString());

                String ans1 = MyClient.Check_button(id);

                if (ans1.equalsIgnoreCase("success")) {
                    obj.jButton1.setText("ADDED");
                } else {
                    obj.jButton1.setText("ADD");
                }

                obj.jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         String res = MyClient.add_fav_movies(id);
                        if (res.equalsIgnoreCase("fail")) {
                            obj.jButton1.setText("ADD");
                        } else {
                            obj.jButton1.setText("ADDED");
                        }

                    }
                });

                obj.setBounds(x, 10, 270, 400);
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
            jPanel1.setPreferredSize(new Dimension(290 * arr.length(), 400));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOP TRENDING");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 20, 300, 50);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 120, 870, 460);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 20, 65, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       home obj = new home ();
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(top_trending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(top_trending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(top_trending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(top_trending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new top_trending().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
