package com.jiang.sys.service.systemservice.impl;


import com.jiang.sys.dao.SysLogDao;
import com.jiang.sys.dao.SysParameterDao;
import com.jiang.sys.domain.SysLog;
import com.jiang.sys.domain.SysParameter;
import com.jiang.sys.service.systemservice.interfaceclass.SysLogService;
import com.jiang.sys.service.systemservice.interfaceclass.SysParameterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiang on 2018/4/3.
 */
@Service(value = "sysParameterService")
public class SysParameterServiceImpl implements SysParameterService {
    @Resource
    private SysParameterDao sysParameterDao;

    @Override
    public void insertSysParameter(SysParameter sysParameter) throws Exception{
        sysParameterDao.insertSysParameter(sysParameter);
    }

}
