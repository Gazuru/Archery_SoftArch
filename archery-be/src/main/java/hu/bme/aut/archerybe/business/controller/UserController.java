package hu.bme.aut.archerybe.business.controller;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import hu.bme.aut.archerybe.business.service.UserService;
import hu.bme.aut.archerybe.datamodel.dto.UserRoleRequest;
import hu.bme.aut.archerybe.datamodel.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.path}")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponse updateRole(@Valid @RequestBody UserRoleRequest userRoleRequest, @PathVariable UUID userId) {
        return userService.updateRole(userId, userRoleRequest);
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{userId}")
    public UserResponse getUser(@PathVariable UUID userId) {
        return userService.getUser(userId);
    }
}
