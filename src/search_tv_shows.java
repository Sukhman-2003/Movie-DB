
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
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


public class search_tv_shows extends javax.swing.JFrame {

    /**
     * Creates new form search_tv_shows
     */
    public search_tv_shows() {
        initComponents();
        setSize(1000,700);
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

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 90, 490, 40);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 150, 90, 30);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 190, 910, 420);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(50, 30, 59, 25);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEARCH TV SHOWS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 20, 300, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try
        {
            int x = 10;
            jPanel1.removeAll();
            String tv=jTextField1.getText();
            
            
            String ans = MyClient.searchTVShow(tv);
            System.out.println(ans);
            String api = "980d96176457a6e65b8bc282bcadccd4";
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/tv?api_key=" + api + "&language=en-US&page=1&query=" + tv + "&include_adult=false").asString();

            tv= tv.replaceAll(" ","%20" );

            
            JSONObject mainobj = new JSONObject(ans);
            JSONArray arr = mainobj.getJSONArray("results");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject subobj = (JSONObject) arr.get(i);
                upcoming_design obj = new upcoming_design();


            
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
                if (poster_path.equals("null"))
                {
                    continue;
                }
                
                try 
                {
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
                    } if (overview.equals("null"))
                {
                    continue;
                }
                
                    

                obj.jTextArea1.setText(overview);
                int id = Integer.parseInt(subobj.get("id").toString());

                String ans1 = MyClient.Check_button_tv(id);

                if (ans1.equalsIgnoreCase("success")) {
                    obj.jButton1.setText("ADDED");
                } else {
                    obj.jButton1.setText("ADD");
                }

                obj.jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       String res= MyClient.add_fav_tvshows(id);
                        if (res.equalsIgnoreCase("fail")) {
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
            jPanel1.setPreferredSize(new Dimension(290*arr.length(),390));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        home obj= new home();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(search_tv_shows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search_tv_shows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search_tv_shows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search_tv_shows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_tv_shows().setVisible(true);
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
