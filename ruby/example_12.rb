# save and load
class Player
	attr_accessor :name, :progress
	def initialize(name)
		@name = name
	end
end

player = Player.new("Jorge")
player.progress = 60

puts player.inspect

output = Marshal.dump(player)

new_player = Marshal.load(output)

puts new_player.inspect