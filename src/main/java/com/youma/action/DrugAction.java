/**
 * Copyright (C),2015-2018
 * FileNmae: DrugAction
 * Author:   Administrator
 * Date:     2018/10/26 11:08
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.youma.action;

import com.youma.service.DrugService;
import com.youma.util.Page;
import com.youma.vo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * DrugAction
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/26 11:08
 */
@Controller
public class DrugAction {
    public static String pp = "D:/appach/";
    private DrugService drugService;

    public DrugService getDrugService() {
        return drugService;
    }

    @Autowired
    public void setDrugService(DrugService drugService) {
        this.drugService = drugService;
    }

    @RequestMapping(value = "/toDrugAdd")
    public String toAdd(HttpServletRequest request) {
        System.out.println("进入方法了");
        String str = request.getContextPath();
        System.out.println(str);
        return "/drug/addDrug";
    }

    @RequestMapping(value = "/drugList")
    public String drugList(ModelMap map, HttpServletRequest request) {
        Page page = new Page();
        page.setPageSize(5);
        Drug drug = new Drug();
        drug.setDrugName(request.getParameter("drugName"));
        drug.setDrugID(request.getParameter("drugID"));
        page.setTotalCount(drugService.drugCount(drug));
        if (request.getParameter("pageNo") != null) {
            page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
        } else {
            page.setPageNo(1);
        }
        map.put("drugs", drugService.drugAll(drug, page));
        map.put("page", page);
        map.put("drug", drug);
        return "/drug/drugIndex";
    }

    @RequestMapping(value = "/drugAdd", method = RequestMethod.POST)
    public String drugAdd(HttpServletRequest request) {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile mf = req.getFile("url");
        Drug drug = new Drug();
        drug.setDrugID(req.getParameter("drugID"));
        drug.setDescription(req.getParameter("description"));
        drug.setDrugName(req.getParameter("drugName"));
        String oo = pp + mf.getOriginalFilename();
        System.out.println(oo);
        drug.setDrugUrl(oo);
        try {
            FileOutputStream os = new FileOutputStream(oo);
            int len = 0;
            byte[] b = new byte[1024];
            InputStream in = mf.getInputStream();
            while ((len = in.read(b)) > 0) {
                os.write(b, 0, len);
            }
            in.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        drugService.drugAdd(drug);
        return "redirect:/drugList";
    }

    @RequestMapping(value = "/drugFind", method = RequestMethod.GET)
    public String drugFind(String drugID, ModelMap map) {
        Drug drug = drugService.drugFind(drugID);
        String path = drug.getDrugUrl();
        if (path != null && !path.equals("")) {
            path = path.substring(path.lastIndexOf("appach") + 7);
        }
        drug.setDrugUrl(path);
        System.out.println(path);
        map.put("drug", drug);
        return "/drug/updateDrug";

    }

    @RequestMapping(value = "/drugUpdate", method = RequestMethod.POST)
    public String drugUpdate(Drug drug) {
        drugService.drugUpdate(drug);
        return "redirect:/drugList";

    }

    @RequestMapping(value = "/drugDel", method = RequestMethod.GET)
    public String drugDel(String drugID) {
        drugService.drugDel(drugID);
        return "redirect:/drugList";

    }

    @ResponseBody
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public aa testJson() {
        int i = new Random().nextInt(100);
        return new aa(i, "异步测试 ");
    }

    public class aa {
        int a;
        String b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public aa(int a, String b) {
            this.a = a;
            this.b = b;
        }
    }
}
