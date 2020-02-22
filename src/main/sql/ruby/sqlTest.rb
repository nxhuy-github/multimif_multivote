require './colors.rb'
require './sqlMain.rb'
require './sqlTables.rb'
require './sqlConstraints.rb'


begin
	puts whiteStr('SQL database creation routine')
	setDriverToH2()
	connect('localhost','DB_TEST','root','root')
	loadTables()
	#loadConstraints()

	puts greenStr('Done')

rescue Mysql::Error => e
	puts e.errno
	puts redStr(e.error)
ensure
	disconect()
end
