package com.usermanager.services;
import java.util.List;

import com.usermanager.model.BsResource;
public interface BsResourceService
{
	public boolean  addBsResource(BsResource bsresource); 
	public boolean  saveOrUpdateBsResource(BsResource bsresource); 
	public boolean  deleteBsResourceById(Integer pid); 
	public BsResource  getBsResourceById(Integer pid); 
	public boolean  deleteBsResourceByIds(List<Integer> bsResourceIdList);
}
