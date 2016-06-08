require "./todo_item.rb"
class ToDoList
	attr_reader :name, :to_do_items
	def initialize(name)
		@name = name
		@to_do_items = Array.new
	end
	def add_item(name)
		@to_do_items.push(ToDoItem.new(name))
	end
	def remove_item(name)
		@to_do_items.each do |item|
			if item.name == name
				to_do_items.delete_at(to_do_items.index(item))
				puts "#{name} were removed from the list.\n\n"
			end
		end
	end
	def mark_complete(name)
		@to_do_items.each do |item|
			if item.name == name
				to_do_items[to_do_items.index(item)].mark_complete!
				puts "#{name} were completed.\n"
			end
		end
	end
end

todo_list = ToDoList.new("groceries")
todo_list.add_item("Milk")
todo_list.add_item("Meat")
todo_list.add_item("Eggs")
todo_list.add_item("Bread")

print todo_list.inspect + "\n\n"
todo_list.remove_item("Eggs")
print todo_list.inspect + "\n"
todo_list.mark_complete("Milk")
print todo_list.inspect + "\n\n"
