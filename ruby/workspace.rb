# ----------STRUCT--------------
Customer = Struct.new(:name, :email)

customer1 = Customer.new("Jorge", "oterogalvis@gmail.com")
customer2 = Customer.new("Jesus", "jesus.javier.m@gmail.com")
# customer3 = Customer.new("Jorge", "oterogalvis@gmail.com")

customer1.each_pair {|x,y| print "#{x}: #{y}\n"}
customer2.each_pair {|x,y| print "#{x}: #{y}\n"}