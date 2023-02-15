package day08;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _03_FileExist {

    @Test
    public void isExistTest() {

        String userDIR = System.getProperty("user.dir");     //    C:\Users\sevin\IdeaProjects\Maven_JUnit
        System.out.println("userDIR = " + userDIR);

        String userHome = System.getProperty("user.home");       //  C:\Users\sevin
        System.out.println("userHome = " + userHome);

        String filePath = userHome+"\\OneDrive\\Desktop\\logo (1).jpeg";   //"C:\Users\sevin\OneDrive\Desktop\logo (1).jpeg"
        System.out.println("filePath = " + filePath);

        boolean isExist = Files.exists(Paths.get(filePath));
        System.out.println("isExist = " + isExist);

    }
}
