package com.police.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.police.Entity.police;
import com.police.Repository.policerepository;
import com.police.resoursenotfoundexception.resoursenotfoundexception;
import com.police.service.policeservice;
@Service
public class policeserviceimpl implements policeservice {
	private policerepository policerepository;

	public policeserviceimpl(com.police.Repository.policerepository policerepository) {
		super();
		this.policerepository = policerepository;
	}

	@Override
	public police savapolice(police police) {
		
		return policerepository.save(police);
	}

	@Override
	public List<police> getALLpolice() {
		
		return policerepository.findAll();
	}

	@Override
	public police getpoliceByid(Long id) {
		Optional<police> police=policerepository.findById(id);
		if(police.isPresent()) {
			return police.get();
		}
		else {
			throw new resoursenotfoundexception("police","id",id);
		}
		
	}

	@Override
	public police updatepolice(police police, Long id) {
		police expolice=policerepository.findById(id).orElseThrow(()-> new resoursenotfoundexception("police","id",id));
		expolice.setName(police.getName());
		expolice.setCity(police.getCity());
		policerepository.save(expolice);
		return expolice;
	}

	@Override
	public void deletepolice(Long id) {
		policerepository.findById(id).orElseThrow(() -> new resoursenotfoundexception("police","id",id));
		policerepository.deleteById(id);
	
		
	}

}
