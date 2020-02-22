require './colors.rb'
require './sqlMain.rb'

def loadTables()
	puts whiteStr("SQL Tables declaration routine")
	executeFile("./tables/Member.sql")
	executeFile("./tables/VoteType.sql")
	executeFile("./tables/Vote.sql")
	executeFile("./tables/VoteOption.sql")
	executeFile("./tables/MemberVote.sql")
	executeFile("./tables/Voice.sql")
	executeFile("./tables/VoiceVoteOption.sql")
	executeFile("./tables/MajoritarianRepresentation.sql")
end
