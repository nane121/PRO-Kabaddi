# ======== Problem Statement =======
Build a RESTful service that generates the round robin schedule for the PRO-Kabaddi event that conforms to the following constraints
- Accept N number of teams
- Each team must play against every other team once home and away
- Maximum 2 matches per day are allowed
- No team should play on consecutive days

# ======== Solution =======

# Step-1: Deploy PRO-Kabaddi Service WAR to Tomcat
- Clone GIT Repository locally using this URL : https://github.com/124938/PRO-Kabaddi.git
- Import Maven Project in eclipse
- Deploy pro-kabaddi-service war in Tomcat
- Open browser and type this URL to see available REST services exposed : http://localhost:8080/pro-kabaddi-service/api

# Step-2: Generate match schedule
curl -H "Content-Type: application/json" -X GET http://localhost:8080/myretailstore-service/api/match/schedule?teamIds=1,2,3,4,5&startDate=20160218

