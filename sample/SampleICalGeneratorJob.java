package sample.job;

import java.io.IOException;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.SingletonS2Container;

import jp.co.gsol.ical.exception.ICalException;
import jp.co.gsol.ical.exception.NoSuchDirectoryException;
import jp.co.gsol.ical.logic.ICalGeneratorLogic;

import jp.co.intra_mart.foundation.context.Contexts;
import jp.co.intra_mart.foundation.context.model.AccountContext;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;
import jp.co.intra_mart.foundation.job_scheduler.Job;
import jp.co.intra_mart.foundation.job_scheduler.JobResult;
import jp.co.intra_mart.foundation.job_scheduler.JobSchedulerContext;
import jp.co.intra_mart.foundation.job_scheduler.exception.JobExecuteException;

/**
 * sample job.
 * @author Global Solutions Co., Ltd.
 *
 */
public class SampleICalGeneratorJob implements Job {
    /**
     * 前回実行時以降に更新されたスケジュールのicsファイルを更新します.
     * @return jobの結果
     * @throws JobExecuteException job実行時に例外が発生した場合
     */
    @Override
    public final JobResult execute() throws JobExecuteException {
        try {
            new ICalGeneratorLogic(SingletonS2Container.getComponent(JdbcManager.class))
            .writeBatchUpdatedSchedules(
                     Contexts.get(JobSchedulerContext.class).getPreviousFireDate(),
                     new DateTime(Contexts.get(AccountContext.class).getTimeZone()));
        } catch (ICalException | IOException | NoSuchDirectoryException e) {
            throw new JobExecuteException("error", e);
        }
        return JobResult.success("success");
    }
}
