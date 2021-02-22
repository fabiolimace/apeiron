package com.github.small.ac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;
import com.github.f4b6a3.uuid.UuidCreator;

import static com.github.apeforge.ironape.commons.util.Util.*;

@Entity
@Table(name = "tb_permission", schema = "ironape")
public class Permission extends BaseEntity {

	protected static final long serialVersionUID = 9442952295444958L;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "object_id")
	private Object object;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "operation_id")
	private Operation operation;

	@OneToMany(mappedBy = "permission")
	private List<PermissionAssignment> permissionAssignments;

	public Permission() {
		this(null);
	}

	public Permission(String name) {
		this(name, null, null);
	}

	public Permission(Object object, Operation operation) {
		this(null, object, operation);
	}

	public Permission(String name, Object object, Operation operation) {
		super();
		
		if (name != null)
			this.name = name;
		else
			this.name = getNameSuggestion();
			
		setObject(object);
		setOperation(operation);
		setPermissionAssignments(permissionAssignments);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getObject() {
		return object;
	}

	public Operation getOperation() {
		return operation;
	}
	
	public void setObject(Object object) {
		this.setObject(object, true);
	}

	public List<PermissionAssignment> getPermissionAssignments() {
		return permissionAssignments;
	}

	public void setObject(Object object, boolean bidirectional) {
		if (bidirectional) {
			if (this.object != null) {
				this.object.removePermission(this);
			}
			if (object != null) {
				object.addPermission(this);
			}
		} else {
			this.object = object;
		}
	}

	public void setOperation(Operation operation) {
		this.setOperation(operation, true);
	}
	
	public void setOperation(Operation operation, boolean bidirectional){
		if(bidirectional){
			if(this.operation !=null){
				this.operation.removePermission(this);
			}
			if(operation!=null){
				operation.addPermission(this);
			}
		} else {
			this.operation = operation;
		}
	}

	public void setPermissionAssignments(
			List<PermissionAssignment> permissionAssignments) {
		if (isEmpty(permissionAssignments)) {
			this.permissionAssignments = new ArrayList<PermissionAssignment>();
		} else {
			this.permissionAssignments = permissionAssignments;
			for (PermissionAssignment i : permissionAssignments) {
				if (i.getPermission() != this)
					i.setPermission(this);
			}
		}
	}

	public void addPermissionAssignment(
			PermissionAssignment permissionAssignment) {
		if(isNotIn(permissionAssignments, permissionAssignment)){
			permissionAssignments.add(permissionAssignment);
			permissionAssignment.setPermission(this, false);
		}
	}

	public void removePermissionAssignment(
			PermissionAssignment permissionAssignment) {
		if(isIn(permissionAssignments, permissionAssignment)){
			permissionAssignments.remove(permissionAssignment);
			permissionAssignment.setPermission(null, false);
		}
	}

	public List<Role> getRoles() {
		ArrayList<Role> roles = new ArrayList<Role>();
		for (PermissionAssignment i : this.getPermissionAssignments()) {
			roles.add(i.getRole());
		}
		return roles;
	}

	public String getNameSuggestion() {
		String nameSuggestion = "";

		if ((this.object != null) && (this.operation != null)) {
			nameSuggestion = object.getName() + "." + operation.getName();
		} else {
			if (this.object != null) {
				nameSuggestion = object.getName();
			} else if (this.operation != null) {
				nameSuggestion = operation.getName();
			} else {
				nameSuggestion = UuidCreator.getRandom().toString();
			}
		}

		return nameSuggestion;
	}
}
