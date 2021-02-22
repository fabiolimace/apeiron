package com.github.small.ac.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.apeforge.ironape.commons.entity.BaseEntity;

@Entity
@Table(name = "tb_role_hierarchy", schema = "ironape")
public class RoleHierarchy extends BaseEntity {

	private static final long serialVersionUID = 5684167075158301272L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "base_role_id", nullable = false)
	private Role ascendantRole;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "derived_role_id", nullable = false)
	private Role descendantRole;

	// In RBAC the ascendant role inherits from the descendant role.
	// When we say inherit, we mean inherit PERMISSIONS.
	// The use of ascendant and descendant is confuse because they are
	// inverted.
	// So, please, read the following explanations.
	//
	// Types of relations:
	// >>: immediate inheritance (binary relation between two nodes)
	// >=: proper inheritance (recursive relation between two nodes)
	//
	// Alternate types of relations:
	// --> : the same as >>
	// -->*: the same as >=
	//
	// Examples of relations:
	// r1 >> r2: r1 inherits immediately from r2
	// r1 >= r2: r1 inherits properly from r2
	//
	// Another way to represent the relations above is:
	// r1 --> r2: r1 inherits immediately from r2
	// r2 -->* r2: r1 inherits properly from r2
	//
	// In RBAC Inheritance relations are represented top-to-bottom, so
	// r1 is called ASCENDANT (top) and r2 is called DESCENDANT (bottom).
	// See bellow:
	//
	// r1 (ascendant, because it is in the top)
	// |
	// | (inherits from)
	// v
	// r2 (descendant, because it is in the bottom)
	//

	public RoleHierarchy() {
		this(null, null);
	}

	public RoleHierarchy(Role ascendantRole, Role descendantRole) {
		super();
		this.setAscendantRole(ascendantRole);
		this.setDescendantRole(descendantRole);
	}
	

	public Role getAscendantRole() {
		return ascendantRole;
	}

	public Role getDescendantRole() {
		return descendantRole;
	}

	public void setAscendantRole(Role role){
		this.setAscendantRole(role, true);
	}
	
	public void setAscendantRole(Role ascendantRole, boolean bidirectional){
		if(bidirectional){
			if(this.ascendantRole!=null){
				this.ascendantRole.removeAscendantHierarchy(this);
			}
			if(ascendantRole!=null){
				ascendantRole.addAscendantHierarchy(this);
			}
		} else {
			this.ascendantRole = ascendantRole;
		}
	}

	public void setDescendantRole(Role descendantRole) {
		this.setDescendantRole(descendantRole, true);
	}
	
	public void setDescendantRole(Role descendantRole, boolean bidirectional) {
		if(bidirectional){
			if(this.descendantRole!=null){
				this.descendantRole.removeDescendantHierarchy(this);
			}
			if(descendantRole!=null){
				descendantRole.addDescendantHierarchy(this);
			}
		} else {
			this.descendantRole = descendantRole;
		}
	}

	public boolean isValid() {
		return isValid(ascendantRole, descendantRole);
	}

	public static boolean isValid(Role ascendantRole, Role descendantRole) {
		return (ascendantRole != descendantRole)
				&& (!ascendantRole.isImmediateAscendantOf(descendantRole))
				&& (!descendantRole.inheritsProperly(ascendantRole));

	}
}
