/**
 * Purpose: The purpose of the code is to while loops and if statements alongside ASCII to print out randomly generated passwords
 * based on the user's option choice and password length. The code also makes use of reading and writing to files.
 *
 * @author Briana Berger
 * @version 01/09/2018
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
public class SecretPasscodes
{
    public static void main(String []args) throws IOException
    {
        Random r = new Random();
        File myFile = new File ("hello.txt");
        PrintWriter outFile = new PrintWriter(myFile);
        Scanner in = new Scanner(System.in);
        Scanner inFile = new Scanner(myFile);
        
        String password = "";
        int option = 0;
        int count = 0;
        String randomCharacter = "";
        int userPasswordLength = 0;
        int passwordLength = 0;
        int randomNumber = 0;
        
        System.out.println("                     Password Generator Menu                     ");
        System.out.println("*****************************************************************");
        System.out.println("*    [1] Lowercase Letters                                      *");
        System.out.println("*    [2] Lowercase Letters & Numbers                            *");
        System.out.println("*    [3] Lowercase Letters & Uppercase Letters                  *");
        System.out.println("*    [4] Lowercase, Uppercase, & Numbers                        *");
        System.out.println("*    [5] Quit                                                   *");
        System.out.println("*****************************************************************");    
    
        System.out.print("Enter Selection (1-5): ");
        option = in.nextInt();
        
        while(option != 5)
        {
            while(option < 0 || option > 5)
            {
                System.out.println("Invalid option choice. Please try again.");
                System.out.print("Enter Selection (1-5): ");
                option = in.nextInt();
            }
            System.out.print("Password Length (6 or more): ");
            userPasswordLength = in.nextInt();
            while(userPasswordLength < 6)
            {
                System.out.println("Invalid password length. Please try again.");
                System.out.print("Password Length (6 or more): ");
                userPasswordLength = in.nextInt();
            }
            
            //Option 1
            if (option == 1)
            {
                while (passwordLength < userPasswordLength)
                {
                    randomNumber = r.nextInt(122);
                    if(randomNumber >= 97 && randomNumber <= 122)
                    {
                        //Determines if random number is a lowercase letter
                        randomCharacter = Character.toString((char) randomNumber);
                        password += randomCharacter;
                        passwordLength = password.length();
                    }
                }
            }
            
            //Option 2
            if (option == 2)
            {
                while (passwordLength < userPasswordLength)
                {
                    randomNumber = r.nextInt(122);
                    if((randomNumber >= 97 && randomNumber <= 122) || (randomNumber >= 48 && randomNumber <= 57))
                    {
                        //Determines if random number is a lowercase letter
                        randomCharacter = Character.toString((char) randomNumber);
                        password += randomCharacter;
                        passwordLength = password.length();
                    }
                }
            }
            
            //Option 3
            if (option == 3)
            {
                while (passwordLength < userPasswordLength)
                {
                    randomNumber = r.nextInt(122);
                    if((randomNumber >= 97 && randomNumber <= 122) || (randomNumber >= 65 && randomNumber <= 90))
                    {
                        //Determines if random number is a lowercase letter
                        randomCharacter = Character.toString((char) randomNumber);
                        password += randomCharacter;
                        passwordLength = password.length();
                    }
                }
            }
            
            //Option 4
            if (option == 4)
            {
                while (passwordLength < userPasswordLength)
                {
                    randomNumber = r.nextInt(122);
                    if((randomNumber >= 97 && randomNumber <= 122) || (randomNumber >= 65 && randomNumber <= 90) || (randomNumber >= 48 && randomNumber <= 57))
                    {
                        //Determines if random number is a lowercase letter
                        randomCharacter = Character.toString((char) randomNumber);
                        password += randomCharacter;
                        passwordLength = password.length();
                    }
                }
            }
            
            outFile.println(password);
            passwordLength = 0;
            password = "";
            
            System.out.println();
            System.out.print("Enter Selection (1-5): ");
            option = in.nextInt();
        }
        
        outFile.close();
        
        System.out.println();
        System.out.println("Thank you for using the Passcode Generator.");
        System.out.println();
            
        System.out.println("Here are your randomly generated codes:");
        while(inFile.hasNextLine())
        {
            count++;
            System.out.println("  " + count + "         " + inFile.nextLine());
        }
    }
}
