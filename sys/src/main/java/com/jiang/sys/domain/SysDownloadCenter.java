package com.jiang.sys.domain;

import com.jiang.common.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysDownloadCenter extends BaseDomain {
    /** 版本号 */
    private static final long serialVersionUID = -5979370168435264743L;
    /**  */
    private String fileName;

    /**  */
    private String filePath;

    /**  */
    private String fileExtension;

    /** 文件类型：文本文件、视频文件、音频文件、图片文件 */
    private String fileType;

}