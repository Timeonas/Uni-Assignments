#!/bin/bash

if [ $# -eq 0 ]; then   #if the number af arguments are equal to zero
 	echo "nok: no identifier provided" >&2 #error message
 	exit 1 #exit program
 else 
 	id="$1"
 	directory="../Bashbook/$id"
 	if [ ! -d "$directory" ]; then #if directory of same name not already created then create directory
 		cd "../Bashbook"
 		mkdir "$id" #create directory
 		cd "$id" #enter new directory
 		touch "friends.txt"#create friends.txt and wall.txt within that directory
 		touch "wall.txt"
 		echo "ok: user created!"
 		exit 0 
 	else
 		echo "nok: user already exists" >&2
 		exit 1
 	fi
 fi