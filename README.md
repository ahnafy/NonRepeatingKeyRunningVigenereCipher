# Explanation

What we currently have is a function that will duplicate a given key phrase as many times as the length of the cipher text is. For  example:

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
 
We then have a compiled file including all those words, which we skimmed to see if some were more 'english' than the others, and compiled a list of possible words.

# Location & Use of files
We first have a dictionary that we used which is included in linux ```/usr/share/dict/words``` and compared against that for all tests

Next we have a folder that will be generated upon running RunningKeyCipher.java called `output`. Inside of output are folders with the name of the word we think, and inside of that folder is text files with the key but it is shifted `n` times to the right.

From there, we begin to run scripts, located in the `etc` folder.

Step one is to run find_word.pl with the first argument being the text resulting from running RunningKeyCipher (the stuff in the output/<word> folder). Once that finishes, it will produce a file called report.txt which is a usable, but messy, result of searching against the dictionary. To get it into a more easier-to-read and helpful format, we run it through the next script.

Step two is optional, but helpful. You can put the results from step one into this script to have all the . removed from it.

# Words we think we found
* <word> in <file>
* brass in cipher1.txt
