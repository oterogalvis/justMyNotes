require "base64"

message = "Welcome to Treehouse"
message_encode = Base64.encode64(message)
puts message_encode
message_regular = Base64.decode64(message_encode)
puts message_regular
message_urlsafe = Base64.urlsafe_encode64(message)
puts message_urlsafe