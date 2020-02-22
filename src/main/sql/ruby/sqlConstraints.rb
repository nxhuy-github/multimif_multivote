require './colors.rb'
require './sqlMain.rb'

def loadConstraints()
	puts whiteStr("SQL Constraints declaration routine")
	executeFile("./constraints/Member.sql")
	executeFile("./constraints/VoteType.sql")
	executeFile("./constraints/Vote.sql")
	executeFile("./constraints/VoteOption.sql")
	executeFile("./constraints/MemberVote.sql")
	executeFile("./constraints/Voice.sql")
	executeFile("./constraints/VoiceVoteOption.sql")
	executeFile("./constraints/MajoritarianRepresentation.sql")
end
