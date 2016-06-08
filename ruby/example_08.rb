
class BankAccount
	attr_reader :name

	def initialize(name)
		@name = name
		@transactions = []
		add_transaction("Begining balance",0)
	end
	def credit(description,amount)
		add_transaction(description,amount)
	end
	def debit(description,amount)
		add_transaction(description,-amount)
	end
	def add_transaction(description, amount)
		@transactions.push(description: description, amount: amount)
	end
	def balance
		balance = 0.0
		@transactions.each do |transaction|
			balance += transaction[:amount]
		end
		return balance
	end
	def to_s
		"Name: #{name}\tBalance: #{sprintf("%0.2f",balance)}"
	end
	def print_register
		print "#{name}'s Bank Account\n"
		print "-" * 80 + "\n"
		print "Description".ljust(30) +"Amount\n".rjust(10)
		@transactions.each do |transaction|
			print transaction[:description].ljust(30) + sprintf("%0.2f",transaction[:amount]).rjust(10).to_s + "\n"
		end	
		print "-" * 80 + "\n"
		puts "Balance:".ljust(30) + sprintf("%0.2f",balance).rjust(10).to_s
	end
end

bank_account = BankAccount.new("Jorge")
bank_account.credit("Paycheck",100)
bank_account.debit("Groceries",40)	
bank_account.debit("Cinema",20)	
bank_account.print_register
