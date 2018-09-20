package com.ultrapower.dcs.cluster.control;

import com.ultrapower.dcs.cluster.control.dao.TestItemDao;
import com.ultrapower.dcs.cluster.control.model.TestItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ClusterControlApplication.class )
public class Test2ApplicationTests {

	@Autowired
	private TestItemDao itemDao;

	@Test
	@Transactional
	public void contextLoads() {
		TestItem item=new TestItem();
		item.setItemName("winterchen");
		item.setPassword("123456");
		item.setPhone("12345678911");
		itemDao.insert(item);
		TestItem u = itemDao.selectByPhone("12345678911");
		Assert.assertEquals("winterchen", u.getItemName());
	}
	@Autowired
	private Task task;
	@Test
	public void test() throws Exception {
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();
	}

}
