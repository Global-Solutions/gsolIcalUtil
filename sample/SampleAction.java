package sample.action;

import java.io.IOException;

import jp.co.gsol.ical.exception.ICalException;
import jp.co.gsol.ical.logic.ICalUserDataManipulatorLogic;
import jp.co.intra_mart.foundation.context.Contexts;
import jp.co.intra_mart.foundation.context.model.AccountContext;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;
import org.seasar.struts.annotation.Execute;

/**
 * iCal設定画面アクション.
 * @author Global Solutions Co., Ltd.
 *
 */
public class SettingAction {

    /**
     * {@link ManipulateICalUserDataLogic}.
     */
    private ICalUserDataManipulatorLogic iCalUserDataManipulatorLogic;

    /**
     * リソースを設定します.
     * @throws ICalException 設定ファイルが間違えている場合
     */
    public SettingAction() throws ICalException {
        iCalUserDataManipulatorLogic =
                new ICalUserDataManipulatorLogic(SingletonS2Container.getComponent(JdbcManager.class));
    }
    /**
     * ユーザのicsアクセスURL取得.
     * @return 画面のjsp
     */
    @Execute(validator = false)
    public String index() {
        //アカウント情報等取得
        AccountContext ac = Contexts.get(AccountContext.class);
        // serviceからURLを取得してくる.
        String fileName = iCalUserDataManipulatorLogic.getFileName(ac.getUserCd());
        // ファイルのURL.
        String iCalFileURL = ICalUserDataManipulatorLogic.getFileAccesssURL(fileName);
        return "/path/to/your.jsp";
    }

    /**
     * URLの生成.
     * @throws IOException ファイル削除時にエラーが起きた場合
     * @throws ICalException ファイル削除の操作が不正な場合
     */
    @Execute(validator = false)
    public String generateURL() throws IOException, ICalException {
        //アカウント情報等取得
        AccountContext ac = Contexts.get(AccountContext.class);

        DateTime time = new DateTime(ac.getTimeZone());
        String fileName = iCalUserDataManipulatorLogic.deleteAndCreateUserData(ac.getUserCd(), time);
        String fileURL = ICalUserDataManipulatorLogic.getFileAccesssURL(fileName);

        return "/path/to/your.jsp";
    }

    /**
     * URLの削除.
     * @throws IOException ファイル削除時にエラーが起きた場合
     * @throws ICalException ファイル削除の操作が不正な場合
     */
    @Execute(validator = false)
    public String deleteURL() throws IOException, ICalException {
        //アカウント情報等取得
        AccountContext ac = Contexts.get(AccountContext.class);

        boolean success = iCalUserDataManipulatorLogic.deleteUserData(ac.getUserCd());

        return "/path/to/your.jsp";
    }
}
