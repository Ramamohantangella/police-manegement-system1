package com.police.service;

import java.util.List;

import com.police.Entity.police;

public interface policeservice {
	police savapolice(police police);
	 List<police>getALLpolice();
	 police getpoliceByid(Long id);
	 police updatepolice(police police,Long id);
	 void deletepolice(Long id);

}
