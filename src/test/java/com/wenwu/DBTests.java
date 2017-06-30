package com.wenwu;

import com.wenwu.service.JoinService;
import com.wenwu.tables.tables.SCourseJoin;
import com.wenwu.tables.tables.SUserAccount;
import com.wenwu.tables.tables.records.SCourseJoinRecord;
import com.wenwu.tables.tables.records.SUserAccountRecord;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by lvchuan on 17/6/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTests {
    @Autowired JoinService joinService;
    private Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Test
    public void databaseLoad() {
//        joinService.insertJoin();
        logger.info("lvchuan");
        logger.warn("hi");
    }

}
