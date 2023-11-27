package com.stc.uploaddownloadfiles.utils.impl;

import com.stc.uploaddownloadfiles.exceptions.BlockedUserException;
import com.stc.uploaddownloadfiles.model.entity.Item;
import com.stc.uploaddownloadfiles.model.entity.Permission;
import com.stc.uploaddownloadfiles.model.entity.PermissionGroup;
import com.stc.uploaddownloadfiles.model.entity.User;
import com.stc.uploaddownloadfiles.model.enums.ErrorCode;
import com.stc.uploaddownloadfiles.model.enums.PermissionLevel;
import com.stc.uploaddownloadfiles.model.enums.UserStatus;
import com.stc.uploaddownloadfiles.repository.PermissionsRepository;
import com.stc.uploaddownloadfiles.repository.UserRepository;
import com.stc.uploaddownloadfiles.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SecurityUtilsImpl implements SecurityUtils {

    private final  PermissionsRepository permissionsRepository ;


    private final UserRepository userRepository;

    public SecurityUtilsImpl(PermissionsRepository permissionsRepository, UserRepository userRepository) {
        this.permissionsRepository = permissionsRepository;
        this.userRepository = userRepository;
    }


    public void authenticate(Item item) {
        PermissionGroup permissionGroup = item.getPermissionGroup();
        Long permissionGroupId = permissionGroup.getId();
        Permission permission = permissionsRepository.findById(permissionGroupId).get();
        Long userId = permission.getUserId().getId();
        User user = userRepository.findById(userId).get();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        String username = principal.getUsername();
        if (Objects.equals(user.getEmail(), username) && permission.getPermissionLevel().equals(PermissionLevel.VIEW)) {
            user.setStatus(UserStatus.BLOCKED);
            userRepository.save(user);
            throw new BlockedUserException(ErrorCode.STC_BLOCK);
        }
    }

    @Override
    public void authenticateDownload(Item item) {
        PermissionGroup permissionGroup = item.getPermissionGroup();
        Long permissionGroupId = permissionGroup.getId();
        Permission permission = permissionsRepository.findById(permissionGroupId).get();
        Long userId = permission.getUserId().getId();
        User user = userRepository.findById(userId).get();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        String username = principal.getUsername();
        if (Objects.equals(user.getEmail(), username) && ( !permission.getPermissionLevel().equals(PermissionLevel.VIEW)
                && !permission.getPermissionLevel().equals(PermissionLevel.EDIT))) {
            user.setStatus(UserStatus.BLOCKED);
            userRepository.save(user);
            throw new BlockedUserException(ErrorCode.STC_BLOCK);
        }
    }
}
