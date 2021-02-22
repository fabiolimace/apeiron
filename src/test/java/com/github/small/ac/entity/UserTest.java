package com.github.small.ac.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import com.github.small.ac.entity.Role;
import com.github.small.ac.entity.User;

public class UserTest {

	private User user1;
	private User user2;
	private User user3;

	private Role role1;
	private Role role2;
	private Role role3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user1 = new User("Alice");
		user2 = new User("Bob");
		user3 = new User("Charles");

		role1 = new Role("writer");
		role2 = new Role("editor");
		role3 = new Role("publisher");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test @Ignore
	public void testGetRoles() {

		fail("Not implemented!");

	}

}
