def ask_contact
	contact_array = []
	loop do
		print "Do you whant to add a contact: (y/n) "
		answer = gets.chomp
		if answer == "y"
			contact_array.push(add_contact)
		else
			break
		end
	end
	puts "\t\tList of Contacts"
	print "-" * 80 + "\n"
	contact_array.each do |contact|
		puts "\tName: #{contact["name"]} \tNumber: #{contact["number"]}"
		print "-" * 80 + "\n"
	end
end
def add_contact
	print "Type name: "
	name = gets.chomp
	print "Type number: "
	number = gets.chomp
	contact = {"name" => name, "number" => number}
	return contact
end
# def print_list
# 	puts "List of Contacts"
# 	print "-" * 80 + "\n"
# 	ask_contact.each do |contact|
# 		puts "\tName: #{contact["name"]} \tNumber: #{contact["number"]}"
# 		print "-" * 80 + "\n"
# 	end
# end
ask_contact