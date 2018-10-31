#!/usr/bin/bash

NAME="$1_report.txt";

# This function reduces all the words with '.' in it as we are condisering word with no period only of importance to us
grep -v '\.' "$1_report.txt" > "$1 trimmed.txt"; rm "$1_report.txt"


