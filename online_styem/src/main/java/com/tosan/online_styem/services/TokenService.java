package com.tosan.online_styem.services;

import com.tosan.online_styem.base.service.BaseService;
import com.tosan.online_styem.models.Token;

public interface TokenService extends BaseService<Token, Integer> {

    int getTokenDetail(String emailId);

    boolean updateToken(String email, String authenticationToken, String secretKey);
}
