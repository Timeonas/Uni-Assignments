#!/bin/bash
#Trap command is used to delete the user created pipe once the user exits the program
trap ctrl_c INT 
trap "rm -f $1_pipe" EXIT
ctrl_c() {
echo Exiting program
exit 1
}
#Check to see if the user exists in the database
if [ -d "../Bashbook/$1" ]; then 
#If the number of inputs is greater than 0 proceed
if [ $# -ge 0 ]; then 
#Create a pipe for the user
mkfifo $1_pipe
echo "Welcome to Bashbook.Please enter your request"
echo "Accepted Commands: {create|add|post|display}"
echo $1
#Enter an endless loop
while true; do

#Read the request from the user
read request id1 message 
#Parse the user's id
id=$1

#Crete a lock
lock="serverlink"

while   [ -h "$lock" ]; do #if lock exists enter loop and wait
echo waiting
sleep 0.5
done

ln -s server.sh serverlink
#Send data to the serverpipe
echo $request $id $id1 $message > server_pipe
#Retrieve the data from the pipe
read output < $1_pipe

#Variables are assigned strings that will be used to compare outputs from the server
check0="ok: user created!"
check1="nok: user already exists"
check2="add"
check3="post"
check4="display"

#Variable will used to print default error messages
check=0
#If there is a match with any of these if statements, then the specifc error message is printed in a user friendly wau
if [ "$output" = "$check0" ]; then
echo SUCCESS: user created
check=1
fi

if [ "$output" = "$check1" ]; then
echo ERROR: user already exists
check=1
fi

if [ "$request" = "$check2" ] || [ "$request" = "$check3" ]; then
echo $output
check=1
fi

if [ "$request" = "$check4" ]; then
output=${output//./"\n"}
echo -e $output
check=1
fi

if [ $check -ne 1 ]; then
echo $output
fi




   
 done
 
 fi
else
echo $1 is not a user please use another account
 fi
