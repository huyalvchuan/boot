package com.wenwu.service;

import com.wenwu.tables.tables.SCourseJoin;
import com.wenwu.tables.tables.records.SCourseJoinRecord;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * Created by lvchuan on 17/6/27.
 */
@Service
public class JoinService{
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired DSLContext dsl;
    public int insertJoin() {
        logger.info("i'am fine");
        dsl.insertInto(SCourseJoin.S_COURSE_JOIN).set(SCourseJoin.S_COURSE_JOIN.ID, 1).set(SCourseJoin.S_COURSE_JOIN.U_ID, 2).execute();
        return 1;
    }
}
