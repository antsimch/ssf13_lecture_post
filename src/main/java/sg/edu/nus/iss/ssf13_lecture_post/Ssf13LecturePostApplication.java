package sg.edu.nus.iss.ssf13_lecture_post;

import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sg.edu.nus.iss.ssf13_lecture_post.utility.Utility;

@SpringBootApplication
public class Ssf13LecturePostApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Ssf13LecturePostApplication.class);

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List<String> opsVal = appArgs.getOptionValues("dataDir");

		System.out.println(opsVal);

		if (opsVal == null) {
			System.out.println("args[0]: directory");
			System.exit(1);
		}

		Utility.createDir(opsVal.get(0));

		SpringApplication.run(Ssf13LecturePostApplication.class, args);
	}
}
