names = ["prompter", "game", "hangman"]
current_version = 6
names.each {|file_name| print `cp Example_0#{current_version}_#{file_name}.java Example_0#{current_version+1}_#{file_name}.java\n`}