#!/bin/bash
echo "Welcome to Bashbook."
if [ ! -d "../Bashbook" ]; then #Check to see if Bashbook directory exists on Desktop
	mkdir "../Bashbook" #Create the Bashbook database directory on the desktop if it doesnt already exist
	echo "Bashbook database directory created on the Desktop successfully!" #Inform the user
fi
while true; do
	echo  -n "Enter a request: " #new line asks user for request
	read request id1 id2 message #ensures that the arguments are read in the correct format 
	case "$request" in #compares the value of request against each of the four possible commands 
		create)
			if [ "$id1" = "" ]; then # if an invalid number of arguments are entered then individual script create.sh will return an error 
				echo "nok: Bad Request">&2 #the indivudual script files each have their own checks to ensure that the arguemtns are valid
			else #if the user enters the incorrect number of arguments for a command than that script will return an error.
				./create.sh $id1 #create command only needs one argument and so only takes $id1. 
			fi
			;;
		add)
			if [ "$id1" = "" ] || [ "$id2" = "" ]; then
				echo "nok: Bad Request">&2
			else
				./add_friend.sh $id1 $id2 #runs add_friend if all criteria are met
			fi
			;;
		post)
			if [ "$id1" = "" ] || [ "$id2" = "" ] || [ "$message" = "" ] ; then
				echo "nok: Bad Request">&2
			else
				./post_messages.sh $id1 $id2 $message #runs post_messages if all crieteria are met
			fi
			;;
		display)
			if [ "$id1" = "" ]; then
				echo "nok: Bad Request">&2
			else
				./display_wall.sh $id1 #runs display_wall if all criteria are met
			fi
			;;
		*)
			echo "Accepted Commands: {create|add|post|display}" #displays to user which commands are accepted
			exit 1
	esac
done