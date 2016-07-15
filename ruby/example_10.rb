module Fetcher
	def self.included(klass)
		puts "#{klass} have been include"
		attr_accessor :fetch_count
	end
	def fetch(item)
		@fetch_count ||= 0
		@fetch_count += 1
		puts "[#{@fetch_count}]#{@name} will bring the #{item} back."
	end
end

class Dog
	include Fetcher
	def initialize(name)
		@name = name
	end
end

class Cat
	include Fetcher
	def initialize(name)
		@name = name
	end
end

dog = Dog.new("Fido")
dog.fetch("bone")
dog.fetch("frisbee")

cat = Cat.new("Garfield")
cat.fetch("Laser Pointer")