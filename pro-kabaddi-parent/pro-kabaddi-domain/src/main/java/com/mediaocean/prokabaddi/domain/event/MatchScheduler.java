package com.mediaocean.prokabaddi.domain.event;

import java.util.Date;
import java.util.List;

import com.mediaocean.prokabaddi.domain.common.Team;

public interface MatchScheduler {
	
	List<Match> generate(List<Team> teamList, Date startDate);
}
