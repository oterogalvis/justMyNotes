require "date"

my_birthdate1 = Date.new(1988,9,16)
my_birthdate2 = Date.parse("September 16th, 1988")
my_birthdate3 = Date.parse("16/9/1988")
my_birthdate4 = Date.strptime("9/16/1988", "%m/%d/%Y")
today = Date.today

puts my_birthdate1.inspect
puts my_birthdate2.inspect
puts my_birthdate3.inspect
puts my_birthdate4.inspect
puts my_birthdate4.to_s
puts my_birthdate4.strftime("%Y / %m / %d This is my date")




puts today -1
puts today +1
puts today << 1
puts today >> 1

time = Time.new
puts time.min
puts time.sec
puts time.month
puts time.day
puts time.year
puts time.to_a
puts time.strftime("%b %d %Y")


time1 = Time.new(2015, 9, 16, 14, 0 , 0, "-04:00")
time2 = Time.new(2015, 9, 16, 13, 0 , 0, "-05:00")
puts time1 == time2

puts time1.dst? #Day light savings.

# duplicate and transform in utc(Universal Time Zone).
utc_time1 = time1.dup.utc


# utc_offset is use to see how far it is from utc.
puts utc_time1.utc_offset
# Divided by 60 twice to get the time in hours
puts time1.utc_offset / 60 / 60