package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestUserServiceImpl {
	@Autowired
	IUserService us;

	@Test
	public void testRetrieveAllUsers() {
		List<User> users = us.retrieveAllUsers();
		Assertions.assertEquals(6, users.size());
	}

	// @Test
	public void testAddUser() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-20");
		User u = new User("Ali", "Ben ahmed", d, Role.ADMINISTRATEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}

	// @Test
	public void testUpdateUser() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-20");
		User u = new User(2L, "Ali", "Ben ahmed", d, Role.INGENIEUR);
		User userUpdate = us.updateUser(u);
		Assertions.assertEquals(u.getLastName(), userUpdate.getLastName());
	}

	// @Test
	public void testRetrieveUser() {
		User userRetrieved = us.retrieveUser("2");
		Assertions.assertEquals(2L, userRetrieved.getId());
	}

	// @Test
	public void testDeleteUser() {
		us.deleteUser("5");
		Assertions.assertNull(us.retrieveUser("5"));
	}

}
// @Test
// @Order(3)
// public void testModifuUser() throws ParseException{
// SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
// Date d = dateFormat.parse("2015-03-23");
// User u = new User(1L,"Mayssa122222222","Mayssa",d, Role.INGENIEUR);
// User userUpdated = us.updateUser(u);
// Assertions.assertEquals(u.getLastName(),userUpdated.getLastName());
// }

// @Test
// @Order(4)
// public void testRetrieveUser() {
// User userRetrieved = us.retrieveUser("1");
// Assertions.assertEquals(1L, userRetrieved.getId());
// }

// @Test
// @Order(5)
// public void testDeletUser() {
// us.deletUser("1");
// Assertions.assertNull(us.retriveUser("1")))
// }
