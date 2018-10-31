#!/usr/bin/perl -w
use strict;
use warnings;

#Found from https://www.perlmonks.org/?node_id=336331 with no real useful java (or any) language equivalent?
# We learned basic perl syntax and made tweaks to adjust to what we required and we then feed the output to trim.sh that we wrote.

#Variable init
my $start_time = time();
my $end_time;
print "Starting..\n";

#Read from standard input
my $search_word = <STDIN>;
chomp($search_word);


#Create a file called 'report.txt' unfortunately 
open(my $fh, '>', $ARGV[0] . "_report.txt");

my @words = ();
open WORDS, "/usr/share/dict/words" or die "can't open words file\n";
while (<WORDS>) {
    	chomp;
	if(length > 3)
	{
		print $fh "\n", $_ if $search_word =~ /$_/i;
	}
}
close WORDS;
close $fh;


$end_time = time() - $start_time;
print "Done in $end_time seconds.\n";
