package sample.data.jpa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    /**
     * 默认页<br/>
     * @RequestMapping("/") 和 @RequestMapping 是有区别的
     * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
     * 如果加了参数“/”，则只认为是根页面。
     *
     */
    @RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", "hello，你好！");

        return "index";
    }

    /**
     * 响应到JSP页面page1
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping("/page1")
    public ModelAndView page1(){
        log.info(">>>>>>>> PageController.page1");
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        ModelAndView mav = new ModelAndView("page/page1");
        mav.addObject("content", "hello");
        return mav;
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public Map<String, String> getInfo(@RequestParam(required=false) String name,
            @RequestParam(required=false) String name1) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("name1", name1);
        return map;
    }   

}
