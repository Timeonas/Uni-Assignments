#!/bin/bash

#possibly remove text from file after read?

if [ ! -d "../Bashbook" ]; then 
    mkfifo server_pipe #creates server pipe if bashbook directory does not exist
	mkdir "../Bashbook" 
	mkdir "../Bashbook/test" #creates test user for very first login
	mkdir "../Bashbook/test/friends.txt"
	mkdir ".../Bashbook/test/wall.txt"
	echo "Bashbook database directory created on the Desktop successfully!" 
fi

while true; do
read arg1 arg0 arg2 message < server_pipe #reads in data from the server_pipe


#these echos are just for testing
echo $arg0
echo $arg1
echo $arg2
echo $message

case "$arg1" in 
		create)
			if [ "$arg0" = "" ] || [ "$arg2" = "" ] ; then 
				echo "nok: Bad Request" > "$arg0"_pipe 
			else 
		             output=$(./create.sh "$arg2" "$arg0")#takes output from function and puts it into output variable
				

                                echo $output > "$arg0"_pipe #prints output to pipe
				
				
				 
			fi
			;;
		add)
			if [ "$arg0" = "" ] || [ "$arg2" = "" ]; then
				echo "nok: Bad Request" > "$arg0"_pipe
				
			else
			echo $arg0
			echo $arg2
		             output=$(./add_friend.sh "$arg0" "$arg2") #takes output from function
				echo $output > "$arg0"_pipe
			fi
			;;
		post)
			if [ "$arg0" = "" ] || [ "$arg2" = "" ] || [ "$message" = "" ] ; then
				echo "nok: Bad Request" >"$arg0"_pipe
			else
		             output=$(./post_messages.sh "$arg0" "$arg2" "$message") #takes output from function
				echo $output > "$arg0"_pipe
			fi
			;;
		display)
			if [ "$arg2" = "" ]; then
				echo "nok: Bad Request" > "$arg0"_pipe
			else
				output=$(./display_wall.sh "$arg2") #takes output from function
				output="${output#start_of_file}" #removes line 'start of file'
				output="${output//end_of_file/}" #removes line 'end_of_file'
				echo "$output" #echoes output for testing purposes
				echo $output > "$arg0"_pipe #prints to pipe
				
				
			fi
			;;
		*)
			echo "Accepted Commands: {create|add|post|display}" > "$arg0"_pipe #if invalid command is etnered this is transferred to the client
			
	esac
done
