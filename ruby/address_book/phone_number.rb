class PhoneNumber
	attr_accessor :kind, :number
	def to_s
		"#{kind.capitalize}: #{number}"
	end
end