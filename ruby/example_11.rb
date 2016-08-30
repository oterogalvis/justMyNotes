File.open("example_11.txt", "a+") do |file|  
	print "Enter your name: "
	name = gets.chomp
	file.print "Name: #{name}\n"
	print "Enter your email: "
	email = gets.chomp
	file.print "Email: #{email}\n"	
end