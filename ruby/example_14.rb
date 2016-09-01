require "json"

json_string = '{"name": "Jorge", "location": "Boston", "year":2016}'
print json_string, "\n"

JSON.parse(json_string)
print json_string, "\n"

hash = JSON.parse(json_string)
print hash["name"], "\n"

my_hash = {name: "Jorge", email: "oterogalvis#@gmai.com", favorite_numbers: [0, 3, 7, 10]}
json_output =  JSON.dump(my_hash)
puts json_output.class #=> String

hash_again = JSON.parse(json_output)
puts hash_again.class #=> Hash

json_file = JSON.load( File.new("./example_14.json"))
puts json_file
