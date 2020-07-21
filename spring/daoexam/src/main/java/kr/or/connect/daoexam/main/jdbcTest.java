package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class jdbcTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
		RoleDao roleDao =ac.getBean(RoleDao.class);
		
		Role role =new Role();
		role.setRoldID(500);role.setDescription("CED");
		
		int count = roleDao.insert(role);
		System.out.print(count+"입력했음");
		
		roleDao.update(role);
	}

}
