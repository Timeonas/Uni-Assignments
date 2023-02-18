#!/bin/bash
#argument 0 is ./create.sh

message0="ok: user created!"
if [ $# -eq 0 ]; then   #if the number af arguments are equal to zero
 	echo "nok: no identifier provided" >&2 #error message
 	exit 1 #exit program
 else 
 	id="$1"
 	directory="../Bashbook/$1"
 	if [ ! -d "$directory" ]; then #if directory of same name not already created then create directory
 
 	
 		cd ..
 		cd Bashbook
 		mkdir "$1" #create directory
 		cd $1
 		touch "friends.txt"
 		echo "$1" >> friends.txt
 		touch "wall.txt"
 		cd ..
 		cd ..
 		cd Scripts
 		echo "ok: user created!"
 		
 	else
 		echo "nok: user already exists" 
 		
 	fi
 fi
