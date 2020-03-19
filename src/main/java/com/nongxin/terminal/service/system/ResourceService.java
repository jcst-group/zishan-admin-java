package com.nongxin.terminal.service.system;

import com.nongxin.terminal.entity.system.Resource;

import java.util.List;

public interface ResourceService {

    boolean add(Resource resource);

    boolean delete(Integer id);

    boolean update(Resource resource);

    /**
     * 获取用户后台权限
     * @param uid
     * @param type null:所有权限 1:前台权限 2:后端权限
     * @return
     */
    List<Resource> getResourceByUid(Integer uid, Integer type);

    /**
     * 获取后台权限
     * @param type null:所有权限 1:前台权限 2:后端权限
     * @return
     */
    List<Resource> getResourceList(Integer type);

    //获取菜单action
    List<Resource> getAction(Integer parentId,Integer uid);

}
