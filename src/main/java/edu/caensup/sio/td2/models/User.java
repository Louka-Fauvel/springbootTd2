package edu.caensup.sio.td2.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User  implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 30)
	private String firstname;
	
	@Column(length = 30)
	private String lastname;
	
	@Column(nullable = true)
	private String email;
	
	@Column(nullable = true)
	private String password;
	
	private boolean suspended;
	
	private String authorities;
	
	@ManyToOne(optional = true)
	private Organization organization;
	
	@ManyToMany(mappedBy = "users")
	private List<Group> groups;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if(authorities == null) {
			authorities = "";
		}
		String[] auths = authorities.split(",");
        List<SimpleGrantedAuthority> authoritiesObjects = new ArrayList<SimpleGrantedAuthority>();
        for (String role : auths) {
            authoritiesObjects.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authoritiesObjects;
        
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
