package ex05.collection;

import java.util.Map;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("collection-context.xml");
		
		Customer customer = ctx.getBean(Customer.class);
		
		customer.getLists().forEach((s)-> System.out.println(s));
		customer.getVo().forEach((vo)->System.out.println(vo.getId()+" "+vo.getName()));
		Map<String,Object> maps = customer.getMaps();
		Set<String> keySet = customer.getMaps().keySet();
		
		for(String s:keySet) {
			if(maps.get(s) instanceof MemberVO ) {
				MemberVO vo = (MemberVO)maps.get(s);
				System.out.println(s+" "+vo.getId()+" "+vo.getName());
			}else {
				System.out.println(s+" "+maps.get(s));
			}
		}
	}
}
