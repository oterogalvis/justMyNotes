module InventoriAble
	def self.included(klass)
		klass.extend(ClassMethods)
	end
	module ClassMethods
		def create(attributes)
			object = new(attributes)
			instances.push(object)
			return object
		end
		def instances
			@instances ||= Array.new
		end
		def stock_report
			print "-"*50,"\n"
			puts "#{self.to_s} Stock Report"
			print "-"*50,"\n"
			instances.each do|instance| 
				print "Name: #{instance.attributes[:name]}\t\t"
				print "Size: #{instance.attributes[:size]}\t\t" if !instance.attributes[:size].nil?
				print "Stock: #{instance.stock_count}\n"
			end
		end
	end
	def stock_count
		@stock_count ||= 0
	end
	def stock_count=(number)
		@stock_count = number
	end
	def in_stock?
		stock_count > 0
	end
end

module MyStore
	class Shirt
		include InventoriAble
		attr_accessor :attributes
		def initialize(attributes)
			@attributes = attributes
		end
	end

	class Pant
		include InventoriAble
		attr_accessor :attributes
		def initialize(attributes)
			@attributes = attributes
		end
	end

	class Accessory
		include InventoriAble
		attr_accessor :attributes
		def initialize(attributes)
			@attributes = attributes
		end
	end
end

shirt1 = MyStore::Shirt.create(name: "mtf", size: "l")
shirt2 = MyStore::Shirt.create(name: "tbpob", size: "s")
shirt1.stock_count = 10
pant1 = MyStore::Pant.create(name: "Jeans", size: "l")
pant2 = MyStore::Pant.create(name: "Jeans", size: "s")
pant2.stock_count = 15
belt1 = MyStore::Accessory.create(name: "Belt")
belt2 = MyStore::Accessory.create(name: "Belt")
belt1.stock_count = 20

MyStore::Shirt.stock_report
MyStore::Pant.stock_report
MyStore::Accessory.stock_report
