#!/usr/bin/bash

NAME="$1_report.txt";

grep -v '\.' "$1_report.txt" > "$1 trimmed.txt"; rm "$1_report.txt"


