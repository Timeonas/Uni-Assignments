#!/bin/bash
if [ $# -ge 3 ]; then #if number of arguments less than 3 than dont run code,we use ge to ensure message is stored correctly
 	sender="$1"
 	receiver="$2"
 	if [ ! -d "../Bashbook/$sender" ]; then #checking if directroy is valid 
	 	echo "nok: user $sender does not exist" >&2
	 	exit 1
	else
		if [ ! -d "../Bashbook/$receiver" ]; then #valid directory check
	 		echo "nok: user $receiver does not exist" >&2
	 		exit 1
	 	else #checks if sender is friends with the receiver then add message to wall.txt of receiver
	 		if grep "^$sender" ../Bashbook/"$receiver"/friends.txt >/dev/null; then
	 			shift #two shifts are used to distinguish the message from the other inputs
	 			shift
	 			message="$@" #after double shift all remaining inpus are assigned to message variable
	 			echo "$sender: $message" >> "../Bashbook/$receiver/wall.txt" #message is added to wall.txt file of reciever
	 			echo "ok: message posted!"
	 			exit 0
	 		else
	 			echo "nok: user $sender is not a friend of $receiver" >&2 #error code if you are not a friend of reciever
	 			exit 1
			fi
		fi
	fi	
else
	exit 1
fi