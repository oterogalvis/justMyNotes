require "./phone_number.rb"
require "./address.rb"
class Contact
	attr_accessor :first_name, :middle_name, :last_name
	attr_reader :phone_numbers, :addresses
	def initialize
		@phone_numbers = []
		@addresses = []
	end
	def find_by_name name
		results = []
		search = name
	end
	def add_phone_number(kind, number)
		phone_number = PhoneNumber.new
		phone_number.kind = kind
		phone_number.number = number
		phone_numbers.push(phone_number)
	end
	def add_address(kind, street_1, street_2, city, state, postal_code)
		address = Address.new
		address.kind = kind
		address.street_1 = street_1
		address.street_2 = street_2
		address.city = city
		address.state = state
		address.postal_code = postal_code 
		addresses.push(address)
	end
	def full_name
		full_name = first_name
		if !middle_name.nil?
			full_name += "\s"
			full_name += middle_name
		end
		full_name += "\s"
		full_name += last_name
	end
	def by_first_name
		first_name + " " + last_name

	end
	def by_last_name
		by_last_name = last_name
		by_last_name += ", "
		by_last_name += first_name
		if !middle_name.nil?
			by_last_name += "\s"
			by_last_name += middle_name.slice(0,1)
			by_last_name += "."
		end
		by_last_name
	end
	def to_s(format = "full_name")
		case format
		when "full_name"
			full_name
		when "last_name"
			by_last_name
		when "first"
			first_name
		when "last"
			last_name
		else
			by_first_name
		end
	end
	def print_phone_numbers
		phone_numbers.each do |number|
			puts number
		end
		
	end
end

jorge = Contact.new
jorge.first_name = "Jorge"
jorge.middle_name = "Eliecer"
jorge.last_name = "Otero Galvis"
jorge.add_phone_number("home", "786-87-0469")
jorge.add_phone_number("work", "786-87-0496")
# puts jorge.to_s("full_name")
# puts jorge.inspect
jorge.print_phone_numbers