package com.jiang.sys.controller;

import com.jiang.common.domain.EasyUiPage;
import com.jiang.common.result.CodeMessage;
import com.jiang.common.result.Result;
import com.jiang.sys.domain.SysDepartment;
import com.jiang.sys.domain.SysDepartmentTreeNode;
import com.jiang.sys.service.systemservice.interfaceclass.SysDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 部门管理
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-27 14:40:36
 */
@Slf4j
@Controller
@RequestMapping("/sys/sysDept")
public class SysDeptController {
    private String prefix = "sys/dept";
    @Autowired
    private SysDepartmentService sysDepartmentService;

    private Result result = null;

    @GetMapping()
        //@RequiresPermissions("system:sysDept:sysDept")
    String dept() {
        return "/sys/dept/dept";
    }

    @ResponseBody
    @PostMapping("/find")
    //@RequiresPermissions("system:sysDept:add")
    public List<SysDepartmentTreeNode> find(HttpServletRequest request) {
        EasyUiPage<SysDepartmentTreeNode> resultPage = EasyUiPage.parsePage(request.getParameterMap());
        List<SysDepartmentTreeNode> list=null;
        try {
            list = sysDepartmentService.findSysDepartmentTree();
            result = Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result = Result.error(CodeMessage.SERVER_ERROR);
        }
        return list;
    }


    @GetMapping("/toAddSysDept")
        //@RequiresPermissions("system:sysDept:add")
    String toAddSysDept(String parentCode, String parentName, Model model) {
        model.addAttribute("parentCode", parentCode);
        if (StringUtils.isEmpty(parentName)) {
            parentName = "总部门";
        }
        model.addAttribute("parentName", parentName);
        return "/sys/dept/add";
    }
    @ResponseBody
    @PostMapping("/save")
    //@RequiresPermissions("system:sysDept:add")
    public Result save(SysDepartment sysDept) {
        try {
            sysDepartmentService.insertSysDepartment(sysDept);
            result = Result.success(sysDept);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result = Result.error(CodeMessage.SERVER_ERROR);
        }
        return result;
    }

//	@GetMapping("/edit/{deptId}")
//	//@RequiresPermissions("system:sysDept:edit")
//	String edit(@PathVariable("deptId") Long deptId, Model model) {
//		SysDepartment sysDept = sysDepartmentService.get(deptId);
//		model.addAttribute("sysDept", sysDept);
//		if(Constant.DEPT_ROOT_ID.equals(sysDept.getParentId())) {
//			model.addAttribute("parentDeptName", "无");
//		}else {
//			SysDepartment parDept = sysDepartmentService.get(sysDept.getParentId());
//			model.addAttribute("parentDeptName", parDept.getName());
//		}
//		return  prefix + "/edit";
//	}

    /**
     * 保存
     */


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    //@RequiresPermissions("system:sysDept:edit")
    public Result update(SysDepartment sysDept) {
        try {
            sysDepartmentService.updateSysDepartment(sysDept);
            result = Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result = Result.error(CodeMessage.SERVER_ERROR);
        }
        return result;
    }

    /**
     * 删除
     */
//	@PostMapping("/remove")
//	@ResponseBody
//	public R remove(Long deptId) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("parentId", deptId);
//		if(sysDepartmentService.count(map)>0) {
//			return R.error(1, "包含下级部门,不允许修改");
//		}
//		if(sysDepartmentService.checkDeptHasUser(deptId)) {
//			if (sysDepartmentService.remove(deptId) > 0) {
//				return R.ok();
//			}
//		}else {
//			return R.error(1, "部门包含用户,不允许修改");
//		}
//		return R.error();
//	}
    @ResponseBody
    @RequestMapping("/remove")
    //@RequiresPermissions("system:sysDept:edit")
    public Result remove(String id) {
        try {
            sysDepartmentService.deleteSysDepartmentById(id);
            result = Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result = Result.error(CodeMessage.SERVER_ERROR);
        }
        return result;
    }

    /**
     * 删除
     */
//	@PostMapping("/batchRemove")
//	@ResponseBody
//	@RequiresPermissions("system:sysDept:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] deptIds) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
//		sysDepartmentService.batchRemove(deptIds);
//		return R.ok();
//	}

//	@GetMapping("/tree")
//	@ResponseBody
//	public Tree<SysDepartment> tree() {
//		Tree<DeptDO> tree = new Tree<DeptDO>();
//		tree = sysDepartmentService.getTree();
//		return tree;
//	}
    @GetMapping("/treeView")
    String treeView() {
        return prefix + "/deptTree";
    }

}
