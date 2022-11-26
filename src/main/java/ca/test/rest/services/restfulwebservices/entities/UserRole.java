package ca.test.rest.services.restfulwebservices.entities;

import java.util.UUID;

public class UserRole {

    private UUID roleId;
    private String role;


    public UserRole(UserRoles role) {
        this.roleId = UUID.randomUUID();
        switch (role) {
            case ADMIN -> this.role = String.valueOf(UserRoles.ADMIN).toLowerCase();
            case PROVIDER -> this.role = String.valueOf(UserRoles.PROVIDER).toLowerCase();
            case SUBSCRIBER -> this.role = String.valueOf(UserRoles.SUBSCRIBER).toLowerCase();
        }
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
