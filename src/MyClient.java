
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.File;
import java.sql.*;
import vmm_project.DBLoader;
import vmm_project.DBLoader1;

public class MyClient {

    public static String user_sign_up(String username, String useremail, String password, String address, File photo) {
        String ans = "";
        try {
            ResultSet rs = DBLoader1.executeQuery("select * from movie_db.users where useremail='" + useremail + "' ");
            if (rs.next()) {
                ans = "fail";
            } else {
                String whole_path = SaveFile.saveFile(photo);

                rs.moveToInsertRow();
                rs.updateString("username", username);
                rs.updateString("useremail", useremail);
                rs.updateString("password", password);
                rs.updateString("address", address);
                rs.updateString("photo", whole_path);
                rs.insertRow();

                ans = "success";
            }
        } catch (Exception e) {
            return e.toString();
        }
        return ans;
    }

    public static String User_Login(String useremail, String password) {
        ResultSet rs = DBLoader.executeQuery("select * from movie_db.users where useremail='" + useremail + "' and password='" + password + "'");
        try {
            if (rs.next()) {

                global.un = rs.getString("username");

                global.pho = rs.getString("photo");

                global.adds = rs.getString("address");

                global.ue = rs.getString("useremail");

                global.pass = rs.getString("password");

                return ("success");
            } else {
                return ("fail");
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static String topTrending() {

        String api = "980d96176457a6e65b8bc282bcadccd4";

        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/trending/all/day?api_key=" + api).asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return null;
    }

    public static String UpcomingMovies() {
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/movie/upcoming?api_key=" + api + "&language=en-US&page=1")
                    .asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return null;
    }

    public static String searchTVShow(String tv) {
        String api = "980d96176457a6e65b8bc282bcadccd4";

        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/tv?api_key=" + api + "&language=en-US&page=1&query=" + tv + "&include_adult=false").asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return null;
    }

    public static String searchMovie(String movie) {
        String api = "980d96176457a6e65b8bc282bcadccd4";

        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/movie?api_key=" + api + "&language=en-US&query=" + movie + "&page=1&include_adult=false").asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return null;
    }

    public static String searchMovieHouse(String house) {
        String api = "980d96176457a6e65b8bc282bcadccd4";

        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/company?api_key=" + api + "&query=" + house + "&page=1").asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return null;
    }

    public static String searchActor(String actorname) {

        String api = "980d96176457a6e65b8bc282bcadccd4";

        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/person?query=" + actorname + "&include_adult=false&language=en-US&page=1&api_key=" + api).asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return null;
    }

    public static String UserEditProfile(String username, String address) {
        String ans = "";
        try {
            String useremail = global.ue;
            String password = global.pass;

            ResultSet rs = DBLoader.executeQuery("select * from movie_db.users where useremail='" + useremail + "' and password='" + password + "'");
            if (rs.next()) {

                global.adds = address;
                global.un = username;

                rs.updateString("username", username);
                rs.updateString("address", address);
                rs.updateRow();
                ans = "success";

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }

        return null;

    }

    public static String UserChangePassword(String old_password, String new_password) {
        String ans = "";
        try {
            String password = global.pass;
            ResultSet rs = DBLoader.executeQuery("select * from movie_db.users where password='" + old_password + "' ");
            if (rs.next()) {
                rs.updateString("password", new_password);
                global.pass = new_password;
                rs.updateRow();
                ans = "success";

            } else {
                ans = "fail";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return (ans);

    }

    public static String dpedit(File photo) {
        String ans = "";
        try {
            String password = global.pass;
            String useremail = global.ue;
            String ph = SaveFile.saveFile(photo);
            ResultSet rs = DBLoader.executeQuery("select * from movie_db.users where useremail='" + useremail + "' and password='" + password + "'");
            if (rs.next()) {
                rs.updateString("photo", ph);
                global.pho = ph;
                rs.updateRow();
                ans = "success";

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return (ans);

    }

    public static String deleteacc() {
        String ans = "";
        try {
            String password = global.pass;
            String useremail = global.ue;

            ResultSet rs = DBLoader.executeQuery("select * from movie_db.users where useremail='" + useremail + "' and password='" + password + "'");
            if (rs.next()) {

                rs.deleteRow();
                global.adds = "";
                global.pass = "";
                global.pho = "";
                global.ue = "";
                global.un = "";

                ans = "success";

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return (ans);
    }

    public static String add_fav_movies(int id) {
        String ans = "";
        try {

            String useremail = global.ue;

            ResultSet rs = DBLoader.executeQuery("select * from movie_db.fav_movies where UserEmail='" + useremail + "' and ID='" + id + "'");
            if (rs.next()) {
                rs.deleteRow();
                ans="fail";

            } else {
                rs.moveToInsertRow();
                rs.updateInt("id", id);
                rs.updateString("useremail", useremail);

                rs.insertRow();
                ans = "success";
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return (ans);

    }
    public static String Check_button(int id){
        String ans = "";
        try{
            String useremail = global.ue;
              ResultSet rs = DBLoader.executeQuery("select * from movie_db.fav_movies where UserEmail='" + useremail + "' and ID='" + id + "'");
            if (rs.next()) {
                ans="success";
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            
        }
        
        return ans;
    }
    public static String add_fav_tvshows(int id){
         String ans = "";
        try {

            String useremail = global.ue;

            ResultSet rs = DBLoader.executeQuery("select * from movie_db.fav_tvshows where useremail='" + useremail + "' and id='" + id + "'");
            if (rs.next()) {
                rs.deleteRow();
                ans="fail";

            } else {
                rs.moveToInsertRow();
                rs.updateInt("id", id);
                rs.updateString("useremail", useremail);

                rs.insertRow();
                ans = "success";
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return (ans);
        
    }
    
    public static String Check_button_tv(int id){
        String ans = "";
        try{
            String useremail = global.ue;
              ResultSet rs = DBLoader.executeQuery("select * from movie_db.fav_tvshows where useremail='" + useremail + "' and id='" + id + "'");
            if (rs.next()) {
                ans="success";
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            
        }
        
        return ans;
    }
    public static String show_fav_movies(){
        String ans = "";
        try{
            String useremail = global.ue;
              ResultSet rs = DBLoader.executeQuery("select * from movie_db.fav_movies where UserEmail='" + useremail +  "'");
           
               while(rs.next())
               {
                   int id=rs.getInt("id");
                   ans=ans+id+";";
               }
               return ans;
          
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return ans;
        
    }
     public static String show_fav_tvshows(){
        String ans = "";
        try{
            String useremail = global.ue;
              ResultSet rs = DBLoader.executeQuery("select * from movie_db.fav_tvshows where useremail='" + useremail +  "'");
           
               while(rs.next())
               {
                   int id=rs.getInt("id");
                   ans=ans+id+";";
               }
               return ans;
          
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return ans;
        
    }
     public static String searchMulti(String search) {
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try {
            System.out.println("In MyClient "+search);
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/multi?api_key=" + api + "&language=en-US&query=" + search + "&page=1&include_adult=false").asString();
            //System.out.println(response.getBody());
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return null;
    }


}

