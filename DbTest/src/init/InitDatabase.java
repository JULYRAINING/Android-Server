package init;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;

import com.serviceImpl.CategoryServiceImpl;

import entity.Category;
import service.CategoryService;
@Repository
public class InitDatabase implements ApplicationListener<ContextRefreshedEvent>{

	@Resource
	private CategoryService categoryServiceImpl;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
//		categoryServiceImpl.deleteAll();
		Category category0 = new Category();
		category0.setCategoryId(0);
		category0.setName("校内");
		
		categoryServiceImpl.addCategory(category0);
		
		Category category1 = new Category();
		category1.setCategoryId(1);
		category1.setName("公寓");
		categoryServiceImpl.addCategory(category1);
		
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setName("学习");
		categoryServiceImpl.addCategory(category2);
		
		Category category3 = new Category();
		category3.setCategoryId(3);
		category3.setName("其它");
		categoryServiceImpl.addCategory(category3);
		
		categoryServiceImpl.addCategory(category3);
	}

}
