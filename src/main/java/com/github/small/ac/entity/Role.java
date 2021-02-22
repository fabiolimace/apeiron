package com.github.small.ac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;

import static com.github.apeforge.ironape.commons.util.Util.*;

@Entity
@Table(name = "tb_role", schema = "ironape")
public class Role extends BaseEntity {

	private static final long serialVersionUID = -3666066831437819403L;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "role")
	private List<UserAssignment> userAssignments;

	@OneToMany(mappedBy = "role")
	private List<PermissionAssignment> permissionAssignments;

	@OneToMany(mappedBy = "ascendantRole")
	private List<RoleHierarchy> ascendantHierarchies;

	@OneToMany(mappedBy = "descendantRole")
	private List<RoleHierarchy> descendantHierarchies;
	
	@OneToMany(mappedBy = "role")
	private List<SessionRole> sessionRoles;

	public Role() {
		this(null);
	}

	public Role(String name) {
		super();
		this.name = name;

		init();
	}

	private void init() {
		setUserAssignments(userAssignments);
		setPermissionAssignments(permissionAssignments);
		setAscendantHierarchies(ascendantHierarchies);
		setDescendantHierarchies(descendantHierarchies);
		setSessionRoles(sessionRoles);
	}

	/* Getters and Setters */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserAssignment> getUserAssignments() {
		return userAssignments;
	}

	public List<PermissionAssignment> getPermissionAssignments() {
		return permissionAssignments;
	}

	public List<RoleHierarchy> getAscendantHierarchies() {
		return ascendantHierarchies;
	}

	public List<RoleHierarchy> getDescendantHierarchies() {
		return descendantHierarchies;
	}
	
	public List<SessionRole> getSessionRoles() {
		return sessionRoles;
	}

	public void setUserAssignments(List<UserAssignment> userAssignments) {

		if (isEmpty(userAssignments))
			this.userAssignments = new ArrayList<UserAssignment>();
		else {
			this.userAssignments = userAssignments;
			for (UserAssignment i : userAssignments) {
				if (i.getRole() != this)
					i.setRole(this);
			}
		}
	}

	public void setPermissionAssignments(
			List<PermissionAssignment> permissionAssignments) {

		if (isEmpty(permissionAssignments)) {
			this.permissionAssignments = new ArrayList<PermissionAssignment>();
		} else {
			this.permissionAssignments = permissionAssignments;
			for (PermissionAssignment i : permissionAssignments) {
				if (i.getRole() != this)
					i.setRole(this);
			}
		}
	}

	public void setAscendantHierarchies(List<RoleHierarchy> ascendantHierarchies) {

		if (isEmpty(ascendantHierarchies)) {
			this.ascendantHierarchies = new ArrayList<RoleHierarchy>();
		} else {
			this.ascendantHierarchies = ascendantHierarchies;
			for (RoleHierarchy i : ascendantHierarchies) {
				if (i.getAscendantRole() != this)
					i.setAscendantRole(this);
			}
		}
	}

	public void setDescendantHierarchies(
			List<RoleHierarchy> descendantHierarchies) {

		if (isEmpty(descendantHierarchies)) {
			this.descendantHierarchies = new ArrayList<RoleHierarchy>();
		} else {
			this.descendantHierarchies = descendantHierarchies;
			for (RoleHierarchy i : descendantHierarchies) {
				if (i.getDescendantRole() != this)
					i.setDescendantRole(this);
			}
		}
	}

	public void setSessionRoles(List<SessionRole> sessionRoles) {

		if (isEmpty(sessionRoles))
			this.sessionRoles = new ArrayList<SessionRole>();
		else {
			this.sessionRoles = sessionRoles;
			for (SessionRole i : sessionRoles) {
				if (i.getRole() != this)
					i.setRole(this);
			}
		}
	}
	
	/* End of Getters and Setters */
	
	/* Add to list */
	
	public void addUserAssignment(UserAssignment userAssignment) {
		if (isNotIn(userAssignments, userAssignment)) {
			userAssignments.add(userAssignment);
			userAssignment.setRole(this, false);
		}
	}
	
	public void addPermissionAssignment(
			PermissionAssignment permissionAssignment) {
		if (isNotIn(permissionAssignments, permissionAssignment)) {
			permissionAssignments.add(permissionAssignment);
			permissionAssignment.setRole(this, false);
		}
	}
	
	public void addAscendantHierarchy(RoleHierarchy ascendantHierarchy) {
		if(isNotIn(ascendantHierarchies, ascendantHierarchy)) {
			this.ascendantHierarchies.add(ascendantHierarchy);
			ascendantHierarchy.setAscendantRole(this, false);
		}
	}
	
	public void addDescendantHierarchy(RoleHierarchy descendantHierarchy) {	
		if(isNotIn(descendantHierarchies, descendantHierarchy)) {
			this.descendantHierarchies.add(descendantHierarchy);
			descendantHierarchy.setDescendantRole(this, false);
		}
	}
	
	public void addSessionRole(SessionRole sessionRole) {
		if (isNotIn(sessionRoles, sessionRole)) {
			sessionRoles.add(sessionRole);
			sessionRole.setRole(this, false);
		}
	}
	
	/* End of Add to list */
	
	/* Remove from list */ 
	
	public void removeUserAssignment(UserAssignment userAssignment) {
		if (isIn(userAssignments, userAssignment)) {
			userAssignments.remove(userAssignment);
			userAssignment.setRole(null, false);
		}
	}

	public void removePermissionAssignment(	
			PermissionAssignment permissionAssignment) {
		if (isIn(permissionAssignments, permissionAssignment)) {
			permissionAssignments.remove(permissionAssignment);
			permissionAssignment.setRole(null, false);
		}
	}
	
	public void removeAscendantHierarchy(RoleHierarchy ascendantHierarchy) {
		if(isIn(ascendantHierarchies, ascendantHierarchy)) {
			this.ascendantHierarchies.remove(ascendantHierarchy);
			ascendantHierarchy.setAscendantRole(null, false);
		}
	}

	public void removeDescendantHierarchy(RoleHierarchy descendantHierarchy) {
		if(isIn(descendantHierarchies, descendantHierarchy)) {
			this.descendantHierarchies.remove(descendantHierarchy);
			descendantHierarchy.setDescendantRole(null, false);
		}
	}
	
	public void removeSessionRole(SessionRole sessionRole) {
		if (isIn(sessionRoles, sessionRole)) {
			sessionRoles.remove(sessionRole);
			sessionRole.setRole(null, false);
		}
	}
	
	/* End of Remove from list */

	/* Ascendants */

	// Direct ascendants
	public List<Role> getImmediateAscendants() {

		List<Role> roles = new ArrayList<Role>();

		for (RoleHierarchy i : getDescendantHierarchies()) {
			if (!(roles.contains(i)))
				roles.add(i.getAscendantRole());
		}

		return roles;
	}

	// Indirect ascendants
	public List<Role> getMediateAscendants() {
		List<Role> roles = getAscendants();
		roles.removeAll(getImmediateAscendants());
		return roles;
	}

	// Direct plus indirect ascendants
	public List<Role> getAscendants() {
		return getAscendantsRecursively(this.getImmediateAscendants());
	}

	private List<Role> getAscendantsRecursively(List<Role> immediateRoles) {

		List<Role> roles = new ArrayList<Role>();
		roles.addAll(immediateRoles);

		for (Role i : immediateRoles) {
			for (Role j : getAscendantsRecursively(i.getImmediateAscendants())) {
				if (!(roles.contains(j))) {
					roles.add(j);
				}
			}
		}

		return roles;
	}

	public boolean isImmediateAscendantOf(Role descendantRole) {
		return getImmediateDescendants().contains(descendantRole);
	}

	public boolean isMediateAscendantOf(Role descendantRole) {
		return getMediateDescendants().contains(descendantRole);
	}

	public boolean isAscendantOf(Role descendantRole) {
		return getDescendants().contains(descendantRole);
	}

	/* End of Ascendants */

	/* Descendants */

	// Direct descendants
	public List<Role> getImmediateDescendants() {

		List<Role> roles = new ArrayList<Role>();

		for (RoleHierarchy i : getAscendantHierarchies()) {
			if (!(roles.contains(i)))
				roles.add(i.getDescendantRole());
		}

		return roles;
	}

	// Indirect descendants
	public List<Role> getMediateDescendants() {
		List<Role> roles = getDescendants();
		roles.removeAll(getImmediateDescendants());
		return roles;
	}

	// Direct plus indirect descendants
	public List<Role> getDescendants() {
		return getDescendantsRecursively(this.getImmediateDescendants());
	}

	private List<Role> getDescendantsRecursively(List<Role> immediateRoles) {

		List<Role> roles = new ArrayList<Role>();
		roles.addAll(immediateRoles);

		for (Role i : immediateRoles) {
			for (Role j : getDescendantsRecursively(i.getImmediateDescendants())) {
				if (!(roles.contains(j))) {
					roles.add(j);
				}
			}
		}

		return roles;
	}

	public boolean isImmediateDescendantOf(Role ascendantRole) {
		return getImmediateAscendants().contains(ascendantRole);
	}

	public boolean isMediateDescendantOf(Role ascendantRole) {
		return getMediateAscendants().contains(ascendantRole);
	}

	public boolean isDescendantOf(Role ascendantRole) {
		return getAscendants().contains(ascendantRole);
	}

	/* End of Descendants */

	/* Inheritance */
	
	public boolean inheritsImmediatelly(Role descendantRole) {
		return isImmediateAscendantOf(descendantRole);
	}

	public boolean inheritsProperly(Role descendantRole) {
		return isAscendantOf(descendantRole);
	}

	/* End of Inheritance */

	
	/* Derived methods */
	
	public List<User> getAssignedUsers() {

		ArrayList<User> users = new ArrayList<User>();
		for (UserAssignment i : this.getUserAssignments())
			if (isNotIn(users, i))
				users.add(i.getUser());

		return users;
	}

	public List<Permission> getAssignedPermissions() {

		ArrayList<Permission> permissions = new ArrayList<Permission>();
		for (PermissionAssignment i : this.getPermissionAssignments())
			if (isNotIn(permissions, i))
				permissions.add(i.getPermission());

		return permissions;
	}
	
	public List<User> getAuthorizedUsers() {

		List<User> users = this.getAssignedUsers();

		for (Role i : this.getAscendants())
			for (User j : i.getAssignedUsers())
				if (isNotIn(users, j))
					users.add(j);

		return users;
	}

	public List<Permission> getAuthorizedPermissions() {

		List<Permission> permissions = this.getAssignedPermissions();

		for (Role i : this.getDescendants())
			for (Permission j : i.getAssignedPermissions())
				if (isNotIn(permissions, j))
					permissions.add(j);

		return permissions;

	}
	
	public List<Permission> getPermissions(){
		return this.getAssignedPermissions();
	}

	/* End of Derived methods */
	
	public List<Operation> getOperationsOnObject(Object object) {
		List<Operation> operations = new ArrayList<Operation>();
		for (Permission i : this.getAssignedPermissions()) {
			if ((i != null) && i.getObject().equals(object))
				operations.add(i.getOperation());
		}
		return operations;
	}
}
