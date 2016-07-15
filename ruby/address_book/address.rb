class Address
	attr_accessor :kind, :street_1, :street_2, :city, :state, :postal_code
	def to_s (format = "short")
		address = ""
		case format
		when "short"
			address += "#{kind}: "
			address += "#{street_1}"
			address += ", " + street_2 if street_2
		address += ", #{city}, #{state} #{postal_code}"
		when "long"

			address += "#{street_1}"
			address += street_2 + "\n" if !street_2.nil?
			address += "#{city}, #{state} #{postal_code}"
		end
	end
end

home = Address.new
home.kind = "Home"
home.street_1 = "88 Riverside St."
# home.street_2 = "88 Riverside St."
home.city = "Watertown"
home.state = "MA"
home.postal_code = "02472"
puts home
puts home.to_s("long")
