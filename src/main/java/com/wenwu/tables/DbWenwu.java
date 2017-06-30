/**
 * This class is generated by jOOQ
 */
package com.wenwu.tables;


import com.wenwu.tables.tables.SCourse;
import com.wenwu.tables.tables.SCourseHistory;
import com.wenwu.tables.tables.SCourseJoin;
import com.wenwu.tables.tables.SCourseQuestion;
import com.wenwu.tables.tables.SCourseware;
import com.wenwu.tables.tables.SUserAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DbWenwu extends SchemaImpl {

    private static final long serialVersionUID = -1304199286;

    /**
     * The reference instance of <code>db_wenwu</code>
     */
    public static final DbWenwu DB_WENWU = new DbWenwu();

    /**
     * The table <code>db_wenwu.s_course</code>.
     */
    public final SCourse S_COURSE = com.wenwu.tables.tables.SCourse.S_COURSE;

    /**
     * The table <code>db_wenwu.s_courseware</code>.
     */
    public final SCourseware S_COURSEWARE = com.wenwu.tables.tables.SCourseware.S_COURSEWARE;

    /**
     * The table <code>db_wenwu.s_course_history</code>.
     */
    public final SCourseHistory S_COURSE_HISTORY = com.wenwu.tables.tables.SCourseHistory.S_COURSE_HISTORY;

    /**
     * The table <code>db_wenwu.s_course_join</code>.
     */
    public final SCourseJoin S_COURSE_JOIN = com.wenwu.tables.tables.SCourseJoin.S_COURSE_JOIN;

    /**
     * The table <code>db_wenwu.s_course_question</code>.
     */
    public final SCourseQuestion S_COURSE_QUESTION = com.wenwu.tables.tables.SCourseQuestion.S_COURSE_QUESTION;

    /**
     * The table <code>db_wenwu.s_user_account</code>.
     */
    public final SUserAccount S_USER_ACCOUNT = com.wenwu.tables.tables.SUserAccount.S_USER_ACCOUNT;

    /**
     * No further instances allowed
     */
    private DbWenwu() {
        super("db_wenwu", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            SCourse.S_COURSE,
            SCourseware.S_COURSEWARE,
            SCourseHistory.S_COURSE_HISTORY,
            SCourseJoin.S_COURSE_JOIN,
            SCourseQuestion.S_COURSE_QUESTION,
            SUserAccount.S_USER_ACCOUNT);
    }
}