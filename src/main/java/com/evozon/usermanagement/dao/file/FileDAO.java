package com.evozon.usermanagement.dao.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.model.User;

@Repository(value="fileDAO")
public class FileDAO implements UserDAO {

	private List<User> currentUsers;
	
	public FileDAO(){
		
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		BufferedReader buffer = null;
		String line;

		try {
			buffer = new BufferedReader(new FileReader("file.csv"));
			while ((line = buffer.readLine()) != null) {
				if (!line.equals("")) {
					String[] parts = line.split(",");
					User user = new User(parts[1], parts[2], new SimpleDateFormat("dd/MM/yyyy").parse(parts[3]), parts[4], parts[5], parts[6], parts[7]);
					list.add(user);
				}
			}
		} catch (IOException e) {
			throw new FileDAOException("Wrong format file", e);
		} catch (ParseException e) {
			throw new ParseDateException("Wrong date file format", e);
		} finally {
			try {
				if (buffer != null)
					buffer.close();
			} catch (IOException ex) {
				throw new FileDAOException("File not found", ex);
			}
		}
		return list;
	}


	public void writeUsersToFile(List<User> usersList) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("file.csv"));
			for(User u : usersList){
				writer.write(u.toString());
			}
		} catch(IOException ex){
			throw new FileDAOException("File not found", ex);
		} finally {
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					throw new FileDAOException("Something wrong with the reader...");
				}
			}
		}
	}
	
	@Override
	public void addUser(User user) {
		if(currentUsers == null) {
			currentUsers = getAllUsers();
		}

		if(currentUsers == null) {
			currentUsers = new ArrayList<User>();
		}

		currentUsers.add(user);
		writeUsersToFile(currentUsers);
	}
	
	@Override
	public void updateUsers(List<User> usersList,int index) {
		writeUsersToFile(usersList);	
	}

	

}
