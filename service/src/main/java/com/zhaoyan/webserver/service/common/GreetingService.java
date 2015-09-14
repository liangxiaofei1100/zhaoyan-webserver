package com.zhaoyan.webserver.service.common;

import com.zhaoyan.webserver.dao.common.GreetingDao;
import com.zhaoyan.webserver.domain.common.GreetingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingDao mGreetingDao;

    public GreetingModel getGreetingMessage(){
        return mGreetingDao.getGreetingMessage();
    }

}
