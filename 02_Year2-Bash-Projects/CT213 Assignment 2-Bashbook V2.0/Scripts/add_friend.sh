#!/bin/bash

if [ $# -eq 2 ]; then  #if number of arguments is equal to two then run code
	id="$1" #id is equal to argument one
 	friend="$2" #friend is equal to argument two
	if [ ! -d "../Bashbook/$id" ]; then 
	 	echo "nok: user $id does not exist"
	 	
	else
	 	if [ ! -d "../Bashbook/$friend" ]; then 
	               
	 		echo "nok: user $friend does not exist" 
	 		
	 	else
	 		if grep "^$friend" ../Bashbook/"$id"/friends.txt > /dev/null; then 
	 		echo "These two users are already friends"
	 		else
	 		chmod u+x add_friend.sh
	 		        cd ..
	 		        cd Bashbook
	 		        cd $id
	 			echo "$friend" >> "friends.txt" 
	 			 cd ..
	 			 cd $friend 
	 			 echo "$id" >> "friends.txt"
	 			cd ..
	 			cd ..
	 			cd Scripts
	 			echo "ok: friend added!" 
	 			
	 		fi
	 	fi
	 fi
else
	exit 1
	
fi
