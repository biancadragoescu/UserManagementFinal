package com.evozon.usermanagement.dao.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.service.User;

@Component
public class FileDAO implements UserDAO {

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		BufferedReader buffer = null;
		String line;

		try {
			buffer = new BufferedReader(new FileReader("C:\\samuel\\workspace\\UserManagement\\file.csv"));
			while ((line = buffer.readLine()) != null) {
				if (!line.equals("")) {
					String[] parts = line.split(",");
					User user = new User(parts[0], parts[1]);
					list.add(user);
				}
			}
		} catch (IOException e) {
			throw new FileDAOException("Wrong format file", e);
		} finally {
			try {
				if (buffer != null)
					buffer.close();
			} catch (IOException ex) {
				throw new FileDAOException("Wrong format file", ex);
			}
		}
		return list;
	}

}
