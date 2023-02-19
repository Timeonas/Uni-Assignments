#!/bin/bash

if [ $# -eq 1 ]; then  #if number of arguemtns is equal to one
	id="$1"
	if [ ! -d "../Bashbook/$id" ]; then #checks directory validity
	 	echo "nok: user $id does not exist" >&2
	 	exit 1
	else
		echo "start_of_file" #signals beginning of wall in terminal
		cat "../Bashbook/$id/wall.txt" #prints wall.txt of user specified in argument
		echo "end_of_file" #signals end of wall in terminal
		exit 0
	fi
		
else
	exit 1
fi