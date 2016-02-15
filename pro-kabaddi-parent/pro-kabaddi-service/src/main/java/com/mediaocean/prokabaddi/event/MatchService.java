package com.mediaocean.prokabaddi.event;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.mediaocean.prokabaddi.domain.event.Match;

public interface MatchService {
	
	@GET
    @Path("/schedule")
	@Produces("application/json")
	List<Match> generateSchedule(@QueryParam("teamIds") String teamIds, @QueryParam("startDate") String startDate);

}
