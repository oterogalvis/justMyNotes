array = "3 6 8 4 2 4 7 7".split(" ").map { |x| x.to_i  }
puts array.inject{|sum, x| sum += x}

