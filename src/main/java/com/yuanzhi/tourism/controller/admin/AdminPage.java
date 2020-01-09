package com.yuanzhi.tourism.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/12 22:13
 */

@Controller
public class AdminPage {

    @GetMapping("/adminLogins")
    public String toLogin(){
        return "admin/adminLogin";
    }

    @GetMapping("/adminIndex")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/admin/welcome")
    public String welcome(){
        return "admin/pages/welcome";
    }

    /**
     * 所有用户属性
     * @return
     */
    @GetMapping("/pages/member/user.html")
    public String memberUser(){
        return "admin/pages/member/user";
    }
    @GetMapping("/pages/member/user-center.html")
    public String memberUserCenter(){
        return "admin/pages/member/user-center";
    }
    @GetMapping("/pages/member/user-add.html")
    public String memberUserAdd(){
        return "admin/pages/member/user-add";
    }
    @GetMapping("/pages/member/user-info.html")
    public String memberUserInfo(){
        return "admin/pages/member/user-info";
    }
    @GetMapping("/pages/member/user-edit.html")
    public String memberUserEdit(){
        return "admin/pages/member/user-edit";
    }

    /**
     * 所有文章属性
     */
    @GetMapping("/pages/often/article.html")
    public String oftenArticle(){
        return "admin/pages/often/article";
    }
    @GetMapping("/pages/often/article-add.html")
    public String oftenArticleAdd(){
        return "admin/pages/often/article-add";
    }
    @GetMapping("/pages/often/article-edit.html")
    public String oftenArticleEdit(){
        return "admin/pages/often/article-edit";
    }
    @GetMapping("/pages/often/download.html")
    public String oftenDownload(){
        return "admin/pages/often/download";
    }
    @GetMapping("/pages/often/image.html")
    public String oftenImage(){
        return "admin/pages/often/image";
    }
    @GetMapping("/pages/often/link.html")
    public String oftenLink(){
        return "admin/pages/often/link";
    }
    @GetMapping("/pages/often/message.html")
    public String oftenMessage(){
        return "admin/pages/often/message";
    }
    @GetMapping("/pages/often/process.html")
    public String oftenProcess(){
        return "admin/pages/often/process";
    }
    @GetMapping("/pages/often/product.html")
    public String oftenProduct(){
        return "admin/pages/often/product";
    }

    /**
     *
     * @return
     */
    @GetMapping("/pages/other/403.html")
    public String other403(){
        return "admin/pages/other/403";
    }
    @GetMapping("/pages/other/404.html")
    public String other404(){
        return "admin/pages/other/404";
    }
    @GetMapping("/pages/other/500.html")
    public String other500(){
        return "admin/pages/other/500";
    }
    @GetMapping("/pages/other/login.html")
    public String otherLogin(){
        return "admin/pages/other/login";
    }

    /**
     *
     * @return
     */
    @GetMapping("/pages/system/alertSkin.html")
    public String systemAlertSkin(){
        return "admin/pages/system/alertSkin";
    }
    @GetMapping("/pages/system/system-log.html")
    public String systemLog(){
        return "admin/pages/system/system-log";
    }
    @GetMapping("/pages/system/system-log-detail.html")
    public String systemLogDetail(){
        return "admin/pages/system/system-log-detail";
    }
    @GetMapping("/pages/system/system-setting.html")
    public String systemSetting(){
        return "admin/pages/system/system-setting";
    }
    @GetMapping("/pages/system/system-shield.html")
    public String systemShield(){
        return "admin/pages/system/system-shield";
    }

    /**
     *
     * @return
     */
    @GetMapping("/pages/test/okLayer.html")
    public String testOkLayer(){
        return "admin/pages/system/okLayer";
    }
    @GetMapping("/pages/test/okProgress.html")
    public String testOkProgress(){
        return "admin/pages/test/okProgress";
    }
    @GetMapping("/pages/test/okutils.html")
    public String testOkUtils(){
        return "admin/pages/test/okutils";
    }

    /**
     *
     * @return
     */
    @GetMapping("/pages/use/demo.html")
    public String useDemo(){
        return "admin/pages/use/demo";
    }
    @GetMapping("/pages/use/use-okLayer.html")
    public String useOkLayer(){
        return "admin/pages/use/use-okLayer";
    }
    @GetMapping("/pages/use/use-okMenu.html")
    public String useOkMenu(){
        return "admin/pages/use/use-okMenu";
    }
    @GetMapping("/pages/use/use-okTab.html")
    public String useOkTab(){
        return "admin/pages/use/use-okTab";
    }
    @GetMapping("/pages/use/use-okTab-sub.html")
    public String useOkTabSub(){
        return "admin/pages/use/use-okTab-sub";
    }
    @GetMapping("/pages/use/use-okUtils.html")
    public String useOkUtils(){
        return "admin/pages/use/use-okUtils";
    }
    @GetMapping("/pages/use/use-tab.html")
    public String useTab(){
        return "admin/pages/use/use-tab";
    }

    /**
     *
     * @return
     */
    @GetMapping("/pages/notification/notification.html")
    public String notification(){
        return "admin/pages/notification/notification";
    }

    @GetMapping("/pages/remain/remain.html")
    public String remain(){
        return "admin/pages/remain/remain";
    }

    @GetMapping("/pages/hotel/hotel.html")
    public String hotel(){
        return "admin/pages/hotel/hotel";
    }

    @GetMapping("/pages/album/album.html")
    public String album(){
        return "admin/pages/album/album";
    }
    @GetMapping("/pages/album/picture.html")
    public String picture(){
        return "admin/pages/album/picture";
    }

    @GetMapping("/pages/turn/turn.html")
    public String turn(){
        return "admin/pages/turn/turn";
    }
    @GetMapping("/pages/turn/turn-edit.html")
    public String turnEdit(){
        return "admin/pages/turn/turn-edit";
    }
    @GetMapping("/pages/turn/turn-add.html")
    public String turnAdd(){
        return "admin/pages/turn/turn-add";
    }

    @GetMapping("/pages/scene/scene.html")
    public String scene(){
        return "admin/pages/scene/scene";
    }

    @GetMapping("/pages/history/history.html")
    public String history(){
        return "admin/pages/history/history";
    }

    @GetMapping("/pages/search/search.html")
    public String search(){
        return "admin/pages/search/search";
    }

}
