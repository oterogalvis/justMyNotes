class TodoList
  attr_reader :name, :todo_items
  
  def initialize(name)
    @name = name
    @todo_items = []
  end
  
  def add_item(name)
    todo_items.push(name)
  end
  
  def contains?(name)
  end
  
  def find_index(name)
    found = false
    todo_items.each do |item|
      if item == name
        found = true
        break
      end
    end
    return found
  end
end

item = TodoList.new("jojoto")
item.add_item("perol")
item.add_item("lagarto")
item.add_item("hoar")
puts item.find_index("hoar")