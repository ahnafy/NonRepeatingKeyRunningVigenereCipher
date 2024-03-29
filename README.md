# NON REPEATING KEY VIGENERE CIPHER

## Goals:
Your goal is to attempt to break the following text encrypted using the running key cipher. While you might not be able to decrypt the entire text, you may be able to identify likely words or gain other partial information about the encrypted text and/or the key. Your answer for this problem should contain all approaches that you used (with reasons why you think they might work) and any partial guesses about the plaintext and the key, with justification. 

## Our Solution:
We have a function that will duplicate a given key phrase as many times as the length of the cipher text is. For  example:

* word we think is in plain text: crypto  
```
ciphertext:   iqwyuhgveduqwvdqw
key:          cryptocryptocrypt
--------------------------------
              ideally this will then cancel out to be english words
```
From here it gets difficult, because the deciphered text may or may not be fully intact (we could get just parts of it). So to assist in finding english words, we have two suplimentary scripts to:
* search the massive result of the running key with our constructed keystream agaisnt a dictionary on the system
* clean up the results 

For this, we made assumptions that words under 3 characters will generally be unhelpful, so our generated reports after running both scripts only include full words (no periods or anything) and are four or more letters.

We ran our two scripts a few times on a multitude of different 'buzzwords' we think would fit the definition of being related to our class material, such as:
 * cipher
 * cryptopgraphy
 * cryptanalyzsis
 * decryption
 * encryption
 * stream
 * vigenere
 * bruteforce
 
We then have a compiled file including all those words, which we skimmed to see if some were more 'english' than the others, and compiled a list of possible words.

# Location & Use of files
We first have a dictionary that we used which is included in linux ```/usr/share/dict/words``` and compared against that for all tests

Next we have a folder that will be generated upon running RunningKeyCipher.java called `output`. Inside of output are folders with the name of the word we think, and inside of that folder is text files with the key but it is shifted `n` times to the right.

From there, we begin to run scripts, located in the `etc` folder.

# How to run Scripts
* !!Must be able to run bash and perl scripts on machine!!
* Open a terminal
* CD to CryptoLab2/etc/
* To run the script, execute the following
```./find_word.pl name_of_file < name_of_file.txt; ./trim.sh name_of_file``` 
* !!It should be noted that the files you are running these scripts on must be in the same folder (CryptoLab2/etc)!!
* The first script (find_word.pl) will run and perform a search against a dictionary of the output file(s)
* The second (trim.sh) will clean up the results into something nice we can look at

All the different outputs are in the output folder.

# Words we think we found (only a few examples) 
* In encryption7.txt (shifted 8)
also
-ding
fading
four
span

* In cipher0.txt (shifted 1)
care
pick
ware

* In cryptography0.txt (shifted 1)
bill
quit

* In vigenere0.txt (shifted 1)
bail
eight

* In bruteforce0.txt (shifted 1)
fame
draw
song 
bird 
wine

* In bruteforce1.txt (shifted 2)
held 
love 
sort

### To see all the different 4 or more lettered dictionary words that were found running against the 'buzzwords' of our choice: 
``` cd inside the directory output and the files are labelled with a *trimmed.txt ```




