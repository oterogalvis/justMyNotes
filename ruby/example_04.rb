grocery_list = Array.new
grocery_list << "milk"
grocery_list.push("eggs","bread")
grocery_list.unshift("carrots")
grocery_list.insert(3, "ice cream")

words_list = Array.new
words_list = %w(j o r g e)
words_list.delete_at(1)

puts grocery_list.inspect
puts grocery_list.slice(-2,2)


puts words_list.inspect
puts words_list.count("j")
print words_list.drop(1)
puts "\n"
puts  "-"*100

food_hash = {"name" => "bread", group: "carbs"}
food_hash["cuantity"] = "1"
food_hash["brand"] = "bimbo"
food_hash.store("calories", 100)

puts food_hash.inspect
print food_hash.keys
print "\n"
print food_hash.values
print "\n"
puts food_hash.length