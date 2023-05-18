package sg.edu.nus.iss.ssf13_lecture_post.utility;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class Utility {
    
    public boolean isUniqueEmail(String email) {

        return true;
    }

    public static void createDir(String dirPath) {

        File newDir = new File(dirPath);

        if (!newDir.exists()) {
            newDir.mkdir();
        }
    }
}
