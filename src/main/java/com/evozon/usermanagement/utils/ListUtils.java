
package com.evozon.usermanagement.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.evozon.usermanagement.model.User;

@Component
public class ListUtils {
	
	//returneaza indexul pe care se gaseste userul
	//returneaza -1 daca nu il gaseste
	public int findUserIndex(User user, List<User> list) {
		int index = 0;
		for (User dest : list) {
			if (user.equals(dest))
				return index;
			index ++;
		}
		return -1;
	}
}
