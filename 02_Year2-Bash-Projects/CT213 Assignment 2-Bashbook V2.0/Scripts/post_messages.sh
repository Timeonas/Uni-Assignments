#!/bin/bash
if [ $# -ge 3 ]; then 
 	sender="$1"
 	receiver="$2"
 	if [ ! -d "../Bashbook/$sender" ]; then 
	 	echo "nok: user $sender does not exist" 
	 	
	else
		if [ ! -d "../Bashbook/$receiver" ]; then  check
	 		echo "nok: user $receiver does not exist" 
	 		
	 	else 
	 		if grep "^$sender" ../Bashbook/"$receiver"/friends.txt >/dev/null; then
	 			shift 
	 			shift
	 			message="$@" 
	 			echo ".$sender: $message" >> "../Bashbook/$receiver/wall.txt" 
	 			echo "ok: message posted!"
	 			
	 		else
	 			echo "nok: user $sender is not a friend of $receiver"  
	 			
			fi
		fi
	fi	
else
	exit 1
fi
