#!/bin/bash
if [ $# -eq 2 ]; then  #if number of arguments is equal to two then run code
	id="$1" #id is equal to argument one
 	friend="$2" #friend is equal to argument two
	if [ ! -d "../Bashbook/$id" ]; then #if the person who is trying to add a friend does not exist then print error i.e. if directory $iddoesnt exist
	 	echo "nok: user $id does not exist" >&2
	 	exit 1
	else
	 	if [ ! -d "../Bashbook/$friend" ]; then #if person who is being added does not exist then print error i.e. if directory $friend doesnt exist
	 		echo "nok: user $friend does not exist" >&2
	 		exit 1
	 	else
	 		if grep "^$friend" ../Bashbook/"$id"/friends.txt > /dev/null; then #if $friend string variable is in file ../Bashbook/"$id"/friends.txt 
	 			exit 1 #i.e. checks if fiend is already added
	 		else
	 			echo "$friend" >> "../Bashbook/$id/friends.txt" #ammends $friend to friends.txt file of $id
	 			#Symmetrical friendship
	 			echo "$id" >> "../Bashbook/$friend/friends.txt" #ammends $idto friends.txt file of $friend
	 			echo "ok: friend added!"
	 			exit 0
	 		fi
	 	fi
	 fi
else
	exit 1
fi