require "yaml"

# Create .yml document with with hash inside.
my_hash = {name: "Jorge", location: "Boston", year: 2016}
File.open("example_15.yml","w") do |file|
	file.write(my_hash.to_yaml)
end

# Have access to the yml document
load_hash1 = YAML.load_file("example_15.yml")

# If the .yml file exist have access to it.
if File.exist?("example_15.yml")
	load_hash2 = YAML.load_file("example_15.yml")
end
puts load_hash2
puts load_hash2.to_yaml


# Use .load_file to read a file and .load to read a variable.