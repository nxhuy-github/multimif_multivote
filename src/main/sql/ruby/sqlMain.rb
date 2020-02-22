require 'mysql'
require 'pg'
require './colors.rb'

$SQL_DRIVER_MYSQL = 'mySql'
$SQL_DRIVER_H2 = 'h2'
$SQL_DRIVER = 'null'
$BDD = 'null'

def setDriverToMySql()
	setDriver($SQL_DRIVER_MYSQL)
end

def setDriverToH2()
	setDriver($SQL_DRIVER_H2)
end

def setDriver(driver)
	$SQL_DRIVER = driver
	puts whiteStr('driver set : ' + $SQL_DRIVER)
end

def connect(url, dbname, user, password)
	if $SQL_DRIVER == $SQL_DRIVER_H2
		#$BDD = PG::Connection.open(:url => url,:dbname => dbname, :user => user, :password => password)
		$BDD = PGconn.connect(url, 8082, '', '', dbname, user, password)
	elsif $SQL_DRIVER == $SQL_DRIVER_MYSQL
		$BDD = Mysql::new(url, user, password)
		$BDD.set_server_option Mysql::OPTION_MULTI_STATEMENTS_ON
		$BDD.query_with_result = false
		$BDD.query("DROP DATABASE DB_TEST;")
		$BDD.query("CREATE DATABASE DB_TEST;")
		$BDD.query("USE DB_TEST;")
	else
		puts redStr('connect ERROR - driver not defined (' + $SQL_DRIVER + ')')
	end
end

def execute(request)
	if $BDD == 'null'
		puts redStr('execute ERROR - connection not established')
	elsif $SQL_DRIVER == $SQL_DRIVER_H2
		res = $BDD.exec(request)
	elsif $SQL_DRIVER == $SQL_DRIVER_MYSQL
		res = $BDD.query(request)
		while $BDD.next_result 
			puts res.fetch_row
			res = $BDD.store_result   
		end
		#statement = $BDD.prepare(request)
		#statement.execute
	else
		puts redStr('execute ERROR - driver not defined (' + $SQL_DRIVER + ')')
	end
end

def executeFile(filePath)
	puts 'execute file : ' + filePath
	content = File.read(filePath)
	execute(content)
end

def disconect()
	if $BDD == 'null'
		puts redStr('disconect ERROR - connection not established')
	elsif $SQL_DRIVER == $SQL_DRIVER_H2
		
	elsif $SQL_DRIVER == $SQL_DRIVER_MYSQL
		$BDD.close
	else
		puts redStr('ERROR - driver not defined (' + $SQL_DRIVER + ')')
	end
end

