def create_list
	print "Please write the name of the list: "
	list_name = gets.chomp
	general_hash = {"name" => list_name, "items" => []}
	return general_hash
end
def items_keys
	print "Please write the name of the item: "
	item_name = gets.chomp
	items_hash = {"Item" => item_name}
	print "Please write the quantity of the item: "
	item_quantity = gets.chomp
	items_hash["Quantity"] = item_quantity
	print "Please choose a brand: "
	item_brand = gets.chomp
	items_hash["Brand"] = item_brand
	return items_hash
end
def print_list
	list = create_list()
	list["items"].push(items_keys())

	print "-"*80 + "\n"
	print "List name: #{list["name"]}" + "\n"
	print ". "*40 + "\n"

	first_item = list["items"][0]
	print "\tItem: #{first_item["Item"]}" + "\t\tQuantity: #{first_item["Quantity"]}" + "\t\tBrand: #{first_item["Brand"]}\n"
	print "-"*80 + "\n"
end

print_list