package jp.co.gsol.oss.ical.model;

import java.util.EnumSet;

import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;

/**
 * Event コンテナクラス.
 * @author Global Solutions Co., Ltd.
 */
public final class ICalEvent {
    /**
     * コンテナのdata.
     */
    private final Data data;

    /**
     * データ保持クラス.
     * @author Global Solutions Co., Ltd.
     */
    private static class Data {
        /**
         * イベントのユニークなID.
         */
        private String id;
        /**
         * 終日かどうか. Collaborationのスケジュールならfalse,イベントならtrue
         */
        private boolean wholeDay;
        /**
         * タイトル.
         */
        private String summary;
        /**
         * 期間開始日時.
         */
        private DateTime startDate;
        /**
         * 期間終了日時.
         */
        private DateTime endDate;
        /**
         * 説明.
         */
        private String description;
        /**
         * 場所.
         */
        private String location;
        /**
         * 更新日時.
         */
        private DateTime lastModified;
    }

    /**
     * コンテナ作成クラス.
     * @author Global Solutions Co., Ltd.
     */
    public static class Builder {

        /**
         * 入力チェックフラグ.
         * @author Global Solutions Co., Ltd.
         */
        private enum SETUP_FLAG {
            /** ID.*/
            ID,
            /** WHOLE_DAY.*/
            WHOLE_DAY,
            /** SUMMARY.*/
            SUMMARY,
            /** START_DATE.*/
            START_DATE,
            /** END_DATE.*/
            END_DATE,
            /** DESCRIPTION.*/
            DESCRIPTION,
            /** LOCATION.*/
            LOCATION,
            /** LAST_MODIFIED.*/
            LAST_MODIFIED
        }
        /**
         * コンテナのdata.
         */
        private final Data data;

        /**
         * 入力チェック.
         */
        private EnumSet<SETUP_FLAG> setupFlag;

        /**
         * コンテナ作成クラス.
         */
        Builder() {
            this.data = new Data();
            setupFlag = EnumSet.noneOf(SETUP_FLAG.class);
        }
        /**
         * {@link #id}.
         * @param value id
         * @return this
         */
        public final Builder id(final String value) {
            data.id = value;
            setupFlag.add(SETUP_FLAG.ID);
            return this;
        }
        /**
         * {@link #wholeDay}.
         * @param value wholeDay
         * @return this
         */
        public final Builder wholeDay(final boolean value) {
            data.wholeDay = value;
            setupFlag.add(SETUP_FLAG.WHOLE_DAY);
            return this;
        }
        /**
         * {@link #summary}.
         * @param value summary
         * @return this
         */
        public final Builder summary(final String value) {
            data.summary = value;
            setupFlag.add(SETUP_FLAG.SUMMARY);
            return this;
        }
        /**
         * {@link #startDate}.
         * @param value startDate
         * @return this
         */
        public final Builder startDate(final DateTime value) {
            data.startDate = value;
            setupFlag.add(SETUP_FLAG.START_DATE);
            return this;
        }
        /**
         * {@link #endDate}.
         * @param value endDate
         * @return this
         */
        public final Builder endDate(final DateTime value) {
            data.endDate = value;
            setupFlag.add(SETUP_FLAG.END_DATE);
            return this;
        }
        /**
         * {@link #description}.
         * @param value description
         * @return this
         */
        public final Builder description(final String value) {
            data.description = value;
            setupFlag.add(SETUP_FLAG.DESCRIPTION);
            return this;
        }
        /**
         * {@link #location}.
         * @param value location
         * @return this
         */
        public final Builder location(final String value) {
            data.location = value;
            setupFlag.add(SETUP_FLAG.LOCATION);
            return this;
        }
        /**
         * {@link #lastModified}.
         * @param value lastModified
         * @return this
         */
        public final Builder lastModified(final DateTime value) {
            data.lastModified = value;
            setupFlag.add(SETUP_FLAG.LAST_MODIFIED);
            return this;
        }
        /**
         * コンテナクラス作成.
         * @return コンテナクラス
         * @throws ICalException 必須フィールドが未入力の場合
         */
        public final ICalEvent build() throws ICalException {
            if (!EnumSet.allOf(SETUP_FLAG.class).equals(setupFlag))
                throw new ICalException(
                        "Some required parameters are not inputed.");
            return new ICalEvent(this);
        }
    }

    /**
     * コンテナクラス作成.
     * @return コンテナクラス
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Event コンテナ.
     * @param builder コンテナ作成クラス
     */
    private ICalEvent(final Builder builder) {
        this.data = builder.data;
    }

    /**
     * イベントのユニークなID.
     * @return id
     */
    public String id() {
        return data.id;
    }

    /**
     * 終日かどうか. Collaborationのスケジュールならfalse,イベントならtrue.
     * @return 終日かどうか
     */
    public boolean wholeDay() {
        return data.wholeDay;
    }

    /**
     * タイトル.
     * @return タイトル
     */
    public String summary() {
        return data.summary;
    }

    /**
     * 期間開始日時.
     * @return 期間開始日時
     */
    public DateTime startDate() {
        return data.startDate;
    }

    /**
     * 期間終了日時.
     * @return 期間終了日時
     */
    public DateTime endDate() {
        return data.endDate;
    }

    /**
     * 説明.
     * @return 説明
     */
    public String description() {
        return data.description;
    }

    /**
     * 場所.
     * @return 場所
     */
    public String location() {
        return data.location;
    }

    /**
     * 更新日時.
     * @return 更新日時
     */
    public DateTime lastModified() {
        return data.lastModified;
    }
}
