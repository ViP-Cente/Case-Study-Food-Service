package com.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.ModeratorRepository;
import com.project.model.Moderator;

@Service
public class ModeratorServiceImpl implements ModeratorService{

	@Autowired
	ModeratorRepository repo;
	
	@Override
	public List<Moderator> getAll() {
		List<Moderator> mList= repo.findAll();
		return mList;
	}

	@Override
	public Moderator getModeratorById(Integer id) throws Exception {
		if(repo.findById(id).isEmpty()) {
			System.out.println("Moderator with id = " + id + " was not found");
			throw new Exception();
		}else {
			return repo.findById(id).get();
		}
	}

	@Override
	public boolean deleteModeratorById(Integer id) throws Exception {
		if(repo.findById(id).isEmpty()) {
			System.out.println("Moderato with id = " + id + " was not found and could not be deleted");
			throw new Exception();
		}else {
			repo.deleteById(id);
			return true;
		}
	}

	@Override
	public Moderator updateModerator(Integer id, Moderator mod) throws Exception {
		if(repo.findById(id).isEmpty()) {
			System.out.println("Moderator with id = " + id + " was not found and could not be updated");
			throw new Exception();
		}else {
			Moderator saved = repo.save(mod);
			return saved;
		}
	}

	@Override
	public Moderator createModerator(Moderator mod) throws Exception {
		if(repo.existsById(mod.getModID())) {
			throw new Exception();
		}
		Moderator saved = repo.save(mod);
		return saved;
	}
}
