
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SaveFile {
    static String saveFile(File photo){
        
        
        String abspath = "src/my_uploads";
                String photo_name = photo.getName();
                
                String Whole_Path = abspath +"/"+photo_name;
                try{
                FileInputStream fis = new FileInputStream(photo);
                byte b[] = new byte[100000];
                File f = new File(abspath + "/" + photo_name);
                FileOutputStream fos = new FileOutputStream(f);
                
                int r = fis.read(b,0,b.length);
                
                fos.write(b,0,r);
                
                fos.close();
                fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Whole_Path;
    }
}
