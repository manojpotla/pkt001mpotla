package com.nirvana.parkingtom.service.mapper;

import com.nirvana.parkingtom.service.dto.UserAccountDTO;

public class UserAccountMapper {

	public  static boolean mapUserAccount(com.nirvana.parkingtom.entities.UserAccount userAccount, UserAccountDTO userAccountDTO){
		//userAccount =  new UserAccount();
		userAccount.setFirstName(userAccountDTO.getFirstName());
		userAccount.setLastName(userAccountDTO.getLastName());
		userAccount.setMobileNumber(userAccountDTO.getMobileNumber());
		return true;
	}
}
