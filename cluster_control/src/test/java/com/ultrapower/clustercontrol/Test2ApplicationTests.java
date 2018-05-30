package com.ultrapower.clustercontrol;

import com.ultrapower.clustercontrol.dao.ItemDao;
import com.ultrapower.clustercontrol.model.Item;
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
	private ItemDao itemDao;

	@Test
	@Transactional
	public void contextLoads() {
		Item item=new Item();
		item.setItemName("winterchen");
		item.setPassword("123456");
		item.setPhone("12345678911");
		itemDao.insert(item);
		Item u = itemDao.selectByPhone("12345678911");
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
