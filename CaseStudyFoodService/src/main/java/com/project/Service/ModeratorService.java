package com.project.Service;

import java.util.List;

import com.project.model.Moderator;


public interface ModeratorService {
	List<Moderator> getAll();
	Moderator getModeratorById(Integer id) throws Exception;
	boolean deleteModeratorById(Integer id) throws Exception;
	Moderator updateModerator(Integer id, Moderator mod) throws Exception;
	Moderator createModerator(Moderator mod) throws Exception;
}
