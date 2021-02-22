package com.github.small.ac.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.apeforge.ironape.commons.util.IronApeException;
import com.github.apeforge.ironape.commons.util.JPAUtil;
import com.github.small.ac.entity.Object;
import com.github.small.ac.entity.Operation;
import com.github.small.ac.entity.Permission;
import com.github.small.ac.entity.Role;
import com.github.small.ac.entity.Session;
import com.github.small.ac.entity.User;
import com.github.small.ac.service.AccessControlService;

public class AccessControlServiceTest {

	private AccessControlService service;

	private EntityManager entityManager;
	EntityTransaction transaction;

	private User user1;
	private User user2;
	private User user3;

	private Role role1;
	private Role role2;
	private Role role3;

	private Object object1;
	private Object object2;
	private Object object3;

	private Operation operation1;
	private Operation operation2;
	private Operation operation3;

	private Permission permission1;
	private Permission permission2;
	private Permission permission3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		entityManager = JPAUtil.getEntityManager();
		transaction = entityManager.getTransaction();

		service = new AccessControlService(entityManager);

		user1 = new User("user1");
		user2 = new User("user2");
		user3 = new User("user3");

		role1 = new Role("role1");
		role2 = new Role("role2");
		role3 = new Role("role3");

		object1 = new Object("Object1");
		object2 = new Object("Object2");
		object3 = new Object("Object3");

		operation1 = new Operation("Operation1");
		operation2 = new Operation("Operation2");
		operation3 = new Operation("Operation3");

		permission1 = new Permission(object1, operation1);
		permission2 = new Permission(object2, operation2);
		permission3 = new Permission(object3, operation3);

		transaction.begin();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.flush();
		transaction.rollback();
	}

	@Test
	public void testAddUser() {

		service.addUser(user1);
		service.addUser(user2);
		service.addUser(user3);

		assertEquals(3, service.getAllUsers().size());

	}

	@Test
	public void testDeleteUser() {

		service.addUser(user1);
		service.addUser(user2);
		service.addUser(user3);

		service.deleteUser(user2);

		assertEquals(2, service.getAllUsers().size());

	}

	@Test
	public void testAddRole() {

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		assertEquals(3, service.getAllRoles().size());
	}

	@Test
	public void testDeleteRole() {

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.deleteRole(role2);

		assertEquals(2, service.getAllRoles().size());
	}

	@Test
	public void testAssignUser() {

		service.addUser(user1);
		service.addRole(role1);

		service.assignUser(user1, role1);

		assertEquals(1, user1.getUserAssignments().size());
	}

	@Test
	public void testDeassignUser() {

		service.addUser(user1);
		service.addUser(user2);
		service.addUser(user3);

		service.addRole(role1);

		service.assignUser(user1, role1);
		service.assignUser(user2, role1);
		service.assignUser(user3, role1);

		service.deassignUser(user2, role1);

		assertEquals(2, role1.getUserAssignments().size());

	}

	@Test
	public void testGrantPermission() {

		// test 1
		service.addRole(role1);
		service.addPermission(permission1);
		service.grantPermission(permission1, role1);
		assertEquals(1, role1.getPermissionAssignments().size());

		// test 2
		service.addRole(role2);
		service.addPermission(permission2);
		service.grantPermission(object2, operation2, role2);
		assertEquals(1, role2.getPermissionAssignments().size());

	}

	@Test
	public void testRevokePermission() {

		// test 1
		service.addRole(role1);
		service.addPermission(permission1);
		service.grantPermission(permission1, role1);
		assertEquals(1, role1.getPermissionAssignments().size());
		service.revokePermission(permission1, role1);
		assertEquals(0, role1.getPermissionAssignments().size());

		// test 2
		service.addRole(role2);
		service.addPermission(permission2);
		service.grantPermission(object2, operation2, role2);
		assertEquals(1, role2.getPermissionAssignments().size());
		service.revokePermission(object2, operation2, role2);
		assertEquals(0, role2.getPermissionAssignments().size());

	}

	@Test
	public void testGetBaseRoles() {

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addInheritance(role1, role2);
		service.addInheritance(role2, role3);

		assertEquals(2, service.getAscendants(role3).size());

	}

	@Test
	public void testGetDerivedRoles() {

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addInheritance(role1, role2);
		service.addInheritance(role2, role3);

		assertEquals(2, service.getDescendants(role1).size());

	}

	@Test
	public void testGetAssignedUsers() {

		service.addUser(user1);
		service.addUser(user2);
		service.addUser(user3);

		service.addRole(role1);

		service.assignUser(user1, role1);
		service.assignUser(user2, role1);
		service.assignUser(user3, role1);

		assertEquals(3, service.getAssignedUsers(role1).size());
	}

	@Test
	public void testGetRolePermissions() {

		service.addPermission(permission1);
		service.addPermission(permission2);
		service.addPermission(permission3);

		service.addRole(role1);

		service.grantPermission(permission1, role1);
		service.grantPermission(permission2, role1);
		service.grantPermission(permission3, role1);

		assertEquals(3, service.getRolePermissions(role1).size());
	}

	@Test
	public void testGetAssignedPermissions() {

		service.addPermission(permission1);
		service.addPermission(permission2);
		service.addPermission(permission3);

		service.addRole(role1);

		service.grantPermission(permission1, role1);
		service.grantPermission(permission2, role1);
		service.grantPermission(permission3, role1);

		assertEquals(3, service.getAssignedPermissions(role1).size());
	}

	@Test
	public void testAuthorizedUsers() {
		service.addUser(user1);
		service.addUser(user2);
		service.addUser(user3);

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addInheritance(role1, role2);
		service.addInheritance(role2, role3);

		service.assignUser(user1, role1);
		service.assignUser(user2, role2);
		service.assignUser(user3, role3);

		assertEquals(3, service.getAuthorizedUsers(role3).size());

	}

	@Test
	public void testAuthorizedPermissions() {

		service.addPermission(permission1);
		service.addPermission(permission2);
		service.addPermission(permission3);

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addInheritance(role1, role2);
		service.addInheritance(role2, role3);

		service.grantPermission(permission1, role1);
		service.grantPermission(permission2, role2);
		service.grantPermission(permission3, role3);

		assertEquals(3, service.getAuthorizedPermissions(role1).size());
	}

	@Test
	public void testAddInheritance() {

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addInheritance(role1, role2);
		service.addInheritance(role2, role3);

		assertEquals(2, role3.getAscendants().size());
	}

	@Test(expected = IronApeException.class)
	public void testAddInheritanceWithCircularReference() {

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addInheritance(role1, role2);
		service.addInheritance(role2, role3);
		service.addInheritance(role3, role1);

		assertEquals(2, role3.getAscendants().size());

	}

	@Test
	public void testDeleteInheritance() {

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addInheritance(role1, role2);
		service.addInheritance(role2, role3);
		service.deleteInheritance(role1, role2);

		assertEquals(1, role3.getAscendants().size());
	}

	@Test
	public void testAddAscendant() {

		service.addRole(role1);
		service.addAscendant(role2, role1);
		service.addAscendant(role3, role1);

		assertEquals(2, role1.getAscendants().size());
	}

	@Test
	public void testAddDescendant() {

		service.addRole(role1);
		service.addDescendant(role1, role2);
		service.addDescendant(role1, role3);

		assertEquals(2, role1.getDescendants().size());
	}

	@Test
	public void testCreateSession() {

		service.addUser(user1);

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.assignUser(user1, role1);
		service.assignUser(user1, role2);
		service.assignUser(user1, role3);

		Session session = service.createSession(user1, user1.getAssignedRoles());

		assertTrue(service.existsSession(session));
	}

	@Test
	public void testDeleteSession() {

		service.addUser(user1);

		service.addRole(role1);

		service.assignUser(user1, role1);

		Session session = service.createSession(user1, user1.getAssignedRoles());

		service.deleteSession(session);

		assertFalse(service.existsSession(session));
	}

	@Test
	public void testAddActiveRole() {
		service.addUser(user1);

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.assignUser(user1, role1);
		service.assignUser(user1, role2);
		service.assignUser(user1, role3);

		List<Role> roles = new ArrayList<Role>();
		roles.add(role1);
		roles.add(role2);

		Session session = service.createSession(user1, roles);

		service.addActiveRole(session, role3);

		assertEquals(3, session.getRoles().size());
	}

	@Test
	public void testDropActiveRole() {
		service.addUser(user1);

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.assignUser(user1, role1);
		service.assignUser(user1, role2);
		service.assignUser(user1, role3);

		Session session = service.createSession(user1, user1.getAssignedRoles());

		service.dropActiveRole(session, role3);

		assertEquals(2, session.getRoles().size());
	}

	@Test
	public void testCheckAccess() {
		// TODO
		service.addUser(user1);
		service.addRole(role1);
		service.assignUser(user1, role1);
		service.addPermission(permission1);
		service.grantPermission(permission1, role1);

		Session session1 = service.createSession(user1, user1.getAssignedRoles());

		assertTrue(service.checkAccess(session1, operation1, object1));
	}

	@Test
	public void testGetUserPermissions() {
		service.addPermission(permission1);
		service.addPermission(permission2);
		service.addPermission(permission3);

		service.addRole(role1);

		service.grantPermission(permission1, role1);
		service.grantPermission(permission2, role1);
		service.grantPermission(permission3, role1);

		service.addUser(user1);

		service.assignUser(user1, role1);

		assertEquals(3, service.getUserPermissions(user1).size());
	}

	@Test
	public void testGetSessionRoles() {

		service.addUser(user1);

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.assignUser(user1, role1);
		service.assignUser(user1, role2);
		service.assignUser(user1, role3);

		Session session = service.createSession(user1, user1.getAssignedRoles());

		assertEquals(3, service.getSessionRoles(session).size());
	}

	@Test
	public void testGetSessionPermissions() {
		service.addUser(user1);

		service.addRole(role1);
		service.addRole(role2);
		service.addRole(role3);

		service.addPermission(permission1);
		service.addPermission(permission2);
		service.addPermission(permission3);

		service.grantPermission(permission1, role1);
		service.grantPermission(permission2, role1);
		service.grantPermission(permission3, role1);

		service.assignUser(user1, role1);
		service.assignUser(user1, role2);
		service.assignUser(user1, role3);

		Session session = service.createSession(user1, user1.getAssignedRoles());

		assertEquals(3, service.getSessionPermissions(session).size());
	}

	@Test
	public void testGetRoleOperationsOnObject() {
		service.addUser(user1);

		service.addRole(role1);

		service.addPermission(permission1);

		service.grantPermission(permission1, role1);

		service.assignUser(user1, role1);

		assertEquals(1, service.getRoleOperationsOnObject(role1, permission1.getObject()).size());
	}

	@Test
	public void testGetUserOperationsOnObject() {
		service.addUser(user1);

		service.addRole(role1);

		service.addPermission(permission1);

		service.grantPermission(permission1, role1);

		service.assignUser(user1, role1);

		assertEquals(1, service.getUserOperationsOnObject(user1, permission1.getObject()).size());
	}
}
