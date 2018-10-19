import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class RunningKeyCipher
{
    //Dictionary
    //Less likely to result in complete matches in long words
    //It might match in short words
    //Matches on parts of words


    public static String shiftString(String text)
    {
        //Put the string into an array of characters
        char[] buffer = text.toCharArray();

        //Save the last element (to be put into the first position)
        char lastElement = buffer[text.length() - 1];

        //Copy the array buffer at position 0 to the array buffer at position 1 until the end of the buffer
        System.arraycopy(buffer, 0, buffer, 1, buffer.length - 1);

        //Set the first element equal to the last
        buffer[0] = lastElement;

        String result = "";

        //Add all the characters to a string
        for(int i = 0; i < buffer.length; i++)
        {
            result += buffer[i];
        }

        //Return string;
        return result;
    }

    //Vigenère cipher from Lab 1
    public static String encrypt(String text, String key)
    {
        String result = "";

        for(int i = 0; i < text.length(); i++)
        {
            //Add the text together and 'wrap' it back around to stay in our range.
            result += (char)(((text.charAt(i) + key.charAt(i % key.length())) - 97 * 2) % 26 + 97);
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        //Create readers for the needed inputs
        Scanner keyboardInput = new Scanner(System.in);
        Scanner fileInput = new Scanner(new File("ciphertext.txt"));

        //Init variable for creating a 'key stream' out of the word looped x times plus a remainder
        String loopingkey = "";

        //Get the cipher text from ciphertext.txt (this is done to avoid massively large strings in the editor)
        String ciphertext = fileInput.nextLine();

        //Prompt users for input
        System.out.println("Enter the word you think exists in the text:");

        //Get word input from user
        String word = keyboardInput.nextLine();

        //Repeat the whole string as many times as possible into loopingkey
        for(int i = 0; i < Math.floor(ciphertext.length()/word.length()); i++)
        {
            loopingkey += word;
        }

        //Add the last fragments where we couldn't put in a whole word
        for(int i = 0; i < ciphertext.length() % word.length(); i++)
        {
            loopingkey += word.charAt(i);
        }

        //Run (and output) the results for each shifted keyword to attempt to find things that cancel
        for(int i = 0; i < word.length(); i++)
        {
            //Shift the key over once
            loopingkey = shiftString(loopingkey);

            try
            {
                PrintWriter writer = new PrintWriter(word + Integer.toString(i) + ".txt", "UTF-8");

                String a = encrypt(ciphertext, loopingkey);

                writer.println(a);
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
            }

        }

        //From here on out, we need to find a way to run our string through a dictionary and find real words in it.
        //https://www.perlmonks.org/?node_id=336331
    }
}
