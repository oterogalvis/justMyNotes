require "yaml"

class AddPeople
	def initialize
		@people = []
		open
		menu
	end
	def open
		if File.exist?("example_09.yml")
			@people = YAML.load_file("example_09.yml")
		end
	end
	def save
		File.open("example_09.yml", "w") do |file|
			file.write(@people.to_yaml)
		end
	end
	def menu
		loop do
			puts "a: add person"
			puts "b: exit"
			puts "c: print list"
			input = gets.chomp.downcase
			case input
			when "a"
				print "insert name: "
				name = gets.chomp
				@people.push(name)
			when "b"
				save
				break
			when "c"
				index = 0
				@people.each do |person|
					index += 1
					print "The person number:#{index} is #{person}\n"
				end
			end
		end
	end
end

AddPeople.new
