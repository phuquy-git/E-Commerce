package com.EcommerceBackEnd.EcommerceBackEnd.converter;

import com.EcommerceBackEnd.EcommerceBackEnd.dto.AccountDTO;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.AccountDTOAdmin;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.AccountDTOUpdateRoles;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Account;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@Component
public class AccountConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepository;

    public AccountDTO convertToDto(Account account) {
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        accountDTO.setAccountId(account.getAccountId());
        return accountDTO;
    }

    public Account convertToEntity(AccountDTO accountDTO) throws ParseException {
        Account account = modelMapper.map(accountDTO, Account.class);
        return account;
    }

    public AccountDTOAdmin convertToDtoAdmin(Account account) {
        AccountDTOAdmin accountDTOAdmin = modelMapper.map(account, AccountDTOAdmin.class);
        accountDTOAdmin.setAccountId(account.getAccountId());
        return accountDTOAdmin;
    }
    public Account convertToEntityUpdateRoles(AccountDTOUpdateRoles accountDTOUpdateRoles) throws ParseException {
        Account account = modelMapper.map(accountDTOUpdateRoles, Account.class);
        Set<String> strRoles = accountDTOUpdateRoles.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByRname(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByRname(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByRname(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        account.setRoles(roles);
        return account;
    }

}
