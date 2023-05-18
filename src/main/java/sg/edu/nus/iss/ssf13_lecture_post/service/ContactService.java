package sg.edu.nus.iss.ssf13_lecture_post.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import sg.edu.nus.iss.ssf13_lecture_post.model.Contact;

@Service
public class ContactService {
    
    public void save(Contact contact, Model model, String dataDir) {

        try {
            String dirPathFileName = dataDir + File.separator + contact.getId();
            File newFile = new File(dirPathFileName);

            if (newFile.exists()) {
                System.out.println("File already exists");
                return;
            }

            newFile.createNewFile();

            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(contact.getName());
            bw.newLine();
            bw.write(contact.getEmail());
            bw.newLine();
            bw.write(contact.getTelNo());
            bw.newLine();
            bw.write(contact.getDateOfBirth().toString());

            bw.flush();
            bw.close();
            fw.close();

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public void getAllContactsInURL(Model model, String dataDir) {

        Set<String> dataFiles = listFiles(dataDir);

        Set<String> modifiedFiles = new HashSet<String>();

        for(String file : dataFiles){
            String modifiledFile = file.replace(".txt", "");
            modifiedFiles.add(modifiledFile);
        }

        model.addAttribute("contacts", modifiedFiles.toArray(new String[dataFiles.size()]));
    }
    
    
    private Set<String> listFiles(String dataDir) {

       return Stream.of(new File(dataDir).listFiles()).filter(file -> !file.isDirectory()).map(File :: getName).collect(Collectors.toSet());
    }

    public Contact getContactById(String contactId, String dataDir) {

        Contact contact = new Contact();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Path filePath = new File(dataDir + "/" + contactId).toPath();
        System.out.println("-----> " + filePath);

        Charset charset = Charset.forName("UTF-8");
        List<String> stringList = new ArrayList<>();

        try {
            stringList = Files.readAllLines(filePath, charset);

            contact.setId(contactId);
            contact.setName(stringList.get(0));
            contact.setEmail(stringList.get(1));
            contact.setTelNo(stringList.get(2));
            LocalDate dob = LocalDate.parse(stringList.get(3), formatter);
            contact.setDateOfBirth(dob);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return contact;
    }
}
