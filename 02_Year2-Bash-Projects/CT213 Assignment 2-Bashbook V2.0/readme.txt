Ensure that the scripts directory is placed on your desktop
Within the Bash terminal, navigate to the scripts directory on your Desktop using the cd command
Once inside, launch the server.sh script file using ./server.sh 
(If you encounter any permission errors, ensure you run the sudo -s command)
Once you have run the server script, open a new terminal instance.
Within the second terminal, run the client script file alongside your already existing user ID e.g, ./client.sh "your name"
By default the user 'test' should be created so type ./client.sh test to login as test then create as many users as you like. 

You can now run commands in the following format:
create (userid)
add (userid) (friendid)
post (senderid) (receiverid)
display (userid)

When exiting the program, always use ctrl+c or the user pipe will not be deleted and it may cause errors with overlap. So always use ctrl+c when exiting and not ctrl+z.
