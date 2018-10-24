# Explanation

What we currently have is a function that will duplicate a given key phrase as many times as the length of the cipher text is. For  example:

* word we think is in plain text: crypto  
```
ciphertext: iqwyuhgveduqwvdqw
key: cryptocryptocrypt
```

It then processes the result of taking a Vigenere cipher with the ciphertext and the key. 

* Unfortunately  instead of writing it as a decryptor, it was written as an encryptor, which would possibly be a problem. 

* From there, it will generate n amount of files were n is the length of the word we think is in plain text. Those files are the result of shifting the key (cryptocryptocrypt) by one to the right until it comes full circle. The current task is to search through the output files and find words or parts of words that would give us some sort of idea about the plain text.

Elena noted quite often that we may only get parts of the key that match up with words, and also may not get a complete word either.
