#!/usr/bin/perl -w
use strict;
use warnings;

#Found from https://www.perlmonks.org/?node_id=336331 with no real useful java (or any) language equivalent?

my $search_word = shift or die "search word required\n";

print "Starting..\n";

print "Deleted old report..";
unlink 'report.txt';

open(my $fh, '>', 'report.txt');

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

print "Done!\n";
