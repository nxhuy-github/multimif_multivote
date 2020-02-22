
# color macro definitions

C_RED = '[0;31m'
C_GREEN = '[0;32m'
C_YELLOW = '[0;33m'
C_BLUE = '[0;34m'
C_PURPLE = '[0;35m'
C_CYAN = '[0;36m'
C_NONE = '[0m'

# string coloration functions

def redStr(text)
	return C_RED + text + C_NONE
end

def greenStr(text)
	return C_GREEN + text + C_NONE
end

def yellowStr(text)
	return C_YELLOW + text + C_NONE
end

def blueStr(text)
	return C_BLUE + text + C_NONE
end

def purpleStr(text)
	return C_PURPLE + text + C_NONE
end

def cyanStr(text)
	return C_CYAN + text + C_NONE
end

def whiteStr(text)
	return C_NONE + text + C_NONE
end
