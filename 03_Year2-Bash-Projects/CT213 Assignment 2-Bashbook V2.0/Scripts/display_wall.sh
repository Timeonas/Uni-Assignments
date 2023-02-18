#!/bin/bash

if [ $# -eq 1 ]; then  #if number of arguemtns is equal to one
	id="$1"
	if [ ! -d "../Bashbook/$id" ]; then #checks directory valididty
	 	echo "nok: user $id does not exist" 
	 	
	else
		echo "start_of_file" #signals beginning of wall in terminal
		message=`cat "../Bashbook/$id/wall.txt"`
		echo "$message" 
		echo "end_of_file" #signals end of wall in terminal
		
	fi
		
else
	echo wrong arguments
	
fi
