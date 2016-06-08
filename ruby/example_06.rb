def loop_test	
	loop do
		puts "hi"
		answer = gets.chomp
	end
end
def until_test
	answer = false
	until answer == "no"
		print "Do u whant to continue? (yes/no)\n"
		answer = gets.chomp
	end
end
#say_hi_index and say_hi_iteration do the same using differents methods.
def say_hi_index
	classmates = ["Julia", "Malcom" , "Dejvi" , "Toni", "Brandon", "Josh"]
	mates_index = 0
	while mates_index < classmates.length
		classmate = classmates[mates_index]
		print "Hi, #{classmate}\n"
		mates_index += 1
	end
end
def say_hi_iteration
	classmates = ["Julia", "Malcom" , "Dejvi" , "Toni", "Brandon", "Josh"]
	classmates.each do |classmate|
		print "Hi, #{classmate}\n"
	end
end
#using itearion in hashes.
def bussiness_info
	business = { "name" => "Treehouse", "location" => "Portland, OR" }
	business.each do |value|
	  puts "The hash key is and the value is #{value}."
	end
end
#using times iterator.
def times_iterator
	5.times do |item|
	  puts "Hello! #{item}"
	end
end
#using the for iterator.
def for_iterator
	for item in 1..3 do
	  puts "The current item is #{item}."
	end
end