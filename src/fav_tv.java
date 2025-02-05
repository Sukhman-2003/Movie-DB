
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.JSONObject;


public class fav_tv extends javax.swing.JFrame {

  
    public fav_tv() {
        initComponents();
        setSize(900, 700);        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        show_fav_tvshows();

    }
    void show_fav_tvshows() {
        String ans = MyClient.show_fav_tvshows();
        System.out.println(ans);

        int x = 10;
        StringTokenizer st = new StringTokenizer(ans, ";");
        int count = st.countTokens();
        String api = "980d96176457a6e65b8bc282bcadccd4";
        for (int i = 0; i < count; i++) {

            int id = Integer.parseInt(st.nextToken());

            try {

                HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/tv/" + id + "?api_key=" + api + "&language=en-US").asString();
                if (response.getStatus() == 200) {
                    String body = response.getBody();

                    JSONObject mainobj = new JSONObject(body);
                    

                    upcoming_design obj = new upcoming_design();

                    String title = "";
                    if (mainobj.has("title")) {
                        title = mainobj.get("title").toString();
                        obj.jLabel1.setText(title);

                    }
                    if (mainobj.has("name")) {
                        title = mainobj.get("name").toString();
                        obj.jLabel1.setText(title);

                    }

                    String release_date = "";
                    if (mainobj.has("release_date")) {
                        release_date = mainobj.get("release_date").toString();
                        obj.jLabel4.setText(release_date);

                    }
                    if (mainobj.has("first_air_date")) {
                        release_date = mainobj.get("first_air_date").toString();
                        obj.jLabel4.setText(release_date);

                    }
                    String poster_path = mainobj.get("poster_path").toString();
                    try {
                        BufferedImage bi = ImageIO.read(new URL("https://image.tmdb.org/t/p/w200" + poster_path));

                        bi = scale(bi, 180, 150);

                        obj.jLabel2.setIcon(new ImageIcon(bi));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String overview = mainobj.get("overview").toString();
                    obj.jTextArea1.setText(overview);

                    String ans1 = MyClient.Check_button_tv(id);

                    if (ans1.equalsIgnoreCase("success")) {
                        obj.jButton1.setText("ADDED");
                    } else {
                        obj.jButton1.setText("ADD");
                    }

                    obj.jButton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String res = MyClient.add_fav_tvshows(id);
                            if (res.equalsIgnoreCase("fail")) {
                                obj.jButton1.setText("ADD");
                            } else {
                                obj.jButton1.setText("ADDED");
                            }

                        }
                    });

                    upcoming_design obj1 = new upcoming_design();

                    

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
                jPanel1.setPreferredSize(new Dimension(290 * count, 400));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(27, 108, 810, 430);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("YOUR FAVOURITE TV SHOW");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 20, 520, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(fav_tv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fav_tv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fav_tv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fav_tv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fav_tv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
